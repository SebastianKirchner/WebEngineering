
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
object winner extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[models.JeopardyGame,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(game: models.JeopardyGame):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import play.i18n._
import helper._

Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/main("winner-page", "Gewinnanzeige")/*5.38*/ {_display_(Seq[Any](format.raw/*5.40*/("""      
      """),format.raw/*6.7*/("""<!-- Content -->
      <div role="main">
		"""),_display_(/*8.4*/gameInfo(game.getLeader(), game.getSecond(), game.getMaxQuestions(), game.isHumanPlayer(game.getLeader().getUser()))),format.raw/*8.120*/("""
         """),format.raw/*9.10*/("""<section id="newgame" aria-labelledby="newgameheading">
             <h2 id="newgameheading" class="accessibility">"""),_display_(/*10.61*/Messages/*10.69*/.get("quizover.newgame")),format.raw/*10.93*/("""</h2>
             """),_display_(/*11.15*/helper/*11.21*/.form(routes.GameController.newGame())/*11.59*/ {_display_(Seq[Any](format.raw/*11.61*/("""
             """),format.raw/*12.14*/("""<input name="newgame" id="new_game" class="orangelink contentlink" type="submit" value=""""),_display_(/*12.103*/Messages/*12.111*/.get("quizover.newgame")),format.raw/*12.135*/("""" />
             """)))}),format.raw/*13.15*/("""
"""),format.raw/*14.1*/("""<!--          	 <a class="orangelink contentlink" id="new_game" href=""""),_display_(/*14.72*/routes/*14.78*/.GameController.newGame()),format.raw/*14.103*/("""">"""),_display_(/*14.106*/Messages/*14.114*/.get("quizover.newgame")),format.raw/*14.138*/("""</a>
 -->         </section>
      </div>
""")))}/*17.2*/ {_display_(Seq[Any](format.raw/*17.4*/("""
		"""),format.raw/*18.3*/("""<script type="text/javascript">
        //<![CDATA[
           $(document).ready(function()"""),format.raw/*20.40*/("""{"""),format.raw/*20.41*/("""
         	   """),format.raw/*21.14*/("""if(supportsLocalStorage())"""),format.raw/*21.40*/("""{"""),format.raw/*21.41*/("""
         		   """),format.raw/*22.15*/("""localStorage["lastGame"] = new Date().getTime();
         	   """),format.raw/*23.14*/("""}"""),format.raw/*23.15*/("""
           """),format.raw/*24.12*/("""}"""),format.raw/*24.13*/(""");
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
                  DATE: Mon May 25 19:03:23 CEST 2015
                  SOURCE: C:/Users/Maks/Documents/we/WebEngineering/ue4/we15-lab4/app/views/winner.scala.html
                  HASH: 72c06b2b2707a93293efc77ad3399265825ad5ea
                  MATRIX: 737->1|886->28|914->69|942->72|986->108|1025->110|1065->124|1136->170|1273->286|1311->297|1455->414|1472->422|1517->446|1565->467|1580->473|1627->511|1667->513|1710->528|1827->617|1845->625|1891->649|1942->669|1971->671|2069->742|2084->748|2131->773|2162->776|2180->784|2226->808|2290->854|2329->856|2360->860|2481->953|2510->954|2553->969|2607->995|2636->996|2680->1012|2771->1075|2800->1076|2841->1089|2870->1090
                  LINES: 26->1|30->1|31->4|32->5|32->5|32->5|33->6|35->8|35->8|36->9|37->10|37->10|37->10|38->11|38->11|38->11|38->11|39->12|39->12|39->12|39->12|40->13|41->14|41->14|41->14|41->14|41->14|41->14|41->14|44->17|44->17|45->18|47->20|47->20|48->21|48->21|48->21|49->22|50->23|50->23|51->24|51->24
                  -- GENERATED --
              */
          