import at.ac.tuwien.big.we.dbpedia.api.DBPediaService;
import at.ac.tuwien.big.we.dbpedia.api.SelectQueryBuilder;
import at.ac.tuwien.big.we.dbpedia.vocabulary.DBPedia;
import at.ac.tuwien.big.we.dbpedia.vocabulary.DBPediaOWL;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.sparql.vocabulary.FOAF;
import com.hp.hpl.jena.vocabulary.RDF;
import com.hp.hpl.jena.vocabulary.RDFS;
import data.JSONDataInserter;
import models.Answer;
import models.Category;
import models.JeopardyDAO;
import models.Question;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.Play;
import play.db.jpa.JPA;
import play.libs.F.Function0;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Global extends GlobalSettings {

    @play.db.jpa.Transactional
    public static void insertJSonData() throws IOException {
        String file = Play.application().configuration().getString("questions.filePath");
        Logger.info("Data from: " + file);
        InputStream is = Play.application().resourceAsStream(file);
        List<Category> categories = JSONDataInserter.insertData(is);
        Logger.info(categories.size() + " categories from json file '" + file + "' inserted.");
    }

    @play.db.jpa.Transactional
    public void onStart(Application app) {
        try {
            JPA.withTransaction(new Function0<Boolean>() {

                @Override
                public Boolean apply() throws Throwable {
                    insertJSonData();
                    insertDBPediaData();
                    return true;
                }

            });
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private static void insertDBPediaData() {
        if (!DBPediaService.isAvailable()) {
            return;
        }

        Category category = categoryFromDBPedia();
        JeopardyDAO.INSTANCE.persist(category);
    }

    /**
     * Create a new Category from DBPedia
     *
     * @return a Category Object with 5 Questions, each holding correct and false answers
     */
    private static Category categoryFromDBPedia() {

        Category c = new Category();

        c.setName("Film und Kino", "DE");
        c.setName("Movies", "EN");

				/*
        FIRST QUESTION

        Example Question with Johnny Depp and Tim Burton
		 */
        Question q1 = new Question();

        // Resource Tim Burton is available at http://dbpedia.org/resource/Tim_Burton
        // Load all statements as we need to get the name later
        Resource director = DBPediaService.loadStatements(DBPedia.createResource("Tim_Burton"));

        // Resource Johnny Depp is available at http://dbpedia.org/resource/Johnny_Depp
        // Load all statements as we need to get the name later
        Resource actor = DBPediaService.loadStatements(DBPedia.createResource("Johnny_Depp"));

        // build SPARQL-query
        SelectQueryBuilder movieQuery = DBPediaService.createQueryBuilder()
                .setLimit(5) // at most five statements
                .addWhereClause(RDF.type, DBPediaOWL.Film)
                .addPredicateExistsClause(FOAF.name)
                .addWhereClause(DBPediaOWL.director, director)
                .addFilterClause(RDFS.label, Locale.GERMAN)
                .addFilterClause(RDFS.label, Locale.ENGLISH);

        // retrieve data from dbpedia
        Model timBurtonMovies = DBPediaService.loadStatements(movieQuery.toQueryString());

        // alter query to get movies without tim burton
        movieQuery.removeWhereClause(DBPediaOWL.director, director);
        movieQuery.addMinusClause(DBPediaOWL.director, director);

        // retrieve data from dbpedia
        Model noTimBurtonMovies = DBPediaService.loadStatements(movieQuery.toQueryString());

        q1.setTextDE("In welchen der folgenden Filme hat Tim Burton Regie gefuehrt?");
        q1.setTextEN("On which of the following movies did Tim Burton act as a director?");
        q1.setValue(10);
        c.addQuestion(createQuestion(q1, timBurtonMovies, noTimBurtonMovies));


		/*
        SECOND QUESTION

        Actors that died after 2000
		 */
        Question q2 = new Question();

        Calendar year2000 = Calendar.getInstance();
        year2000.set(Calendar.YEAR, 2000);
        year2000.set(Calendar.MONTH, 1);
        year2000.set(Calendar.DAY_OF_YEAR, 1);

        // build SPARQL-query
        SelectQueryBuilder deadActorsAfter2000 = DBPediaService.createQueryBuilder()
                .setLimit(5) // at most five statements
                .addWhereClause(RDF.type, DBPediaOWL.Actor)
                .addPredicateExistsClause(FOAF.name)
                .addFilterClause(RDFS.label, Locale.GERMAN)
                .addFilterClause(RDFS.label, Locale.ENGLISH)
                .addFilterClause(DBPediaOWL.deathDate, year2000, SelectQueryBuilder.MatchOperation.GREATER_OR_EQUAL);

        // retrieve data from dbpedia
        Model deadAfter2000 = DBPediaService.loadStatements(deadActorsAfter2000.toQueryString());

        SelectQueryBuilder deadActorsBefore2000 = DBPediaService.createQueryBuilder()
                .setLimit(5) // at most five statements
                .addWhereClause(RDF.type, DBPediaOWL.Actor)
                .addPredicateExistsClause(FOAF.name)
                .addFilterClause(RDFS.label, Locale.GERMAN)
                .addFilterClause(RDFS.label, Locale.ENGLISH)
                .addFilterClause(DBPediaOWL.deathDate, year2000, SelectQueryBuilder.MatchOperation.LESS);

        // retrieve data from dbpedia
        Model deadBefore2000 = DBPediaService.loadStatements(deadActorsBefore2000.toQueryString());

        q2.setTextDE("Welche der folgenden SchauspielerInnen sind nach dem Jahr 2000 verstorben?");
        q2.setTextEN("Which of the following actors/actresses passed away after the year 2000?");
        q2.setValue(20);
        c.addQuestion(createQuestion(q2, deadAfter2000, deadBefore2000));


		/*
        THIRD QUESTION

        Which actors were born in the UK
		 */
        Question q3 = new Question();

        Resource uk = DBPediaService.loadStatements(DBPedia.createResource("United_Kingdom"));

        // build SPARQL-query
        SelectQueryBuilder bornUKQuery = DBPediaService.createQueryBuilder()
                .setLimit(5) // at most five statements
                .addWhereClause(RDF.type, DBPediaOWL.Actor)
                .addPredicateExistsClause(FOAF.name)
                .addFilterClause(RDFS.label, Locale.GERMAN)
                .addFilterClause(RDFS.label, Locale.ENGLISH)
                .addWhereClause(DBPediaOWL.birthPlace, uk);

        // retrieve data from dbpedia
        Model bornUK = DBPediaService.loadStatements(bornUKQuery.toQueryString());

        // build SPARQL-query
        SelectQueryBuilder notBornUKQuery = DBPediaService.createQueryBuilder()
                .setLimit(5) // at most five statements
                .addWhereClause(RDF.type, DBPediaOWL.Actor)
                .addPredicateExistsClause(FOAF.name)
                .addFilterClause(RDFS.label, Locale.GERMAN)
                .addFilterClause(RDFS.label, Locale.ENGLISH)
                .addMinusClause(DBPediaOWL.birthPlace, uk);

        // retrieve data from dbpedia
        Model notBornUK = DBPediaService.loadStatements(notBornUKQuery.toQueryString());

        q3.setTextDE("Welche/r der folgende SchauspielerInnen wurde in England geboren?");
        q3.setTextEN("Which of the following actors/actresses was born in the UK?");
        q3.setValue(40);
        c.addQuestion(createQuestion(q3, bornUK, notBornUK));


		/*
		FOURTH QUESTION
		 */
        Question q4 = new Question();

        c.addQuestion(q4);


		/*
		FIFTH QUESTION
		 */
        Question q5 = new Question();
        // TODO query

        c.addQuestion(q5);


        return c;
    }

    /**
     *
     *
     * @param q Question object
     * @param correct Answers
     * @param incorrect Answers
     * @return Questino Object with right and wrong answers set
     */
    private static Question createQuestion(Question q, Model correct, Model incorrect) {
        System.out.println(q.getTextDE());

        List<String> correctEN = DBPediaService.getResourceNames(correct, Locale.ENGLISH);
        System.out.println("correctEN: " + correctEN.size());
        List<String> correctDE = DBPediaService.getResourceNames(correct, Locale.GERMAN);
        System.out.println("correctDE: " + correctDE.size());

        List<String> incorrectEN = DBPediaService.getResourceNames(incorrect, Locale.ENGLISH);
        System.out.println("incorrectEN: " + incorrectEN.size());
        List<String> incorrectDE = DBPediaService.getResourceNames(incorrect, Locale.GERMAN);
        System.out.println("incorrectDE: " + incorrectDE.size());

        // 2 - 4 correct answers or if less all correct answers
        Integer right = Math.min(new Random().nextInt(2) + 2, correctEN.size());

        for (int i = 0; i <right; ++i) {
            Answer a = new Answer();
            a.setTextDE(correctDE.get(i));
            a.setTextEN(correctEN.get(i));
            System.out.println("correct: " + correctDE.get(i));

            q.addRightAnswer(a);
        }

        for (int i = 0; i < 5-right; ++i) {
            Answer a = new Answer();
            a.setTextDE(incorrectDE.get(i));
            a.setTextEN(incorrectEN.get(i));
            System.out.println("incorrect: " + incorrectDE.get(i));

            q.addWrongAnswer(a);
        }

        return q;
    }


    public void onStop(Application app) {
        Logger.info("Application shutdown...");
    }

}