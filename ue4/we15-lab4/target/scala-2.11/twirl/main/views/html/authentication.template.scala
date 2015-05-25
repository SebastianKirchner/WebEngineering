
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
object authentication extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[DynamicForm,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(myForm : DynamicForm):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import play.i18n._
import helper._

Seq[Any](format.raw/*1.24*/("""
"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/main("login-page", "Login")/*5.29*/ {_display_(Seq[Any](format.raw/*5.31*/("""
	"""),format.raw/*6.2*/("""<!-- Login section -->
	<div role="main">
	    <section id="login" aria-labelledby="loginheading">
	       <h2 id="loginheading" class="accessibility">Login</h2>
	       
	       """),_display_(/*11.10*/if(myForm.hasGlobalErrors)/*11.36*/ {_display_(Seq[Any](format.raw/*11.38*/("""
			    """),format.raw/*12.8*/("""<div role="alert" class="errors">
			        """),_display_(/*13.13*/Messages/*13.21*/.get("error.login")),format.raw/*13.40*/("""
			    """),format.raw/*14.8*/("""</div>
			""")))}),format.raw/*15.5*/("""
			"""),_display_(/*16.5*/if(flash.contains("registration.successful"))/*16.50*/ {_display_(Seq[Any](format.raw/*16.52*/("""
		    	"""),format.raw/*17.8*/("""<div role="success" class="success">
		        	"""),_display_(/*18.13*/Messages/*18.21*/.get(flash.get("registration.successful"))),format.raw/*18.63*/("""
		    	"""),format.raw/*19.8*/("""</div>
			""")))}),format.raw/*20.5*/("""
	       
	        """),_display_(/*22.11*/helper/*22.17*/.form(action = routes.Authentication.authenticate())/*22.69*/ {_display_(Seq[Any](format.raw/*22.71*/("""
	            """),format.raw/*23.14*/("""<fieldset>
	                <legend id="logindata">Login</legend>
	                """),_display_(/*25.19*/inputField(myForm("userName"), 'required -> "required")),format.raw/*25.74*/("""
	                """),_display_(/*26.19*/inputField(myForm("password"), 'type -> "password", 'required -> "required")),format.raw/*26.95*/("""
	                """),format.raw/*27.18*/("""<input name="login" id="loginsubmit" class="greenlink formlink clickable" type="submit" value=""""),_display_(/*27.114*/Messages/*27.122*/.get("auth.login")),format.raw/*27.140*/("""" />
	            </fieldset>
	        """)))}),format.raw/*29.11*/("""
	    """),format.raw/*30.6*/("""</section>
	    <!-- Register section -->
	    <section id="registerforward" aria-labelledby="registerheading">
	        <h2 id="registerheading" class="accessibility">"""),_display_(/*33.58*/Messages/*33.66*/.get("auth.gotoreg")),format.raw/*33.86*/("""</h2>
	        <p id="registerhint">"""),_display_(/*34.32*/Messages/*34.40*/.get("auth.regquestion")),format.raw/*34.64*/("""</p>
	        <a class="contentlink orangelink" title=""""),_display_(/*35.52*/Messages/*35.60*/.get("nav.altregister")),format.raw/*35.83*/("""" href=""""),_display_(/*35.92*/routes/*35.98*/.Registration.index()),format.raw/*35.119*/("""" accesskey="r">"""),_display_(/*35.136*/Messages/*35.144*/.get("auth.gotoreg")),format.raw/*35.164*/("""</a>
	    </section>
	</div>
""")))}/*38.2*/ {_display_(Seq[Any](format.raw/*38.4*/("""
""")))}))}
  }

  def render(myForm:DynamicForm): play.twirl.api.HtmlFormat.Appendable = apply(myForm)

  def f:((DynamicForm) => play.twirl.api.HtmlFormat.Appendable) = (myForm) => apply(myForm)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon May 25 19:03:09 CEST 2015
                  SOURCE: C:/Users/Maks/Documents/we/WebEngineering/ue4/we15-lab4/app/views/authentication.scala.html
                  HASH: 12214dc8215e71acc16f6bd7a2c57abb3d910714
                  MATRIX: 737->1|881->23|909->64|937->67|972->94|1011->96|1040->99|1252->284|1287->310|1327->312|1363->321|1437->368|1454->376|1494->395|1530->404|1572->416|1604->422|1658->467|1698->469|1734->478|1811->528|1828->536|1891->578|1927->587|1969->599|2018->621|2033->627|2094->679|2134->681|2177->696|2290->782|2366->837|2413->857|2510->933|2557->952|2681->1048|2699->1056|2739->1074|2812->1116|2846->1123|3045->1295|3062->1303|3103->1323|3168->1361|3185->1369|3230->1393|3314->1450|3331->1458|3375->1481|3411->1490|3426->1496|3469->1517|3514->1534|3532->1542|3574->1562|3625->1595|3664->1597
                  LINES: 26->1|30->1|31->4|32->5|32->5|32->5|33->6|38->11|38->11|38->11|39->12|40->13|40->13|40->13|41->14|42->15|43->16|43->16|43->16|44->17|45->18|45->18|45->18|46->19|47->20|49->22|49->22|49->22|49->22|50->23|52->25|52->25|53->26|53->26|54->27|54->27|54->27|54->27|56->29|57->30|60->33|60->33|60->33|61->34|61->34|61->34|62->35|62->35|62->35|62->35|62->35|62->35|62->35|62->35|62->35|65->38|65->38
                  -- GENERATED --
              */
          