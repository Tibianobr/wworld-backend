package bs.project.worldweather.console.core.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class SearchResponseDTO {
    List<CityDTO> cities;
}
