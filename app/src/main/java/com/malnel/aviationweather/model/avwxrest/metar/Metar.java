
package com.malnel.aviationweather.model.avwxrest.metar;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metar {

    @SerializedName("altimeter")
    @Expose
    private Altimeter altimeter;
    @SerializedName("clouds")
    @Expose
    private List<Cloud> clouds = null;
    @SerializedName("dewpoint")
    @Expose
    private Dewpoint dewpoint;
    @SerializedName("flight_rules")
    @Expose
    private String flightRules;
    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("other")
    @Expose
    private List<Object> other = null;
    @SerializedName("raw")
    @Expose
    private String raw;
    @SerializedName("remarks")
    @Expose
    private String remarks;
    @SerializedName("remarks_info")
    @Expose
    private RemarksInfo remarksInfo;
    @SerializedName("runway_visibility")
    @Expose
    private List<Object> runwayVisibility = null;
    @SerializedName("sanitized")
    @Expose
    private String sanitized;
    @SerializedName("station")
    @Expose
    private String station;
    @SerializedName("temperature")
    @Expose
    private Temperature temperature;
    @SerializedName("time")
    @Expose
    private Time time;
    @SerializedName("units")
    @Expose
    private Units units;
    @SerializedName("visibility")
    @Expose
    private Visibility visibility;
    @SerializedName("wind_direction")
    @Expose
    private WindDirection windDirection;
    @SerializedName("wind_gust")
    @Expose
    private Object windGust;
    @SerializedName("wind_speed")
    @Expose
    private WindSpeed windSpeed;
    @SerializedName("wind_variable_direction")
    @Expose
    private List<Object> windVariableDirection = null;

    public Altimeter getAltimeter() {
        return altimeter;
    }

//    public void setAltimeter(Altimeter altimeter) {
//        this.altimeter = altimeter;
//    }

    public List<Cloud> getClouds() {
        return clouds;
    }

    public void setClouds(List<Cloud> clouds) {
        this.clouds = clouds;
    }

    public Dewpoint getDewpoint() {
        return dewpoint;
    }

//    public void setDewpoint(Dewpoint dewpoint) {
//        this.dewpoint = dewpoint;
//    }

    public String getFlightRules() {
        return flightRules;
    }

    public void setFlightRules(String flightRules) {
        this.flightRules = flightRules;
    }

    public Meta getMeta() {
        return meta;
    }

//    public void setMeta(Meta meta) {
//        this.meta = meta;
//    }

    public List<Object> getOther() {
        return other;
    }

    public void setOther(List<Object> other) {
        this.other = other;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public RemarksInfo getRemarksInfo() {
        return remarksInfo;
    }

//    public void setRemarksInfo(RemarksInfo remarksInfo) {
//        this.remarksInfo = remarksInfo;
//    }

    public List<Object> getRunwayVisibility() {
        return runwayVisibility;
    }

    public void setRunwayVisibility(List<Object> runwayVisibility) {
        this.runwayVisibility = runwayVisibility;
    }

    public String getSanitized() {
        return sanitized;
    }

    public void setSanitized(String sanitized) {
        this.sanitized = sanitized;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public Temperature getTemperature() {
        return temperature;
    }

//    public void setTemperature(Temperature temperature) {
//        this.temperature = temperature;
//    }

    public Time getTime() {
        return time;
    }

//    public void setTime(Time time) {
//        this.time = time;
//    }

    public Units getUnits() {
        return units;
    }

//    public void setUnits(Units units) {
//        this.units = units;
//    }

    public Visibility getVisibility() {
        return visibility;
    }

//    public void setVisibility(Visibility visibility) {
//        this.visibility = visibility;
//    }

    public WindDirection getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(WindDirection windDirection) {
//        this.windDirection = windDirection;
    }

    public Object getWindGust() {
        return windGust;
    }

    public void setWindGust(Object windGust) {
        this.windGust = windGust;
    }

    public WindSpeed getWindSpeed() {
        return windSpeed;
    }

//    public void setWindSpeed(WindSpeed windSpeed) {
//        this.windSpeed = windSpeed;
//    }

    public List<Object> getWindVariableDirection() {
        return windVariableDirection;
    }

    public void setWindVariableDirection(List<Object> windVariableDirection) {
        this.windVariableDirection = windVariableDirection;
    }

}
