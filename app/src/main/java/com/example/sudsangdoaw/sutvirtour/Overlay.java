package com.example.sudsangdoaw.sutvirtour;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
//import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
//import android.os.Bundle;
//import android.util.Log;
import android.view.View;

import com.google.android.gms.location.LocationListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 * Created by Mote'Sarut on 5/1/2559.
 */
public class Overlay extends View implements SensorEventListener, LocationListener {

    public static final String DEBUG_TAG = "OverlayView Log";
    String accelData = "Accelerometer Data";
    String compassData = "Compass Data";
    String gyroData = "Gyro Data";
    //String gpsData = "";
//    String asd = "";
//    String abc = "";
//    String aaa = "";
//    String bbb = "";

    private float[] lastAccelerometer = new float[3];
    private float[] lastCompass =  new float[3];
    private  Location currentLocation;
    //private final float xAngleWidth = 29;
    //private final float yAngleWidth = 19;
    private ArrayList<POI> pois = new ArrayList();
    public float canvasHeight;
    public float canvasWidth;
    //public float direction = 22.4f;
    //public float distanceInMeters;


    // orientation vector
    private float[] orientation = new float[3];
    private float[] cameraRotation = new float[9];

    private Bitmap img;

    public Overlay(Context context) {
        super(context);

        try {

            InputStream is = getResources().openRawResource(R.raw.poi);
            Writer writer = new StringWriter();
            char[] buffer = new char[16384];

            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
            is.close();

            String jsonString = writer.toString();
            JSONObject jsonReader = new JSONObject(jsonString);
            //JSon array มาใส่ใน places
            JSONArray places = jsonReader.getJSONArray("poi");
            //Loop
            for (int i=0; i < places.length(); i++) {
                Location l = new Location("SUTVirtualTour");
                //JSon Object เป็น array ดูตาม Key  แล้วไป Get ค่ามันออกมา เก็บไว้ใน Double ตำแหน่งที่ 0,1,...
                l.setLatitude(places.getJSONObject(i).getJSONArray("location").getDouble(0));
                l.setLongitude(places.getJSONObject(i).getJSONArray("location").getDouble(1));
                POI poi = new POI(places.getJSONObject(i).getString("name"), l);
                poi.setImage(places.getJSONObject(i).getString("img"));
                pois.add(poi);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        SensorManager sensors = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        Sensor accelSensor = sensors.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        Sensor compassSensor = sensors.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        Sensor gyroSensor = sensors.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        boolean isAccelAvailable = sensors.registerListener(this, accelSensor, SensorManager.SENSOR_DELAY_NORMAL);
        boolean isCompassAvailable = sensors.registerListener(this, compassSensor, SensorManager.SENSOR_DELAY_NORMAL);
        boolean isGyroAvailable = sensors.registerListener(this, gyroSensor, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvasHeight = canvas.getHeight();
        canvasWidth = canvas.getWidth();
        super.onDraw(canvas);

        Paint contentPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        contentPaint.setTextAlign(Paint.Align.CENTER);
        contentPaint.setTextSize(30);
        contentPaint.setColor(Color.RED);

        //canvas.drawText(aaa, canvas.getWidth() / 2, canvas.getHeight() / 4, contentPaint);
        //canvas.drawText(asd, canvas.getWidth() / 2, canvas.getHeight() / 5, contentPaint);
        //canvas.drawText(abc, canvas.getWidth() / 2, canvas.getHeight() / 6, contentPaint);
        //canvas.drawText(bbb, canvas.getWidth() / 2, canvas.getHeight() / 7, contentPaint);

        //canvas.rotate((float) (0.0f - Math.toDegrees(orientation[2])));

        //canvas.drawText(accelData, canvas.getWidth()/2, canvas.getHeight()/8, contentPaint);
        //canvas.drawText(compassData, canvas.getWidth()/2, canvas.getHeight()/20, contentPaint);
        //canvas.drawText(gyroData, canvas.getWidth()/2, (canvas.getHeight()*3)/30, contentPaint);

        //canvas.rotate((float)(0.0f- Math.toDegrees(orientation[2])));
        //int i = 0;

        for (POI poi: pois) {
            //ถ้าอยู่บอกจอก็ไม่ต้องวาด
            if (poi.getDistance() <= 200 && (poi.getX() > 0 && poi.getX() < canvasWidth) && (poi.getY() > 0 && poi.getY() < canvasHeight)) {
                //
                //canvas.drawCircle(poi.getX(), poi.getY(), 14f, contentPaint);
                canvas.drawText(poi.getName(), poi.getX(), poi.getY(), contentPaint);
                //สร้าง Bitmap Factory ส่ง วัตถุดิบไป ไม่ต้องรู้ว่าทำงานยังไง Factory Pattern
                img = BitmapFactory.decodeResource(getResources(),getResources().getIdentifier(poi.getImage(), null, "com.suranaree.motesarut.hello"));
                canvas.drawBitmap(img,poi.getX()  - (img.getWidth() / 2), poi.getY() + 24,contentPaint);
                //canvas.drawBitmap(img,poi.getX()  - (img.getWidth() / 2), poi.getY() / 2,contentPaint);

                //canvas.drawText(String.format("%s, %f: %f %f", poi.getName(), poi.getBearing(), poi.getX(), poi.getY()), canvas.getWidth() / 2, 600 + i * 30, contentPaint);
            }
            //i++;
        }
    }

    public void onSensorChanged(SensorEvent event) {
        StringBuilder msg = new StringBuilder(event.sensor.getName()).append(" ");
        for (int i = 0; i < event.values.length; i++) {
            msg.append("[").append(String.format("%.3f", event.values[i])).append("]");
        }
        // compute rotation matrix
        float rotation[] = new float[9];
        float identity[] = new float[9];

        switch (event.sensor.getType()) {
            case Sensor.TYPE_ACCELEROMETER:
                accelData = msg.toString();
                lastAccelerometer = event.values;
                break;
            case Sensor.TYPE_GYROSCOPE:
                gyroData = msg.toString();
                break;
            case Sensor.TYPE_MAGNETIC_FIELD:
                compassData = msg.toString();
                lastCompass = event.values;
                break;
        }

        boolean gotRotation = SensorManager.getRotationMatrix(rotation, identity, lastAccelerometer, lastCompass);

        //
        if (gotRotation) {
             //remap such that the camera is pointing straight down the Y axis
            SensorManager.remapCoordinateSystem(rotation, SensorManager.AXIS_X,
                    SensorManager.AXIS_Z, cameraRotation);
            SensorManager.getOrientation(cameraRotation,orientation);
        }
        //asd = String.format("orientation: %f %f %f", Math.toDegrees(orientation[0]),Math.toDegrees(orientation[1]),Math.toDegrees(orientation[2]));
        this.invalidate();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onLocationChanged(Location location) {
        // Do something when got new current location
        currentLocation = location;
        //asd = String.format("canvasWidth: %f xAngleWidth: %f orientation: %f",canvasWidth, CameraPreview.getHorizontalViewAngle(), Math.toDegrees(orientation[0]));
        //abc  = String.format("canvasHeight: %f yAngleWidth: %f orientation: %f",canvasHeight,CameraPreview.getVerticalViewAngle(),Math.toDegrees(orientation[1]));
        for (POI poi:pois) {
            float bearing = currentLocation.bearingTo(poi.getLocation());
            poi.setBearing(bearing);
            poi.setPosition
                    ((float) ( canvasWidth / 3 + ((canvasWidth / CameraPreview.getHorizontalViewAngle()) * (bearing - Math.toDegrees(orientation[0])))),
                    (float) (canvasHeight / 3 + ((canvasHeight / CameraPreview.getVerticalViewAngle()) * ( - Math.toDegrees(orientation[1])))));

            poi.setDistance(currentLocation.distanceTo(poi.getLocation()));

        }
    }
}
