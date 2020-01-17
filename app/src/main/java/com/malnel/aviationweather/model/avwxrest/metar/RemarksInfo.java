
package com.malnel.aviationweather.model.avwxrest.metar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RemarksInfo {

    @SerializedName("dewpoint_decimal")
    @Expose
    private DewpointDecimal dewpointDecimal;
    @SerializedName("temperature_decimal")
    @Expose
    private TemperatureDecimal temperatureDecimal;

    public DewpointDecimal getDewpointDecimal() {
        return dewpointDecimal;
    }

    public void setDewpointDecimal(DewpointDecimal dewpointDecimal) {
        this.dewpointDecimal = dewpointDecimal;
    }

    public TemperatureDecimal getTemperatureDecimal() {
        return temperatureDecimal;
    }

    public void setTemperatureDecimal(TemperatureDecimal temperatureDecimal) {
        this.temperatureDecimal = temperatureDecimal;
    }

}
