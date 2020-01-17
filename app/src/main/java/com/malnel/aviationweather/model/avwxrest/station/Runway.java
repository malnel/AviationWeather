
package com.malnel.aviationweather.model.avwxrest.station;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Runway {

    @SerializedName("length_ft")
    @Expose
    private Integer lengthFt;
    @SerializedName("width_ft")
    @Expose
    private Integer widthFt;
    @SerializedName("ident1")
    @Expose
    private String ident1;
    @SerializedName("ident2")
    @Expose
    private String ident2;

    public Integer getLengthFt() {
        return lengthFt;
    }

    public void setLengthFt(Integer lengthFt) {
        this.lengthFt = lengthFt;
    }

    public Integer getWidthFt() {
        return widthFt;
    }

    public void setWidthFt(Integer widthFt) {
        this.widthFt = widthFt;
    }

    public String getIdent1() {
        return ident1;
    }

    public void setIdent1(String ident1) {
        this.ident1 = ident1;
    }

    public String getIdent2() {
        return ident2;
    }

    public void setIdent2(String ident2) {
        this.ident2 = ident2;
    }

}
