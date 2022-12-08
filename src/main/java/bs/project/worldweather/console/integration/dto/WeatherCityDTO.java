package bs.project.worldweather.console.integration.dto;

import lombok.Data;

@Data
public class WeatherCityDTO {
    private String name;
    private String country;
    private String lat;
    private String lon;
}
