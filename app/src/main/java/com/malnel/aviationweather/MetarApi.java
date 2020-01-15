package com.malnel.aviationweather;

import com.malnel.aviationweather.model.Metar.MetarModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface MetarApi {

    @Headers("X-API-KEY: # MY API KEY #")
    @GET("metar/{input}/decoded")
    Call<MetarModel> getResponse(@Path("input") String input);
}