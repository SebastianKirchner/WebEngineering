package controllers;


import at.ac.tuwien.big.we15.lab2.api.*;
import at.ac.tuwien.big.we15.lab2.api.impl.PlayJeopardyFactory;
import at.ac.tuwien.big.we15.lab2.api.impl.SimpleUser;
import play.data.DynamicForm;
import play.data.Form;
import play.i18n.Messages;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Application extends Controller {

	public static Result authentication(){
        return ok(authentication.render(""));
	}

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
	

	
	public static Result jeopardy(){
		return ok(jeopardy.render());
	}

	public static Result question(){
        return ok(question.render());
    }

    public static Result register(){
        DynamicForm requestData = Form.form().bindFromRequest();


        return ok(registration.render());
    }

    @play.db.jpa.Transactional
    public static Result loginsubmit(){
        DynamicForm requestData = Form.form().bindFromRequest();
        String username = requestData.get("username");
        String password = requestData.get("password");
        Loginuser u = new Loginuser(username,password);
        Loginuser a = Loginuser.getLoginuser(username);



        if(a != null ){

            JeopardyFactory factory = new PlayJeopardyFactory(Messages.get("json.file"));

            User user = new SimpleUser();
            user.setName(a.getUsername());
            user.setAvatar(Avatar.getAvatar(a.getAvatar()));
            JeopardyGame game = factory.createGame(user);
            Player human = game.getHumanPlayer();
            return ok(jeopardy.render());
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
        u.setAvatar(requestData.get("avatar"));
        u.setBirthdate(requestData.get("birthdate"));

        boolean isValid = true;
/*
        if(u.getUsername().length()<4){
            isValid = false;
        }

        if(u.getAvatar() == null){
            isValid = false;
        }

        Loginuser sameUser = JPA.em().find(Loginuser.class,u.getUsername());
        if(sameUser != null){

            isValid = false;
        }

        if(u.getPassword().length()<4){

            isValid = false;
        }


        if(u.getBirthdate() != null) {
            if (!u.getBirthdate().matches("a")) {
                isValid = false;
            }
        }*/


        if(!isValid){
            return ok(registration.render());
        } else{
            Loginuser.saveLoginuser(u);

            return ok(authentication.render(""));
        }



    }
	
	
}
