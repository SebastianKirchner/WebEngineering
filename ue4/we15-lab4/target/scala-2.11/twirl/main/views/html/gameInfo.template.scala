
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
                  DATE: Mon May 25 19:03:11 CEST 2015
                  SOURCE: C:/Users/Maks/Documents/we/WebEngineering/ue4/we15-lab4/app/views/gameInfo.scala.html
                  HASH: 47f94ff003455f28db28985fb407f9c7bf86cc73
                  MATRIX: 759->1|935->226|947->231|1027->236|1047->248|1085->249|1110->256|1122->260|1160->261|1191->270|1207->278|1287->283|1307->295|1345->296|1382->315|1394->319|1432->320|1478->343|1493->350|1574->355|1595->367|1634->368|1666->381|1679->385|1718->386|1765->597|1779->603|1906->653|1936->656|2011->704|2049->721|2095->740|2110->746|2163->778|2192->116|2214->130|2269->175|2285->183|2337->412|2348->415|2557->88|2585->111|2616->172|2645->221|2676->267|2705->340|2735->407|2766->594|2795->785|2826->790|2847->802|2886->803|2916->807|3098->967|3128->971|3311->1132|3344->1135|3375->1139|3473->1210|3501->1217|3564->1253|3581->1261|3642->1300|3694->1325|3716->1338|3755->1339|3803->1356|3832->1357|3903->1401|3932->1409|3978->1428|4007->1436|4037->1439|4059->1452|4098->1453|4151->1475|4188->1486|4205->1494|4249->1517|4279->1520|4294->1526|4335->1546|4370->1554|4410->1568|4451->1588|4486->1596|4576->1659|4593->1667|4641->1694|4711->1737|4726->1743|4767->1764|4789->1777|4828->1778|4857->1779|4886->1781|4903->1789|4945->1809|4979->1811|5083->1888|5100->1896|5149->1924|5221->1969|5236->1975|5269->1987|5298->1988|5393->2056|5415->2069|5454->2070|5503->2088|5532->2089|5596->2126|5624->2133|5670->2152|5698->2159|5750->2184|5767->2192|5817->2221|5857->2235|5892->2249|5927->2257|6017->2320|6034->2328|6082->2355|6152->2398|6167->2404|6208->2425|6231->2439|6270->2440|6299->2441|6328->2443|6345->2451|6387->2471|6421->2473|6525->2550|6542->2558|6591->2586|6663->2631|6678->2637|6711->2649|6740->2650|6830->2714|6874->2749|6914->2751|6947->2757|6989->2772|7006->2780|7053->2806|7083->2809|7118->2823|7147->2824|7177->2827|7212->2841|7252->2851|7286->2858
                  LINES: 26->1|28->8|28->8|30->8|30->8|30->8|30->8|30->8|30->8|30->9|30->9|32->9|32->9|32->9|32->9|32->9|32->9|32->10|32->10|34->10|34->10|34->10|34->10|34->10|34->10|34->19|34->19|36->19|37->20|37->20|37->20|38->21|38->21|38->21|39->5|39->5|39->6|39->6|39->12|39->12|46->1|47->3|49->5|50->6|52->8|53->9|54->10|56->18|57->22|59->24|59->24|59->24|60->25|60->25|61->26|61->26|62->27|64->29|65->30|65->30|65->30|65->30|65->30|67->32|67->32|67->32|67->32|67->32|67->32|67->32|68->33|68->33|68->33|68->33|68->33|68->33|69->34|69->34|69->34|69->34|69->34|69->34|70->35|71->36|71->36|72->37|74->39|74->39|74->39|75->40|75->40|75->40|75->40|75->40|75->40|75->40|75->40|75->40|75->40|78->43|78->43|78->43|79->44|79->44|79->44|79->44|83->48|83->48|83->48|83->48|83->48|83->48|83->48|84->49|84->49|84->49|84->49|84->49|85->50|85->50|86->51|88->53|88->53|88->53|89->54|89->54|89->54|89->54|89->54|89->54|89->54|89->54|89->54|89->54|92->57|92->57|92->57|93->58|93->58|93->58|93->58|98->63|98->63|98->63|99->64|99->64|99->64|99->64|99->64|99->64|99->64|99->64|99->64|100->65|102->67
                  -- GENERATED --
              */
          