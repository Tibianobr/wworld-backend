package bs.project.worldweather.console.core.services;

import bs.project.worldweather.console.core.models.Coords;

public interface DataService {
    void fetchWeatherData(Coords coords);
}
