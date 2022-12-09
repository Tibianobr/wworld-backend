package bs.project.worldweather.console.integration.dto;

import bs.project.worldweather.console.core.models.Coords;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Instant;

@Data
public class WeatherCurrentInfoDTO {
    private Integer id;
    private Instant dt;
    private String name;
    private CoordsDoubleDTO coord;
    private SysDTO sys;
    private MainDTO main;
    private WeatherDTO[] weather;
    private WindDTO wind;
    private Integer timezone;
    @JsonProperty("dt_txt")
    private String dtTxt;

}
