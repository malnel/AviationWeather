package com.malnel.aviationweather;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.malnel.aviationweather.model.checkwx.metar.MetarDecoded;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_activity);
        Intent intent = getIntent();
        String icao = intent.getStringExtra("ICAO");
        requestMetar(icao);
    }

    private void requestMetar(String icao) {
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
                if (null != content && 0 != content.getData().size()) {
                    DataManager.getInstance().retrievedMetars.put(icao, content);

                    Intent intent = new Intent(LoadingActivity.this, MetarActivity.class);
                    intent.putExtra("ICAO", icao);
                    startActivity(intent);

                } else {

                    Intent intent = new Intent(LoadingActivity.this, FailureActivity.class);
                    intent.putExtra("ICAO", icao);
                    startActivity(intent);
                }

            }


            @Override
            public void onFailure(Call<MetarDecoded> call, Throwable t) {
                Log.e("API failure msg: ", t.getMessage());
            }
        });

    }
}

