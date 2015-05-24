package controllers;

import java.util.*;

import models.Category;
import models.JeopardyDAO;
import models.JeopardyGame;
import models.JeopardyUser;
import play.Logger;
import play.cache.Cache;
import play.data.DynamicForm;
import play.data.DynamicForm.Dynamic;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.jeopardy;
import views.html.question;
import views.html.winner;

import javax.xml.namespace.QName;
import javax.xml.soap.*;

@Security.Authenticated(Secured.class)
public class GameController extends Controller {
	
	protected static final int CATEGORY_LIMIT = 5;
	
	@Transactional
	public static Result index() {
		return redirect(routes.GameController.playGame());
	}
	
	@play.db.jpa.Transactional(readOnly = true)
	private static JeopardyGame createNewGame(String userName) {
		return createNewGame(JeopardyDAO.INSTANCE.findByUserName(userName));
	}
	
	@play.db.jpa.Transactional(readOnly = true)
	private static JeopardyGame createNewGame(JeopardyUser user) {
		if(user == null) // name still stored in session, but database dropped
			return null;

		Logger.info("[" + user + "] Creating a new game.");
		List<Category> allCategories = JeopardyDAO.INSTANCE.findEntities(Category.class);
		
		if(allCategories.size() > CATEGORY_LIMIT) {
			// select 5 categories randomly (simple)
			Collections.shuffle(allCategories);
			allCategories = allCategories.subList(0, CATEGORY_LIMIT);
		}
		Logger.info("Start game with " + allCategories.size() + " categories.");
		JeopardyGame game = new JeopardyGame(user, allCategories);
		cacheGame(game);
		return game;
	}
	
	private static void cacheGame(JeopardyGame game) {
		Cache.set(gameId(), game, 3600);
	}
	
	private static JeopardyGame cachedGame(String userName) {
		Object game = Cache.get(gameId());
		if(game instanceof JeopardyGame)
			return (JeopardyGame) game;
		return createNewGame(userName);
	}
	
	private static String gameId() {
		return "game." + uuid();
	}

	private static String uuid() {
		String uuid = session("uuid");
		if (uuid == null) {
			uuid = UUID.randomUUID().toString();
			session("uuid", uuid);
		}
		return uuid;
	}
	
	@Transactional
	public static Result newGame() {
		Logger.info("[" + request().username() + "] Start new game.");
		JeopardyGame game = createNewGame(request().username());
		return ok(jeopardy.render(game));
	}
	
	@Transactional
	public static Result playGame() {
		Logger.info("[" + request().username() + "] Play the game.");
		JeopardyGame game = cachedGame(request().username());
		if(game == null) // e.g., username still in session, but db dropped
			return redirect(routes.Authentication.login());
		if(game.isAnswerPending()) {
			Logger.info("[" + request().username() + "] Answer pending... redirect");
			return ok(question.render(game));
		} else if(game.isGameOver()) {
			Logger.info("[" + request().username() + "] Game over... redirect");
			return ok(winner.render(game));
		}			
		return ok(jeopardy.render(game));
	}
	
	@play.db.jpa.Transactional(readOnly = true)
	public static Result questionSelected() {
		JeopardyGame game = cachedGame(request().username());
		if(game == null || !game.isRoundStart())
			return redirect(routes.GameController.playGame());
		
		Logger.info("[" + request().username() + "] Questions selected.");		
		DynamicForm form = Form.form().bindFromRequest();
		
		String questionSelection = form.get("question_selection");
		
		if(questionSelection == null || questionSelection.equals("") || !game.isRoundStart()) {
			return badRequest(jeopardy.render(game));
		}
		
		game.chooseHumanQuestion(Long.parseLong(questionSelection));
		
		return ok(question.render(game));
	}
	
	@play.db.jpa.Transactional(readOnly = true)
	public static Result submitAnswers() {
		JeopardyGame game = cachedGame(request().username());
		if(game == null || !game.isAnswerPending())
			return redirect(routes.GameController.playGame());
		
		Logger.info("[" + request().username() + "] Answers submitted.");
		Dynamic form = Form.form().bindFromRequest().get();
		
		@SuppressWarnings("unchecked")
		Map<String,String> data = form.getData();
		List<Long> answerIds = new ArrayList<>();
		
		for(String key : data.keySet()) {
			if(key.startsWith("answers[")) {
				answerIds.add(Long.parseLong(data.get(key)));
			}
		}
		game.answerHumanQuestion(answerIds);
		if(game.isGameOver()) {
			return redirect(routes.GameController.gameOver());
		} else {
			return ok(jeopardy.render(game));
		}
	}
	
	@play.db.jpa.Transactional(readOnly = true)
	public static Result gameOver() {
		JeopardyGame game = cachedGame(request().username());
		if(game == null || !game.isGameOver())
			return redirect(routes.GameController.playGame());
		
		Logger.info("[" + request().username() + "] Game over.");
        Logger.info("Data being transmitted to Highscore-Service");
        try {
            SOAPConnectionFactory connFac = SOAPConnectionFactory.newInstance();
            SOAPConnection conn = connFac.createConnection();

            String url = "http://playground.big.tuwien.ac.at:8080/highscoreservice/PublishHighScoreService?wsdl";
            //String url = "";
            SOAPMessage soapmsg = conn.call(createSOAPMessage(game),url);

        } catch (SOAPException e){
            Logger.error(e.getMessage());
        }

		return ok(winner.render(game));
	}

    public static SOAPMessage createSOAPMessage(JeopardyGame game) throws SOAPException{
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "http://playground.big.tuwien.ac.at:8080/highscoreservice/";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("data", serverURI);

        /*
        * <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:data="http://big.tuwien.ac.at/we/highscore/data">
        <soapenv:Header/>
            <soapenv:Body>
                <data:HighScoreRequest>
                    <data:UserKey>3ke93-gue34-dkeu9</data:UserKey>
                    <data:UserData>
                        <Loser Gender="male" BirthDate="1990-01-12">
                            <FirstName>Hans</FirstName>
                            <LastName>Mustermann</LastName>
                            <Password></Password>
                            <Points>12</Points>
                        </Loser>
                        <Winner Gender="female" BirthDate="1981-01-12">
                            <FirstName>Gerda</FirstName>
                            <LastName>Haydn</LastName>
                            <Password></Password>
                            <Points>12</Points>
                        </Winner>
                    </data:UserData>
                </data:HighScoreRequest>
            </soapenv:Body>
        </soapenv:Envelope>
        * */

        SOAPBody soapBody = envelope.getBody();



        SOAPElement highscorerequestElem = soapBody.addChildElement("HighScoreRequest","data");
        SOAPElement userkeyElem = highscorerequestElem.addChildElement("UserKey", "data");
        userkeyElem.addTextNode("3ke93-gue34-dkeu9");

        SOAPElement userDataElem = highscorerequestElem.addChildElement("UserData", "data");
        SOAPElement loserElem = userDataElem.addChildElement("Loser");
        SOAPElement winnerElem = userDataElem.addChildElement("Winner");

        JeopardyUser loser = game.getLoser().getUser();
        String loserBirthdate  = loser.getBirthDate() == null ? "" : loser.getBirthDate().toString();
        loser.setFirstName(loser.getFirstName() == null ? "" : loser.getFirstName());
        loser.setLastName(loser.getLastName() == null ? "" : loser.getLastName());

        JeopardyUser winner = game.getWinner().getUser();
        String winnerBirthdate  = winner.getBirthDate() == null ? "" : winner.getBirthDate().toString();
        winner.setFirstName(winner.getFirstName() == null ? "" : winner.getFirstName());
        winner.setLastName(winner.getLastName() == null ? "" : winner.getLastName());

        loserElem.addAttribute(new QName("Gender"),loser.getGender().name());
        loserElem.addAttribute(new QName("BirthDate"),loserBirthdate);
        SOAPElement loserFirstname = loserElem.addChildElement("FirstName").addTextNode(loser.getFirstName());
        SOAPElement loserLastName = loserElem.addChildElement("LastName").addTextNode(loser.getLastName());
        SOAPElement loserPassword = loserElem.addChildElement("Password").addTextNode("");
        SOAPElement loserPoints = loserElem.addChildElement("Points").addTextNode(Integer.toString(game.getLoser().getProfit()));

        winnerElem.addAttribute(new QName("Gender"),winner.getGender().name());
        winnerElem.addAttribute(new QName("BirthDate"),winnerBirthdate);
        SOAPElement winnerFirstname = winnerElem.addChildElement("FirstName").addTextNode(winner.getFirstName());
        SOAPElement winnerLastName = winnerElem.addChildElement("LastName").addTextNode(winner.getLastName());
        SOAPElement winnerPassword = winnerElem.addChildElement("Password").addTextNode("");
        SOAPElement winnerPoints = winnerElem.addChildElement("Points").addTextNode(Integer.toString(game.getWinner().getProfit()));

        MimeHeaders headers = soapMessage.getMimeHeaders();

        Logger.info(soapMessage.toString());
        return soapMessage;
    }

}
