
package com.malnel.aviationweather.model.Metar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Elevation {

    @SerializedName("feet")
    @Expose
    private Double feet;
    @SerializedName("meters")
    @Expose
    private Double meters;

    public Double getFeet() {
        return feet;
    }

    public void setFeet(Double feet) {
        this.feet = feet;
    }

    public Double getMeters() {
        return meters;
    }

    public void setMeters(Double meters) {
        this.meters = meters;
    }

}
