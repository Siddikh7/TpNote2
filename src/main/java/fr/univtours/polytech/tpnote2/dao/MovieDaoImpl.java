package fr.univtours.polytech.tpnote2.dao;

import java.util.List;

import fr.univtours.polytech.tpnote2.model.MovieBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class MovieDaoImpl implements MovieDao {

    @PersistenceContext(unitName = "MovieApp")
    private EntityManager em;

    @Override
    public void addMovie(MovieBean bean) {
        em.persist(bean);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MovieBean> getMovies() {
        Query request = em.createQuery("select m from MovieBean m");
        return request.getResultList();
    }

    @Override
    public MovieBean getMovie(Integer id) {
        return em.find(MovieBean.class, id);
    }

    @Override
    public void updateMovie(MovieBean movieBean) {
        em.merge(movieBean);
    }

    @Override
    public void deleteMovie(MovieBean movieBean) {
        em.merge(em.contains(movieBean)? movieBean : em.merge(movieBean));
    }

    public void deleteMoviebyId(Integer id){
        MovieBean managedMovieBean = em.find(MovieBean.class, movieBean.getId());
        if (managedMovieBean != null) {
            em.remove(managedMovieBean);
        } 
    }

    public MovieBean findMoviebyId(Integer id){
        return em.find(MovieBean.class, id);
    }


}
