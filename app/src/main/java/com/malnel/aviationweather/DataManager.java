package com.malnel.aviationweather;

import android.location.Location;
import android.util.Log;

import com.malnel.aviationweather.model.aviationweathergov.AvWxGovMetars;
import com.malnel.aviationweather.model.avwxrest.station.Station;
import com.malnel.aviationweather.model.avwxrest.taf.Taf;
import com.malnel.aviationweather.model.checkwx.metar.MetarDecoded;
import com.malnel.aviationweather.model.checkwx.taf.TafDecoded;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataManager {

    private DataManager() {}

    private static DataManager instance;
    private AvWxGovMetars avWxGovMetars;
    private Taf taf;
    private Station station;
    public Map<String, MetarDecoded> retrievedMetars = new HashMap<>();
    private TafDecoded tafDecoded;
    private Long metarTimestamp;
    private Long maxMetarAge = 900000L;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    private Location location;


    public AvWxGovMetars getAvWxGovMetars() {
        if (null == metarTimestamp || !isCurrent()) {
            requestMetar();
            metarTimestamp = System.currentTimeMillis();
        }
        return avWxGovMetars;
    }

    public Taf getTaf() {
        requestTaf();
        return taf;
    }

    public Station getStation() {
        requestStation();
        return station;
    }

    public MetarDecoded getMetarDecoded(String icao) {
        return retrievedMetars.get(icao);
    }

    public TafDecoded getTafDecoded() {
        requestTafDecoded();
        return tafDecoded;
    }

    private void requestMetar() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://aviationweather.gov/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherApi weatherApi = retrofit.create(WeatherApi.class);

        Call<AvWxGovMetars> call = weatherApi.getGovMetars();
        call.enqueue(new Callback<AvWxGovMetars>() {

            @Override
            public void onResponse(Call<AvWxGovMetars> call, Response<AvWxGovMetars> response) {
                if (!response.isSuccessful()) {
                    Log.i("API response code: ", String.valueOf(response.code()));
                    return;
                }

                AvWxGovMetars content = response.body();
                if (null != content && !"0".equals(content.getFeatures())) {
                    avWxGovMetars = content;
                }
            }

            @Override
            public void onFailure(Call<AvWxGovMetars> call, Throwable t) {
                Log.e("API failure msg: ", t.getMessage());
            }
        });

    }

    private boolean isCurrent() {
        return System.currentTimeMillis() - metarTimestamp < maxMetarAge;
    }

    public void setAvWxGovMetars(AvWxGovMetars avWxGovMetars) {
        this.avWxGovMetars = avWxGovMetars;
    }

    public static DataManager getInstance() {
        if(instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    private void requestTaf() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://avwx.rest/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherApi weatherApi = retrofit.create(WeatherApi.class);

        Call<Taf> call = weatherApi.getTaf();
        call.enqueue(new Callback<Taf>() {

            @Override
            public void onResponse(Call<Taf> call, Response<Taf> response) {
                if (!response.isSuccessful()) {
                    Log.i("API response code: ", String.valueOf(response.code()));
                    return;
                }

                Taf content = response.body();
                if (null != content && !"0".equals(content.getRaw())) {
                    taf = content;
                }
            }

            @Override
            public void onFailure(Call<Taf> call, Throwable t) {
                Log.e("API failure msg: ", t.getMessage());
            }
        });

    }

    private void requestStation() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://avwx.rest/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherApi weatherApi = retrofit.create(WeatherApi.class);

        Call<Station> call = weatherApi.getStation();
        call.enqueue(new Callback<Station>() {

            @Override
            public void onResponse(Call<Station> call, Response<Station> response) {
                if (!response.isSuccessful()) {
                    Log.i("API response code: ", String.valueOf(response.code()));
                    return;
                }

                Station content = response.body();
                if (null != content && !"0".equals(content.getName())) {
                    station = content;
                }
            }

            @Override
            public void onFailure(Call<Station> call, Throwable t) {
                Log.e("API failure msg: ", t.getMessage());
            }
        });

    }

    public void requestMetarDecoded(String icao) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.checkwx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherApi weatherApi = retrofit.create(WeatherApi.class);

        Call<MetarDecoded> call = weatherApi.getMetarDecoded(icao);
        call.enqueue(new Callback<MetarDecoded>() {

            @Override
            public void onResponse(Call<MetarDecoded> call, Response<MetarDecoded> response) {
                if (!response.isSuccessful()) {
                    Log.i("API response code: ", String.valueOf(response.code()));
                    return;
                }

                MetarDecoded content = response.body();
                if (null != content && !"0".equals(content.getData().get(0).getIcao())) {
                    retrievedMetars.put(icao, content);
                }
            }

            @Override
            public void onFailure(Call<MetarDecoded> call, Throwable t) {
                Log.e("API failure msg: ", t.getMessage());
            }
        });

    }

    private void requestTafDecoded() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.checkwx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherApi weatherApi = retrofit.create(WeatherApi.class);

        Call<TafDecoded> call = weatherApi.getTafDecoded();
        call.enqueue(new Callback<TafDecoded>() {

            @Override
            public void onResponse(Call<TafDecoded> call, Response<TafDecoded> response) {
                if (!response.isSuccessful()) {
                    Log.i("API response code: ", String.valueOf(response.code()));
                    return;
                }

                TafDecoded content = response.body();
                if (null != content && !"0".equals(content.getData().get(0).getIcao())) {
                    tafDecoded = content;
                }
            }

            @Override
            public void onFailure(Call<TafDecoded> call, Throwable t) {
                Log.e("API failure msg: ", t.getMessage());
            }
        });

    }
}
