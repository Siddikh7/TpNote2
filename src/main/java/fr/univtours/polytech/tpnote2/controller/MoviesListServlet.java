package fr.univtours.polytech.tpnote2.controller;

import java.io.IOException;
import java.util.List;

import fr.univtours.polytech.tpnote2.business.MovieBusinessImpl;
import fr.univtours.polytech.tpnote2.model.LocationBean;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LocationsListServlet
 */
@WebServlet("/locationsList")
public class MoviesListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private MovieBusinessImpl business;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<LocationBean> locationsList = business.getLocations();

        request.setAttribute("LOCATIONS_LIST", locationsList);

        request.getRequestDispatcher("locationsList.jsp").forward(request, response);
    }
}
