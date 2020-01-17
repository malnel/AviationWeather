package com.malnel.aviationweather;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.malnel.aviationweather.model.metar.Feature;
import com.malnel.aviationweather.model.metar.MetarModel;

import java.util.List;


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

        displayNearbyAirports(DataManager.getInstance().getMetarModel(), DataManager.getInstance().getLocation());

    }


    private void displayNearbyAirports(MetarModel metarModel, Location location) {
        List<Feature> airports = metarModel.getFeatures();
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

}
