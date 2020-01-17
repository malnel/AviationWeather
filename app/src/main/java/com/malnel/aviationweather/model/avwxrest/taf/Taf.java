
package com.malnel.aviationweather.model.avwxrest.taf;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Taf {

    @SerializedName("alts")
    @Expose
    private Object alts;
    @SerializedName("end_time")
    @Expose
    private EndTime endTime;
    @SerializedName("forecast")
    @Expose
    private List<Forecast> forecast = null;
    @SerializedName("max_temp")
    @Expose
    private String maxTemp;
    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("min_temp")
    @Expose
    private String minTemp;
    @SerializedName("raw")
    @Expose
    private String raw;
    @SerializedName("remarks")
    @Expose
    private String remarks;
    @SerializedName("start_time")
    @Expose
    private StartTime_ startTime;
    @SerializedName("station")
    @Expose
    private String station;
    @SerializedName("temps")
    @Expose
    private Object temps;
    @SerializedName("time")
    @Expose
    private Time time;
    @SerializedName("units")
    @Expose
    private Units units;

    public Object getAlts() {
        return alts;
    }

    public void setAlts(Object alts) {
        this.alts = alts;
    }

    public EndTime getEndTime() {
        return endTime;
    }

    public void setEndTime(EndTime endTime) {
        this.endTime = endTime;
    }

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
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

    public StartTime_ getStartTime() {
        return startTime;
    }

    public void setStartTime(StartTime_ startTime) {
        this.startTime = startTime;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public Object getTemps() {
        return temps;
    }

    public void setTemps(Object temps) {
        this.temps = temps;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Units getUnits() {
        return units;
    }

    public void setUnits(Units units) {
        this.units = units;
    }

}
