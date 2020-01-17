package com.malnel.aviationweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText airport_txt;
    private Button metar_btn;
    private Button taf_btn;
    private String airport_code;
    public static String airport = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataManager.getInstance().getMetarModel();
        airport_txt = findViewById(R.id.airport_code);
        metar_btn = findViewById(R.id.metar_button);
        taf_btn = findViewById(R.id.taf_button);

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
}
