package com.malnel.aviationweather;

import android.util.Log;

import com.malnel.aviationweather.model.metar.MetarModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataManager {

    private DataManager() {}

    private static DataManager instance;
    private MetarModel metarModel;
    private Long metarTimestamp;
    private Long maxMetarAge = 900000L;

    public MetarModel getMetarModel() {
        if (null == metarTimestamp || !isCurrent()) {
            requestMetar();
            metarTimestamp = System.currentTimeMillis();
        }
        return metarModel;
    }

    private void requestMetar() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://aviationweather.gov/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MetarApi metarApi = retrofit.create(MetarApi.class);

        Call<MetarModel> call = metarApi.getResponse();
        call.enqueue(new Callback<MetarModel>() {

            @Override
            public void onResponse(Call<MetarModel> call, Response<MetarModel> response) {
                if (!response.isSuccessful()) {
                    Log.i("API response code: ", String.valueOf(response.code()));
                    return;
                }

                MetarModel content = response.body();
                if (null != content && !"0".equals(content.getFeatures())) {
                    metarModel = content;
                }
            }

            @Override
            public void onFailure(Call<MetarModel> call, Throwable t) {
                Log.e("API failure msg: ", t.getMessage());
            }
        });

    }

    private boolean isCurrent() {
        return System.currentTimeMillis() - metarTimestamp < maxMetarAge;
    }

    public void setMetarModel(MetarModel metarModel) {
        this.metarModel = metarModel;
    }

    public static DataManager getInstance() {
        if(instance == null) {
            instance = new DataManager();
        }
        return instance;
    }
}
