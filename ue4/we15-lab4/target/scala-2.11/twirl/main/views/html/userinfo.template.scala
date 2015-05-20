
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
                  DATE: Wed May 20 18:36:39 CEST 2015
                  SOURCE: E:/IntelliJProjects/WebEngineeringMaven/ue4/we15-lab4/app/views/userinfo.scala.html
                  HASH: 1adb00bd98f47ed2280ea23519a86432372178fa
                  MATRIX: 769->1|974->117|1003->121|1053->163|1092->165|1121->168|1168->189|1214->227|1252->228|1286->244|1298->248|1336->249|1383->265|1414->271|1431->280|1461->283|1480->293|1492->298|1530->300|1544->306|1584->326|1612->328|1647->340|1676->344|1722->382|1751->384|1772->395|1784->399|1813->401|1844->410|1873->413|1920->451|1960->453|1993->456|2008->462|2053->486|2082->487|2122->498
                  LINES: 26->1|29->1|30->2|30->2|30->2|31->3|31->3|31->3|31->3|31->3|31->3|31->3|31->3|32->4|32->4|32->4|32->4|32->4|32->4|32->4|32->4|32->4|32->4|33->5|33->5|33->5|33->5|33->5|33->5|33->5|33->5|33->5|33->5|33->5|33->5|33->5|33->5|35->7
                  -- GENERATED --
              */
          