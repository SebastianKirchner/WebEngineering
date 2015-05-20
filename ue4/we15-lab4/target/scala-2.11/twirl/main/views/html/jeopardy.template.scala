
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
object jeopardy extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[models.JeopardyGame,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(game: models.JeopardyGame):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import play.i18n._
import helper._
def /*5.2*/marvin/*5.8*/ = {{game.getMarvinPlayer()}};def /*6.2*/marvinQuestion/*6.16*/ = {{marvin.getChosenQuestion()}};
Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*4.1*/("""
"""),format.raw/*5.36*/("""
"""),format.raw/*6.48*/("""

"""),_display_(/*8.2*/main("selection-page", "Fragenauswahl")/*8.41*/ {_display_(Seq[Any](format.raw/*8.43*/("""
      """),format.raw/*9.7*/("""<!-- Content -->
      <div role="main"> 
         """),_display_(/*11.11*/gameInfo(game.getLeader(), game.getSecond(), game.getMaxQuestions(), game.isHumanPlayer(game.getLeader().getUser()))),format.raw/*11.127*/("""

         """),format.raw/*13.10*/("""<!-- Question -->
         <section id="question-selection" aria-labelledby="questionheading">
            <h2 id="questionheading" class="black accessibility">Jeopardy</h2>
            """),_display_(/*16.14*/userinfo(game.getHumanPlayer(), true, Messages.get("userinfo.human"), Messages.get("userinfo.computer"), Messages.get("userinfo.correct"), Messages.get("userinfo.wrong"))),format.raw/*16.184*/("""
            """),_display_(/*17.14*/userinfo(game.getMarvinPlayer(), false, Messages.get("userinfo.human"), Messages.get("userinfo.computer"), Messages.get("userinfo.correct"), Messages.get("userinfo.wrong"))),format.raw/*17.186*/("""
            
             """),_display_(/*19.15*/if(marvinQuestion != null)/*19.41*/ {_display_(Seq[Any](format.raw/*19.43*/("""
            	"""),format.raw/*20.14*/("""<p class="user-info">"""),_display_(/*20.36*/marvin/*20.42*/.getUser().getName()),format.raw/*20.62*/(""" """),_display_(/*20.64*/Messages/*20.72*/.get("jeopardy.has")),format.raw/*20.92*/(""" """),_display_(/*20.94*/Messages/*20.102*/.get("jeopardy.chosen1")),format.raw/*20.126*/(""" """),_display_(/*20.128*/marvinQuestion/*20.142*/.getCategory().getName(lang.code)),format.raw/*20.175*/(""" """),_display_(/*20.177*/Messages/*20.185*/.get("jeopardy.for")),format.raw/*20.205*/(""" """),format.raw/*20.206*/("""€ """),_display_(/*20.209*/marvinQuestion/*20.223*/.getValue()),format.raw/*20.234*/(""" """),_display_(/*20.236*/Messages/*20.244*/.get("jeopardy.chosen2")),format.raw/*20.268*/(""".</p>
            """)))}),format.raw/*21.14*/("""
            """),_display_(/*22.14*/helper/*22.20*/.form(action=routes.GameController.questionSelected())/*22.74*/ {_display_(Seq[Any](format.raw/*22.76*/("""
               """),format.raw/*23.16*/("""<fieldset>
               <legend class="accessibility">"""),_display_(/*24.47*/Messages/*24.55*/.get("acc.questionselection")),format.raw/*24.84*/("""</legend>
               """),_display_(/*25.17*/for((category, i) <- game.getCategories().zipWithIndex) yield /*25.72*/ {_display_(Seq[Any](format.raw/*25.74*/("""
               	   """),format.raw/*26.20*/("""<section class="questioncategory" aria-labelledby=""""),_display_(/*26.72*/Messages/*26.80*/.get("id."+category.getNameEN())),format.raw/*26.112*/("""">
	                  <h3 id=""""),_display_(/*27.29*/Messages/*27.37*/.get("id."+category.getNameEN())),format.raw/*27.69*/("""" class="tile category-title">
	                  	<span class="accessibility">"""),_display_(/*28.50*/Messages/*28.58*/.get("category")),format.raw/*28.74*/(""": </span>"""),_display_(/*28.84*/category/*28.92*/.getName(lang.code)),format.raw/*28.111*/("""
	                  """),format.raw/*29.20*/("""</h3>
	                  <ol class="category_questions">
	                  """),_display_(/*31.21*/for((question, j) <- category.getQuestions().zipWithIndex) yield /*31.79*/ {_display_(Seq[Any](format.raw/*31.81*/("""
	                  	"""),format.raw/*32.21*/("""<li>
	                  		<input name="question_selection" id="question_"""),_display_(/*33.69*/(i)),format.raw/*33.72*/("""_"""),_display_(/*33.74*/(j)),format.raw/*33.77*/("""" value=""""),_display_(/*33.87*/question/*33.95*/.getId()),format.raw/*33.103*/("""" type="radio" """),_display_(/*33.119*/if(game.hasBeenChosen(question))/*33.151*/{_display_(Seq[Any](format.raw/*33.152*/("""disabled="disabled"""")))}),format.raw/*33.172*/("""/>
	                  		<label class="tile clickable" for="question_"""),_display_(/*34.67*/(i)),format.raw/*34.70*/("""_"""),_display_(/*34.72*/(j)),format.raw/*34.75*/("""">"""),_display_(/*34.78*/question/*34.86*/.getValue()),format.raw/*34.97*/(""" """),format.raw/*34.98*/("""€</label>
						</li>
	                  """)))}),format.raw/*36.21*/("""
	                  """),format.raw/*37.20*/("""</ol>
	               </section>
               """)))}),format.raw/*39.17*/("""
               """),format.raw/*40.16*/("""</fieldset>
               <input class="greenlink formlink clickable" name="question_submit" id="next" type="submit" value=""""),_display_(/*41.115*/Messages/*41.123*/.get("jeopardy.choose")),format.raw/*41.146*/("""" accesskey="s" />
            """)))}),format.raw/*42.14*/("""
         """),format.raw/*43.10*/("""</section>
         
         <section id="lastgame" aria-labelledby="lastgameheading">
            <h2 id="lastgameheading" class="accessibility">"""),_display_(/*46.61*/Messages/*46.69*/.get("quiz.lastgameinfo")),format.raw/*46.94*/("""</h2>
            <p>"""),_display_(/*47.17*/Messages/*47.25*/.get("quiz.lastgame")),format.raw/*47.46*/(""": """),_display_(/*47.49*/Messages/*47.57*/.get("quiz.never")),format.raw/*47.75*/("""</p>
         </section>
		</div>
""")))}/*50.2*/ {_display_(Seq[Any](format.raw/*50.4*/("""	  
	  """),format.raw/*51.4*/("""<script type="text/javascript">
            //<![CDATA[
            
            // initialize time
            $(document).ready(function() """),format.raw/*55.42*/("""{"""),format.raw/*55.43*/("""
                """),format.raw/*56.17*/("""// set last game
                if(supportsLocalStorage()) """),format.raw/*57.44*/("""{"""),format.raw/*57.45*/("""
	                """),format.raw/*58.18*/("""var lastGameMillis = parseInt(localStorage['lastGame'])
	                if(!isNaN(parseInt(localStorage['lastGame'])))"""),format.raw/*59.64*/("""{"""),format.raw/*59.65*/("""
	                    """),format.raw/*60.22*/("""var lastGame = new Date(lastGameMillis);
	                	$("#lastgame p").replaceWith('<p>Letztes Spiel: <time datetime="'
	                			+ lastGame.toUTCString()
	                			+ '">'
	                			+ lastGame.toLocaleString()
	                			+ '</time></p>')
	                """),format.raw/*66.18*/("""}"""),format.raw/*66.19*/("""
            	"""),format.raw/*67.14*/("""}"""),format.raw/*67.15*/("""
            """),format.raw/*68.13*/("""}"""),format.raw/*68.14*/(""");            
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
                  SOURCE: E:/IntelliJProjects/WebEngineeringMaven/ue4/we15-lab4/app/views/jeopardy.scala.html
                  HASH: 7ba16a8e35095e3f851e3b26e176f30c526ba222
                  MATRIX: 739->1|871->68|884->74|925->104|947->118|1009->28|1036->66|1064->102|1092->150|1120->153|1167->192|1206->194|1239->201|1318->253|1456->369|1495->380|1709->567|1901->737|1942->751|2136->923|2191->951|2226->977|2266->979|2308->993|2357->1015|2372->1021|2413->1041|2442->1043|2459->1051|2500->1071|2529->1073|2547->1081|2593->1105|2623->1107|2647->1121|2702->1154|2732->1156|2750->1164|2792->1184|2822->1185|2853->1188|2877->1202|2910->1213|2940->1215|2958->1223|3004->1247|3054->1266|3095->1280|3110->1286|3173->1340|3213->1342|3257->1358|3341->1415|3358->1423|3408->1452|3461->1478|3532->1533|3572->1535|3620->1555|3699->1607|3716->1615|3770->1647|3828->1678|3845->1686|3898->1718|4005->1798|4022->1806|4059->1822|4096->1832|4113->1840|4154->1859|4202->1879|4306->1956|4380->2014|4420->2016|4469->2037|4569->2110|4593->2113|4622->2115|4646->2118|4683->2128|4700->2136|4730->2144|4774->2160|4816->2192|4856->2193|4908->2213|5004->2282|5028->2285|5057->2287|5081->2290|5111->2293|5128->2301|5160->2312|5189->2313|5262->2355|5310->2375|5390->2424|5434->2440|5588->2566|5606->2574|5651->2597|5714->2629|5752->2639|5927->2787|5944->2795|5990->2820|6039->2842|6056->2850|6098->2871|6128->2874|6145->2882|6184->2900|6237->2935|6276->2937|6310->2944|6479->3085|6508->3086|6553->3103|6641->3163|6670->3164|6716->3182|6863->3301|6892->3302|6942->3324|7269->3623|7298->3624|7340->3638|7369->3639|7410->3652|7439->3653
                  LINES: 26->1|29->5|29->5|29->6|29->6|30->1|31->4|32->5|33->6|35->8|35->8|35->8|36->9|38->11|38->11|40->13|43->16|43->16|44->17|44->17|46->19|46->19|46->19|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|48->21|49->22|49->22|49->22|49->22|50->23|51->24|51->24|51->24|52->25|52->25|52->25|53->26|53->26|53->26|53->26|54->27|54->27|54->27|55->28|55->28|55->28|55->28|55->28|55->28|56->29|58->31|58->31|58->31|59->32|60->33|60->33|60->33|60->33|60->33|60->33|60->33|60->33|60->33|60->33|60->33|61->34|61->34|61->34|61->34|61->34|61->34|61->34|61->34|63->36|64->37|66->39|67->40|68->41|68->41|68->41|69->42|70->43|73->46|73->46|73->46|74->47|74->47|74->47|74->47|74->47|74->47|77->50|77->50|78->51|82->55|82->55|83->56|84->57|84->57|85->58|86->59|86->59|87->60|93->66|93->66|94->67|94->67|95->68|95->68
                  -- GENERATED --
              */
          