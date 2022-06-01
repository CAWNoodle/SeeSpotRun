package com.colossalcrow.seespotrun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent(this, SensorActivity.class);
        startActivity(i);
        /*
        SensorActivity sensorActivity = new SensorActivity();
        sensorActivity.onCreate(savedInstanceState);
        TextView dispView = findViewById(R.id.sensor_data);
        String dispText = getString(R.string.sensor_data_string, sensorActivity.getNumSensors());
        dispView.setText(dispText);
        */
    }

}