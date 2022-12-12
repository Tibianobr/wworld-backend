package bs.project.worldweather.console.core.mapper;

import bs.project.worldweather.console.core.dto.response.DataWeatherResponseDTO;
import bs.project.worldweather.console.integration.dto.WeatherCurrentInfoDTO;
import bs.project.worldweather.console.integration.dto.WeatherForecastDTO;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataMapper {

    public static DataWeatherResponseDTO toDataDTO(WeatherCurrentInfoDTO weatherCurrentInfoDTO, WeatherForecastDTO weatherForecastDTO) {
        DataWeatherResponseDTO data = new DataWeatherResponseDTO();
        data.setName(weatherCurrentInfoDTO.getName());
        data.setSunrise(weatherCurrentInfoDTO.getSys().getSunrise().plus(weatherCurrentInfoDTO.getTimezone(), ChronoUnit.SECONDS));
        data.setSunset(weatherCurrentInfoDTO.getSys().getSunset().plus(weatherCurrentInfoDTO.getTimezone(), ChronoUnit.SECONDS));
        data.setCurrentLocalTime(weatherCurrentInfoDTO.getDt().plus(weatherCurrentInfoDTO.getTimezone(), ChronoUnit.SECONDS));
        data.setTemperatureForecast(buildTemperatureArray(weatherForecastDTO));
        data.setDateIndexForecast(buildDateTimeIndex(weatherForecastDTO));
        data.setWeatherDesc(weatherCurrentInfoDTO.getWeather()[0]);
        data.setCurrentInfo(weatherCurrentInfoDTO.getMain());
        data.setCurrentLocalTime(data.getCurrentLocalTime().plus(weatherCurrentInfoDTO.getTimezone(), ChronoUnit.SECONDS));
        return data;
    }

    private static List<Double> buildTemperatureArray(WeatherForecastDTO weatherForecastDTO) {
        return Arrays.stream(weatherForecastDTO.getList()).map(info -> info.getMain().getTemp()).collect(Collectors.toList());
    }

    private static List<String> buildDateTimeIndex(WeatherForecastDTO weatherForecastDTO) {
        return Arrays.stream(weatherForecastDTO.getList()).map(info -> info.getDtTxt()).collect(Collectors.toList());
    }
}
