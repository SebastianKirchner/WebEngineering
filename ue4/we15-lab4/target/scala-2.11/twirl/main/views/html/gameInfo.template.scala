
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
object gameInfo extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[models.Player,models.Player,Int,Boolean,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(leader: models.Player, second: models.Player, totalQuestions: Int, leaderYou: Boolean):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import play.i18n._
def /*8.2*/state/*8.7*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](_display_(/*8.12*/if(gameOver)/*8.24*/{_display_(Seq[Any](format.raw/*8.25*/("""winner""")))}/*8.32*/else/*8.36*/{_display_(Seq[Any](format.raw/*8.37*/("""game""")))})))};def /*9.2*/leaderId/*9.10*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](_display_(/*9.15*/if(gameOver)/*9.27*/{_display_(Seq[Any](format.raw/*9.28*/("""winnerannouncement""")))}/*9.47*/else/*9.51*/{_display_(Seq[Any](format.raw/*9.52*/("""firstplayerheading""")))})))};def /*10.2*/loserId/*10.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](_display_(/*10.14*/if(gameOver)/*10.26*/{_display_(Seq[Any](format.raw/*10.27*/("""loserheading""")))}/*10.40*/else/*10.44*/{_display_(Seq[Any](format.raw/*10.45*/("""secondplayerheading""")))})))};def /*19.2*/avatar/*19.8*/(player: models.Player, full: Boolean = false):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*19.58*/("""
	"""),format.raw/*20.2*/("""<img class="avatar" src="/assets/images/avatar/"""),_display_(/*20.50*/img(player, full)),format.raw/*20.67*/(""""
		 alt="Avatar """),_display_(/*21.17*/player/*21.23*/.getUser().getAvatar().getName()),format.raw/*21.55*/("""" />
""")))};def /*5.2*/askedQuestions/*5.16*/ = {{leader.getAnsweredQuestions().size()}};def /*6.2*/gameOver/*6.10*/ = {{askedQuestions == totalQuestions}};def /*12.2*/img/*12.5*/(player: models.Player, full: Boolean) = {{
	if(gameOver && full){
		player.getUser().getAvatar().getImageFull()
	} else {
		player.getUser().getAvatar().getImageHead()
	}
}};
Seq[Any](format.raw/*1.89*/("""
"""),format.raw/*3.1*/("""

"""),format.raw/*5.58*/("""
"""),format.raw/*6.48*/("""

"""),format.raw/*8.43*/("""
"""),format.raw/*9.72*/("""
"""),format.raw/*10.66*/("""

"""),format.raw/*18.2*/("""
"""),format.raw/*22.2*/("""

"""),_display_(/*24.2*/if(gameOver)/*24.14*/{_display_(Seq[Any](format.raw/*24.15*/("""
	"""),_display_(/*25.3*/userinfo(leader, leaderYou, Messages.get("userinfo.human"), Messages.get("userinfo.computer"), Messages.get("userinfo.correct"), Messages.get("userinfo.wrong"))),format.raw/*25.163*/("""
	"""),_display_(/*26.3*/userinfo(second, !leaderYou, Messages.get("userinfo.human"), Messages.get("userinfo.computer"), Messages.get("userinfo.correct"), Messages.get("userinfo.wrong"))),format.raw/*26.164*/("""
""")))}),format.raw/*27.2*/("""

"""),format.raw/*29.1*/("""<section id="gameinfo" aria-labelledby="gameinfoheading">
   <h2 id=""""),_display_(/*30.13*/(state)),format.raw/*30.20*/("""infoheading" class="accessibility">"""),_display_(/*30.56*/Messages/*30.64*/.get("gameinfo.accessibility." + state)),format.raw/*30.103*/("""</h2>
   
   <section """),_display_(/*32.14*/if(!gameOver)/*32.27*/{_display_(Seq[Any](format.raw/*32.28*/("""id="firstplayer"""")))}),format.raw/*32.45*/(""" """),format.raw/*32.46*/("""class="playerinfo leader" aria-labelledby=""""),_display_(/*32.90*/leaderId),format.raw/*32.98*/("""">
      <h3 id=""""),_display_(/*33.16*/leaderId),format.raw/*33.24*/("""" """),_display_(/*33.27*/if(!gameOver)/*33.40*/{_display_(Seq[Any](format.raw/*33.41*/("""class="accessibility"""")))}),format.raw/*33.63*/(""">
      	"""),_display_(/*34.9*/Messages/*34.17*/.get("gameinfo.leader")),format.raw/*34.40*/(""": """),_display_(/*34.43*/leader/*34.49*/.getUser().getName()),format.raw/*34.69*/("""
      """),format.raw/*35.7*/("""</h3>
      """),_display_(/*36.8*/avatar(leader, true)),format.raw/*36.28*/("""
      """),format.raw/*37.7*/("""<table>
         <tr>
            <th class="accessibility">"""),_display_(/*39.40*/Messages/*39.48*/.get("gameinfo.playername")),format.raw/*39.75*/("""</th>
            <td class="playername">"""),_display_(/*40.37*/leader/*40.43*/.getUser().getName()),_display_(/*40.64*/if(leaderYou)/*40.77*/{_display_(Seq[Any](format.raw/*40.78*/(""" """),format.raw/*40.79*/("""("""),_display_(/*40.81*/Messages/*40.89*/.get("gameinfo.you")),format.raw/*40.109*/(""")""")))}),format.raw/*40.111*/("""</td>
         </tr>
         <tr>
            <th class="accessibility">"""),_display_(/*43.40*/Messages/*43.48*/.get("gameinfo.playerscore")),format.raw/*43.76*/("""</th>
            <td class="playerpoints">"""),_display_(/*44.39*/leader/*44.45*/.getProfit()),format.raw/*44.57*/(""" """),format.raw/*44.58*/("""€</td>
         </tr>
      </table>
   </section>
   <section """),_display_(/*48.14*/if(!gameOver)/*48.27*/{_display_(Seq[Any](format.raw/*48.28*/("""id="secondplayer"""")))}),format.raw/*48.46*/(""" """),format.raw/*48.47*/("""class="playerinfo" aria-labelledby=""""),_display_(/*48.84*/loserId),format.raw/*48.91*/("""">
      <h3 id=""""),_display_(/*49.16*/loserId),format.raw/*49.23*/("""" class="accessibility">"""),_display_(/*49.48*/Messages/*49.56*/.get("gameinfo.secondplayer")),format.raw/*49.85*/("""</h3>
      """),_display_(/*50.8*/avatar(second)),format.raw/*50.22*/("""
      """),format.raw/*51.7*/("""<table>
         <tr>
            <th class="accessibility">"""),_display_(/*53.40*/Messages/*53.48*/.get("gameinfo.playername")),format.raw/*53.75*/("""</th>
            <td class="playername">"""),_display_(/*54.37*/second/*54.43*/.getUser().getName()),_display_(/*54.64*/if(!leaderYou)/*54.78*/{_display_(Seq[Any](format.raw/*54.79*/(""" """),format.raw/*54.80*/("""("""),_display_(/*54.82*/Messages/*54.90*/.get("gameinfo.you")),format.raw/*54.110*/(""")""")))}),format.raw/*54.112*/("""</td>
         </tr>
         <tr>
            <th class="accessibility">"""),_display_(/*57.40*/Messages/*57.48*/.get("gameinfo.playerscore")),format.raw/*57.76*/("""</th>
            <td class="playerpoints">"""),_display_(/*58.39*/second/*58.45*/.getProfit()),format.raw/*58.57*/(""" """),format.raw/*58.58*/("""€</td>
         </tr>
      </table>
   </section>
   
   """),_display_(/*63.5*/if(askedQuestions > 0 && !gameOver)/*63.40*/ {_display_(Seq[Any](format.raw/*63.42*/("""
   	"""),format.raw/*64.5*/("""<p id="round">"""),_display_(/*64.20*/Messages/*64.28*/.get("gameinfo.questions")),format.raw/*64.54*/(""": """),_display_(/*64.57*/askedQuestions),format.raw/*64.71*/(""" """),format.raw/*64.72*/("""/ """),_display_(/*64.75*/totalQuestions),format.raw/*64.89*/("""</p>
   """)))}),format.raw/*65.5*/("""
   
"""),format.raw/*67.1*/("""</section>"""))}
  }

  def render(leader:models.Player,second:models.Player,totalQuestions:Int,leaderYou:Boolean): play.twirl.api.HtmlFormat.Appendable = apply(leader,second,totalQuestions,leaderYou)

  def f:((models.Player,models.Player,Int,Boolean) => play.twirl.api.HtmlFormat.Appendable) = (leader,second,totalQuestions,leaderYou) => apply(leader,second,totalQuestions,leaderYou)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed May 20 18:36:38 CEST 2015
                  SOURCE: E:/IntelliJProjects/WebEngineeringMaven/ue4/we15-lab4/app/views/gameInfo.scala.html
                  HASH: 666dc6b22e5bb7f95051e2c00a5f7704788107fc
                  MATRIX: 759->1|935->219|947->224|1027->229|1047->241|1085->242|1110->249|1122->253|1160->254|1191->262|1207->270|1287->275|1307->287|1345->288|1382->307|1394->311|1432->312|1478->334|1493->341|1574->346|1595->358|1634->359|1666->372|1679->376|1718->377|1765->579|1779->585|1906->635|1935->637|2010->685|2048->702|2093->720|2108->726|2161->758|2189->112|2211->126|2266->170|2282->178|2334->401|2345->404|2548->88|2575->109|2604->168|2632->216|2661->260|2689->332|2718->398|2747->577|2775->764|2804->767|2825->779|2864->780|2893->783|3075->943|3104->946|3287->1107|3319->1109|3348->1111|3445->1181|3473->1188|3536->1224|3553->1232|3614->1271|3664->1294|3686->1307|3725->1308|3773->1325|3802->1326|3873->1370|3902->1378|3947->1396|3976->1404|4006->1407|4028->1420|4067->1421|4120->1443|4156->1453|4173->1461|4217->1484|4247->1487|4262->1493|4303->1513|4337->1520|4376->1533|4417->1553|4451->1560|4539->1621|4556->1629|4604->1656|4673->1698|4688->1704|4729->1725|4751->1738|4790->1739|4819->1740|4848->1742|4865->1750|4907->1770|4941->1772|5042->1846|5059->1854|5108->1882|5179->1926|5194->1932|5227->1944|5256->1945|5347->2009|5369->2022|5408->2023|5457->2041|5486->2042|5550->2079|5578->2086|5623->2104|5651->2111|5703->2136|5720->2144|5770->2173|5809->2186|5844->2200|5878->2207|5966->2268|5983->2276|6031->2303|6100->2345|6115->2351|6156->2372|6179->2386|6218->2387|6247->2388|6276->2390|6293->2398|6335->2418|6369->2420|6470->2494|6487->2502|6536->2530|6607->2574|6622->2580|6655->2592|6684->2593|6769->2652|6813->2687|6853->2689|6885->2694|6927->2709|6944->2717|6991->2743|7021->2746|7056->2760|7085->2761|7115->2764|7150->2778|7189->2787|7221->2792
                  LINES: 26->1|28->8|28->8|30->8|30->8|30->8|30->8|30->8|30->8|30->9|30->9|32->9|32->9|32->9|32->9|32->9|32->9|32->10|32->10|34->10|34->10|34->10|34->10|34->10|34->10|34->19|34->19|36->19|37->20|37->20|37->20|38->21|38->21|38->21|39->5|39->5|39->6|39->6|39->12|39->12|46->1|47->3|49->5|50->6|52->8|53->9|54->10|56->18|57->22|59->24|59->24|59->24|60->25|60->25|61->26|61->26|62->27|64->29|65->30|65->30|65->30|65->30|65->30|67->32|67->32|67->32|67->32|67->32|67->32|67->32|68->33|68->33|68->33|68->33|68->33|68->33|69->34|69->34|69->34|69->34|69->34|69->34|70->35|71->36|71->36|72->37|74->39|74->39|74->39|75->40|75->40|75->40|75->40|75->40|75->40|75->40|75->40|75->40|75->40|78->43|78->43|78->43|79->44|79->44|79->44|79->44|83->48|83->48|83->48|83->48|83->48|83->48|83->48|84->49|84->49|84->49|84->49|84->49|85->50|85->50|86->51|88->53|88->53|88->53|89->54|89->54|89->54|89->54|89->54|89->54|89->54|89->54|89->54|89->54|92->57|92->57|92->57|93->58|93->58|93->58|93->58|98->63|98->63|98->63|99->64|99->64|99->64|99->64|99->64|99->64|99->64|99->64|99->64|100->65|102->67
                  -- GENERATED --
              */
          