package geotutor;

import geotutor.model.Country;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryUtil {

    public int count(List<Country> countries){
        return countries.size();
    }
}
