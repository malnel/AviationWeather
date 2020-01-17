package com.malnel.aviationweather;

import com.malnel.aviationweather.model.aviationweathergov.AvWxGovMetars;
import com.malnel.aviationweather.model.avwxrest.station.Station;
import com.malnel.aviationweather.model.avwxrest.taf.Taf;
import com.malnel.aviationweather.model.checkwx.metar.MetarDecoded;
import com.malnel.aviationweather.model.checkwx.taf.TafDecoded;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface WeatherApi {

    //metars from aviationweather.gov -> incomplete, only about 200 stations
    @GET("cgi-bin/json/MetarJSON.php")
    Call<AvWxGovMetars> getGovMetars();

    @Headers("Authorization: ###")
    @GET("taf/KDFW?options=summary&airport=true&reporting=true&format=json&onfail=cache")
    Call<Taf> getTaf();

    @Headers("Authorization: ###")
    @GET("station/KDFW?format=json")
    Call<Station> getStation();

    /**
     * Returns the latest METAR information for a one or more ICAO codes.
     *
     * URL Parameter	Description
     * icao	A single ICAO code or multiple ICAO codes seperated by commas. Maximum of 20 ICAO codes per request.	REQUIRED
     * decoded	The response data will include decoded METAR information	OPTIONAL
     *
     * @return
     */
    @Headers("X-API-KEY: ###")
    @GET("metar/{icao}/decoded")
    Call<MetarDecoded> getMetarDecoded(@Path("icao") String icao);

    /**
     * Returns the latest METAR information for stations within a miles radius of a single ICAO code.
     *
     * The results are sorted based on the distance from the requested ICAO code.
     *
     * URL Parameter	Description
     * icao	A single ICAO code or multiple ICAO codes seperated by commas. Maximum of 20 ICAO codes per request.	REQUIRED
     * radius	The surrounding radius in miles from the ICAO code. 250 miles is the maximum radius.	REQUIRED
     * decoded	The response data will include decoded METAR information	OPTIONAL
     *
     *
     * Additional response fields are included in the response data to show the distance and direction
     * from the requested ICAO parameter.
     *
     * Additional response fields:
     * radius	array	Array with the following properties
     * radius.from	string	Base location ICAO
     * radius.miles	float	Distance from base location in miles
     * radius.meters	float	Distance from base location in meters
     * radius.bearing	integer	Bearing from base location (0-360)
     * radius.direction	string	Compass text from base location (N/NE/E/SE/S/SW/W/NW)
     *
     * @return
     */
    @Headers("X-API-KEY: ###")
    @GET("metar/krdu/radius/50/decoded")
    Call<MetarDecoded> getMetarsInRadius();

    /**
     * Returns the latest METAR information for a single station nearest to the parameters latitude and longitude.
     *
     * URL Parameter	Description
     * latitude	The decimal latitude	REQUIRED
     * longitude	The decimal longitude	REQUIRED
     * decoded	The response data will include decoded METAR information	OPTIONAL
     *
     * Additional response fields are included in the response data to show the distance and direction
     * from the requested latitude and longitude parameters.
     *
     * @return
     */
    @Headers("X-API-KEY: ###")
    @GET("metar/lat/40.72/lon/-73.99/decoded")
    Call<MetarDecoded> getNearestLatLon();


    /**
     * Returns the latest METAR information for multiple stations within a specified radius
     * of the parameters latitude and longitude.
     *
     * URL Parameter	Description
     * latitude	The decimal latitude	REQUIRED
     * longitude	The decimal longitude	REQUIRED
     * radius	The surrounding radius in miles from the ICAO code. 250 miles is the maximum radius.	REQUIRED
     * decoded	The response data will include decoded METAR information	OPTIONAL
     *
     * @return
     */
    @Headers("X-API-KEY: ###")
    @GET("metar/lat/40.72/lon/-73.99/radius/100/decoded")
    Call<MetarDecoded> getLatLonInRadius();

    /**
     * Returns the latest TAF information for a one or more ICAO codes.
     *
     * URL Parameter	Description
     * icao	A single ICAO code or multiple ICAO codes seperated by commas. Maximum of 20 ICAO codes per request.	REQUIRED
     * decoded	The response data will include decoded TAF information	OPTIONAL
     */
    @Headers("X-API-KEY: ###")
    @GET("taf/kpie/decoded")
    Call<TafDecoded> getTafDecoded();

    /**
     * Returns the latest TAF information for stations within a miles radius of a single ICAO code.
     *
     * The results are sorted based on the distance from the requested ICAO code.
     *
     * Additional response fields are included in the response data to show the distance and direction from the requested ICAO parameter.
     *
     * URL Parameter	Description
     * icao	A single ICAO code or multiple ICAO codes seperated by commas. Maximum of 20 ICAO codes per request.	REQUIRED
     * radius	The surrounding radius in miles from the ICAO code. 100 miles is the maximum radius.	REQUIRED
     * decoded	The response data will include decoded TAF information	OPTIONAL
     *
     */
    @Headers("X-API-KEY: ###")
    @GET("taf/krdu/radius/60/decoded")
    Call<TafDecoded> getTafRadiusDecoded();

    /**
     * Returns the latest TAF information for a single station nearest to the parameters latitude and longitude.
     *
     * Additional response fields are included in the response data to show the distance and direction from the requested latitude and longitude parameters.
     *
     * URL Parameter	Description
     * latitude	The decimal latitude	REQUIRED
     * longitude	The decimal longitude	REQUIRED
     * decoded	The response data will include decoded TAF information	OPTIONAL
     */
    @Headers("X-API-KEY: ###")
    ///@GET("taf/lat/:latitude/lon/:longitude")
    @GET("taf/lat/40.72/lon/-73.99/decoded")
    Call<TafDecoded> getTafLonLatDecoded();

    /**
     * Returns the latest TAF information for multiple stations within a specified radius of the parameters latitude and longitude.
     *
     * Additional response fields are included in the response data to show the distance and direction
     * from the requested latitude and longitude parameters.
     *
     * URL Parameter	Description
     * latitude	The decimal latitude	REQUIRED
     * longitude	The decimal longitude	REQUIRED
     * radius	The surrounding radius in miles from the ICAO code. 250 miles is the maximum radius.	REQUIRED
     * decoded	The response data will include decoded TAF information	OPTIONAL
     */
    @Headers("X-API-KEY: ###")
//    @GET("/taf/lat/:latitude/lon/:longitude/radius/:radius")
    @GET("lat/40.72/lon/-73.99/radius/100/decoded")
    Call<TafDecoded> getTafLonLatRadiusDecoded();
}