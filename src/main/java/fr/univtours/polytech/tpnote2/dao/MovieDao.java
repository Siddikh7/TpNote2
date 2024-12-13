package fr.univtours.polytech.tpnote2.dao;

import java.util.List;

import fr.univtours.polytech.tpnote2.model.MovieBean;

public interface MovieDao {

    public void addMovie(MovieBean bean);

    public List<MovieBean> getMovies();

    public MovieBean getMovie(Integer id);

    public void updateMovie(MovieBean MovieBean);

    public void deleteMovie(MovieBean MovieBean);

    public void deleteMoviebyId(Integer id);

    public MovieBean findMoviebyId(Integer id);
}
