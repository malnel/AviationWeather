
package com.malnel.aviationweather.model.checkwx.taf;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wind {

    @SerializedName("degrees")
    @Expose
    private Integer degrees;
    @SerializedName("speed_kts")
    @Expose
    private Integer speedKts;
    @SerializedName("speed_mph")
    @Expose
    private Integer speedMph;
    @SerializedName("speed_mps")
    @Expose
    private Integer speedMps;
    @SerializedName("gust_kts")
    @Expose
    private Integer gustKts;
    @SerializedName("gust_mph")
    @Expose
    private Integer gustMph;
    @SerializedName("gust_mps")
    @Expose
    private Integer gustMps;

    public Integer getDegrees() {
        return degrees;
    }

    public void setDegrees(Integer degrees) {
        this.degrees = degrees;
    }

    public Integer getSpeedKts() {
        return speedKts;
    }

    public void setSpeedKts(Integer speedKts) {
        this.speedKts = speedKts;
    }

    public Integer getSpeedMph() {
        return speedMph;
    }

    public void setSpeedMph(Integer speedMph) {
        this.speedMph = speedMph;
    }

    public Integer getSpeedMps() {
        return speedMps;
    }

    public void setSpeedMps(Integer speedMps) {
        this.speedMps = speedMps;
    }

    public Integer getGustKts() {
        return gustKts;
    }

    public void setGustKts(Integer gustKts) {
        this.gustKts = gustKts;
    }

    public Integer getGustMph() {
        return gustMph;
    }

    public void setGustMph(Integer gustMph) {
        this.gustMph = gustMph;
    }

    public Integer getGustMps() {
        return gustMps;
    }

    public void setGustMps(Integer gustMps) {
        this.gustMps = gustMps;
    }

}
