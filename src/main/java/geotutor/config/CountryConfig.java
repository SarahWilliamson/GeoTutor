package geotutor.config;

import geotutor.model.Country;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@SpringBootConfiguration
@ConfigurationProperties
public class CountryConfig {

    @Getter
    @Setter
    private List<Country> countries = new ArrayList();

}

