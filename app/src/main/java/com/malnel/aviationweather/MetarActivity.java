package com.malnel.aviationweather;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.malnel.aviationweather.model.Metar.MetarModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MetarActivity extends AppCompatActivity {

    TextView rawMetarTxt;
    private String airport;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.metar_activity);
        Intent intent = getIntent();
        airport = intent.getStringExtra("ICAO");
        rawMetarTxt = findViewById(R.id.raw_metar_txt);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.checkwx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MetarApi metarApi = retrofit.create(MetarApi.class);

        Call<MetarModel> call = metarApi.getResponse(airport);
        call.enqueue(new Callback<MetarModel>() {

            @Override
            public void onResponse(Call<MetarModel> call, Response<MetarModel> response) {
                if (!response.isSuccessful()) {
                    Log.i("API response code: ", String.valueOf(response.code()));
                    return;
                }

                MetarModel content = response.body();
                if (null != content && !"0".equals(content.getResults())) {
                    String rawMetar = content.getData().get(0).getRawText();
                    rawMetarTxt.setText(rawMetar);
                }
            }

            @Override
            public void onFailure(Call<MetarModel> call, Throwable t) {
                Log.e("API failure msg: ", t.getMessage());
            }
        });

    }
}
