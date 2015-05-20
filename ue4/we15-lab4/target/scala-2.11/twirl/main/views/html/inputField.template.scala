
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
                  DATE: Wed May 20 18:36:39 CEST 2015
                  SOURCE: E:/IntelliJProjects/WebEngineeringMaven/ue4/we15-lab4/app/views/inputField.scala.html
                  HASH: 362e1fbf36b80a7326602a85478ceecdb6b94611
                  MATRIX: 760->1|885->571|900->577|981->581|1021->594|1047->599|1077->602|1094->610|1140->635|1172->647|1186->653|1267->657|1308->671|1338->680|1374->689|1399->693|1433->700|1447->705|1471->708|1508->718|1534->723|1564->726|1606->746|1636->747|1661->67|1678->76|1754->145|1767->150|1846->222|1858->226|1936->297|1949->302|2045->388|2057->393|2112->441|2129->449|2270->36|2297->57|2333->139|2365->216|2397->291|2429->385|2458->434|2493->560|2531->644|2562->750|2593->755|2611->764|2651->766|2681->770|2708->776|2738->780|2765->786|2786->790|2798->795|2837->796|2867->800|2894->806|2924->810|2951->816|2984->819|3016->880|3045->882|3092->902|3106->907|3130->910|3201->954|3218->962|3266->989|3298->994|3347->1068|3376->1071|3404->1090|3443->1091|3476->1097|3523->1117|3554->1127|3615->1162|3657->1188|3697->1190|3732->1198|3763->1202|3780->1210|3834->1243|3873->1252|3906->1258|3948->1270
                  LINES: 26->1|28->12|28->12|30->12|30->12|30->12|30->12|30->12|30->12|30->13|30->13|32->13|32->13|32->13|32->13|32->13|32->13|32->13|32->13|32->13|32->13|32->13|32->13|32->13|32->4|32->4|32->5|32->5|32->6|32->6|32->7|32->7|32->8|32->8|32->10|32->10|33->1|34->3|35->4|36->5|37->6|38->7|39->8|41->10|43->12|44->13|46->15|46->15|46->15|47->16|47->16|48->17|48->17|49->18|49->18|49->18|50->19|50->19|51->20|51->20|52->21|54->23|55->24|55->24|55->24|55->24|56->25|56->25|56->25|57->26|60->29|61->30|61->30|61->30|62->31|62->31|62->31|63->32|63->32|63->32|64->33|64->33|64->33|64->33|65->34|66->35|67->36
                  -- GENERATED --
              */
          