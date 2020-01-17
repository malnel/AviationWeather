
package com.malnel.aviationweather.model.checkwx.taf;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("timestamp")
    @Expose
    private Timestamp timestamp;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("radius")
    @Expose
    private Radius radius;
    @SerializedName("icao")
    @Expose
    private String icao;
    @SerializedName("raw_text")
    @Expose
    private String rawText;
    @SerializedName("forecast")
    @Expose
    private List<Forecast> forecast = null;
    @SerializedName("station")
    @Expose
    private Station station;

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Radius getRadius() {
        return radius;
    }

    public void setRadius(Radius radius) {
        this.radius = radius;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public String getRawText() {
        return rawText;
    }

    public void setRawText(String rawText) {
        this.rawText = rawText;
    }

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

}
