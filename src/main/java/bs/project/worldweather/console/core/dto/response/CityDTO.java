package bs.project.worldweather.console.core.dto.response;

import bs.project.worldweather.console.core.models.Coords;
import lombok.Data;

@Data
public class CityDTO {
    private String cityName;
    private String country;
    private Coords coords;
}
