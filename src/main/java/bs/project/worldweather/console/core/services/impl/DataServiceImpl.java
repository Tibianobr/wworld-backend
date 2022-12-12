package bs.project.worldweather.console.core.services.impl;

import bs.project.worldweather.console.core.dto.response.DataWeatherResponseDTO;
import bs.project.worldweather.console.core.mapper.DataMapper;
import bs.project.worldweather.console.core.models.Coords;
import bs.project.worldweather.console.core.services.DataService;
import bs.project.worldweather.console.integration.dto.WeatherCurrentInfoDTO;
import bs.project.worldweather.console.integration.dto.WeatherForecastDTO;
import bs.project.worldweather.console.integration.service.WeatherIntegrationService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataServiceImpl implements DataService {

    private WeatherIntegrationService weatherIntegrationService;

    public DataServiceImpl(WeatherIntegrationService weatherIntegrationService) {
        this.weatherIntegrationService = weatherIntegrationService;
    }

    @Override
    public DataWeatherResponseDTO fetchWeatherData(Coords coords) {
        // execute the requests
        WeatherCurrentInfoDTO weatherCurrentInfoDTO = weatherIntegrationService.currentWeatherRequest(coords);
        WeatherForecastDTO weatherForecastDTO = weatherIntegrationService.hourlyForecastRequest(coords);

        return DataMapper.toDataDTO(weatherCurrentInfoDTO,weatherForecastDTO);
    }


}
