package com.malnel.aviationweather;

import com.google.gson.annotations.SerializedName;

public class Metar {

    @SerializedName("results")
    private String results;

    @SerializedName("data")
    private String[] data;

    public String[] getData() {
        return data;
    }

    public String getResults() {
        return results;
    }
}


