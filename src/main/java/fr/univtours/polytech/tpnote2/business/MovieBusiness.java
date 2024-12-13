package fr.univtours.polytech.tpnote2.business;

import java.util.List;

import fr.univtours.polytech.tpnote2.model.MovieBean;
import jakarta.ejb.Remote;

@Remote
public interface MovieBusiness {

    public void addMovie(MovieBean movieBean);

    public List<MovieBean> getMovies();

    public MovieBean getMovie(Integer id);

    public void updateMovie(MovieBean movieBean);

    public void deleteMovie(Integer id);

}
