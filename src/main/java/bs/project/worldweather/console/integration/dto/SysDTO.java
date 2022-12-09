package bs.project.worldweather.console.integration.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class SysDTO {
    private String country;
    private Instant sunset;
    private Integer id;
    private Instant sunrise;
}
