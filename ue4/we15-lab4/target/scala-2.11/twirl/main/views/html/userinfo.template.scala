
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object userinfo extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template6[models.Player,Boolean,String,String,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(player: models.Player, human: Boolean, msgHuman: String, msgComputer: String, msgCorrect: String, msgWrong: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.118*/(""" 
	"""),_display_(/*2.3*/if(player.getLatestProfitChange() != null)/*2.45*/ {_display_(Seq[Any](format.raw/*2.47*/("""
		"""),format.raw/*3.3*/("""<p class="user-info """),_display_(/*3.24*/if(player.getLatestProfitChange() > 0)/*3.62*/{_display_(Seq[Any](format.raw/*3.63*/("""positive-change""")))}/*3.79*/else/*3.83*/{_display_(Seq[Any](format.raw/*3.84*/("""negative-change""")))}),format.raw/*3.100*/("""">
		"""),_display_(/*4.4*/if(human)/*4.13*/ {_display_(_display_(/*4.16*/msgHuman))}/*4.26*/else/*4.31*/{_display_(Seq[Any](_display_(/*4.33*/player/*4.39*/.getUser().getName()),format.raw/*4.59*/(""" """),_display_(/*4.61*/msgComputer)))}),format.raw/*4.73*/("""
		"""),_display_(/*5.4*/if(player.getLatestProfitChange() > 0)/*5.42*/{_display_(_display_(/*5.44*/msgCorrect))}/*5.55*/else/*5.59*/{_display_(_display_(/*5.61*/msgWrong))}),format.raw/*5.70*/(""": """),_display_(/*5.73*/if(player.getLatestProfitChange() > 0)/*5.111*/ {_display_(Seq[Any](format.raw/*5.113*/("""+""")))}),_display_(/*5.116*/player/*5.122*/.getLatestProfitChange()),format.raw/*5.146*/(""" """),format.raw/*5.147*/("""€
		</p>
	""")))}),format.raw/*7.3*/("""
"""))}
  }

  def render(player:models.Player,human:Boolean,msgHuman:String,msgComputer:String,msgCorrect:String,msgWrong:String): play.twirl.api.HtmlFormat.Appendable = apply(player,human,msgHuman,msgComputer,msgCorrect,msgWrong)

  def f:((models.Player,Boolean,String,String,String,String) => play.twirl.api.HtmlFormat.Appendable) = (player,human,msgHuman,msgComputer,msgCorrect,msgWrong) => apply(player,human,msgHuman,msgComputer,msgCorrect,msgWrong)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon May 25 19:03:23 CEST 2015
                  SOURCE: C:/Users/Maks/Documents/we/WebEngineering/ue4/we15-lab4/app/views/userinfo.scala.html
                  HASH: 56ffeac44d8549b064d6cd560cf323916bfa6c43
                  MATRIX: 769->1|974->117|1004->122|1054->164|1093->166|1123->170|1170->191|1216->229|1254->230|1288->246|1300->250|1338->251|1385->267|1417->274|1434->283|1464->286|1483->296|1495->301|1533->303|1547->309|1587->329|1615->331|1650->343|1680->348|1726->386|1755->388|1776->399|1788->403|1817->405|1848->414|1877->417|1924->455|1964->457|1997->460|2012->466|2057->490|2086->491|2128->504
                  LINES: 26->1|29->1|30->2|30->2|30->2|31->3|31->3|31->3|31->3|31->3|31->3|31->3|31->3|32->4|32->4|32->4|32->4|32->4|32->4|32->4|32->4|32->4|32->4|33->5|33->5|33->5|33->5|33->5|33->5|33->5|33->5|33->5|33->5|33->5|33->5|33->5|33->5|35->7
                  -- GENERATED --
              */
          