
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
object inputField extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Field,Array[scala.Tuple2[Symbol, Any]],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(field: Field, args: (Symbol,Any)*):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import play.i18n._
def /*12.6*/_label/*12.12*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*12.16*/("""<label for=""""),_display_(/*12.29*/label),format.raw/*12.34*/("""">"""),_display_(/*12.37*/Messages/*12.45*/.get("label." + field.id)),format.raw/*12.70*/("""</label>""")))};def /*13.3*/_input/*13.9*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*13.13*/("""<input type=""""),_display_(/*13.27*/inputType),format.raw/*13.36*/("""" name=""""),_display_(/*13.45*/name),format.raw/*13.49*/("""" id=""""),_display_(/*13.56*/field/*13.61*/.id),format.raw/*13.64*/("""" value=""""),_display_(/*13.74*/value),format.raw/*13.79*/("""" """),_display_(/*13.82*/toHtmlArgs(htmlArgs)),format.raw/*13.102*/(""" """),format.raw/*13.103*/("""/>""")))};def /*4.6*/inputType/*4.15*/ = {{ args.toMap.get('type).map(_.toString).getOrElse("text") }};def /*5.6*/label/*5.11*/ = {{ args.toMap.get('label).map(_.toString).getOrElse(field.id) }};def /*6.6*/name/*6.10*/ = {{ args.toMap.get('name).map(_.toString).getOrElse(field.id) }};def /*7.6*/value/*7.11*/ = {{ args.toMap.get('value).map(_.toString).getOrElse(field.value.getOrElse("")) }};def /*8.3*/after/*8.8*/ = {{ args.toMap.exists(_._1 == 'after) }};def /*10.6*/htmlArgs/*10.14*/ = {{args.filter(_._1 != 'labelAfter).filter(_._1 != 'type).filter(_._1 != 'label).filter(_._1 != 'name).toMap}};
Seq[Any](format.raw/*1.37*/("""
"""),format.raw/*3.1*/("""    
    """),format.raw/*4.78*/("""
    """),format.raw/*5.77*/("""
    """),format.raw/*6.75*/("""
    """),format.raw/*7.94*/("""
	"""),format.raw/*8.49*/("""

    """),format.raw/*10.125*/("""
    
    """),format.raw/*12.79*/("""
	"""),format.raw/*13.106*/("""
	
	"""),_display_(/*15.3*/if(after)/*15.12*/ {_display_(Seq[Any](format.raw/*15.14*/("""
	 """),_display_(/*16.4*/_input),format.raw/*16.10*/("""
	 """),_display_(/*17.4*/_label),format.raw/*17.10*/("""
	""")))}/*18.4*/else/*18.9*/{_display_(Seq[Any](format.raw/*18.10*/("""
	 """),_display_(/*19.4*/_label),format.raw/*19.10*/("""
	 """),_display_(/*20.4*/_input),format.raw/*20.10*/("""
	""")))}),format.raw/*21.3*/("""
	
	"""),format.raw/*23.59*/("""
	"""),format.raw/*24.2*/("""<div id="error_msg_"""),_display_(/*24.22*/field/*24.27*/.id),format.raw/*24.30*/("""" class="hide" role="alert"> 	   	
        """),_display_(/*25.10*/Messages/*25.18*/.get( "error." + field.id )),format.raw/*25.45*/("""
    """),format.raw/*26.5*/("""</div>
    
    
    """),format.raw/*29.58*/("""
	"""),_display_(/*30.3*/if(field.hasErrors)/*30.22*/{_display_(Seq[Any](format.raw/*30.23*/("""
    	"""),format.raw/*31.6*/("""<div id="error_msg_"""),_display_(/*31.26*/(field.id)),format.raw/*31.36*/("""_from_server" role="alert">
    		"""),_display_(/*32.8*/for(error <- field.errors) yield /*32.34*/ {_display_(Seq[Any](format.raw/*32.36*/("""
			    """),format.raw/*33.8*/("""<p>"""),_display_(/*33.12*/Messages/*33.20*/.get( error.message, error.args )),format.raw/*33.53*/("""</p>
			""")))}),format.raw/*34.5*/("""
    	"""),format.raw/*35.6*/("""</div>
    """)))}),format.raw/*36.6*/("""  """))}
  }

  def render(field:Field,args:Array[scala.Tuple2[Symbol, Any]]): play.twirl.api.HtmlFormat.Appendable = apply(field,args:_*)

  def f:((Field,Array[scala.Tuple2[Symbol, Any]]) => play.twirl.api.HtmlFormat.Appendable) = (field,args) => apply(field,args:_*)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon May 25 19:03:13 CEST 2015
                  SOURCE: C:/Users/Maks/Documents/we/WebEngineering/ue4/we15-lab4/app/views/inputField.scala.html
                  HASH: 2c0a1159ea6dbe92434cd7222f8b875da04235ac
                  MATRIX: 760->1|885->582|900->588|981->592|1021->605|1047->610|1077->613|1094->621|1140->646|1172->659|1186->665|1267->669|1308->683|1338->692|1374->701|1399->705|1433->712|1447->717|1471->720|1508->730|1534->735|1564->738|1606->758|1636->759|1661->70|1678->79|1754->149|1767->154|1846->227|1858->231|1936->303|1949->308|2045->395|2057->400|2112->450|2129->458|2270->36|2298->59|2335->142|2368->220|2401->296|2434->391|2464->441|2501->569|2541->655|2573->762|2606->769|2624->778|2664->780|2695->785|2722->791|2753->796|2780->802|2802->807|2814->812|2853->813|2884->818|2911->824|2942->829|2969->835|3003->839|3037->902|3067->905|3114->925|3128->930|3152->933|3224->978|3241->986|3289->1013|3322->1019|3374->1096|3404->1100|3432->1119|3471->1120|3505->1127|3552->1147|3583->1157|3645->1193|3687->1219|3727->1221|3763->1230|3794->1234|3811->1242|3865->1275|3905->1285|3939->1292|3982->1305
                  LINES: 26->1|28->12|28->12|30->12|30->12|30->12|30->12|30->12|30->12|30->13|30->13|32->13|32->13|32->13|32->13|32->13|32->13|32->13|32->13|32->13|32->13|32->13|32->13|32->13|32->4|32->4|32->5|32->5|32->6|32->6|32->7|32->7|32->8|32->8|32->10|32->10|33->1|34->3|35->4|36->5|37->6|38->7|39->8|41->10|43->12|44->13|46->15|46->15|46->15|47->16|47->16|48->17|48->17|49->18|49->18|49->18|50->19|50->19|51->20|51->20|52->21|54->23|55->24|55->24|55->24|55->24|56->25|56->25|56->25|57->26|60->29|61->30|61->30|61->30|62->31|62->31|62->31|63->32|63->32|63->32|64->33|64->33|64->33|64->33|65->34|66->35|67->36
                  -- GENERATED --
              */
          