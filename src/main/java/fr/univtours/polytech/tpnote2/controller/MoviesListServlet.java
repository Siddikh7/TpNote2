package fr.univtours.polytech.tpnote2.controller;

import java.io.IOException;
import java.util.List;
import fr.univtours.polytech.tpnote2.business.MovieBusiness;
import fr.univtours.polytech.tpnote2.model.MovieBean;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/moviesList")
public class MoviesListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private MovieBusiness business;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<MovieBean> moviesList = business.getMovies();
        request.setAttribute("RESULTS_LIST", moviesList);
        request.getRequestDispatcher("moviesList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        Integer id = Integer.parseInt(request.getParameter("id"));

        if ("increase".equals(action)) {
            business.increaseNote(id);
        } else if ("decrease".equals(action)) {
            business.decreaseNote(id);
        }

        response.sendRedirect("moviesList");
    }
}