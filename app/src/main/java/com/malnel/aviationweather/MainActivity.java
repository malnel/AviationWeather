package com.malnel.aviationweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.malnel.aviationweather.model.Metar.MetarModel;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.clouds_result);

//        checkMetar();
        checkMetarDecoded();
    }

    private void checkMetar() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.checkwx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MetarApi metarApi = retrofit.create(MetarApi.class);

        Call<Metar> call = metarApi.getResponse();
        call.enqueue(new Callback<Metar>() {

            @Override
            public void onResponse(Call<Metar> call, Response<Metar> response) {
                if (!response.isSuccessful()) {
                    result.setText("Result:" + response.code());
                    return;
                }

                Metar content = response.body();
                if (null != content && !"0".equals(content.getResults())) {
                    result.setText(content.getData()[0]);
                }
            }

            @Override
            public void onFailure(Call<Metar> call, Throwable t) {
                result.setText(t.getMessage());
            }
        });
    }

    private void checkMetarDecoded() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.checkwx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MetarDecodedApi metarDecodedApi = retrofit.create(MetarDecodedApi.class);

        Call<MetarModel> call = metarDecodedApi.getResponse();
        call.enqueue(new Callback<MetarModel>() {

            @Override
            public void onResponse(Call<MetarModel> call, Response<MetarModel> response) {
                if (!response.isSuccessful()) {
                    result.setText("Result:" + response.code());
                    return;
                }

                MetarModel content = response.body();
                if (null != content && !"0".equals(content.getResults())) {
                    content.getData();
                }
            }

            @Override
            public void onFailure(Call<MetarModel> call, Throwable t) {
                result.setText(t.getMessage());
            }
        });
    }
}
