package nerdery.com.umbrella.parser;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Date;

import nerdery.com.umbrella.models.ForecastCondition;

/**
 * Converts Weather Underground's hourly forecast data to Java objects
 *
 * @author bherbst & Aleckson
 */

public class ForecastParser implements JsonDeserializer<ForecastCondition>{
        @Override
        public ForecastCondition deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext
        context) throws JsonParseException {
        ForecastCondition condition = new ForecastCondition();

        // Parse out root data
        JsonObject root = json.getAsJsonObject();
        condition.setIcon(root.get("icon").getAsString());

        // Parse out temperature data
        JsonObject temp = root.getAsJsonObject("temp");
        String tempEnglishString = temp.get("english").getAsString();
        String tempMetricString = temp.get("metric").getAsString();
        condition.setTempFahrenheit(Float.valueOf(tempEnglishString));
        condition.setTempCelsius(Float.valueOf(tempMetricString));
        condition.setCondition(root.get("condition").getAsString());

        // Parse out time data
        JsonObject fcttime = root.getAsJsonObject("FCTTIME");
        condition.setDisplayTime(fcttime.get("civil").getAsString());
        long epochSeconds = fcttime.get("epoch").getAsLong();
        condition.setTime(new Date(epochSeconds * 1000));
        condition.setHour(fcttime.get("hour").getAsInt());
        condition.setDay(fcttime.get("weekday_name").getAsString());
        condition.setYday(fcttime.get("yday").getAsLong());

        return condition;
    }
}
