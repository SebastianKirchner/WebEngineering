// @SOURCE:C:/Users/Maks/Documents/we/WebEngineering/ue4/we15-lab4/conf/routes
// @HASH:331cfae7aa41dc6f34b9f0186deb3a25b0b719a3
// @DATE:Mon May 25 19:02:30 CEST 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:27
// @LINE:24
// @LINE:22
// @LINE:21
// @LINE:19
// @LINE:18
// @LINE:16
// @LINE:15
// @LINE:13
// @LINE:12
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
package controllers {

// @LINE:13
// @LINE:12
class ReverseRegistration {


// @LINE:13
def create(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "register")
}
                        

// @LINE:12
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "register")
}
                        

}
                          

// @LINE:24
// @LINE:22
// @LINE:21
// @LINE:19
// @LINE:18
// @LINE:16
// @LINE:15
// @LINE:6
class ReverseGameController {


// @LINE:19
def questionSelected(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "jeopardy/question")
}
                        

// @LINE:16
def newGame(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "jeopardy")
}
                        

// @LINE:22
def submitAnswers(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "jeopardy/answer")
}
                        

// @LINE:24
def gameOver(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "jeopardy/gameover")
}
                        

// @LINE:21
// @LINE:18
// @LINE:15
def playGame(): Call = {
   () match {
// @LINE:15
case ()  =>
  import ReverseRouteContext.empty
  Call("GET", _prefix + { _defaultPrefix } + "jeopardy")
                                         
   }
}
                                                

// @LINE:6
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        

}
                          

// @LINE:27
class ReverseAssets {


// @LINE:27
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:10
// @LINE:9
// @LINE:8
class ReverseAuthentication {


// @LINE:10
def logout(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                        

// @LINE:9
def authenticate(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "login")
}
                        

// @LINE:8
def login(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "login")
}
                        

}
                          
}
                  


// @LINE:27
// @LINE:24
// @LINE:22
// @LINE:21
// @LINE:19
// @LINE:18
// @LINE:16
// @LINE:15
// @LINE:13
// @LINE:12
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:13
// @LINE:12
class ReverseRegistration {


// @LINE:13
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Registration.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "register"})
      }
   """
)
                        

// @LINE:12
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Registration.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "register"})
      }
   """
)
                        

}
              

// @LINE:24
// @LINE:22
// @LINE:21
// @LINE:19
// @LINE:18
// @LINE:16
// @LINE:15
// @LINE:6
class ReverseGameController {


// @LINE:19
def questionSelected : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.GameController.questionSelected",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "jeopardy/question"})
      }
   """
)
                        

// @LINE:16
def newGame : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.GameController.newGame",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "jeopardy"})
      }
   """
)
                        

// @LINE:22
def submitAnswers : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.GameController.submitAnswers",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "jeopardy/answer"})
      }
   """
)
                        

// @LINE:24
def gameOver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.GameController.gameOver",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "jeopardy/gameover"})
      }
   """
)
                        

// @LINE:21
// @LINE:18
// @LINE:15
def playGame : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.GameController.playGame",
   """
      function() {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "jeopardy"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "jeopardy/question"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "jeopardy/answer"})
      }
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.GameController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

}
              

// @LINE:27
class ReverseAssets {


// @LINE:27
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:10
// @LINE:9
// @LINE:8
class ReverseAuthentication {


// @LINE:10
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Authentication.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:9
def authenticate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Authentication.authenticate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

// @LINE:8
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Authentication.login",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

}
              
}
        


// @LINE:27
// @LINE:24
// @LINE:22
// @LINE:21
// @LINE:19
// @LINE:18
// @LINE:16
// @LINE:15
// @LINE:13
// @LINE:12
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
package controllers.ref {


// @LINE:13
// @LINE:12
class ReverseRegistration {


// @LINE:13
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Registration.create(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Registration", "create", Seq(), "POST", """""", _prefix + """register""")
)
                      

// @LINE:12
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Registration.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Registration", "index", Seq(), "GET", """""", _prefix + """register""")
)
                      

}
                          

// @LINE:24
// @LINE:22
// @LINE:21
// @LINE:19
// @LINE:18
// @LINE:16
// @LINE:15
// @LINE:6
class ReverseGameController {


// @LINE:19
def questionSelected(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.GameController.questionSelected(), HandlerDef(this.getClass.getClassLoader, "", "controllers.GameController", "questionSelected", Seq(), "POST", """""", _prefix + """jeopardy/question""")
)
                      

// @LINE:16
def newGame(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.GameController.newGame(), HandlerDef(this.getClass.getClassLoader, "", "controllers.GameController", "newGame", Seq(), "POST", """""", _prefix + """jeopardy""")
)
                      

// @LINE:22
def submitAnswers(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.GameController.submitAnswers(), HandlerDef(this.getClass.getClassLoader, "", "controllers.GameController", "submitAnswers", Seq(), "POST", """""", _prefix + """jeopardy/answer""")
)
                      

// @LINE:24
def gameOver(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.GameController.gameOver(), HandlerDef(this.getClass.getClassLoader, "", "controllers.GameController", "gameOver", Seq(), "GET", """""", _prefix + """jeopardy/gameover""")
)
                      

// @LINE:15
def playGame(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.GameController.playGame(), HandlerDef(this.getClass.getClassLoader, "", "controllers.GameController", "playGame", Seq(), "GET", """""", _prefix + """jeopardy""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.GameController.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.GameController", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

}
                          

// @LINE:27
class ReverseAssets {


// @LINE:27
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:10
// @LINE:9
// @LINE:8
class ReverseAuthentication {


// @LINE:10
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Authentication.logout(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Authentication", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:9
def authenticate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Authentication.authenticate(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Authentication", "authenticate", Seq(), "POST", """""", _prefix + """login""")
)
                      

// @LINE:8
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Authentication.login(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Authentication", "login", Seq(), "GET", """""", _prefix + """login""")
)
                      

}
                          
}
        
    