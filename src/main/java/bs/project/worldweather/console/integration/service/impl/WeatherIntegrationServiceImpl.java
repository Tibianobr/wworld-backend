package bs.project.worldweather.console.integration.service.impl;

import bs.project.worldweather.console.core.models.Coords;
import bs.project.worldweather.console.integration.dto.WeatherCityDTO;
import bs.project.worldweather.console.integration.dto.WeatherQueryParam;
import bs.project.worldweather.console.integration.service.WeatherIntegrationService;
import bs.project.worldweather.console.integration.utils.WebClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class WeatherIntegrationServiceImpl implements WeatherIntegrationService {

    @Value("${openweather.api.key}")
    private String apiKey;

    @Autowired
    private WebClientUtils webClientUtils;

    // https://openweathermap.org/api/hourly-forecast
    // https://openweathermap.org/current
    /*
    Juntar as duas APIs acima e gerar um retorno único
     */
    @Override
    public void currentWeatherRequest(Coords coords){
        WebClient webClient = webClientUtils.webClientWeatherData();
        String a = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("weather")
                        .queryParam(WeatherQueryParam.LATITUDE.getParam(), coords.getLat())
                        .queryParam(WeatherQueryParam.LONGITUDE.getParam(), coords.getLon())
                        .queryParam(WeatherQueryParam.API_KEY.getParam(), apiKey)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    @Override
    public void hourlyForecastRequest(Coords coords){
        WebClient webClient = webClientUtils.webClientWeatherGeo();
        String a = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("direct")
                        .queryParam(WeatherQueryParam.LATITUDE.getParam(), coords.getLat())
                        .queryParam(WeatherQueryParam.LONGITUDE.getParam(), coords.getLon())
                        .queryParam(WeatherQueryParam.API_KEY.getParam(), apiKey)
                        .queryParam(WeatherQueryParam.COUNT.getParam(),"5")
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    @Override
    public List<WeatherCityDTO> searchQuery(String query){
        WebClient webClient = webClientUtils.webClientWeatherGeo();
        Mono<WeatherCityDTO[]> response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("direct")
                        .queryParam(WeatherQueryParam.QUERY.getParam(), query)
                        .queryParam(WeatherQueryParam.API_KEY.getParam(), apiKey)
                        .queryParam(WeatherQueryParam.LIMIT.getParam(),"5")
                        .build())
                .retrieve()
                .bodyToMono(WeatherCityDTO[].class);


        WeatherCityDTO[] cities = response.block();
        return List.of(cities);
    }




}
