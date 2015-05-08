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
import views.html.*;

public class Application extends Controller {

	public static Result authentication(){
        return ok(authentication.render(""));
	}

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
	

	
	public static Result jeopardy(){
		return ok(views.html.jeopardy.render((JeopardyGame) Cache.get("game")));
	}

	public static Result question(){
        DynamicForm requestData = Form.form().bindFromRequest();
        return ok(question.render());
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
            user.setAvatar(Avatar.getAvatar(getLoginuser.getAvatar()));
            JeopardyGame game = factory.createGame(user);
            Cache.set("game",game);

            return ok(views.html.jeopardy.render(game));
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

        Loginuser sameUser = JPA.em().find(Loginuser.class,u.getUsername());
        boolean usernameValid = u.getUsername().length()>=4 && u.getUsername().length()<=8;
        boolean passwordValid = u.getPassword().length()>=4 && u.getPassword().length()<=8;
        boolean userExistsValid  = sameUser == null;
        boolean birthdateValid  = true;


        if(!(u.getBirthdate() == null || u.getBirthdate().length()==0)) {

            if (u.getBirthdate().matches("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$.")) {
                birthdateValid = true;
            }
        }
        //return ok(Test.render(u.getBirthdate(),u.getBirthdate().matches("/^([0][1-9]|[1|2][0-9]|[3][0|1])[.]([0][1-9]|[1][0-2])[.]([0-9]{4})$/")));

        if(!(usernameValid && passwordValid && birthdateValid && userExistsValid)){
            return ok(registration.render(usernameValid, passwordValid, birthdateValid, userExistsValid));
        } else{
            Loginuser.saveLoginuser(u);

            return ok(authentication.render(""));
        }



    }
	
	
}
