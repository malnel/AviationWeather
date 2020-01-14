package com.malnel.aviationweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

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

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.checkwx.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherApi weatherApi = retrofit.create(WeatherApi.class);

        Call<Airport> call = weatherApi.getPosts();
        call.enqueue(new Callback<Airport>() {

            @Override
            public void onResponse(Call<Airport> call, Response<Airport> response) {
                if (!response.isSuccessful()) {
                    result.setText("Result:" + response.code());
                    return;
                }

                Airport content = response.body();

                result.setText(content.getData()[0]);
            }

            @Override
            public void onFailure(Call<Airport> call, Throwable t) {
                result.setText(t.getMessage());
            }
        });
    }
}
