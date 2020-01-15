
package com.malnel.aviationweather.model.Metar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ceiling {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("feet_agl")
    @Expose
    private Double feetAgl;
    @SerializedName("meters_agl")
    @Expose
    private Double metersAgl;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Double getFeetAgl() {
        return feetAgl;
    }

    public void setFeetAgl(Double feetAgl) {
        this.feetAgl = feetAgl;
    }

    public Double getMetersAgl() {
        return metersAgl;
    }

    public void setMetersAgl(Double metersAgl) {
        this.metersAgl = metersAgl;
    }

}
