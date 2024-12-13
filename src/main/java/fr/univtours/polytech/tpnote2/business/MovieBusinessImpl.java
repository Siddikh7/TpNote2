package fr.univtours.polytech.tpnote2.business;

import java.util.List;
import fr.univtours.polytech.tpnote2.dao.MovieDao;
import fr.univtours.polytech.tpnote2.model.MovieBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class MovieBusinessImpl implements MovieBusiness {

    @Inject
    private MovieDao movieDao;

    @Override
    public void addMovie(MovieBean movieBean) {
        movieDao.addMovie(movieBean);
    }

    @Override
    public List<MovieBean> getMovies() {
        return movieDao.getMovies();
    }

    @Override
    public MovieBean getMovie(Integer id) {
        return movieDao.getMovie(id);
    }

    @Override
    public void updateMovie(MovieBean movieBean) {
        movieDao.updateMovie(movieBean);
    }

    @Override
    public void deleteMovie(Integer id) {
        movieDao.deleteMoviebyId(id);
    }

    public void increaseNote(Integer id) {
        MovieBean movie = movieDao.getMovie(id);
        if (movie != null) {
            if (movie.getNote() == null) {
                movie.setNote(1);
            } else if (movie.getNote() < 5) {
                movie.setNote(movie.getNote() + 1);
            }
            movieDao.updateMovie(movie);
        }
    }

    public void decreaseNote(Integer id) {
        MovieBean movie = movieDao.getMovie(id);
        if (movie != null) {
            if (movie.getNote() == null) {
                movie.setNote(5);
            } else if (movie.getNote() > 1) {
                movie.setNote(movie.getNote() - 1);
            }
            movieDao.updateMovie(movie);
        }
    }
}