package nerdery.com.umbrella.networking;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import nerdery.com.umbrella.BuildConfig;
import nerdery.com.umbrella.models.ForecastCondition;
import nerdery.com.umbrella.models.WeatherModel;
import nerdery.com.umbrella.parser.ForecastParser;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * This class is responsible for defining how
 * network requests are made leveraging retrofit
 * All network calls by default are synchronous
 *
 * @apiNote Consuming APIs with Retrofit Tutorial:
 * https://github.com/codepath/android_guides/wiki/Consuming-APIs-with-Retrofit
 *
 * @author Aleckson
 */

public class WeatherService {

    private WeatherAPI mWeatherAPI;

    public WeatherService() {
        /**
         * Custom Gson parser instance
         */
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(ForecastCondition.class, new ForecastParser())
                .create();

        /**
         * RxJava adapter for efficient network calls with multi threading.
         */
        RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory.create();

        /**
         * Retrofit builder instance
         */
        Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.API_URL)
                    .addCallAdapterFactory(rxAdapter)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

        mWeatherAPI = retrofit.create(WeatherAPI.class);
    }

    public Observable<WeatherModel> fetchWeather (String zipCode){
        return mWeatherAPI.fetchWeather(zipCode);
    }
}
