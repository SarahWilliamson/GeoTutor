package geotutor.repository;

import geotutor.model.Country;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@SpringBootConfiguration
@ConfigurationProperties
@Component("CountryFile")
public class FileRepository extends AbstractGeoRepository {

    @Getter
    @Setter
    private List<Country> countries = new ArrayList();

    public List<Country> getCountries(){
        return countries;
    }


    public String getFlagPath(int id) {
        return countries.get(id).getPath();
    }

    public String getFlagPath(String name) {
        return countries.stream()
                .filter(country -> country.getName().equals(name))
                .findFirst()
                .get()
                .getPath();
    }

}

