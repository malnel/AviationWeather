
package com.malnel.aviationweather.model.avwxrest.metar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Time {

    @SerializedName("dt")
    @Expose
    private String dt;
    @SerializedName("repr")
    @Expose
    private String repr;

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public String getRepr() {
        return repr;
    }

    public void setRepr(String repr) {
        this.repr = repr;
    }

}
