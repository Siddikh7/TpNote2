package fr.univtours.polytech.tpnote2.business;

import java.util.List;

import fr.univtours.polytech.tpnote2.dao.MovieDao;
import fr.univtours.polytech.tpnote2.model.MovieBean;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class MovieBusinessImpl {

    @Inject
    private MovieDao movieDao;

    public void addMovie(MovieBean locationBean){

    }

    public List<MovieBean> getMovies(){}

    public MovieBean getMovie(Integer id){}

    public void updateMovie(MovieBean locationBean){}

    public void deleteMovie(Integer id){}

    //public LocationBean findLocationById(Integer id);
}
