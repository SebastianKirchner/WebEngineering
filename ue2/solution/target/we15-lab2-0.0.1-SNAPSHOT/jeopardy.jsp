<%@ page import="at.ac.tuwien.big.we15.lab2.api.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="at.ac.tuwien.big.we15.lab2.api.Question" %>
<%@ page import="at.ac.tuwien.big.we15.lab2.api.Answer" %>
<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% List<Category> categories = (List<Category>) request.getSession().getAttribute("categoriesQuestions");
    boolean answerIsRight = false;
    Question questionAnswered = null;
    //Code wird ausgeführt, wenn auf eine Frage geantwortet wird
    if(request.getParameter("answer_submit")!=null && request.getParameter("answer_submit").equals("antworten")){
        String[] answers = request.getParameterValues("answers");
        int questionId = Integer.parseInt(request.getParameter("questionId"));


        //Ermitteln der Frage
        for(int i=0; i<categories.size(); i++){
            for(int j=0; j<categories.get(i).getQuestions().size(); j++){
                if(categories.get(i).getQuestions().get(j).getId() == questionId){
                    questionAnswered = categories.get(i).getQuestions().get(j);
                }
            }
        }

        //Ermitteln der Antworten, ob alle richtig gewählt wurden
        answerIsRight = true;
        for(Answer a : questionAnswered.getCorrectAnswers()){
            answerIsRight = Arrays.asList(answers).contains(Integer.toString(a.getId()));
        }

        if(answerIsRight){
            int points = (Integer) session.getAttribute("playerpoints");
            session.setAttribute("playerpoints", points + questionAnswered.getValue());
        }


    }
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
            <section id="firstplayer" class="playerinfo leader" aria-labelledby="firstplayerheading">
               <h3 id="firstplayerheading" class="accessibility">Führender Spieler</h3>
               <img class="avatar" src="img/avatar/black-widow_head.png" alt="Spieler-Avatar Black Widow" />
               <table>
                  <tr>
                     <th class="accessibility">Spielername</th>
                     <td class="playername"><%= session.getAttribute("username")%></td>
                  </tr>
                  <tr>
                     <th class="accessibility">Spielerpunkte</th>
                     <td class="playerpoints"><%= session.getAttribute("playerpoints")%></td>
                  </tr>
               </table>
            </section>
            <section id="secondplayer" class="playerinfo" aria-labelledby="secondplayerheading">
               <h3 id="secondplayerheading" class="accessibility">Zweiter Spieler</h3>
               <img class="avatar" src="img/avatar/deadpool_head.png" alt="Spieler-Avatar Deadpool" />
               <table>
                  <tr>
                     <th class="accessibility">Spielername</th>
                     <td class="playername">Deadpool</td>
                  </tr>
                  <tr>
                     <th class="accessibility">Spielerpunkte</th>
                     <td class="playerpoints">400 €</td>
                  </tr>
               </table>
            </section>
            <p id="round">Fragen: 2 / 10</p>
         </section>

         <!-- Question -->
         <section id="question-selection" aria-labelledby="questionheading">
            <h2 id="questionheading" class="black accessibility">Jeopardy</h2>
             <%if(answerIsRight){%>
            <p class="user-info positive-change">Du hast richtig geantwortet: +<%=questionAnswered.getValue()%> €</p>
             <%}%>
            <p class="user-info negative-change">Deadpool hat falsch geantwortet: -500 €</p>
            <p class="user-info">Deadpool hat TUWIEN für € 1000 gewählt.</p>
            <form id="questionform" action="question.jsp" method="post">
               <fieldset>
               <legend class="accessibility">Fragenauswahl</legend>

                   <%for(Category c : categories){
                        String categoryHead = c.getName()+"heading";
                   %>
                   <section class="questioncategory" aria-labelledby="<%=categoryHead%>">
                       <h3 id="<%=categoryHead%>" class="tile category-title"><span class="accessibility">Kategorie: </span><%=c.getName()%></h3>
                       <ol class="category_questions">
                           <% for(Question q : c.getQuestions()){
                                String questionId = "question" + q.getId();
                           %>
                           <li><input name="question_selection" id="<%=questionId%>" value="<%=q.getId()%>" type="radio" /><label class="tile clickable" for="<%=questionId%>">€ <%=q.getValue()%></label></li>
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
