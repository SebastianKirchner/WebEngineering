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
import java.util.List;
import java.util.Locale;

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

                    //insertDBPediaData(); TODO -> UNCOMMENT ME
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
        // TODO choose category
        c.setName("Kultur", "DE");
        c.setName("Culture", "EN");

		/*
        FIRST QUESTION
		 */
        Question q1 = new Question();

        // Resource Tim Burton is available at http://dbpedia.org/resource/Tim_Burton
        // Load all statements as we need to get the name later
        Resource director = DBPediaService.loadStatements(DBPedia.createResource("Tim_Burton"));

        // Resource Johnny Depp is available at http://dbpedia.org/resource/Johnny_Depp
        // Load all statements as we need to get the name later
        Resource actor = DBPediaService.loadStatements(DBPedia.createResource("Johnny_Depp"));

        // retrieve english and german names, might be used for question text
        String englishDirectorName = DBPediaService.getResourceName(director, Locale.ENGLISH);
        String germanDirectorName = DBPediaService.getResourceName(director, Locale.GERMAN);
        String englishActorName = DBPediaService.getResourceName(actor, Locale.ENGLISH);
        String germanActorName = DBPediaService.getResourceName(actor, Locale.GERMAN);

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

        // get english and german movie names, e.g., for right choices
        List<String> englishTimBurtonMovieNames =
                DBPediaService.getResourceNames(timBurtonMovies, Locale.ENGLISH);
        List<String> germanTimBurtonMovieNames =
                DBPediaService.getResourceNames(timBurtonMovies, Locale.GERMAN);

        // alter query to get movies without tim burton
        movieQuery.removeWhereClause(DBPediaOWL.director, director);
        movieQuery.addMinusClause(DBPediaOWL.director, director);

        // retrieve data from dbpedia
        Model noTimBurtonMovies = DBPediaService.loadStatements(movieQuery.toQueryString());

        // get english and german movie names, e.g., for wrong choices
        List<String> englishNoTimBurtonMovieNames =
                DBPediaService.getResourceNames(noTimBurtonMovies, Locale.ENGLISH);
        List<String> germanNoTimBurtonMovieNames =
                DBPediaService.getResourceNames(noTimBurtonMovies, Locale.GERMAN);


        q1.setTextDE("In diesem Film hat Johnny Depp mitgespielt und Tim Burton war der " + director + ".");
        q1.setTextEN("Johnny Depp played a role in this movie, where the " + director + " was Tim Burton.");
        q1.setValue(10);
        c.addQuestion(createQuestion(q1, timBurtonMovies, noTimBurtonMovies));


		/*
        SECOND QUESTION
		 */
        Question q2 = new Question();
        // TODO query

        c.addQuestion(q2);


		/*
		THIRD QUESTION
		 */
        Question q3 = new Question();
        // TODO query

        c.addQuestion(q3);


		/*
		FOURTH QUESTION
		 */
        Question q4 = new Question();
        // TODO query

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
        List<String> correctEN = DBPediaService.getResourceNames(correct, Locale.ENGLISH);
        List<String> correctDE = DBPediaService.getResourceNames(correct, Locale.GERMAN);
        List<String> incorrectEN = DBPediaService.getResourceNames(incorrect, Locale.ENGLISH);
        List<String> incorrectDE = DBPediaService.getResourceNames(incorrect, Locale.GERMAN);

        for (int i = 0; i < correctDE.size(); ++i) {
            Answer a = new Answer();
            a.setTextDE(correctDE.get(i));
            a.setTextEN(correctEN.get(i));

            q.addRightAnswer(a);
        }

        for (int i = 0; i < incorrectDE.size(); ++i) {
            Answer a = new Answer();
            a.setTextDE(incorrectDE.get(i));
            a.setTextEN(incorrectEN.get(i));

            q.addWrongAnswer(a);
        }

        return q;
    }


    public void onStop(Application app) {
        Logger.info("Application shutdown...");
    }

}