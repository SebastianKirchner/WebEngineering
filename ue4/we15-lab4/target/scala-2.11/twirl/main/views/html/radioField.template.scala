
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
object radioField extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Field,Array[scala.Tuple2[Symbol, Any]],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(field: Field, args: (Symbol,Any)*):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import play.i18n._

Seq[Any](format.raw/*1.37*/("""
"""),format.raw/*3.1*/("""
"""),format.raw/*4.1*/("""<input type="radio" name=""""),_display_(/*4.28*/field/*4.33*/.id),format.raw/*4.36*/("""" id=""""),_display_(/*4.43*/field/*4.48*/.id),format.raw/*4.51*/("""" """),_display_(/*4.54*/toHtmlArgs(args.toMap)),format.raw/*4.76*/(""" """),format.raw/*4.77*/("""/>
<label for=""""),_display_(/*5.14*/field/*5.19*/.id),format.raw/*5.22*/("""">"""),_display_(/*5.25*/Messages/*5.33*/.get("label." + field.id)),format.raw/*5.58*/("""</label>"""))}
  }

  def render(field:Field,args:Array[scala.Tuple2[Symbol, Any]]): play.twirl.api.HtmlFormat.Appendable = apply(field,args:_*)

  def f:((Field,Array[scala.Tuple2[Symbol, Any]]) => play.twirl.api.HtmlFormat.Appendable) = (field,args) => apply(field,args:_*)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed May 20 18:36:39 CEST 2015
                  SOURCE: E:/IntelliJProjects/WebEngineeringMaven/ue4/we15-lab4/app/views/radioField.scala.html
                  HASH: df685c177250b000c7f8c3af5716b359893f112d
                  MATRIX: 760->1|901->36|928->57|955->58|1008->85|1021->90|1044->93|1077->100|1090->105|1113->108|1142->111|1184->133|1212->134|1254->150|1267->155|1290->158|1319->161|1335->169|1380->194
                  LINES: 26->1|29->1|30->3|31->4|31->4|31->4|31->4|31->4|31->4|31->4|31->4|31->4|31->4|32->5|32->5|32->5|32->5|32->5|32->5
                  -- GENERATED --
              */
          