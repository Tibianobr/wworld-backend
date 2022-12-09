package bs.project.worldweather.console.core.services.impl;

import bs.project.worldweather.console.core.models.Coords;
import bs.project.worldweather.console.core.services.DataService;
import bs.project.worldweather.console.integration.dto.WeatherCurrentInfoDTO;
import bs.project.worldweather.console.integration.dto.WeatherForecastDTO;
import bs.project.worldweather.console.integration.service.WeatherIntegrationService;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {

    private WeatherIntegrationService weatherIntegrationService;

    public DataServiceImpl(WeatherIntegrationService weatherIntegrationService) {
        this.weatherIntegrationService = weatherIntegrationService;
    }

    @Override
    public void fetchWeatherData(Coords coords) {
        // execute the requests
        WeatherCurrentInfoDTO weatherCurrentInfoDTO = weatherIntegrationService.currentWeatherRequest(coords);
        System.out.println(weatherCurrentInfoDTO);
        WeatherForecastDTO weatherForecastDTO = weatherIntegrationService.hourlyForecastRequest(coords);
        System.out.println(weatherForecastDTO);

        // build the response
    }
}
