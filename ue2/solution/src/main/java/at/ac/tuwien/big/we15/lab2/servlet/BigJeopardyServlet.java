package at.ac.tuwien.big.we15.lab2.servlet;

import at.ac.tuwien.big.we15.lab2.api.Avatar;
import at.ac.tuwien.big.we15.lab2.api.Category;
import at.ac.tuwien.big.we15.lab2.api.Game;
import at.ac.tuwien.big.we15.lab2.api.QuestionDataProvider;
import at.ac.tuwien.big.we15.lab2.api.impl.ServletJeopardyFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by David on 20.04.2015.
 */
@WebServlet(name="Jeopardy", urlPatterns = {"/jeopardy"})
public class BigJeopardyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        ServletJeopardyFactory factory = new ServletJeopardyFactory(servletContext);
        QuestionDataProvider provider = factory.createQuestionDataProvider();
        List<Category> categories = provider.getCategoryData();
        request.getSession().setAttribute("game",new Game(Avatar.getRandomAvatar(), categories));

        request.getRequestDispatcher("/jeopardy.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getParameter("username");
    }
}
