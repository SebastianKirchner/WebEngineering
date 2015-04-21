package at.ac.tuwien.big.we15.lab2.api.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by David on 20.04.2015.
 */
@WebServlet(name="Jeopardy", urlPatterns = {"/jeopardy"})
public class BigJeopardyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        request.getSession().setAttribute("username",name);
        request.getRequestDispatcher("/jeopardy.jsp").include(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getParameter("username");
    }
}
