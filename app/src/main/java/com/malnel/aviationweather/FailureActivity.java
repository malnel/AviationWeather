package com.malnel.aviationweather;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FailureActivity extends AppCompatActivity {

    private TextView failureMsgTxt;
    private String icao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.failure_activity);
        Intent intent = getIntent();
        icao = intent.getStringExtra("ICAO");
        initializeMsg();
    }

    private void initializeMsg() {
        failureMsgTxt = findViewById(R.id.failure_msg_txt);
        failureMsgTxt.setText("Sorry! No METAR was found for " + icao.toUpperCase() + ". Try another airport code.");
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
