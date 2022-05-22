package geotutor.service;


import geotutor.CountryUtil;
import geotutor.model.Country;
import geotutor.repository.GeoRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CountryService {

    private GeoRepository geoRepository;
    private CountryUtil countryUtil;
    private ApplicationContext applicationContext;

    public CountryService(ApplicationContext applicationContext, CountryUtil countryUtil, @Value("${application.repository}") String repository){
        this.applicationContext = applicationContext;
        this.geoRepository = (GeoRepository) applicationContext.getBean(repository);
        this.countryUtil = countryUtil;
    }

    public List<Country> findAll() {
        return geoRepository.getCountries();
    }

    public String getFlagPath(String name) {
        if (name == null){
            return geoRepository.getFlagPath(getRandomFlagId());
        }

        return geoRepository.getFlagPath(name);
    }

    private int getRandomFlagId() {
        Random r = new Random();
        return r.ints(1, 0, countryUtil.count(findAll())).findFirst().getAsInt();
    }

}