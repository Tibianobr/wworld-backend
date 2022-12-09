package bs.project.worldweather.console.integration.service;

import bs.project.worldweather.console.core.models.Coords;
import bs.project.worldweather.console.integration.dto.WeatherCityDTO;
import bs.project.worldweather.console.integration.dto.WeatherCurrentInfoDTO;
import bs.project.worldweather.console.integration.dto.WeatherForecastDTO;

import java.util.List;

public interface WeatherIntegrationService {

    // https://openweathermap.org/api/hourly-forecast
    // https://openweathermap.org/current
    /*
    Juntar as duas APIs acima e gerar um retorno único
     */
    WeatherCurrentInfoDTO currentWeatherRequest(Coords coords);

    WeatherForecastDTO hourlyForecastRequest(Coords coords);

    List<WeatherCityDTO> searchQuery(String query);
}
