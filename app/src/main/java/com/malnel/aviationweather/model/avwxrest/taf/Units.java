
package com.malnel.aviationweather.model.avwxrest.taf;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Units {

    @SerializedName("altimeter")
    @Expose
    private String altimeter;
    @SerializedName("altitude")
    @Expose
    private String altitude;
    @SerializedName("temperature")
    @Expose
    private String temperature;
    @SerializedName("visibility")
    @Expose
    private String visibility;
    @SerializedName("wind_speed")
    @Expose
    private String windSpeed;

    public String getAltimeter() {
        return altimeter;
    }

    public void setAltimeter(String altimeter) {
        this.altimeter = altimeter;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

}
