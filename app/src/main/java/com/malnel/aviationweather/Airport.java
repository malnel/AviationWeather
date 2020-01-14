package com.malnel.aviationweather;

import com.google.gson.annotations.SerializedName;

public class Airport {

    @SerializedName("data")
    private String[] data;

    public String[] getData() {
        return data;
    }
}
