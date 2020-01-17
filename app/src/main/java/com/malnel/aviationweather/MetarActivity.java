package com.malnel.aviationweather;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class MetarActivity extends AppCompatActivity {

    private TextView rawMetarTxt;
    private TextView decodedTxt;
    private String airport;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.metar_activity);

        Intent intent = getIntent();
        airport = intent.getStringExtra("ICAO");
        rawMetarTxt = findViewById(R.id.raw_metar_txt);
        decodedTxt = findViewById(R.id.decoded_txt);

        String lol = DataManager.getInstance().getMetarModel().getFeatures().get(0).getProperties().getId();
        rawMetarTxt.setText(lol);

    }

}
