
package com.malnel.aviationweather.model.checkwx.taf;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Forecast {

    @SerializedName("wind")
    @Expose
    private Wind wind;
    @SerializedName("visibility")
    @Expose
    private Visibility visibility;
    @SerializedName("clouds")
    @Expose
    private List<Cloud> clouds = null;
    @SerializedName("conditions")
    @Expose
    private List<Condition> conditions = null;
    @SerializedName("timestamp")
    @Expose
    private Timestamp_ timestamp;
    @SerializedName("section_key")
    @Expose
    private String sectionKey;
    @SerializedName("section")
    @Expose
    private String section;
    @SerializedName("change")
    @Expose
    private Change change;
    @SerializedName("wind_shear_speed_kt")
    @Expose
    private Integer windShearSpeedKt;
    @SerializedName("wind_shear_hgt_ft_agl")
    @Expose
    private Integer windShearHgtFtAgl;
    @SerializedName("wind_shear_dir_degrees")
    @Expose
    private Integer windShearDirDegrees;

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
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

    public Timestamp_ getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp_ timestamp) {
        this.timestamp = timestamp;
    }

    public String getSectionKey() {
        return sectionKey;
    }

    public void setSectionKey(String sectionKey) {
        this.sectionKey = sectionKey;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Change getChange() {
        return change;
    }

    public void setChange(Change change) {
        this.change = change;
    }

    public Integer getWindShearSpeedKt() {
        return windShearSpeedKt;
    }

    public void setWindShearSpeedKt(Integer windShearSpeedKt) {
        this.windShearSpeedKt = windShearSpeedKt;
    }

    public Integer getWindShearHgtFtAgl() {
        return windShearHgtFtAgl;
    }

    public void setWindShearHgtFtAgl(Integer windShearHgtFtAgl) {
        this.windShearHgtFtAgl = windShearHgtFtAgl;
    }

    public Integer getWindShearDirDegrees() {
        return windShearDirDegrees;
    }

    public void setWindShearDirDegrees(Integer windShearDirDegrees) {
        this.windShearDirDegrees = windShearDirDegrees;
    }

}
