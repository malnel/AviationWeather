package com.malnel.aviationweather;

import com.malnel.aviationweather.model.Metar.MetarModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface MetarDecodedApi {

    @Headers("X-API-KEY: # MY API KEY #")
    @GET("metar/KDFW/decoded")
    Call<MetarModel> getResponse();
}