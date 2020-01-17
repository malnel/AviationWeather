package com.malnel.aviationweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.common.api.GoogleApiClient;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.malnel.aviationweather.model.aviationweathergov.AvWxGovMetars;
import com.malnel.aviationweather.model.avwxrest.station.Station;
import com.malnel.aviationweather.model.avwxrest.taf.Taf;
import com.malnel.aviationweather.model.checkwx.metar.MetarDecoded;
import com.malnel.aviationweather.model.checkwx.taf.TafDecoded;

public class MainActivity extends AppCompatActivity {

    private EditText airport_txt;
    private Button metar_btn;
    private Button taf_btn;
    private String icao;
    private FusedLocationProviderClient client;

    public MainActivity() {
    }


    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermission();

        client = LocationServices.getFusedLocationProviderClient(this);
        airport_txt = findViewById(R.id.airport_code);
        metar_btn = findViewById(R.id.metar_button);
        taf_btn = findViewById(R.id.taf_button);

        getLocation();
//        metar = DataManager.getInstance().getAvWxGovMetars();
//        taf = DataManager.getInstance().getTaf();
//        station = DataManager.getInstance().getStation();
//        metarDecoded = DataManager.getInstance().getMetarDecoded();
//        tafDecoded = DataManager.getInstance().getTafDecoded();


        metar_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != airport_txt.getText()) {
                    icao = airport_txt.getText().toString();
                    Intent intent = new Intent(MainActivity.this, MetarActivity.class);
                    intent.putExtra("ICAO", icao);
                    DataManager.getInstance().requestMetarDecoded(icao);
                    startActivity(intent);
                }
            }
        });
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION}, 1);
    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(MainActivity.this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(MainActivity.this, ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        client.getLastLocation().addOnSuccessListener(MainActivity.this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location loc) {
                if (loc != null) {
                    DataManager.getInstance().setLocation(loc);
                }
            }

        });
    }


}
