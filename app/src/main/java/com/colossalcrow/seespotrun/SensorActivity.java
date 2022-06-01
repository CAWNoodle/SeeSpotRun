package com.colossalcrow.seespotrun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class SensorActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager senseMgr;
    private Sensor lightSensor;
    public List<Sensor> sensorList;
    public int numSensors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        senseMgr = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorList = senseMgr.getSensorList(Sensor.TYPE_ALL);
        numSensors = sensorList.size();
        lightSensor = senseMgr.getDefaultSensor(Sensor.TYPE_LIGHT);

        TextView dispView = findViewById(R.id.sensor_data);
        String dispText = getString(R.string.sensor_data_string, numSensors);
        dispView.setText(dispText);
    }

    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy){

    }

    @Override
    public final void onSensorChanged(SensorEvent event){

    }

    @Override
    protected void onResume(){
        super.onResume();
        senseMgr.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause(){
        super.onPause();
        senseMgr.unregisterListener(this);
    }

    public int getNumSensors(){
        return this.numSensors;
    }
}