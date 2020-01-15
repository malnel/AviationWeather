
package com.malnel.aviationweather.model.Metar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Visibility {

    @SerializedName("miles")
    @Expose
    private String miles;
    @SerializedName("miles_float")
    @Expose
    private Double milesFloat;
    @SerializedName("meters")
    @Expose
    private String meters;
    @SerializedName("meters_float")
    @Expose
    private Double metersFloat;

    public String getMiles() {
        return miles;
    }

    public void setMiles(String miles) {
        this.miles = miles;
    }

    public Double getMilesFloat() {
        return milesFloat;
    }

    public void setMilesFloat(Double milesFloat) {
        this.milesFloat = milesFloat;
    }

    public String getMeters() {
        return meters;
    }

    public void setMeters(String meters) {
        this.meters = meters;
    }

    public Double getMetersFloat() {
        return metersFloat;
    }

    public void setMetersFloat(Double metersFloat) {
        this.metersFloat = metersFloat;
    }

}
