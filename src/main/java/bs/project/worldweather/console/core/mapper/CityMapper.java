package bs.project.worldweather.console.core.mapper;

import bs.project.worldweather.console.core.dto.response.CityDTO;
import bs.project.worldweather.console.core.models.Coords;
import bs.project.worldweather.console.integration.dto.WeatherCityDTO;

public class CityMapper {

    public static CityDTO weatherCityToCityDTO(WeatherCityDTO weatherCityDTO){
        CityDTO cityDTO = new CityDTO();
        cityDTO.setCityName(weatherCityDTO.getName());
        cityDTO.setCountry(weatherCityDTO.getCountry());

        Coords coords = new Coords(weatherCityDTO.getLat(), weatherCityDTO.getLon());
        cityDTO.setCoords(coords);

        return cityDTO;
    }
}
