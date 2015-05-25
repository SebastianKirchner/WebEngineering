
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
                  DATE: Mon May 25 19:03:19 CEST 2015
                  SOURCE: C:/Users/Maks/Documents/we/WebEngineering/ue4/we15-lab4/app/views/nav.scala.html
                  HASH: 4d092a2a7b3006b615f9da0714146219f8dbde01
                  MATRIX: 721->1|826->43|840->50|934->68|963->71|1115->198|1138->202|1168->206|1224->17|1252->40|1281->223|1312->228|1326->234|1341->240|1351->245|1380->265|1420->267|1442->277|1474->300|1514->302|1545->307|1563->316|1602->317|1634->322|1743->404|1760->412|1804->435|1846->450|1861->456|1903->477|1959->507|1976->515|2014->532|2047->538|2096->557|2118->567|2137->577|2177->579|2208->584|2226->593|2265->594|2297->599|2407->682|2424->690|2469->714|2511->729|2526->735|2569->757|2625->787|2642->795|2681->813|2714->819|2763->838
                  LINES: 26->1|28->4|28->4|30->4|31->5|34->8|34->8|35->9|38->1|39->3|40->11|42->13|42->13|42->13|42->14|42->14|42->14|43->17|43->17|43->17|44->18|44->18|44->18|45->19|48->22|48->22|48->22|49->23|49->23|49->23|51->25|51->25|51->25|52->26|54->28|55->31|55->31|55->31|56->32|56->32|56->32|57->33|60->36|60->36|60->36|61->37|61->37|61->37|63->39|63->39|63->39|64->40|66->42
                  -- GENERATED --
              */
          