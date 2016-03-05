package com.example.sudsangdoaw.sutvirtour;

import android.location.Location;

/**
 * Created by Mote'Sarut on 10/1/2559.
 */
public class POI {
    private  String name;
    private  Location loc;
    private float x = 0f,y = 0f;
    private float distance,bearing;
    private String image;

    //Point of Interest
    public POI(String n, Location l) {
        name = n;
        loc = l;
    }
    public void setPosition(float newX, float newY) {
        x = newX;
        y = newY;
    }
    public void setBearing(float b) {
        bearing = b;
    }
    public float getBearing() {
        return bearing;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setDistance(float d) {
        distance = d;
    }
    public float getDistance() {
        return distance;
    }
    public float getX() {
        return x;
    }
    public float getY() { return y; }
    public Location getLocation() {
        return loc;
    }
    public String getName() {
        return name;
    }
}
