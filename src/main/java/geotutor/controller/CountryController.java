package geotutor.controller;

import geotutor.model.Country;
import geotutor.service.CountryService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class CountryController {

    @Autowired
    CountryService countryService;

    @ApiOperation(value= "Get Countries" , notes = "Gets all countries names found within app")
    @RequestMapping(value = "/countries", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Country> findAllCountries() {
        return countryService.findAll();
    }

    @GetMapping(value = {"/flag/{name}","/flag"}, produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody ResponseEntity<byte[]> getFlag (@PathVariable(required = false) String name) throws IOException {
        InputStream in = getClass()
                .getResourceAsStream(countryService.getFlagPath(name));
        final HttpHeaders headers = new HttpHeaders();
        headers.set("Country", name);
        return new ResponseEntity<> (org.apache.commons.io.IOUtils.toByteArray(in), headers, HttpStatus.OK);
    }

}