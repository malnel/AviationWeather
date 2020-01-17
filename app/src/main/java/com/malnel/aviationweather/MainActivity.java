package com.malnel.aviationweather;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.malnel.aviationweather.model.metar.Feature;
import com.malnel.aviationweather.model.metar.MetarModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText airport_txt;
    private Button metar_btn;
    private Button taf_btn;
    private String airport_code;
    public static String airport = "";
    private FusedLocationProviderClient client;
    private GoogleApiClient googleApiClient;
    private MetarModel metar;


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
        metar = DataManager.getInstance().getMetarModel();


        airport_code = airport_txt.getText().toString();
        metar_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != airport_txt.getText()) {
                    assignAirport(airport_txt.getText().toString());
                    Intent intent = new Intent(MainActivity.this, MetarActivity.class);
                    intent.putExtra("ICAO", airport_txt.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }


    private void assignAirport(String s) {
        airport_code = s;
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
