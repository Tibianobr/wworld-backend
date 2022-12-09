package bs.project.worldweather.console.integration.dto;

import lombok.Data;

@Data
public class WeatherDTO {
    private String icon;
    private String main;
    private String description;
}
