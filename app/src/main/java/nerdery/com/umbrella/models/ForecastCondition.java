package nerdery.com.umbrella.models;

import java.util.Date;

/**
 * Represents a forecast weather condition returned from Weather Underground
 * Does not include all available  data - only potentially useful fields are included
 *
 * @author bherbst & Aleckson
 */

public class ForecastCondition {
    /**
     * Formatted time suitable for display
     */
    private String displayTime;

    /**
     * Date representation of the time associated with this forecast
     */
    private Date time;

    /**
     * The icon to use for this reading
     */
    private String icon;

    /**
     * The human-readable name of the condition
     */
    private String condition;

    /**
     * The temperature that is forecast (in degrees Fahrenheit)
     */
    private float tempFahrenheit;

    /**
     * The temperature that is forecast (in degrees Celsius)
     */
    private float tempCelsius;
    /**
     * The current hour in 24 hour format
     */

    private int hour;

    private String day;

    private long yday;

    /**
     * Getters and setters for proper encapsulation
     */
    public String getDisplayTime() {
        return displayTime;
    }

    public void setDisplayTime(String displayTime) {
        this.displayTime = displayTime;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public float getTempFahrenheit() {
        return tempFahrenheit;
    }

    public void setTempFahrenheit(float tempFahrenheit) {
        this.tempFahrenheit = tempFahrenheit;
    }

    public float getTempCelsius() {
        return tempCelsius;
    }

    public void setTempCelsius(float tempCelsius) {
        this.tempCelsius = tempCelsius;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public long getYday() {
        return yday;
    }

    public void setYday(long yday) {
        this.yday = yday;
    }
}
