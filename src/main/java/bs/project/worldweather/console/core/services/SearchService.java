package bs.project.worldweather.console.core.services;

import bs.project.worldweather.console.core.dto.request.SearchRequestDTO;
import bs.project.worldweather.console.core.dto.response.SearchResponseDTO;

public interface SearchService {
    SearchResponseDTO searchCity(SearchRequestDTO searchRequestDTO);
}
