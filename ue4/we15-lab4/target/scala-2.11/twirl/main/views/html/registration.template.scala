
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
object registration extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[play.data.Form[JeopardyUser],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(myForm : play.data.Form[JeopardyUser]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import play.i18n._
import helper._

Seq[Any](format.raw/*1.41*/("""
"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/main("register-page", "registration")/*5.39*/ {_display_(Seq[Any](format.raw/*5.41*/("""
	"""),format.raw/*6.2*/("""<div id="register" role="main"> 
		<!-- Register section -->
		<h2 id="registerheading" class="accessibility">"""),_display_(/*8.51*/Messages/*8.59*/.get("register.heading")),format.raw/*8.83*/("""</h2>
		"""),_display_(/*9.4*/helper/*9.10*/.form(action = routes.Registration.create)/*9.52*/ {_display_(Seq[Any](format.raw/*9.54*/("""
			"""),format.raw/*10.4*/("""<fieldset>
				<legend>"""),_display_(/*11.14*/Messages/*11.22*/.get("register.personallegend")),format.raw/*11.53*/("""</legend>
				"""),_display_(/*12.6*/inputField(myForm("firstName"))),format.raw/*12.37*/("""
				"""),_display_(/*13.6*/inputField(myForm("lastName"))),format.raw/*13.36*/("""
				"""),_display_(/*14.6*/inputField(myForm("birthDate"), 'type -> "date")),format.raw/*14.54*/("""
				"""),format.raw/*15.5*/("""<label>"""),_display_(/*15.13*/Messages/*15.21*/.get("label.gender")),format.raw/*15.41*/(""":</label>
				<fieldset class="inputset">
					"""),_display_(/*17.7*/inputField(myForm("male"), 'type -> "radio", 'value -> "male", 'name -> "gender", 'checked -> "checked", 'after -> "")),format.raw/*17.125*/("""
					"""),_display_(/*18.7*/inputField(myForm("female"), 'type -> "radio", 'value -> "female", 'name -> "gender", 'after -> "")),format.raw/*18.106*/("""
				"""),format.raw/*19.5*/("""</fieldset>
			</fieldset>
			<fieldset>
				<legend>"""),_display_(/*22.14*/Messages/*22.22*/.get("register.loginlegend")),format.raw/*22.50*/("""</legend>
				<label for="avatar">Avatar:</label>
				<select id="avatar" name="avatar">
					<option value="ALDRICH_KILLIAN">Aldrich Killian</option>
					<option value="BEETLE">Beetle</option>
					<option value="BLACK_WIDOW">Black Widow</option>
					<option value="CAPTAIN_AMERICA">Captain America</option>
					<option value="CYCLOPS">Cyclops</option>
					<option value="DEADPOOL">Deadpool</option>
					<option value="DOCTOR_DOOM">Doctor Doom</option>
					<option value="DOCTOR_OCTOPUS">Doctor Octopus</option>
					<option value="DRAX">Drax</option>
					<option value="ELECTRO">Electro</option>
					<option value="EXTREMIS_SOLDIER">Extremis Soldier</option>
					<option value="FALCON">Falcon</option>
					<option value="GAMORA">Gamora</option>
					<option value="GREEN_GOBLIN">Green Goblin</option>
					<option value="GROOT">Groot</option>
					<option value="HAWKEYE">Hawkeye</option>
					<option value="HULK">Hulk</option>
					<option value="HYDRA_HENCHMAN">Hydra Henchman</option>
					<option value="IRON_FIST">Iron Fist</option>
					<option value="IRON_MAN">Iron Man</option>
					<option value="J_JONAH_JAMESON">J. Jonah Jameson</option>
					<option value="LOKI">Loki</option>
					<option value="MAGNETO">Magneto</option>
					<option value="MARY_JANE_WATSON">Mary Jane Watson</option>
					<option value="MODOK">MODOK</option>
					<option value="NEBULA">Nebula</option>
					<option value="NICK_FURY">Nick Fury</option>
					<option value="NOVA">Nova</option>
					<option value="PEPPER_POTTS">Pepper Potts</option>
					<option value="POWER_MAN">Power Man</option>
					<option value="RED_SKULL">Red Skull</option>
					<option value="ROCKET_RACCOON">Rocket Raccoon</option>
					<option value="RONAN">Ronan</option>
					<option value="SPIDERMAN">Spiderman</option>
					<option value="STARLORD">Starlord</option>
					<option value="Taskmaster">Taskmaster</option>
					<option value="THE_MANDARIN">The Mandarin</option>
					<option value="THOR">Thor</option>
					<option value="TONY_STARK">Tony Stark</option>
					<option value="VENOM">Venom</option>
					<option value="WAR_MACHINE">War Machine</option>
					<option value="WOLVERINE">Wolverine</option>
				</select>
				"""),_display_(/*68.6*/inputField(myForm("userName"))),format.raw/*68.36*/("""
				"""),_display_(/*69.6*/inputField(myForm("password"), 'type -> "password")),format.raw/*69.57*/("""
				"""),format.raw/*70.5*/("""<input class="greenlink formlink" type="submit" value="   """),_display_(/*70.64*/Messages/*70.72*/.get("nav.register")),format.raw/*70.92*/("""" accesskey="s"/>
				<p id="requiredhint">"""),_display_(/*71.27*/Messages/*71.35*/.get("form.requiredhint")),format.raw/*71.60*/("""</p>
			</fieldset>
		""")))}),format.raw/*73.4*/("""
	"""),format.raw/*74.2*/("""</div>
""")))}/*75.2*/ {_display_(Seq[Any](format.raw/*75.4*/("""
""")))}))}
  }

  def render(myForm:play.data.Form[JeopardyUser]): play.twirl.api.HtmlFormat.Appendable = apply(myForm)

  def f:((play.data.Form[JeopardyUser]) => play.twirl.api.HtmlFormat.Appendable) = (myForm) => apply(myForm)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon May 25 19:03:22 CEST 2015
                  SOURCE: C:/Users/Maks/Documents/we/WebEngineering/ue4/we15-lab4/app/views/registration.scala.html
                  HASH: 16f8cbc48d00004e6d21c93561f2e681faf926bc
                  MATRIX: 752->1|913->40|941->81|969->84|1014->121|1053->123|1082->126|1221->239|1237->247|1281->271|1316->281|1330->287|1380->329|1419->331|1451->336|1503->361|1520->369|1572->400|1614->416|1666->447|1699->454|1750->484|1783->491|1852->539|1885->545|1920->553|1937->561|1978->581|2054->631|2194->749|2228->757|2349->856|2382->862|2466->919|2483->927|2532->955|4813->3210|4864->3240|4897->3247|4969->3298|5002->3304|5088->3363|5105->3371|5146->3391|5218->3436|5235->3444|5281->3469|5336->3494|5366->3497|5393->3506|5432->3508
                  LINES: 26->1|30->1|31->4|32->5|32->5|32->5|33->6|35->8|35->8|35->8|36->9|36->9|36->9|36->9|37->10|38->11|38->11|38->11|39->12|39->12|40->13|40->13|41->14|41->14|42->15|42->15|42->15|42->15|44->17|44->17|45->18|45->18|46->19|49->22|49->22|49->22|95->68|95->68|96->69|96->69|97->70|97->70|97->70|97->70|98->71|98->71|98->71|100->73|101->74|102->75|102->75
                  -- GENERATED --
              */
          