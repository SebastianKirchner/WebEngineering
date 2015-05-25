
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
                  DATE: Mon May 25 19:03:18 CEST 2015
                  SOURCE: C:/Users/Maks/Documents/we/WebEngineering/ue4/we15-lab4/app/views/jeopardy.scala.html
                  HASH: 08f457bba03ed51df95bb88fdad402f3fc68089d
                  MATRIX: 739->1|871->72|884->78|925->109|947->123|1009->28|1037->69|1066->106|1095->155|1125->160|1172->199|1211->201|1245->209|1326->263|1464->379|1505->392|1722->582|1914->752|1956->767|2150->939|2207->969|2242->995|2282->997|2325->1012|2374->1034|2389->1040|2430->1060|2459->1062|2476->1070|2517->1090|2546->1092|2564->1100|2610->1124|2640->1126|2664->1140|2719->1173|2749->1175|2767->1183|2809->1203|2839->1204|2870->1207|2894->1221|2927->1232|2957->1234|2975->1242|3021->1266|3072->1286|3114->1301|3129->1307|3192->1361|3232->1363|3277->1380|3362->1438|3379->1446|3429->1475|3483->1502|3554->1557|3594->1559|3643->1580|3722->1632|3739->1640|3793->1672|3852->1704|3869->1712|3922->1744|4030->1825|4047->1833|4084->1849|4121->1859|4138->1867|4179->1886|4228->1907|4334->1986|4408->2044|4448->2046|4498->2068|4599->2142|4623->2145|4652->2147|4676->2150|4713->2160|4730->2168|4760->2176|4804->2192|4846->2224|4886->2225|4938->2245|5035->2315|5059->2318|5088->2320|5112->2323|5142->2326|5159->2334|5191->2345|5220->2346|5295->2390|5344->2411|5426->2462|5471->2479|5626->2606|5644->2614|5689->2637|5753->2670|5792->2681|5970->2832|5987->2840|6033->2865|6083->2888|6100->2896|6142->2917|6172->2920|6189->2928|6228->2946|6284->2984|6323->2986|6358->2994|6531->3139|6560->3140|6606->3158|6695->3219|6724->3220|6771->3239|6919->3359|6948->3360|6999->3383|7332->3688|7361->3689|7404->3704|7433->3705|7475->3719|7504->3720
                  LINES: 26->1|29->5|29->5|29->6|29->6|30->1|31->4|32->5|33->6|35->8|35->8|35->8|36->9|38->11|38->11|40->13|43->16|43->16|44->17|44->17|46->19|46->19|46->19|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|47->20|48->21|49->22|49->22|49->22|49->22|50->23|51->24|51->24|51->24|52->25|52->25|52->25|53->26|53->26|53->26|53->26|54->27|54->27|54->27|55->28|55->28|55->28|55->28|55->28|55->28|56->29|58->31|58->31|58->31|59->32|60->33|60->33|60->33|60->33|60->33|60->33|60->33|60->33|60->33|60->33|60->33|61->34|61->34|61->34|61->34|61->34|61->34|61->34|61->34|63->36|64->37|66->39|67->40|68->41|68->41|68->41|69->42|70->43|73->46|73->46|73->46|74->47|74->47|74->47|74->47|74->47|74->47|77->50|77->50|78->51|82->55|82->55|83->56|84->57|84->57|85->58|86->59|86->59|87->60|93->66|93->66|94->67|94->67|95->68|95->68
                  -- GENERATED --
              */
          