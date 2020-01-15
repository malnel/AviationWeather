
package com.malnel.aviationweather.model.Metar;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("wind")
    @Expose
    private Wind wind;
    @SerializedName("temperature")
    @Expose
    private Temperature temperature;
    @SerializedName("dewpoint")
    @Expose
    private Dewpoint dewpoint;
    @SerializedName("humidity")
    @Expose
    private Humidity humidity;
    @SerializedName("barometer")
    @Expose
    private Barometer barometer;
    @SerializedName("visibility")
    @Expose
    private Visibility visibility;
    @SerializedName("ceiling")
    @Expose
    private Ceiling ceiling;
    @SerializedName("elevation")
    @Expose
    private Elevation elevation;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("icao")
    @Expose
    private String icao;
    @SerializedName("observed")
    @Expose
    private String observed;
    @SerializedName("raw_text")
    @Expose
    private String rawText;
    @SerializedName("station")
    @Expose
    private Station station;
    @SerializedName("clouds")
    @Expose
    private List<Cloud> clouds = null;
    @SerializedName("conditions")
    @Expose
    private List<Condition> conditions = null;
    @SerializedName("rain")
    @Expose
    private Rain rain;
    @SerializedName("flight_category")
    @Expose
    private String flightCategory;

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Dewpoint getDewpoint() {
        return dewpoint;
    }

    public void setDewpoint(Dewpoint dewpoint) {
        this.dewpoint = dewpoint;
    }

    public Humidity getHumidity() {
        return humidity;
    }

    public void setHumidity(Humidity humidity) {
        this.humidity = humidity;
    }

    public Barometer getBarometer() {
        return barometer;
    }

    public void setBarometer(Barometer barometer) {
        this.barometer = barometer;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public Ceiling getCeiling() {
        return ceiling;
    }

    public void setCeiling(Ceiling ceiling) {
        this.ceiling = ceiling;
    }

    public Elevation getElevation() {
        return elevation;
    }

    public void setElevation(Elevation elevation) {
        this.elevation = elevation;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public String getObserved() {
        return observed;
    }

    public void setObserved(String observed) {
        this.observed = observed;
    }

    public String getRawText() {
        return rawText;
    }

    public void setRawText(String rawText) {
        this.rawText = rawText;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public List<Cloud> getClouds() {
        return clouds;
    }

    public void setClouds(List<Cloud> clouds) {
        this.clouds = clouds;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public String getFlightCategory() {
        return flightCategory;
    }

    public void setFlightCategory(String flightCategory) {
        this.flightCategory = flightCategory;
    }

}
