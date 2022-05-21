package geotutor.controller;

import geotutor.model.Country;
import geotutor.service.CountryService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
@Slf4j
public class CountryController {

    @Autowired
    CountryService countryService;

    @ApiOperation(value= "Get Countries" , notes = "Gets all countries names found within app")
    @RequestMapping(value = "/countries", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Country> findAllCountries() {
        return countryService.findAll();
    }



}