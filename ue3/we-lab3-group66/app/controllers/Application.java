package controllers;

import at.ac.tuwien.big.we15.lab2.api.*;
import at.ac.tuwien.big.we15.lab2.api.impl.PlayJeopardyFactory;
import at.ac.tuwien.big.we15.lab2.api.impl.SimpleUser;
import play.cache.Cache;
import play.data.DynamicForm;
import play.data.Form;
import play.db.jpa.JPA;
import play.i18n.Messages;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.authentication;
import views.html.index;
import views.html.registration;
import views.html.winner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Application extends Controller {

	public static Result authentication(){
        return ok(authentication.render(""));
	}

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
	

	
	public static Result jeopardy(){
        JeopardyGame game = (JeopardyGame) Cache.get("game");
        Question marvinQ = game.getMarvinPlayer().getChosenQuestion();
        DynamicForm requestData = Form.form().bindFromRequest();
        Map<String,String> map = requestData.data();


        List<String> answer = new ArrayList<>();
        //Herauslesen der gewählten Antworten
        for(Map.Entry<String,String> s : map.entrySet()){
            if(s.getKey().contains("answers")){
                answer.add(s.getValue());
            }
        }

        List<Integer> ids = new ArrayList<>();

        for (String s : answer) {
            ids.add(Integer.parseInt(s));
        }

        game.answerHumanQuestion(ids);
        /* TODO: die hier miteinbeziehen
        game.isRoundStart(); // check if we are at the beginning of a new round
        game.isAnswerPending(); // check if the current question needs to be answered
        game.isGameOver(); // check if game is over
        game.getWinner(); // winner of round or null if no winner exists yet
        */
        Cache.set("game", game);
        if(game.isGameOver()){
          return ok(views.html.winner.render((JeopardyGame) Cache.get("game"), marvinQ));
        }
        return ok(views.html.jeopardy.render((JeopardyGame) Cache.get("game"), marvinQ));
	}

	public static Result question(){
        JeopardyGame game = (JeopardyGame) Cache.get("game");
        DynamicForm requestData = Form.form().bindFromRequest();
        int questionID = Integer.parseInt(requestData.get("question_selection"));
        game.getCategories();
        game.chooseHumanQuestion(questionID);
        Cache.set("game", game);
        return ok(views.html.question.render(game, game.getHumanPlayer().getChosenQuestion()));
    }

    public static Result register(){
        DynamicForm requestData = Form.form().bindFromRequest();
        return ok(registration.render(true,true,true,true));
    }

    @play.db.jpa.Transactional
    public static Result loginsubmit(){
        DynamicForm requestData = Form.form().bindFromRequest();
        String username = requestData.get("username");
        String password = requestData.get("password");
        Loginuser getLoginuser = Loginuser.getLoginuser(username);

        if(getLoginuser != null && getLoginuser.getPassword().equals(password)){
            JeopardyFactory factory = new PlayJeopardyFactory(Messages.get("json.file"));
            User user = new SimpleUser();
            user.setName(getLoginuser.getUsername());
            user.setAvatar(getLoginuser.getAvatar());
            JeopardyGame game = factory.createGame(user);
            Cache.set("game",game);
            return ok(views.html.jeopardy.render(game, null));
        } else {
            return ok(authentication.render(Messages.get("login.error")));
        }
    }

    @play.db.jpa.Transactional
    public static Result submitUser(){
        DynamicForm requestData = Form.form().bindFromRequest();
        Loginuser u = new Loginuser();
        u.setUsername(requestData.get("username"));
        u.setPassword(requestData.get("password"));
        u.setFirstname(requestData.get("firstname"));
        u.setSurname(requestData.get("lastname"));
        u.setGender(requestData.get("gender"));
        u.setAvatar(Avatar.getAvatar(requestData.get("avatar")));
        u.setBirthdate(requestData.get("birthdate"));

        //Geburtsdatum vorbereiten
        u.setBirthdate(u.getBirthdate().replace('-','.'));
        if(u.getBirthdate().substring(0,4).matches("^([0-9]{4})")){
            String year = u.getBirthdate().substring(0,4);
            String month = u.getBirthdate().substring(5,7);
            String day = u.getBirthdate().substring(8,10);
            u.setBirthdate(day + "." + month + "." + year);
        }


        Loginuser sameUser = JPA.em().find(Loginuser.class,u.getUsername());
        boolean usernameValid = u.getUsername().length()>=4 && u.getUsername().length()<=8;
        boolean passwordValid = u.getPassword().length()>=4 && u.getPassword().length()<=8;
        boolean userExistsValid  = sameUser == null;
        boolean birthdateValid  = false;


        if(u.getBirthdate() != null || u.getBirthdate().length()>0) {
            if (u.getBirthdate().matches("^([0][1-9]|([1|2][0-9])|[3][0-1]).([0][1-9]|[1][0-2]).[0-9]{4}")) {
                birthdateValid = true;
            }
        }

        if(usernameValid && passwordValid && birthdateValid && userExistsValid){
            Loginuser.saveLoginuser(u);
            return ok(authentication.render(""));

        } else{
            return ok(registration.render(usernameValid, passwordValid, birthdateValid, userExistsValid));
        }
    }

    public static Result logout(){
        Cache.remove("game");
        return ok(authentication.render(""));
    }


    public static Result newGame(){
        JeopardyGame game = (JeopardyGame) Cache.get("game");
        User player = game.getHuman();
        Cache.remove("game");

        JeopardyFactory factory = new PlayJeopardyFactory(Messages.get("json.file"));
        JeopardyGame newgame = factory.createGame(player);
        Cache.set("game",newgame);
        return ok(views.html.jeopardy.render(newgame, null));
    }
	
}
