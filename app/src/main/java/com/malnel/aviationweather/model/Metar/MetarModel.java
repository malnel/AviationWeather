
package com.malnel.aviationweather.model.Metar;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MetarModel {

    @SerializedName("results")
    @Expose
    private Integer results;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public Integer getResults() {
        return results;
    }

    public void setResults(Integer results) {
        this.results = results;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

}
