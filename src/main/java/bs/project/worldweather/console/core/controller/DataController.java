package bs.project.worldweather.console.core.controller;

import bs.project.worldweather.console.core.models.Coords;
import bs.project.worldweather.console.core.services.DataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataController {

    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }


    @PostMapping("/")
    public ResponseEntity<?> fetchWeatherData(@RequestBody Coords coords){
        dataService.fetchWeatherData(coords);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
