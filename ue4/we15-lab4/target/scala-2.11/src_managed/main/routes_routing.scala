// @SOURCE:C:/Users/Maks/Documents/we/WebEngineering/ue4/we15-lab4/conf/routes
// @HASH:331cfae7aa41dc6f34b9f0186deb3a25b0b719a3
// @DATE:Mon May 25 19:02:30 CEST 2015


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String): Unit = {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_GameController_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_GameController_index0_invoker = createInvoker(
controllers.GameController.index(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.GameController", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
        

// @LINE:8
private[this] lazy val controllers_Authentication_login1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
private[this] lazy val controllers_Authentication_login1_invoker = createInvoker(
controllers.Authentication.login(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Authentication", "login", Nil,"GET", """""", Routes.prefix + """login"""))
        

// @LINE:9
private[this] lazy val controllers_Authentication_authenticate2_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
private[this] lazy val controllers_Authentication_authenticate2_invoker = createInvoker(
controllers.Authentication.authenticate(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Authentication", "authenticate", Nil,"POST", """""", Routes.prefix + """login"""))
        

// @LINE:10
private[this] lazy val controllers_Authentication_logout3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
private[this] lazy val controllers_Authentication_logout3_invoker = createInvoker(
controllers.Authentication.logout(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Authentication", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
        

// @LINE:12
private[this] lazy val controllers_Registration_index4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("register"))))
private[this] lazy val controllers_Registration_index4_invoker = createInvoker(
controllers.Registration.index(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Registration", "index", Nil,"GET", """""", Routes.prefix + """register"""))
        

// @LINE:13
private[this] lazy val controllers_Registration_create5_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("register"))))
private[this] lazy val controllers_Registration_create5_invoker = createInvoker(
controllers.Registration.create(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Registration", "create", Nil,"POST", """""", Routes.prefix + """register"""))
        

// @LINE:15
private[this] lazy val controllers_GameController_playGame6_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("jeopardy"))))
private[this] lazy val controllers_GameController_playGame6_invoker = createInvoker(
controllers.GameController.playGame(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.GameController", "playGame", Nil,"GET", """""", Routes.prefix + """jeopardy"""))
        

// @LINE:16
private[this] lazy val controllers_GameController_newGame7_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("jeopardy"))))
private[this] lazy val controllers_GameController_newGame7_invoker = createInvoker(
controllers.GameController.newGame(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.GameController", "newGame", Nil,"POST", """""", Routes.prefix + """jeopardy"""))
        

// @LINE:18
private[this] lazy val controllers_GameController_playGame8_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("jeopardy/question"))))
private[this] lazy val controllers_GameController_playGame8_invoker = createInvoker(
controllers.GameController.playGame(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.GameController", "playGame", Nil,"GET", """""", Routes.prefix + """jeopardy/question"""))
        

// @LINE:19
private[this] lazy val controllers_GameController_questionSelected9_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("jeopardy/question"))))
private[this] lazy val controllers_GameController_questionSelected9_invoker = createInvoker(
controllers.GameController.questionSelected(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.GameController", "questionSelected", Nil,"POST", """""", Routes.prefix + """jeopardy/question"""))
        

// @LINE:21
private[this] lazy val controllers_GameController_playGame10_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("jeopardy/answer"))))
private[this] lazy val controllers_GameController_playGame10_invoker = createInvoker(
controllers.GameController.playGame(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.GameController", "playGame", Nil,"GET", """""", Routes.prefix + """jeopardy/answer"""))
        

// @LINE:22
private[this] lazy val controllers_GameController_submitAnswers11_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("jeopardy/answer"))))
private[this] lazy val controllers_GameController_submitAnswers11_invoker = createInvoker(
controllers.GameController.submitAnswers(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.GameController", "submitAnswers", Nil,"POST", """""", Routes.prefix + """jeopardy/answer"""))
        

// @LINE:24
private[this] lazy val controllers_GameController_gameOver12_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("jeopardy/gameover"))))
private[this] lazy val controllers_GameController_gameOver12_invoker = createInvoker(
controllers.GameController.gameOver(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.GameController", "gameOver", Nil,"GET", """""", Routes.prefix + """jeopardy/gameover"""))
        

// @LINE:27
private[this] lazy val controllers_Assets_at13_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at13_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.GameController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Authentication.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Authentication.authenticate()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Authentication.logout()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """register""","""controllers.Registration.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """register""","""controllers.Registration.create()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """jeopardy""","""controllers.GameController.playGame()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """jeopardy""","""controllers.GameController.newGame()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """jeopardy/question""","""controllers.GameController.playGame()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """jeopardy/question""","""controllers.GameController.questionSelected()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """jeopardy/answer""","""controllers.GameController.playGame()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """jeopardy/answer""","""controllers.GameController.submitAnswers()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """jeopardy/gameover""","""controllers.GameController.gameOver()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_GameController_index0_route(params) => {
   call { 
        controllers_GameController_index0_invoker.call(controllers.GameController.index())
   }
}
        

// @LINE:8
case controllers_Authentication_login1_route(params) => {
   call { 
        controllers_Authentication_login1_invoker.call(controllers.Authentication.login())
   }
}
        

// @LINE:9
case controllers_Authentication_authenticate2_route(params) => {
   call { 
        controllers_Authentication_authenticate2_invoker.call(controllers.Authentication.authenticate())
   }
}
        

// @LINE:10
case controllers_Authentication_logout3_route(params) => {
   call { 
        controllers_Authentication_logout3_invoker.call(controllers.Authentication.logout())
   }
}
        

// @LINE:12
case controllers_Registration_index4_route(params) => {
   call { 
        controllers_Registration_index4_invoker.call(controllers.Registration.index())
   }
}
        

// @LINE:13
case controllers_Registration_create5_route(params) => {
   call { 
        controllers_Registration_create5_invoker.call(controllers.Registration.create())
   }
}
        

// @LINE:15
case controllers_GameController_playGame6_route(params) => {
   call { 
        controllers_GameController_playGame6_invoker.call(controllers.GameController.playGame())
   }
}
        

// @LINE:16
case controllers_GameController_newGame7_route(params) => {
   call { 
        controllers_GameController_newGame7_invoker.call(controllers.GameController.newGame())
   }
}
        

// @LINE:18
case controllers_GameController_playGame8_route(params) => {
   call { 
        controllers_GameController_playGame8_invoker.call(controllers.GameController.playGame())
   }
}
        

// @LINE:19
case controllers_GameController_questionSelected9_route(params) => {
   call { 
        controllers_GameController_questionSelected9_invoker.call(controllers.GameController.questionSelected())
   }
}
        

// @LINE:21
case controllers_GameController_playGame10_route(params) => {
   call { 
        controllers_GameController_playGame10_invoker.call(controllers.GameController.playGame())
   }
}
        

// @LINE:22
case controllers_GameController_submitAnswers11_route(params) => {
   call { 
        controllers_GameController_submitAnswers11_invoker.call(controllers.GameController.submitAnswers())
   }
}
        

// @LINE:24
case controllers_GameController_gameOver12_route(params) => {
   call { 
        controllers_GameController_gameOver12_invoker.call(controllers.GameController.gameOver())
   }
}
        

// @LINE:27
case controllers_Assets_at13_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at13_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     