package nerdery.com.umbrella.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import nerdery.com.umbrella.networking.WeatherAPI;
import nerdery.com.umbrella.networking.WeatherService;
import rx.Observable;

/**
 * Model for weather data returned from network call.
 *
 * References two objects
 * current conditions - the weahter right now and
 * forecast conditions- the weather to come.
 *
 * @author Aleckson
 */

public class WeatherModel {
    @SerializedName("current_observation")
    public CurrentObservation currentObservation;

    @SerializedName("hourly_forecast")
    public List<ForecastCondition> forecast;

    public static Observable<WeatherModel> getWeatherData(String zipCode){
        WeatherService service = new WeatherService();
        return service.fetchWeather(zipCode);
    }
}
