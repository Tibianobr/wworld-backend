package bs.project.worldweather.console.integration.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WebClientUtils {

    @Value("${openweather.base.url}")
    private String baseUrl;

    public WebClient webClientWeatherData() {
        return WebClient
                .builder()
                .baseUrl(baseUrl + "/data/2.5/")
                .build();
    }

    public WebClient webClientWeatherGeo() {
        return WebClient
                .builder()
                .baseUrl(baseUrl + "/geo/1.0/")
                .build();
    }
}
