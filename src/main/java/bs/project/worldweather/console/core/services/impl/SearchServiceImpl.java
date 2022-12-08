package bs.project.worldweather.console.core.services.impl;

import bs.project.worldweather.console.core.dto.request.SearchRequestDTO;
import bs.project.worldweather.console.core.dto.response.SearchResponseDTO;
import bs.project.worldweather.console.core.mapper.CityMapper;
import bs.project.worldweather.console.core.services.SearchService;
import bs.project.worldweather.console.integration.dto.WeatherCityDTO;
import bs.project.worldweather.console.integration.service.WeatherIntegrationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchServiceImpl implements SearchService {

    private WeatherIntegrationService weatherIntegrationService;

    public SearchServiceImpl(WeatherIntegrationService weatherIntegrationService) {
        this.weatherIntegrationService = weatherIntegrationService;
    }


    @Override
    public SearchResponseDTO searchCity(SearchRequestDTO searchRequestDTO) {
        SearchResponseDTO searchResponseDTO = new SearchResponseDTO();
        if (StringUtils.isNotEmpty(searchRequestDTO.getSearchString().trim()))
        {
            List<WeatherCityDTO> cities = weatherIntegrationService.searchQuery(searchRequestDTO.getSearchString());
            searchResponseDTO.setCities(cities.stream().map(CityMapper::weatherCityToCityDTO).collect(Collectors.toList()));
        }

        return searchResponseDTO;
    }
}
