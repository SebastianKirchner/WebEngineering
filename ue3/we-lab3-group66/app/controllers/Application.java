package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
	
	public static Result authentication(){
		return ok(authentication.render());
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
	
	
	
}
