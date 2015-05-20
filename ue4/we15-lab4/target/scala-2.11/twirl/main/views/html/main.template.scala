
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
object main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[String,String,Html,Html,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(bodyId: String, title: String, accessibilityMenu: Html = Html(""))(content: Html)(scripts: Html = Html("")):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import play.i18n._

Seq[Any](format.raw/*1.110*/("""
"""),format.raw/*3.1*/("""
"""),format.raw/*4.1*/("""<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="de" lang="de">
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Business Informatics Group Jeopardy! - """),_display_(/*10.56*/title),format.raw/*10.61*/("""</title>
        <link rel="stylesheet" type="text/css" href=""""),_display_(/*11.55*/routes/*11.61*/.Assets.at("stylesheets/base.css")),format.raw/*11.95*/("""" />
        <link rel="stylesheet" type="text/css" href=""""),_display_(/*12.55*/routes/*12.61*/.Assets.at("stylesheets/screen.css")),format.raw/*12.97*/("""" />
        <script src=""""),_display_(/*13.23*/routes/*13.29*/.Assets.at("javascripts/jquery.js")),format.raw/*13.64*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*14.23*/routes/*14.29*/.Assets.at("javascripts/framework.js")),format.raw/*14.67*/("""" type="text/javascript"></script>
    </head>
    <body id=""""),_display_(/*16.16*/bodyId),format.raw/*16.22*/("""">
		"""),_display_(/*17.4*/accessibilityMenu),format.raw/*17.21*/("""
		"""),format.raw/*18.3*/("""<!-- Header -->
		<header role="banner" aria-labelledby="bannerheading">
		   <h1 id="bannerheading">
		      <span class="accessibility">Business Informatics Group </span><span class="gametitle">Jeopardy!</span>
		   </h1>
		</header>
		
		<!-- Navigation -->
		"""),_display_(/*26.4*/nav(bodyId)),format.raw/*26.15*/("""
		
		    
		"""),format.raw/*29.3*/("""<!-- Content -->
		"""),_display_(/*30.4*/content),format.raw/*30.11*/("""
	
		"""),format.raw/*32.3*/("""<!-- Footer -->
	    <footer role="contentinfo">© 2015 BIG Jeopardy</footer>
	    """),_display_(/*34.7*/scripts),format.raw/*34.14*/("""
    """),format.raw/*35.5*/("""</body>
</html>
"""))}
  }

  def render(bodyId:String,title:String,accessibilityMenu:Html,content:Html,scripts:Html): play.twirl.api.HtmlFormat.Appendable = apply(bodyId,title,accessibilityMenu)(content)(scripts)

  def f:((String,String,Html) => (Html) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (bodyId,title,accessibilityMenu) => (content) => (scripts) => apply(bodyId,title,accessibilityMenu)(content)(scripts)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed May 20 18:36:39 CEST 2015
                  SOURCE: E:/IntelliJProjects/WebEngineeringMaven/ue4/we15-lab4/app/views/main.scala.html
                  HASH: 66ccf6d6243dbf61d68d2596df2da31af6810018
                  MATRIX: 744->1|959->109|986->130|1013->131|1342->433|1368->438|1458->501|1473->507|1528->541|1614->600|1629->606|1686->642|1740->669|1755->675|1811->710|1895->767|1910->773|1969->811|2058->873|2085->879|2117->885|2155->902|2185->905|2475->1169|2507->1180|2547->1193|2593->1213|2621->1220|2653->1225|2762->1308|2790->1315|2822->1320
                  LINES: 26->1|29->1|30->3|31->4|37->10|37->10|38->11|38->11|38->11|39->12|39->12|39->12|40->13|40->13|40->13|41->14|41->14|41->14|43->16|43->16|44->17|44->17|45->18|53->26|53->26|56->29|57->30|57->30|59->32|61->34|61->34|62->35
                  -- GENERATED --
              */
          