package bs.project.worldweather.console.core.controller;

import bs.project.worldweather.console.core.dto.request.SearchRequestDTO;
import bs.project.worldweather.console.core.dto.response.SearchResponseDTO;
import bs.project.worldweather.console.core.services.SearchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchController {

    private SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping("/")
    public ResponseEntity<SearchResponseDTO> searchCities(@RequestBody SearchRequestDTO searchRequestDTO){
        return new ResponseEntity<>(searchService.searchCity(searchRequestDTO), HttpStatus.OK);
    }
}
