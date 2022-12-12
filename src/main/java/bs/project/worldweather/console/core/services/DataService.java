package bs.project.worldweather.console.core.services;

import bs.project.worldweather.console.core.dto.response.DataWeatherResponseDTO;
import bs.project.worldweather.console.core.models.Coords;

public interface DataService {
    DataWeatherResponseDTO fetchWeatherData(Coords coords);
}
