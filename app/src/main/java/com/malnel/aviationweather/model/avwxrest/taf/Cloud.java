
package com.malnel.aviationweather.model.avwxrest.taf;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cloud {

    @SerializedName("altitude")
    @Expose
    private Integer altitude;
    @SerializedName("modifier")
    @Expose
    private Object modifier;
    @SerializedName("repr")
    @Expose
    private String repr;
    @SerializedName("type")
    @Expose
    private String type;

    public Integer getAltitude() {
        return altitude;
    }

    public void setAltitude(Integer altitude) {
        this.altitude = altitude;
    }

    public Object getModifier() {
        return modifier;
    }

    public void setModifier(Object modifier) {
        this.modifier = modifier;
    }

    public String getRepr() {
        return repr;
    }

    public void setRepr(String repr) {
        this.repr = repr;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
