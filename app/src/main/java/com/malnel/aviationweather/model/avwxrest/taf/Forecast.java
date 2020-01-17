
package com.malnel.aviationweather.model.avwxrest.taf;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Forecast {

    @SerializedName("altimeter")
    @Expose
    private String altimeter;
    @SerializedName("clouds")
    @Expose
    private List<Cloud> clouds = null;
    @SerializedName("end_time")
    @Expose
    private EndTime_ endTime;
    @SerializedName("flight_rules")
    @Expose
    private String flightRules;
    @SerializedName("icing")
    @Expose
    private List<Object> icing = null;
    @SerializedName("other")
    @Expose
    private List<Object> other = null;
    @SerializedName("probability")
    @Expose
    private Object probability;
    @SerializedName("raw")
    @Expose
    private String raw;
    @SerializedName("sanitized")
    @Expose
    private String sanitized;
    @SerializedName("start_time")
    @Expose
    private StartTime startTime;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("turbulance")
    @Expose
    private List<Object> turbulance = null;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("visibility")
    @Expose
    private Visibility visibility;
    @SerializedName("wind_direction")
    @Expose
    private WindDirection windDirection;
    @SerializedName("wind_gust")
    @Expose
    private Object windGust;
    @SerializedName("wind_shear")
    @Expose
    private String windShear;
    @SerializedName("wind_speed")
    @Expose
    private WindSpeed windSpeed;

    public String getAltimeter() {
        return altimeter;
    }

    public void setAltimeter(String altimeter) {
        this.altimeter = altimeter;
    }

    public List<Cloud> getClouds() {
        return clouds;
    }

    public void setClouds(List<Cloud> clouds) {
        this.clouds = clouds;
    }

    public EndTime_ getEndTime() {
        return endTime;
    }

    public void setEndTime(EndTime_ endTime) {
        this.endTime = endTime;
    }

    public String getFlightRules() {
        return flightRules;
    }

    public void setFlightRules(String flightRules) {
        this.flightRules = flightRules;
    }

    public List<Object> getIcing() {
        return icing;
    }

    public void setIcing(List<Object> icing) {
        this.icing = icing;
    }

    public List<Object> getOther() {
        return other;
    }

    public void setOther(List<Object> other) {
        this.other = other;
    }

    public Object getProbability() {
        return probability;
    }

    public void setProbability(Object probability) {
        this.probability = probability;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getSanitized() {
        return sanitized;
    }

    public void setSanitized(String sanitized) {
        this.sanitized = sanitized;
    }

    public StartTime getStartTime() {
        return startTime;
    }

    public void setStartTime(StartTime startTime) {
        this.startTime = startTime;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<Object> getTurbulance() {
        return turbulance;
    }

    public void setTurbulance(List<Object> turbulance) {
        this.turbulance = turbulance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public WindDirection getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(WindDirection windDirection) {
        this.windDirection = windDirection;
    }

    public Object getWindGust() {
        return windGust;
    }

    public void setWindGust(Object windGust) {
        this.windGust = windGust;
    }

    public String getWindShear() {
        return windShear;
    }

    public void setWindShear(String windShear) {
        this.windShear = windShear;
    }

    public WindSpeed getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(WindSpeed windSpeed) {
        this.windSpeed = windSpeed;
    }

}
