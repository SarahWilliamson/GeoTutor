package geotutor.repository;

import geotutor.config.CountryConfig;
import geotutor.model.Country;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryRepository {

    private CountryConfig countryConfig;

    public CountryRepository(CountryConfig countryConfig){
        this.countryConfig = countryConfig;
    }

    public List<Country> findAll(){
        return countryConfig.getCountries();
    }

}