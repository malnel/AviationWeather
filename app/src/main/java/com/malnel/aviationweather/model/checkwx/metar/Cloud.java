
package com.malnel.aviationweather.model.checkwx.metar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cloud {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("base_feet_agl")
    @Expose
    private Integer baseFeetAgl;
    @SerializedName("base_meters_agl")
    @Expose
    private Double baseMetersAgl;

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

    public Integer getBaseFeetAgl() {
        return baseFeetAgl;
    }

    public void setBaseFeetAgl(Integer baseFeetAgl) {
        this.baseFeetAgl = baseFeetAgl;
    }

    public Double getBaseMetersAgl() {
        return baseMetersAgl;
    }

    public void setBaseMetersAgl(Double baseMetersAgl) {
        this.baseMetersAgl = baseMetersAgl;
    }

}
