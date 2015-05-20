
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
object question extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[models.JeopardyGame,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(game: models.JeopardyGame):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import play.i18n._
import helper._
def /*5.2*/question/*5.10*/ = {{game.getHumanPlayer().getChosenQuestion()}};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*4.1*/("""
"""),format.raw/*5.57*/("""

"""),_display_(/*7.2*/main("question-page", "Frage")/*7.32*/ {_display_(Seq[Any](format.raw/*7.34*/("""
"""),format.raw/*8.1*/("""<!-- Content -->
<div role="main"> 
	<!-- info -->
	"""),_display_(/*11.3*/gameInfo(game.getLeader(), game.getSecond(), game.getMaxQuestions(), game.isHumanPlayer(game.getLeader().getUser()))),format.raw/*11.119*/("""
	
	"""),format.raw/*13.2*/("""<!-- Question -->
	<section id="question" aria-labelledby="questionheading">
			"""),_display_(/*15.5*/helper/*15.11*/.form(action=routes.GameController.submitAnswers(), 'id -> "questionform")/*15.85*/ {_display_(Seq[Any](format.raw/*15.87*/("""
				 """),format.raw/*16.6*/("""<h2 id="questionheading" class="accessibility">Frage</h2>
				 <p id="questiontype">"""),_display_(/*17.28*/question/*17.36*/.getCategory().getName(lang.code)),format.raw/*17.69*/(""" """),_display_(/*17.71*/Messages/*17.79*/.get("jeopardy.for")),format.raw/*17.99*/(""" """),_display_(/*17.101*/question/*17.109*/.getValue()),format.raw/*17.120*/(""" """),format.raw/*17.121*/("""€</p>
				 <p id="questiontext">"""),_display_(/*18.28*/question/*18.36*/.getText(lang.code)),format.raw/*18.55*/("""</p>
				 <ul id="answers">
				 """),_display_(/*20.7*/for(answer <- question.getShuffledAnswers()) yield /*20.51*/ {_display_(Seq[Any](format.raw/*20.53*/("""
				 	"""),format.raw/*21.7*/("""<li>
				 		<input name="answers[]" id="answer_"""),_display_(/*22.44*/answer/*22.50*/.getId()),format.raw/*22.58*/("""" value=""""),_display_(/*22.68*/answer/*22.74*/.getId()),format.raw/*22.82*/("""" type="checkbox"/>
				 		<label class="tile clickable" for="answer_"""),_display_(/*23.51*/answer/*23.57*/.getId()),format.raw/*23.65*/("""">"""),_display_(/*23.68*/answer/*23.74*/.getText(lang.code)),format.raw/*23.93*/("""</label>
				 	</li>
				 """)))}),format.raw/*25.7*/("""
				 """),format.raw/*26.6*/("""</ul>
				 <input id="timeleftvalue" type="hidden" value="100"/>
				 <input class="greenlink formlink clickable" name="answer_submit" id="next" type="submit" value=""""),_display_(/*28.103*/Messages/*28.111*/.get("jeopardy.answer")),format.raw/*28.134*/("""" accesskey="s"/>
			""")))}),format.raw/*29.5*/("""
	 """),format.raw/*30.3*/("""</section>
			
	 <section id="timer" aria-labelledby="timerheading">
			<h2 id="timerheading" class="accessibility">Timer</h2>
			<p><span id="timeleftlabel">"""),_display_(/*34.33*/Messages/*34.41*/.get("quiz.timeleft")),format.raw/*34.62*/(""":</span> <time id="timeleft">00:30</time></p>
			<meter id="timermeter" min="0" low="20" value="100" max="100"/>
	 </section>
</div>
""")))}/*38.2*/ {_display_(Seq[Any](format.raw/*38.4*/("""
"""),format.raw/*39.1*/("""<script type="text/javascript">
	//<![CDATA[
	
	// initialize time
	$(document).ready(function() """),format.raw/*43.31*/("""{"""),format.raw/*43.32*/("""
			"""),format.raw/*44.4*/("""var maxtime = 30;
			var hiddenInput = $("#timeleftvalue");
			var meter = $("#timer meter");
			var timeleft = $("#timeleft");
			
			hiddenInput.val(maxtime);
			meter.val(maxtime);
			meter.attr('max', maxtime);
			meter.attr('low', maxtime/100*20);
			timeleft.text(secToMMSS(maxtime));
	"""),format.raw/*54.2*/("""}"""),format.raw/*54.3*/(""");
	
	// update time
	function timeStep() """),format.raw/*57.22*/("""{"""),format.raw/*57.23*/("""
			"""),format.raw/*58.4*/("""var hiddenInput = $("#timeleftvalue");
			var meter = $("#timer meter");
			var timeleft = $("#timeleft");
			
			var value = $("#timeleftvalue").val();
			if(value > 0) """),format.raw/*63.18*/("""{"""),format.raw/*63.19*/("""
					"""),format.raw/*64.6*/("""value = value - 1;   
			"""),format.raw/*65.4*/("""}"""),format.raw/*65.5*/("""
			
			"""),format.raw/*67.4*/("""hiddenInput.val(value);
			meter.val(value);
			timeleft.text(secToMMSS(value));
			
			if(value <= 0) """),format.raw/*71.19*/("""{"""),format.raw/*71.20*/("""
					"""),format.raw/*72.6*/("""$('#questionform').submit();
			"""),format.raw/*73.4*/("""}"""),format.raw/*73.5*/("""
	"""),format.raw/*74.2*/("""}"""),format.raw/*74.3*/("""
	
	"""),format.raw/*76.2*/("""window.setInterval(timeStep, 1000);
	
	//]]>
</script>
""")))}))}
  }

  def render(game:models.JeopardyGame): play.twirl.api.HtmlFormat.Appendable = apply(game)

  def f:((models.JeopardyGame) => play.twirl.api.HtmlFormat.Appendable) = (game) => apply(game)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed May 20 18:36:39 CEST 2015
                  SOURCE: E:/IntelliJProjects/WebEngineeringMaven/ue4/we15-lab4/app/views/question.scala.html
                  HASH: bf62df8a13c27806c092a5c4a624330ccf4e23b4
                  MATRIX: 739->1|871->68|887->76|964->28|991->66|1019->123|1047->126|1085->156|1124->158|1151->159|1230->212|1368->328|1399->332|1506->413|1521->419|1604->493|1644->495|1677->501|1789->586|1806->594|1860->627|1889->629|1906->637|1947->657|1977->659|1995->667|2028->678|2058->679|2118->712|2135->720|2175->739|2235->773|2295->817|2335->819|2369->826|2444->874|2459->880|2488->888|2525->898|2540->904|2569->912|2666->982|2681->988|2710->996|2740->999|2755->1005|2795->1024|2852->1051|2885->1057|3080->1224|3098->1232|3143->1255|3195->1277|3225->1280|3411->1439|3428->1447|3470->1468|3622->1602|3661->1604|3689->1605|3814->1702|3843->1703|3874->1707|4193->1999|4221->2000|4291->2042|4320->2043|4351->2047|4549->2217|4578->2218|4611->2224|4663->2249|4691->2250|4726->2258|4857->2361|4886->2362|4919->2368|4978->2400|5006->2401|5035->2403|5063->2404|5094->2408
                  LINES: 26->1|29->5|29->5|30->1|31->4|32->5|34->7|34->7|34->7|35->8|38->11|38->11|40->13|42->15|42->15|42->15|42->15|43->16|44->17|44->17|44->17|44->17|44->17|44->17|44->17|44->17|44->17|44->17|45->18|45->18|45->18|47->20|47->20|47->20|48->21|49->22|49->22|49->22|49->22|49->22|49->22|50->23|50->23|50->23|50->23|50->23|50->23|52->25|53->26|55->28|55->28|55->28|56->29|57->30|61->34|61->34|61->34|65->38|65->38|66->39|70->43|70->43|71->44|81->54|81->54|84->57|84->57|85->58|90->63|90->63|91->64|92->65|92->65|94->67|98->71|98->71|99->72|100->73|100->73|101->74|101->74|103->76
                  -- GENERATED --
              */
          