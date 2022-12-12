package bs.project.worldweather.console.core.dto.response;

import bs.project.worldweather.console.integration.dto.MainDTO;
import bs.project.worldweather.console.integration.dto.WeatherDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataWeatherResponseDTO {
    private Instant currentLocalTime;
    private String name;
    private Instant sunrise;
    private Instant sunset;
    private MainDTO currentInfo;
    private WeatherDTO weatherDesc;
    private List<String> dateIndexForecast;
    private List<Double> temperatureForecast;
}
