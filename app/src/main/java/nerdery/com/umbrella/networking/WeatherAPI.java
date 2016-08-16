package nerdery.com.umbrella.networking;

import nerdery.com.umbrella.BuildConfig;
import nerdery.com.umbrella.models.WeatherModel;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Aleckson on 8/16/2016.
 *
 * Retrofit Interface for fetching weather data
 */

public interface WeatherAPI {

    /**
     * Fetch Weather  data for a given location
     *
     * @param zipCode is the location
     */
    @GET("/api/" + BuildConfig.API_KEY + "/conditions/hourly10day/q/{zip}.json")
    Observable<WeatherModel> fetchWeather
    (@Path("zip") String zipCode);
}
