
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
object nav extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(bodyId: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import play.i18n._
def /*4.2*/navWrap/*4.9*/()(list: Html):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.27*/("""
	"""),format.raw/*5.2*/("""<nav role="navigation" aria-labelledby="navheading">
		<h2 id="navheading" class="accessibility">Navigation</h2>
		<ul>
			"""),_display_(/*8.5*/list),format.raw/*8.9*/("""
		"""),format.raw/*9.3*/("""</ul>
	</nav>
""")))};
Seq[Any](format.raw/*1.18*/("""
"""),format.raw/*3.1*/("""
"""),format.raw/*11.2*/("""

"""),_display_(/*13.2*/bodyId/*13.8*/ match/*13.14*/ {/*14.2*/case "login-page" =>/*14.22*/ {_display_(Seq[Any](format.raw/*14.24*/("""
	""")))}/*17.2*/case "register-page" =>/*17.25*/ {_display_(Seq[Any](format.raw/*17.27*/("""
		"""),_display_(/*18.4*/navWrap()/*18.13*/{_display_(Seq[Any](format.raw/*18.14*/("""
			"""),format.raw/*19.4*/("""<li>
				<a	class="orangelink navigationlink"
					id="loginlink"
					title=""""),_display_(/*22.14*/Messages/*22.22*/.get("nav.login.title")),format.raw/*22.45*/(""""
					href=""""),_display_(/*23.13*/routes/*23.19*/.Authentication.login),format.raw/*23.40*/(""""
					accesskey="l">
					"""),_display_(/*25.7*/Messages/*25.15*/.get("nav.login")),format.raw/*25.32*/("""
				"""),format.raw/*26.5*/("""</a>
			</li>
		""")))}),format.raw/*28.4*/("""
	""")))}/*31.2*/case _  =>/*31.12*/ {_display_(Seq[Any](format.raw/*31.14*/("""
		"""),_display_(/*32.4*/navWrap()/*32.13*/{_display_(Seq[Any](format.raw/*32.14*/("""
			"""),format.raw/*33.4*/("""<li>
				<a	class="orangelink navigationlink"
					id="logoutlink"
					title=""""),_display_(/*36.14*/Messages/*36.22*/.get("nav.logout.title")),format.raw/*36.46*/(""""
					href=""""),_display_(/*37.13*/routes/*37.19*/.Authentication.logout),format.raw/*37.41*/(""""
					accesskey="l">
					"""),_display_(/*39.7*/Messages/*39.15*/.get("nav.logout")),format.raw/*39.33*/("""
				"""),format.raw/*40.5*/("""</a>
			</li>
		""")))}),format.raw/*42.4*/("""
	""")))}}))}
  }

  def render(bodyId:String): play.twirl.api.HtmlFormat.Appendable = apply(bodyId)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (bodyId) => apply(bodyId)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed May 20 18:36:39 CEST 2015
                  SOURCE: E:/IntelliJProjects/WebEngineeringMaven/ue4/we15-lab4/app/views/nav.scala.html
                  HASH: ea66f27a6cf70beb37039fded3a33225f171de57
                  MATRIX: 721->1|826->40|840->47|934->65|962->67|1111->191|1134->195|1163->198|1217->17|1244->38|1272->213|1301->216|1315->222|1330->228|1340->232|1369->252|1409->254|1430->261|1462->284|1502->286|1532->290|1550->299|1589->300|1620->304|1726->383|1743->391|1787->414|1828->428|1843->434|1885->455|1939->483|1956->491|1994->508|2026->513|2073->530|2094->537|2113->547|2153->549|2183->553|2201->562|2240->563|2271->567|2378->647|2395->655|2440->679|2481->693|2496->699|2539->721|2593->749|2610->757|2649->775|2681->780|2728->797
                  LINES: 26->1|28->4|28->4|30->4|31->5|34->8|34->8|35->9|38->1|39->3|40->11|42->13|42->13|42->13|42->14|42->14|42->14|43->17|43->17|43->17|44->18|44->18|44->18|45->19|48->22|48->22|48->22|49->23|49->23|49->23|51->25|51->25|51->25|52->26|54->28|55->31|55->31|55->31|56->32|56->32|56->32|57->33|60->36|60->36|60->36|61->37|61->37|61->37|63->39|63->39|63->39|64->40|66->42
                  -- GENERATED --
              */
          