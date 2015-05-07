package controllers;


import play.data.DynamicForm;
import play.data.Form;
import play.db.jpa.JPA;
import play.mvc.*;

import views.html.*;

import static play.data.Form.*;

public class Application extends Controller {

	public static Result authentication(){
        return ok(authentication.render(""));
	}

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
	
	public static Result register(){
		return ok(registration.render());
	}
	
	public static Result jeopardy(){
		return ok(jeopardy.render());
	}

	public static Result question(){
        return ok(question.render());
    }


    @play.db.jpa.Transactional
    public static Result loginsubmit(){
        DynamicForm requestData = Form.form().bindFromRequest();
        String username = requestData.get("username");
        String password = requestData.get("password");
        Loginuser u = new Loginuser(username,password);
        Loginuser a = Loginuser.getLoginuser(username);
        if(a != null ){
            return ok(jeopardy.render());
        } else {
            return ok(authentication.render("Benutzername oder Passwort falsch"));
        }


    }

    @play.db.jpa.Transactional
    public static Result submitUser(){
        DynamicForm requestData = Form.form().bindFromRequest();
        String birthdate = requestData.get("birthdate");
        String gender = requestData.get("gender");

        Loginuser u = new Loginuser();
        u.setUsername(requestData.get("username"));
        u.setPassword(requestData.get("password"));
        u.setFirstname(requestData.get("firstname"));
        u.setSurname(requestData.get("lastname"));
        u.setGender('f');
        u.setAvatar(requestData.get("avatar"));
        Loginuser.saveLoginuser(u);
        return ok(authentication.render(""));

    }
	
	
}
