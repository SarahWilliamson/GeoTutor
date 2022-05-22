package geotutor.repository;

import geotutor.model.Country;

import java.util.List;

public interface GeoRepository {

     List<Country> getCountries();
     String getFlagPath(int id);
     String getFlagPath(String name);



}
