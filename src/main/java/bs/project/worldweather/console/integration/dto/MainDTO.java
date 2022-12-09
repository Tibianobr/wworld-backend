package bs.project.worldweather.console.integration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MainDTO {
    @JsonProperty("temp_min")
    private Double tempMin;
    @JsonProperty("feels_like")
    private Double feelsLike;
    private Integer humidity;
    private Double temp;
    private Double pressure;
    @JsonProperty("temp_max")
    private Double tempMax;
}
