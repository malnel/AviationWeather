package com.malnel.aviationweather;

import android.content.Intent;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.malnel.aviationweather.model.aviationweathergov.Feature;
import com.malnel.aviationweather.model.aviationweathergov.AvWxGovMetars;
import com.malnel.aviationweather.model.checkwx.metar.Datum;
import com.malnel.aviationweather.model.checkwx.metar.MetarDecoded;

import java.util.List;


public class MetarActivity extends AppCompatActivity {

    private TextView rawMetarTxt;
    private TextView decodedTxt;
    private String icao;
    private MetarDecoded metarDecoded;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.metar_activity);

        Intent intent = getIntent();
        icao = intent.getStringExtra("ICAO");
        rawMetarTxt = findViewById(R.id.raw_metar_txt);
        decodedTxt = findViewById(R.id.decoded_txt);
        decodedTxt.setVisibility(View.INVISIBLE);
        Switch decodeBtn = (Switch) findViewById(R.id.decode_btn);
        decodeBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    rawMetarTxt.setVisibility(View.INVISIBLE);
                    decodedTxt.setVisibility(View.VISIBLE);
                } else {
                    rawMetarTxt.setVisibility(View.VISIBLE);
                    decodedTxt.setVisibility(View.INVISIBLE);
                }
            }
        });

        //this should be displayed if the other thread is done
        final Datum datum = DataManager.getInstance().getMetarDecoded(icao).getData().get(0);
        String rawMetar = datum.getRawText();
        rawMetarTxt.setText(rawMetar);

        StringBuilder sb = new StringBuilder();
        sb.append("Wind: " + datum.getWind().getSpeedKts() + " knots at " + datum.getWind().getDegrees() + " degrees");
        decodedTxt.setText(sb.toString());

    }


    private void displayNearbyAirports(AvWxGovMetars avWxGovMetars, Location location) {
        List<Feature> airports = avWxGovMetars.getFeatures();
        StringBuilder sb = new StringBuilder();

        for (Feature feature : airports) {
            List<Double> coordinates = feature.getGeometry().getCoordinates();
            double latitude = coordinates.get(0);
            double longitude = coordinates.get(1);
            Location airportLocation = new Location("airport");
            airportLocation.setLatitude(latitude);
            airportLocation.setLongitude(longitude);

            if (isNearby(location, airportLocation)) {
                String ICAO = feature.getProperties().getId();
                sb.append(ICAO);
            }
        }

        if (null == sb || ("").equals(sb)) {
            sb.append("No nearby airports found");
        }
        rawMetarTxt.setText(sb);
    }

    private boolean isNearby(Location loc1, Location loc2) {
        //true if within 10000km
        return loc1.distanceTo(loc2) < 10000000;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }


}
