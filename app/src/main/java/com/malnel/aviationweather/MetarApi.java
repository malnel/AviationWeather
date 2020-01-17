package com.malnel.aviationweather;

import com.malnel.aviationweather.model.metar.MetarModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MetarApi {

    @GET("cgi-bin/json/MetarJSON.php")
    Call<MetarModel> getResponse();
}