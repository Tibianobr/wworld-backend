package bs.project.worldweather.console.integration.enums;

public enum WeatherQueryParam {
    API_KEY("appid"),
    LATITUDE("lat"),
    LONGITUDE("lon"),
    COUNT("cnt"),
    QUERY("q"),
    LIMIT("limit");

    private final String param;

    WeatherQueryParam(String param) {
        this.param = param;
    }

    public String getParam() {
        return param;
    }
}
