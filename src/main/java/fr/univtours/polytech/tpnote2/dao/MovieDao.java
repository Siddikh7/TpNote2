package fr.univtours.polytech.tpnote2.dao;

import java.util.List;

import fr.univtours.polytech.tpnote2.model.LocationBean;

public interface MovieDao {

    public void createMovie(LocationBean bean);

    public List<LocationBean> getLocations();

    public LocationBean getLocation(Integer id);

    public void updateLocation(LocationBean locationBean);

    public void deleteLocation(LocationBean locationBean);

    public LocationBean findLocationById(Integer id);
}
