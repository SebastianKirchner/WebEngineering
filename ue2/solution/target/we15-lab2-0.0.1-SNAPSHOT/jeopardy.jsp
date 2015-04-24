<%@ page import="at.ac.tuwien.big.we15.lab2.api.Answer" %>
<%@ page import="at.ac.tuwien.big.we15.lab2.api.Category" %>
<%@ page import="at.ac.tuwien.big.we15.lab2.api.Game" %>
<%@ page import="at.ac.tuwien.big.we15.lab2.api.Question" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% Game game = (Game) request.getSession().getAttribute("game"); %>
<% game.checkRound();%>
<%
    //Code wird ausgeführt, wenn die Seite geladen wird

    if (!game.simulateRound(request.getParameter("questionId"), request.getParameterValues("answers"))) {
        response.setIntHeader("Refresh", 5);
    }

    /*
    if (request.getParameter("timeleftvalue") != null && Integer.parseInt(request.getParameter("timeleftvalue")) == 0) {
        if (!game.simulateRound(Integer.parseInt(request.getParameter("questionId")), null)) {
            response.setIntHeader("Refresh", 5);
        }
    } else if(request.getParameter("answer_submit")!=null && request.getParameter("answer_submit").equals("antworten")) {
        if (!game.simulateRound(Integer.parseInt(request.getParameter("questionId")), request.getParameterValues("answers"))) {
            response.setIntHeader("Refresh", 5);
        }
    } else {
        if (game.getCurrentRound() != 1) {
            if (!game.simulateRound(Integer.parseInt(request.getParameter("questionId")), request.getParameterValues("answers"))) {
                response.setIntHeader("Refresh", 5);
            }
        }
    }*/

%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="de" lang="de">
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Business Informatics Group Jeopardy! - Fragenauswahl</title>
        <link rel="stylesheet" type="text/css" href="style/base.css" />
        <link rel="stylesheet" type="text/css" href="style/screen.css" />
        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="js/framework.js" type="text/javascript"></script>
   </head>
   <body id="selection-page">
      <a class="accessibility" href="#question-selection">Zur Fragenauswahl springen</a>
      <!-- Header -->
      <header role="banner" aria-labelledby="bannerheading">
         <h1 id="bannerheading">
            <span class="accessibility">Business Informatics Group </span><span class="gametitle">Jeopardy!</span>
         </h1>
      </header>
      
      <!-- Navigation -->
		<nav role="navigation" aria-labelledby="navheading">
			<h2 id="navheading" class="accessibility">Navigation</h2>
			<ul>
				<li><a class="orangelink navigationlink" id="logoutlink" title="Klicke hier um dich abzumelden" href="#" accesskey="l">Abmelden</a></li>
			</ul>
		</nav>
      
      <!-- Content -->
      <div role="main"> 
         <!-- info -->
         <section id="gameinfo" aria-labelledby="gameinfoinfoheading">
            <h2 id="gameinfoinfoheading" class="accessibility">Spielinformationen</h2>
            <section id="firstplayer" class="playerinfo <%=game.isPlayerInLead()? "leader" : ""%>" aria-labelledby="firstplayerheading">
               <h3 id="firstplayerheading" class="accessibility">Führender Spieler</h3>
                <img class="avatar" src="img/avatar/<%=game.getPlayer().getImageHead()%>" alt="Spieler-Avatar <%=game.getPlayer().getName()%>" />
                <table>
                    <tr>
                        <th class="accessibility">Spielername</th>
                        <td class="playername"><%=game.getPlayer().getName()%> (Du)</td>
                    </tr>
                    <tr>
                        <th class="accessibility">Spielerpunkte</th>
                        <td class="playerpoints"><%=game.getPlayerPoints()%> €</td>
                    </tr>
                </table>
            </section>
            <section id="secondplayer" class="playerinfo <%=game.isPlayerInLead()? "" : "leader"%>" aria-labelledby="secondplayerheading">
               <h3 id="secondplayerheading" class="accessibility">Zweiter Spieler</h3>
                <img class="avatar" src="img/avatar/<%=game.getBot().getImageHead()%>" alt="Spieler-Avatar <%=game.getBot().getName()%>" />
                <table>
                    <tr>
                        <th class="accessibility">Spielername</th>
                        <td class="playername"><%=game.getBot().getName()%></td>
                    </tr>
                    <tr>
                        <th class="accessibility">Spielerpunkte</th>
                        <td class="playerpoints"><%=game.getBotPoints()%> €</td>
                    </tr>
                </table>
            </section>
            <p id="round">Fragen: <%=game.getCurrentRound()%> / 10</p>
         </section>

         <!-- Question -->
         <section id="question-selection" aria-labelledby="questionheading">
            <h2 id="questionheading" class="black accessibility">Jeopardy</h2>
             <%if(game.isPlayerCorrect() && game.playerAnwered()){%>
            <p class="user-info positive-change">Du hast richtig geantwortet: +<%=game.questionById(Integer.parseInt(request.getParameter("questionId"))).getValue()%> €</p>
             <%} else if (!game.isPlayerCorrect() && game.playerAnwered()) {%>
             <p class="user-info negative-change">Du hast falsch geantwortet: -<%=game.questionById(Integer.parseInt(request.getParameter("questionId"))).getValue()%> €</p>
             <%}%>
             <%if(game.isBotCorrect() && game.botAnswered()){%>
             <p class="user-info positive-change"><%=game.getBot().getName()%> hat richtig geantwortet: +<%=game.getBotQuestion().getValue()%> €</p>
             <p class="user-info"><%=game.getBot().getName()%> hat <%=game.getBotQuestion().getCategory().getName()%> für € <%=game.getBotQuestion().getValue()%> gewählt.</p>
             <%} else if (!game.isBotCorrect() && game.botAnswered()) {%>
             <p class="user-info negative-change"><%=game.getBot().getName()%> hat falsch geantwortet: -<%=game.getBotQuestion().getValue()%> €</p>
             <p class="user-info"><%=game.getBot().getName()%> hat <%=game.getBotQuestion().getCategory().getName()%> für € <%=game.getBotQuestion().getValue()%> gewählt.</p>
             <%}%>
            <form id="questionform" action="question.jsp" method="post">
               <fieldset>
               <legend class="accessibility">Fragenauswahl</legend>

                   <%for(Category c : game.getCategories()){
                        String categoryHead = c.getName()+"heading";
                   %>
                   <section class="questioncategory" aria-labelledby="<%=categoryHead%>">
                       <h3 id="<%=categoryHead%>" class="tile category-title"><span class="accessibility">Kategorie: </span><%=c.getName()%></h3>
                       <ol class="category_questions">
                           <% for(Question q : c.getQuestions()){
                                String questionId = "question" + q.getId();
                           %>
                           <li><input name="question_selection" id="<%=questionId%>" value="<%=q.getId()%>" type="radio" <%=game.wasAnswered(q.getId()) ? "disabled=\"disabled\"" : ""%> /><label class="tile clickable" for="<%=questionId%>">€ <%=q.getValue()%></label></li>
                           <% } %>
                       </ol>
                   </section>
                   <% } %>
               </fieldset>               
               <input class="greenlink formlink clickable" name="question_submit" id="next" type="submit" value="wählen" accesskey="s" />
            </form>
         </section>
         
         <section id="lastgame" aria-labelledby="lastgameheading">
            <h2 id="lastgameheading" class="accessibility">Letztes Spielinfo</h2>
            <p>Letztes Spiel: Nie</p>
         </section>
		</div>
		
      <!-- footer -->
      <footer role="contentinfo">© 2015 BIG Jeopardy!</footer>
	  
	  <script type="text/javascript">
            //<![CDATA[
            
            // initialize time
            $(document).ready(function() {
                // set last game
                if(supportsLocalStorage()) {
	                var lastGameMillis = parseInt(localStorage['lastGame'])
	                if(!isNaN(parseInt(localStorage['lastGame']))){
	                    var lastGame = new Date(lastGameMillis);
	                	$("#lastgame p").replaceWith('<p>Letztes Spiel: <time datetime="'
	                			+ lastGame.toUTCString()
	                			+ '">'
	                			+ lastGame.toLocaleString()
	                			+ '</time></p>')
	                }
            	}
            });            
            //]]>
        </script>
    </body>
</html>
