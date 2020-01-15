package com.malnel.aviationweather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface MetarApi {

    @Headers("X-API-KEY: # MY API KEY #")
    @GET("metar/KDFW/")
    Call<Metar> getResponse();
}
