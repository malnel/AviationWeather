package com.malnel.aviationweather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface WeatherApi {

    @Headers("X-API-KEY: #MY-KEY-HERE")
    @GET("metar/KDFW/")
    Call<Airport> getPosts();
}
