
package com.malnel.aviationweather.model.avwxrest.taf;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta {

    @SerializedName("cache-timestamp")
    @Expose
    private String cacheTimestamp;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;

    public String getCacheTimestamp() {
        return cacheTimestamp;
    }

    public void setCacheTimestamp(String cacheTimestamp) {
        this.cacheTimestamp = cacheTimestamp;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
