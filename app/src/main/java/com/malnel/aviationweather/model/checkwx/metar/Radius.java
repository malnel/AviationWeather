
package com.malnel.aviationweather.model.checkwx.metar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Radius {

    @SerializedName("from")
    @Expose
    private String from;
    @SerializedName("miles")
    @Expose
    private Double miles;
    @SerializedName("meters")
    @Expose
    private Integer meters;
    @SerializedName("bearing")
    @Expose
    private Integer bearing;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Double getMiles() {
        return miles;
    }

    public void setMiles(Double miles) {
        this.miles = miles;
    }

    public Integer getMeters() {
        return meters;
    }

    public void setMeters(Integer meters) {
        this.meters = meters;
    }

    public Integer getBearing() {
        return bearing;
    }

    public void setBearing(Integer bearing) {
        this.bearing = bearing;
    }

}
