
package com.malnel.aviationweather.model.avwxrest.taf;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Visibility {

    @SerializedName("repr")
    @Expose
    private String repr;
    @SerializedName("spoken")
    @Expose
    private String spoken;
    @SerializedName("value")
    @Expose
    private Object value;

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

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

}
