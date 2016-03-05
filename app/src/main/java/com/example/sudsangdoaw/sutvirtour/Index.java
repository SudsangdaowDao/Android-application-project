package com.example.sudsangdoaw.sutvirtour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Index extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
    }
    public void sendToMaps(View v){
        Intent i = new Intent(Index.this,MapsActivity.class);
        startActivity(i);
    }
    public void sendToInformation(View v){
        Intent information = new Intent(Index.this,Information.class);
        startActivity(information);
    }
    public void sendToVideoIntro(View v){
        Intent intro = new Intent(Index.this,Intro_Video.class);
        startActivity(intro);
    }
    public void sendToGallery(View v){
        Intent i = new Intent(Index.this,Slide.class);
        startActivity(i);
    }

    public void  SensToCamera(View v){
        Intent i = new Intent(Index.this,Activity_Welcome.class);
        startActivity(i);
    }

}
