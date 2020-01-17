
package com.malnel.aviationweather.model.avwxrest.metar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Altimeter {

    @SerializedName("repr")
    @Expose
    private String repr;
    @SerializedName("spoken")
    @Expose
    private String spoken;
    @SerializedName("value")
    @Expose
    private Double value;

    public String getRepr() {
        return repr;
    }

    public void setRepr(String repr) {
        this.repr = repr;
    }

    public String getSpoken() {
        return spoken;
    }

    public void setSpoken(String spoken) {
        this.spoken = spoken;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

}
