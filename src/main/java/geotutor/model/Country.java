package geotutor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Country {

    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String path;
    @Getter
    @Setter
    private String capital;
    @Getter
    @Setter
    private List<String> borders;

}