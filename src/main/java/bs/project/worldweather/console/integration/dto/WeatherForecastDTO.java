package bs.project.worldweather.console.integration.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class WeatherForecastDTO extends WeatherCityDTO {
    private Integer cnt;
    private String cod;
    private WeatherCurrentInfoDTO[] list;
    private Integer timezone;
}
