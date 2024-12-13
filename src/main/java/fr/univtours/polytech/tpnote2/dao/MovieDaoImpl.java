package fr.univtours.polytech.tpnote2.dao;

import java.util.List;

import fr.univtours.polytech.tpnote2.model.LocationBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class MovieDaoImpl implements MovieDao {

    @PersistenceContext(unitName = "LocationApp")
    private EntityManager em;

    @Override
    public void createLocation(LocationBean bean) {
        em.persist(bean);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<LocationBean> getLocations() {
        Query request = em.createQuery("select l from LocationBean l");
        return request.getResultList();
    }

    @Override
    public LocationBean getLocation(Integer id) {
        return em.find(LocationBean.class, id);
    }

    @Override
    public void updateLocation(LocationBean locationBean) {
        em.merge(locationBean);
    }

    @Override
    public void deleteLocation(LocationBean locationBean) {
        em.remove(locationBean);
    }

    public LocationBean findLocationById(Integer id){
        return em.find(LocationBean.class, id);
    }


}
