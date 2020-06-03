package com.malnel.aviationweather;

import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.malnel.aviationweather.model.aviationweathergov.Feature;
import com.malnel.aviationweather.model.aviationweathergov.AvWxGovMetars;
import com.malnel.aviationweather.model.checkwx.metar.Cloud;
import com.malnel.aviationweather.model.checkwx.metar.Datum;
import com.malnel.aviationweather.model.checkwx.metar.MetarDecoded;

import java.util.List;


public class MetarActivity extends AppCompatActivity {

    private TextView rawMetarTxt;
    private String icao;
    private MetarDecoded metarDecoded;
    private TableLayout table;
    private TextView flightCategoryInfo;
    private TextView stationInfo;
    private TextView windInfo;
    private TextView visibilityInfo;
    private TextView cloudsInfo;
    private TextView temperatureInfo;
    private TextView dewpointInfo;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.metar_activity);

        Intent intent = getIntent();
        icao = intent.getStringExtra("ICAO");
        rawMetarTxt = findViewById(R.id.raw_metar_txt);
        table = findViewById(R.id.table_layout);
        table.setVisibility(View.INVISIBLE);
        Switch decodeBtn = (Switch) findViewById(R.id.decode_btn);
        decodeBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    rawMetarTxt.setVisibility(View.INVISIBLE);
                    table.setVisibility(View.VISIBLE);
                } else {
                    rawMetarTxt.setVisibility(View.VISIBLE);
                    table.setVisibility(View.INVISIBLE);
                }
            }
        });

        //this should be displayed if the other thread is done
        final Datum datum = DataManager.getInstance().getMetarDecoded(icao).getData().get(0);
        String rawMetar = datum.getRawText();
        rawMetarTxt.setText(rawMetar);

        fillDecodedInfo(datum);

    }

    private void fillDecodedInfo(Datum datum) {
        String flightCategory = datum.getFlightCategory();
        flightCategoryInfo = findViewById(R.id.flt_category_txt);
        flightCategoryInfo.setText(flightCategory);
        int color = 0;
        switch(flightCategory) {
            case "VFR":
                color = Color.GREEN;
                break;
            case "MVFR":
                color = Color.YELLOW;
                break;
            case "IFR":
                color = Color.RED;
                break;
        }
        flightCategoryInfo.setTextColor(color);

        String station = datum.getStation().getName();
        stationInfo = findViewById(R.id.station_name_txt);
        stationInfo.setText(station);

        String wind = datum.getWind().getSpeedKts() + " knots at " + datum.getWind().getDegrees() + " degrees";
        windInfo = findViewById(R.id.wind_info_txt);
        windInfo.setText(wind);

        StringBuilder visibilitySb = new StringBuilder();
        if (null != datum.getVisibility().getMiles()) {
            visibilitySb.append(datum.getVisibility().getMiles() + " miles");
        }
        if (null != datum.getVisibility().getMeters()) {
            visibilitySb.append(datum.getVisibility().getMeters() + " meters");
        }
        visibilityInfo = findViewById(R.id.visibility_info_txt);
        visibilityInfo.setText(visibilitySb.toString());

        List<Cloud> clouds = datum.getClouds();
        StringBuilder cloudsSb = new StringBuilder("");
        for (Cloud cloud : clouds) {
            cloudsSb.append(cloud.getText() + " at " + cloud.getBaseFeetAgl() + " ft\n");
        }
        cloudsInfo = findViewById(R.id.clouds_info_txt);
        cloudsInfo.setText(cloudsSb.toString());

        String temperature = datum.getTemperature().getCelsius() + " C";
        temperatureInfo = findViewById(R.id.temperature_info_txt);
        temperatureInfo.setText(temperature);

        String dewpoint = datum.getDewpoint().getCelsius() + " C";
        dewpointInfo = findViewById(R.id.dewpoint_info_txt);
        dewpointInfo.setText(dewpoint);

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
