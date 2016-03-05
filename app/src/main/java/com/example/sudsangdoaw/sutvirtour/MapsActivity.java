package com.example.sudsangdoaw.sutvirtour;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationListener;
import android.media.Image;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapsActivity extends FragmentActivity
        implements  OnMapReadyCallback {

    private GoogleMap mMap;

    private static final LatLng SUT = new LatLng(14.905725, 102.059816);
    private static final LatLng Library = new LatLng(14.878467, 102.015717);
    private static final LatLng Study_Building_one = new LatLng(14.880906, 102.016844);
    private static final LatLng Study_Building_two = new LatLng(14.882140, 102.014569);
    private static final LatLng Surareangchai = new LatLng(14.885800, 102.017594);
    private static final LatLng Kitjakarn = new LatLng(14.884508, 102.015368);
    private static final LatLng Sport_Center = new LatLng(14.886609, 102.014998);
    private static final LatLng F_1 = new LatLng(14.878028, 102.017110);
    private static final LatLng F_2 = new LatLng(14.877012, 102.017818);
    private static final LatLng F_3 = new LatLng(14.876145, 102.018291);
    private static final LatLng F_4 = new LatLng(14.877099, 102.015856);
    private static final LatLng F_5 = new LatLng(14.876238, 102.016510);
    private static final LatLng F_6 = new LatLng(14.875367, 102.017143);
    private static final LatLng Vichakarn_1 = new LatLng(14.878680, 102.018285);
    private static final LatLng Com_Center = new LatLng(14.877631, 102.019179);
    private static final LatLng Canteen = new LatLng(14.876655, 102.019747);
    private static final LatLng Vicharkarn_2 = new LatLng(14.879502, 102.019552);
    private static final LatLng Building_A = new LatLng(14.880239, 102.020647);
    private static final LatLng Yamo = new LatLng(14.880413, 102.018334);
    private static final LatLng Flag = new LatLng(14.881799, 102.020468);
    private static final LatLng Transport = new LatLng(14.876931, 102.021304);
    private static final LatLng Surapat_1 = new LatLng(14.876385, 102.022223);
    private static final LatLng Surapat_2 = new LatLng(14.874367, 102.024028);
    private static final LatLng Hotel = new LatLng(14.876963, 102.025626);
    private static final LatLng Sinchroton = new LatLng(14.873192, 102.021539);
    private static final LatLng F_7 = new LatLng(14.874684, 102.021248);
    private static final LatLng Butterfly = new LatLng(14.870645, 102.022535);
    private static final LatLng Star = new LatLng(14.874173, 102.028136);
    private static final LatLng Suranapa = new LatLng(14.872817, 102.023566);
    private static final LatLng Amphi = new LatLng(14.871944, 102.024413);
    private static final LatLng Hospital = new LatLng(14.864102, 102.036022);
    private static final LatLng Farm = new LatLng(14.889837, 102.004907);
    private static final LatLng MUSEUM = new LatLng(14.871135, 102.023325);
    private static final LatLng KARNJANAPISAk = new LatLng(14.873188, 102.026194);
    private static final LatLng Trafic = new LatLng(14.872414, 102.020959);


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_maps);


        Spinner s = (Spinner) findViewById(R.id.spin);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            String label = parent.getItemAtPosition(position).toString();
                if(label.equals("ฟาร์มมหาวิทยาลัย")){
                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(Farm, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                    Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();

                }
                if (label.equals("อาคารกีฬา")){
                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(Sport_Center, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                    Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();

                }
                if(label.equals("อาคารสุรเริงไชย")){
                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(Surareangchai, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                    Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();

                }
                if(label.equals("อาคารกิจการนักศึกษา")){
                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(Kitjakarn, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                    Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();

                }
                if(label.equals("อาคารเรียนรวม 1")){
                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(Study_Building_one, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                    Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();

                }
                if(label.equals("อาคารเรียนรวม 2")){
                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(Study_Building_two, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                    Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();

                }
                if(label.equals("อาคารบรรณสาร")){
                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(Library, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                    Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();
                }
                if(label.equals("ลานสัญลักษณ์")){
                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(Yamo, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                    Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();

                }
                if(label.equals("เสาธง")){
                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(Flag, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                    Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();
                }
                if(label.equals("อาคารเครื่องมือ 1")){
                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(F_1, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                    Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();
                }
                if(label.equals("อาคารเครื่องมือ 2")){

                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(F_2, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                    Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();

                }
                if(label.equals("อาคารเครื่องมือ 3")){
                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(F_3, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                    Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();
                }
                if(label.equals("อาคารเครื่องมือ 4")){
                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(F_4, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                    Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();
                }
                if(label.equals("อาคารเครื่องมือ 5")){
                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(F_5, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                    Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();
                }
                if(label.equals("อาคารเครื่องมือ 6")){
                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(F_6, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                    Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();
                }
                if(label.equals("อาคารเครื่องมือ 7")){
                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(F_7, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                    Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();
                }
                if(label.equals("อาคารวิชาการ 1")){
                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(Vichakarn_1, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                    Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();
                }
                if(label.equals("อาคารวิชาการ 2")){
                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(Vicharkarn_2, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                    Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();
                }
                if(label.equals("อาคารบริหาร")){
                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(Building_A, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                    Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();
                }
                if(label.equals("ศูนย์คอมพิวเตอร์")){
                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(Com_Center, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                    Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();
                }
                if(label.equals("โรงอาหารกลาง")){
                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(Canteen, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                    Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();
                }
                if(label.equals("อาคารขนส่ง")){
                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(Transport, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                    Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();
                }
                if(label.equals("อาคารสุรพัฒน์ 1")){
                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(Surapat_1, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                    Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();
                }
                if(label.equals("อาคารสุรพัฒน์ 2")){
                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(Surapat_2, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                    Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();
                }
                if (label.equals("โรงแรมสุรสัมนาคาร")){
                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(Hotel, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                    Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();
                }
                if (label.equals("เมืองจราจรจำลอง")){
                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(Trafic, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                    Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();
                }
                if(label.equals("สถาบันวิยเเสงซินโครตอน")){
                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(Sinchroton, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                    Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();
                }
                if(label.equals("หอสุรนภา")){
                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(Suranapa, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                    Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();
                }
                if (label.equals("พิพิธภัณฑ์เทคโนโลยีไทยโบราณ")){
                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(MUSEUM, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                    Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();
                }
                if (label.equals("อุทยานผีเสื้อ")){
                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(Butterfly, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                    Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();
                }
                if (label.equals("แอมฟิเทียร์เตอร์")){
                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(Amphi, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                    Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();
                }
                if (label.equals("อาคารกาญจนาภิเษก")){
                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(KARNJANAPISAk, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                    Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();
                }
                if (label.equals("หอดูดาว")){
                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(Star, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                    Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();
                }
                if(label.equals("โรงพยาบาลมหาวิทยาลัย")){
                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(Hospital, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
                    Toast.makeText(parent.getContext(), "You selected: " + label,Toast.LENGTH_LONG).show();
                }
                if(label.equals(" ")){
                    mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(Study_Building_two, 5)));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        final ImageButton mainButton = (ImageButton) findViewById(R.id.imageButton1);
        mainButton.setVisibility(View.INVISIBLE); //f1

        final  ImageButton imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton2.setVisibility(View.INVISIBLE); //f2

        final ImageButton imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        imageButton3.setVisibility(View.INVISIBLE); //f3

        final ImageButton imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        imageButton4.setVisibility(View.INVISIBLE);

        final ImageButton imageButton5 = (ImageButton) findViewById(R.id.imageButton5);
        imageButton5.setVisibility(View.INVISIBLE);

        final ImageButton imageButton6 = (ImageButton) findViewById(R.id.imageButton6);
        imageButton6.setVisibility(View.INVISIBLE);

        final ImageButton imageButton7 = (ImageButton) findViewById(R.id.imageButton7);
        imageButton7.setVisibility(View.INVISIBLE);

        final ImageButton imageButton8 = (ImageButton) findViewById(R.id.imageButton8);
        imageButton8.setVisibility(View.INVISIBLE);

        final ImageButton imageButton9 = (ImageButton) findViewById(R.id.imageButton9);
        imageButton9.setVisibility(View.INVISIBLE);

        final ImageButton imageButton10 = (ImageButton) findViewById(R.id.imageButton10);
        imageButton10.setVisibility(View.INVISIBLE);

        final ImageButton imageButton11 = (ImageButton) findViewById(R.id.imageButton11);
        imageButton11.setVisibility(View.INVISIBLE);

        final ImageButton imageButton12 = (ImageButton) findViewById(R.id.imageButton12);
        imageButton12.setVisibility(View.INVISIBLE);

        final ImageButton imageButton13 = (ImageButton) findViewById(R.id.imageButton13);
        imageButton13.setVisibility(View.INVISIBLE);

        final ImageButton imageButton14 = (ImageButton) findViewById(R.id.imageButton14);
        imageButton14.setVisibility(View.INVISIBLE);

        final ImageButton imageButton15 = (ImageButton) findViewById(R.id.imageButton15);
        imageButton15.setVisibility(View.INVISIBLE);

        final ImageButton imageButton16 = (ImageButton) findViewById(R.id.imageButton16);
        imageButton16.setVisibility(View.INVISIBLE);

        final ImageButton imageButton17 = (ImageButton) findViewById(R.id.imageButton17);
        imageButton17.setVisibility(View.INVISIBLE);

        final ImageButton imageButton18 = (ImageButton) findViewById(R.id.imageButton18);
        imageButton18.setVisibility(View.INVISIBLE);

        final ImageButton imageButton19 = (ImageButton) findViewById(R.id.imageButton19);
        imageButton19.setVisibility(View.INVISIBLE);

        final ImageButton imageButton20 = (ImageButton) findViewById(R.id.imageButton20);
        imageButton20.setVisibility(View.INVISIBLE);

        final ImageButton imageButton21 = (ImageButton) findViewById(R.id.imageButton21);
        imageButton21.setVisibility(View.INVISIBLE);

        final ImageButton imageButton22 = (ImageButton) findViewById(R.id.imageButton22);
        imageButton22.setVisibility(View.INVISIBLE);
        final ImageButton imageButton23 = (ImageButton) findViewById(R.id.imageButton23);
        imageButton23.setVisibility(View.INVISIBLE);

        final ImageButton imageButton24 = (ImageButton) findViewById(R.id.imageButton24);
        imageButton24.setVisibility(View.INVISIBLE);

        final ImageButton imageButton25 = (ImageButton) findViewById(R.id.imageButton25);
        imageButton25.setVisibility(View.INVISIBLE);

        final ImageButton imageButton26 = (ImageButton) findViewById(R.id.imageButton26);
        imageButton16.setVisibility(View.INVISIBLE);

        final ImageButton imageButton27 = (ImageButton) findViewById(R.id.imageButton27);
        imageButton27.setVisibility(View.INVISIBLE);

        final ImageButton imageButton28 = (ImageButton) findViewById(R.id.imageButton28);
        imageButton28.setVisibility(View.INVISIBLE);

        final ImageButton imageButton29 = (ImageButton) findViewById(R.id.imageButton29);
        imageButton29.setVisibility(View.INVISIBLE);

        final ImageButton imageButton30 = (ImageButton) findViewById(R.id.imageButton30);
        imageButton30.setVisibility(View.INVISIBLE);

        final ImageButton imageButton31 = (ImageButton) findViewById(R.id.imageButton31);
        imageButton31.setVisibility(View.INVISIBLE);

        final ImageButton imageButton32 = (ImageButton) findViewById(R.id.imageButton32);
        imageButton32.setVisibility(View.INVISIBLE);

        final ImageButton imageButton33 = (ImageButton) findViewById(R.id.imageButton33);
        imageButton33.setVisibility(View.INVISIBLE);

        final ImageButton imageButton34 = (ImageButton) findViewById(R.id.imageButton34);
        imageButton34.setVisibility(View.INVISIBLE);


        mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();


        if (mMap != null) {

            mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(Study_Building_one, 5)));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(16), 2000, null);

            mMap.setInfoWindowAdapter(new BalloonAdapter(getLayoutInflater()));
         final  Marker m = mMap.addMarker(new MarkerOptions().position(F_1).title("อาคารเครื่องมือ 1")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
//            m.showInfoWindow();
          final Marker m2 =  mMap.addMarker(new MarkerOptions().position(F_2).title("อาคารเครื่องมือ 2")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
            final Marker m3 = mMap.addMarker(new MarkerOptions().position(F_3).title("อาคารเครื่องมือ 3")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
            final Marker m4 = mMap.addMarker(new MarkerOptions().position(F_4).title("อาคารเครื่องมือ 4")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
            final Marker m5 = mMap.addMarker(new MarkerOptions().position(F_5).title("อาคารเครื่องมือ 5")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
            final Marker m6 = mMap.addMarker(new MarkerOptions().position(F_6).title("อาคารเครื่องมือ 6")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
            final Marker lib = mMap.addMarker(new MarkerOptions().position(Library).title("อาคารบรรณสาร")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
            final Marker activity = mMap.addMarker(new MarkerOptions().position(Kitjakarn).title("อาคารกิจการนักศึกษา")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
            final Marker b1 = mMap.addMarker(new MarkerOptions().position(Study_Building_one).title("อาคารเรียนรวม 1")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
            final Marker b2 = mMap.addMarker(new MarkerOptions().position(Study_Building_two).title("อาคารเรียนรวม 2")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
            final Marker surareang = mMap.addMarker(new MarkerOptions().position(Surareangchai).title("อาคารสุรเริงไชย")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
            final Marker sportCenter = mMap.addMarker(new MarkerOptions().position(Sport_Center).title("อาคารกีฬา")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
            final Marker farm = mMap.addMarker(new MarkerOptions().position(Farm).title("ฟาร์มหาวิทยาลัย")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
            final Marker vichakarn = mMap.addMarker(new MarkerOptions().position(Vichakarn_1).title("อาคารวิชาการ 1")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
            final Marker vicharkarn2 = mMap.addMarker(new MarkerOptions().position(Vicharkarn_2).title("อาคารวิชาการ 2")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
            final Marker a = mMap.addMarker(new MarkerOptions().position(Building_A).title("อาคารบริหาร")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
            final Marker com_cen = mMap.addMarker(new MarkerOptions().position(Com_Center).title("ศูนย์คอมพิวเตอร์")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
            final Marker CANTEEN = mMap.addMarker(new MarkerOptions().position(Canteen).title("โรงอาหารกลาง")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
            final Marker SURAPAT_1 = mMap.addMarker(new MarkerOptions().position(Surapat_1).title("อาคารสุรพัฒน์ 1 ")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
            final Marker SURAPAT_2 =mMap.addMarker(new MarkerOptions().position(Surapat_2).title("อาคารสุรพัฒน์ 2")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
            final Marker SURANAPA = mMap.addMarker(new MarkerOptions().position(Suranapa).title("หอสุรนภา")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
            final Marker F_7_Building = mMap.addMarker(new MarkerOptions().position(F_7).title("อาคารเครื่องมือ 7")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
            final Marker BUTTERFLY = mMap.addMarker(new MarkerOptions().position(Butterfly).title("อุทยานผีเสื้อ")
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
            final Marker museum = mMap.addMarker(new MarkerOptions().position(MUSEUM).title("พิพิธภัณฑ์เทคโนโลยีไทยโบราณ")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
            final Marker FLAG = mMap.addMarker(new MarkerOptions().position(Flag).title("เสาธง")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
            final Marker YAMO = mMap.addMarker(new MarkerOptions().position(Yamo).title("ลานสัญลักษณ์")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
            final Marker AMPHI = mMap.addMarker(new MarkerOptions().position(Amphi).title("แอมฟิเทียร์เตอร์")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
            final Marker KARN = mMap.addMarker(new MarkerOptions().position(KARNJANAPISAk).title("อาคารกาจณาภิเษก")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
            final Marker STAR = mMap.addMarker(new MarkerOptions().position(Star).title("หอดูดาว")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
            final Marker HOSPITAL = mMap.addMarker(new MarkerOptions().position(Hospital).title("โรงพยาบาลมหาวิทยาลัยเทคโนโลยีสุรนารี")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
            final Marker HOTEL = mMap.addMarker(new MarkerOptions().position(Hotel).title("ฌรงแรมสุรสัมนาคาร")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
            final Marker TRANSPORT = mMap.addMarker(new MarkerOptions().position(Transport).title("อาคารขนส่ง")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
            final Marker SINCROTON = mMap.addMarker(new MarkerOptions().position(Sinchroton).title("สถาบันวิจัยเเสงซินโครตอน")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
            final Marker TRAFIC = mMap.addMarker(new MarkerOptions().position(Trafic).title("เมืองจราจรจำลอง")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
            mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng latLng) {
                    mainButton.setVisibility(View.INVISIBLE);  //f1
                    imageButton2.setVisibility(View.INVISIBLE); // 2
                    imageButton3.setVisibility(View.INVISIBLE);  //3
                    imageButton4.setVisibility(View.INVISIBLE); //4
                    imageButton5.setVisibility(View.INVISIBLE); //5
                    imageButton6.setVisibility(View.INVISIBLE); //6
                    imageButton7.setVisibility(View.INVISIBLE);  // library
                    imageButton8.setVisibility(View.INVISIBLE); //kitjakarn -- activity
                    imageButton9.setVisibility(View.INVISIBLE); // building 1
                    imageButton10.setVisibility(View.INVISIBLE);  //
                    imageButton11.setVisibility(View.INVISIBLE);
                    imageButton12.setVisibility(View.INVISIBLE);
                    imageButton13.setVisibility(View.INVISIBLE);
                    imageButton14.setVisibility(View.INVISIBLE);
                    imageButton15.setVisibility(View.INVISIBLE);
                    imageButton16.setVisibility(View.INVISIBLE);
                    imageButton17.setVisibility(View.INVISIBLE);
                    imageButton18.setVisibility(View.INVISIBLE);
                    imageButton19.setVisibility(View.INVISIBLE);
                    imageButton20.setVisibility(View.INVISIBLE);
                    imageButton21.setVisibility(View.INVISIBLE);
                    imageButton22.setVisibility(View.INVISIBLE);
                    imageButton23.setVisibility(View.INVISIBLE);
                    imageButton24.setVisibility(View.INVISIBLE);
                    imageButton25.setVisibility(View.INVISIBLE);
                    imageButton26.setVisibility(View.INVISIBLE);
                    imageButton27.setVisibility(View.INVISIBLE);
                    imageButton28.setVisibility(View.INVISIBLE);
                    imageButton29.setVisibility(View.INVISIBLE);
                    imageButton30.setVisibility(View.INVISIBLE);
                    imageButton31.setVisibility(View.INVISIBLE);
                    imageButton32.setVisibility(View.INVISIBLE);
                    imageButton33.setVisibility(View.INVISIBLE);
                    imageButton34.setVisibility(View.INVISIBLE);


                }
            });
            mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker) {

                    if (marker.equals(m)) {   //f1
                        mainButton.setVisibility(View.VISIBLE);
                        imageButton2.setVisibility(View.INVISIBLE);
                        imageButton3.setVisibility(View.INVISIBLE);
                        imageButton4.setVisibility(View.INVISIBLE);
                        imageButton5.setVisibility(View.INVISIBLE);
                        imageButton6.setVisibility(View.INVISIBLE);
                        imageButton7.setVisibility(View.INVISIBLE);
                        imageButton8.setVisibility(View.INVISIBLE);
                        imageButton9.setVisibility(View.INVISIBLE);
                        imageButton10.setVisibility(View.INVISIBLE);
                        imageButton11.setVisibility(View.INVISIBLE);
                        imageButton12.setVisibility(View.INVISIBLE);
                        imageButton13.setVisibility(View.INVISIBLE);
                        imageButton14.setVisibility(View.INVISIBLE);
                        imageButton15.setVisibility(View.INVISIBLE);
                        imageButton16.setVisibility(View.INVISIBLE);
                        imageButton17.setVisibility(View.INVISIBLE);
                        imageButton18.setVisibility(View.INVISIBLE);
                        imageButton19.setVisibility(View.INVISIBLE);
                        imageButton20.setVisibility(View.INVISIBLE);
                        imageButton21.setVisibility(View.INVISIBLE);
                        imageButton22.setVisibility(View.INVISIBLE);
                        imageButton23.setVisibility(View.INVISIBLE);
                        imageButton24.setVisibility(View.INVISIBLE);
                        imageButton25.setVisibility(View.INVISIBLE);
                        imageButton26.setVisibility(View.INVISIBLE);
                        imageButton27.setVisibility(View.INVISIBLE);
                        imageButton28.setVisibility(View.INVISIBLE);
                        imageButton29.setVisibility(View.INVISIBLE);
                        imageButton30.setVisibility(View.INVISIBLE);
                        imageButton31.setVisibility(View.INVISIBLE);
                        imageButton32.setVisibility(View.INVISIBLE);
                        imageButton33.setVisibility(View.INVISIBLE);
                        imageButton34.setVisibility(View.INVISIBLE);





                        Toast.makeText(MapsActivity.this, "Click button to open video F1",
                                Toast.LENGTH_LONG).show();

                        m.showInfoWindow();

                    }
                    if (marker.equals(m2)){

                        imageButton2.setVisibility(View.VISIBLE);
                        imageButton3.setVisibility(View.INVISIBLE);
                        mainButton.setVisibility(View.INVISIBLE);
                        imageButton4.setVisibility(View.INVISIBLE);
                        imageButton5.setVisibility(View.INVISIBLE);
                        imageButton6.setVisibility(View.INVISIBLE);
                        imageButton7.setVisibility(View.INVISIBLE);
                        imageButton8.setVisibility(View.INVISIBLE);
                        imageButton9.setVisibility(View.INVISIBLE);
                        imageButton10.setVisibility(View.INVISIBLE);
                        imageButton11.setVisibility(View.INVISIBLE);
                        imageButton12.setVisibility(View.INVISIBLE);
                        imageButton13.setVisibility(View.INVISIBLE);
                        imageButton14.setVisibility(View.INVISIBLE);
                        imageButton15.setVisibility(View.INVISIBLE);
                        imageButton16.setVisibility(View.INVISIBLE);
                        imageButton17.setVisibility(View.INVISIBLE);
                        imageButton18.setVisibility(View.INVISIBLE);
                        imageButton19.setVisibility(View.INVISIBLE);
                        imageButton20.setVisibility(View.INVISIBLE);
                        imageButton21.setVisibility(View.INVISIBLE);
                        imageButton22.setVisibility(View.INVISIBLE);
                        imageButton23.setVisibility(View.INVISIBLE);
                        imageButton24.setVisibility(View.INVISIBLE);
                        imageButton25.setVisibility(View.INVISIBLE);
                        imageButton26.setVisibility(View.INVISIBLE);
                        imageButton27.setVisibility(View.INVISIBLE);
                        imageButton28.setVisibility(View.INVISIBLE);
                        imageButton29.setVisibility(View.INVISIBLE);
                        imageButton30.setVisibility(View.INVISIBLE);
                        imageButton31.setVisibility(View.INVISIBLE);
                        imageButton32.setVisibility(View.INVISIBLE);
                        imageButton33.setVisibility(View.INVISIBLE);
                        imageButton34.setVisibility(View.INVISIBLE);



                        m2.showInfoWindow();
                        Toast.makeText(MapsActivity.this, "Click button to open video F2",
                                Toast.LENGTH_LONG).show();

                    }
                    if(marker.equals(m3)){
                        imageButton3.setVisibility(View.VISIBLE);
                        mainButton.setVisibility(View.INVISIBLE);
                        imageButton2.setVisibility(View.INVISIBLE);
                        imageButton4.setVisibility(View.INVISIBLE);
                        imageButton5.setVisibility(View.INVISIBLE);
                        imageButton6.setVisibility(View.INVISIBLE);
                        imageButton7.setVisibility(View.INVISIBLE);
                        imageButton8.setVisibility(View.INVISIBLE);
                        imageButton9.setVisibility(View.INVISIBLE);
                        imageButton10.setVisibility(View.INVISIBLE);
                        imageButton11.setVisibility(View.INVISIBLE);
                        imageButton12.setVisibility(View.INVISIBLE);
                        imageButton13.setVisibility(View.INVISIBLE);
                        imageButton14.setVisibility(View.INVISIBLE);
                        imageButton15.setVisibility(View.INVISIBLE);
                        imageButton16.setVisibility(View.INVISIBLE);
                        imageButton17.setVisibility(View.INVISIBLE);
                        imageButton18.setVisibility(View.INVISIBLE);
                        imageButton19.setVisibility(View.INVISIBLE);
                        imageButton20.setVisibility(View.INVISIBLE);
                        imageButton21.setVisibility(View.INVISIBLE);
                        imageButton22.setVisibility(View.INVISIBLE);
                        imageButton23.setVisibility(View.INVISIBLE);
                        imageButton24.setVisibility(View.INVISIBLE);
                        imageButton25.setVisibility(View.INVISIBLE);
                        imageButton26.setVisibility(View.INVISIBLE);
                        imageButton27.setVisibility(View.INVISIBLE);
                        imageButton28.setVisibility(View.INVISIBLE);
                        imageButton29.setVisibility(View.INVISIBLE);
                        imageButton30.setVisibility(View.INVISIBLE);
                        imageButton31.setVisibility(View.INVISIBLE);
                        imageButton32.setVisibility(View.INVISIBLE);
                        imageButton33.setVisibility(View.INVISIBLE);
                        imageButton34.setVisibility(View.INVISIBLE);


                        m3.showInfoWindow();
                        Toast.makeText(MapsActivity.this, "Click button to open video F3",
                                Toast.LENGTH_LONG).show();

                    }
                    if (marker.equals(m4)){

                        imageButton4.setVisibility(View.VISIBLE);
                        imageButton3.setVisibility(View.INVISIBLE);
                        mainButton.setVisibility(View.INVISIBLE);
                        imageButton2.setVisibility(View.INVISIBLE);
                        imageButton5.setVisibility(View.INVISIBLE);
                        imageButton6.setVisibility(View.INVISIBLE);
                        imageButton7.setVisibility(View.INVISIBLE);
                        imageButton8.setVisibility(View.INVISIBLE);
                        imageButton9.setVisibility(View.INVISIBLE);
                        imageButton10.setVisibility(View.INVISIBLE);
                        imageButton11.setVisibility(View.INVISIBLE);
                        imageButton12.setVisibility(View.INVISIBLE);
                        imageButton13.setVisibility(View.INVISIBLE);
                        imageButton14.setVisibility(View.INVISIBLE);
                        imageButton15.setVisibility(View.INVISIBLE);
                        imageButton16.setVisibility(View.INVISIBLE);
                        imageButton17.setVisibility(View.INVISIBLE);
                        imageButton18.setVisibility(View.INVISIBLE);
                        imageButton19.setVisibility(View.INVISIBLE);
                        imageButton20.setVisibility(View.INVISIBLE);
                        imageButton21.setVisibility(View.INVISIBLE);
                        imageButton22.setVisibility(View.INVISIBLE);
                        imageButton23.setVisibility(View.INVISIBLE);
                        imageButton24.setVisibility(View.INVISIBLE);
                        imageButton25.setVisibility(View.INVISIBLE);
                        imageButton26.setVisibility(View.INVISIBLE);
                        imageButton27.setVisibility(View.INVISIBLE);
                        imageButton28.setVisibility(View.INVISIBLE);
                        imageButton29.setVisibility(View.INVISIBLE);
                        imageButton30.setVisibility(View.INVISIBLE);
                        imageButton31.setVisibility(View.INVISIBLE);
                        imageButton32.setVisibility(View.INVISIBLE);
                        imageButton33.setVisibility(View.INVISIBLE);
                        imageButton34.setVisibility(View.INVISIBLE);

                        m4.showInfoWindow();
                        Toast.makeText(MapsActivity.this, "Click button to open video F4",
                                Toast.LENGTH_LONG).show();


                    }
                    if (marker.equals(m5)){
                        imageButton5.setVisibility(View.VISIBLE);
                        imageButton4.setVisibility(View.INVISIBLE);
                        imageButton3.setVisibility(View.INVISIBLE);
                        mainButton.setVisibility(View.INVISIBLE);
                        imageButton2.setVisibility(View.INVISIBLE);
                        imageButton6.setVisibility(View.INVISIBLE);
                        imageButton7.setVisibility(View.INVISIBLE);
                        imageButton8.setVisibility(View.INVISIBLE);
                        imageButton9.setVisibility(View.INVISIBLE);
                        imageButton10.setVisibility(View.INVISIBLE);
                        imageButton11.setVisibility(View.INVISIBLE);
                        imageButton12.setVisibility(View.INVISIBLE);
                        imageButton13.setVisibility(View.INVISIBLE);
                        imageButton14.setVisibility(View.INVISIBLE);
                        imageButton15.setVisibility(View.INVISIBLE);
                        imageButton16.setVisibility(View.INVISIBLE);
                        imageButton17.setVisibility(View.INVISIBLE);
                        imageButton18.setVisibility(View.INVISIBLE);
                        imageButton19.setVisibility(View.INVISIBLE);
                        imageButton20.setVisibility(View.INVISIBLE);
                        imageButton21.setVisibility(View.INVISIBLE);
                        imageButton22.setVisibility(View.INVISIBLE);
                        imageButton23.setVisibility(View.INVISIBLE);
                        imageButton24.setVisibility(View.INVISIBLE);
                        imageButton25.setVisibility(View.INVISIBLE);
                        imageButton26.setVisibility(View.INVISIBLE);
                        imageButton27.setVisibility(View.INVISIBLE);
                        imageButton28.setVisibility(View.INVISIBLE);
                        imageButton29.setVisibility(View.INVISIBLE);
                        imageButton30.setVisibility(View.INVISIBLE);
                        imageButton31.setVisibility(View.INVISIBLE);
                        imageButton32.setVisibility(View.INVISIBLE);
                        imageButton33.setVisibility(View.INVISIBLE);
                        imageButton34.setVisibility(View.INVISIBLE);


                        m5.showInfoWindow();
                        Toast.makeText(MapsActivity.this, "Click button to open video F5",
                                Toast.LENGTH_LONG).show();


                    }
                    if(marker.equals(m6)){
                        imageButton6.setVisibility(View.VISIBLE);
                        imageButton5.setVisibility(View.INVISIBLE);
                        imageButton4.setVisibility(View.INVISIBLE);
                        imageButton3.setVisibility(View.INVISIBLE);
                        mainButton.setVisibility(View.INVISIBLE);
                        imageButton2.setVisibility(View.INVISIBLE);
                        imageButton7.setVisibility(View.INVISIBLE);
                        imageButton8.setVisibility(View.INVISIBLE);
                        imageButton9.setVisibility(View.INVISIBLE);
                        imageButton10.setVisibility(View.INVISIBLE);
                        imageButton11.setVisibility(View.INVISIBLE);
                        imageButton12.setVisibility(View.INVISIBLE);
                        imageButton13.setVisibility(View.INVISIBLE);
                        imageButton14.setVisibility(View.INVISIBLE);
                        imageButton15.setVisibility(View.INVISIBLE);
                        imageButton16.setVisibility(View.INVISIBLE);
                        imageButton17.setVisibility(View.INVISIBLE);
                        imageButton18.setVisibility(View.INVISIBLE);
                        imageButton19.setVisibility(View.INVISIBLE);
                        imageButton20.setVisibility(View.INVISIBLE);
                        imageButton21.setVisibility(View.INVISIBLE);
                        imageButton22.setVisibility(View.INVISIBLE);
                        imageButton23.setVisibility(View.INVISIBLE);
                        imageButton24.setVisibility(View.INVISIBLE);
                        imageButton25.setVisibility(View.INVISIBLE);
                        imageButton26.setVisibility(View.INVISIBLE);
                        imageButton27.setVisibility(View.INVISIBLE);
                        imageButton28.setVisibility(View.INVISIBLE);
                        imageButton29.setVisibility(View.INVISIBLE);
                        imageButton30.setVisibility(View.INVISIBLE);
                        imageButton31.setVisibility(View.INVISIBLE);
                        imageButton32.setVisibility(View.INVISIBLE);
                        imageButton33.setVisibility(View.INVISIBLE);
                        imageButton34.setVisibility(View.INVISIBLE);

                        m6.showInfoWindow();
                        Toast.makeText(MapsActivity.this, "Click button to open video F6",
                                Toast.LENGTH_LONG).show();

                    }
                    if(marker.equals(lib)){
                        imageButton7.setVisibility(View.VISIBLE);
                        imageButton6.setVisibility(View.INVISIBLE);
                        imageButton5.setVisibility(View.INVISIBLE);
                        imageButton4.setVisibility(View.INVISIBLE);
                        imageButton3.setVisibility(View.INVISIBLE);
                        mainButton.setVisibility(View.INVISIBLE);
                        imageButton2.setVisibility(View.INVISIBLE);
                        imageButton8.setVisibility(View.INVISIBLE);
                        imageButton9.setVisibility(View.INVISIBLE);
                        imageButton10.setVisibility(View.INVISIBLE);
                        imageButton11.setVisibility(View.INVISIBLE);
                        imageButton12.setVisibility(View.INVISIBLE);
                        imageButton13.setVisibility(View.INVISIBLE);
                        imageButton14.setVisibility(View.INVISIBLE);
                        imageButton15.setVisibility(View.INVISIBLE);
                        imageButton16.setVisibility(View.INVISIBLE);
                        imageButton17.setVisibility(View.INVISIBLE);
                        imageButton18.setVisibility(View.INVISIBLE);
                        imageButton19.setVisibility(View.INVISIBLE);
                        imageButton20.setVisibility(View.INVISIBLE);
                        imageButton21.setVisibility(View.INVISIBLE);
                        imageButton22.setVisibility(View.INVISIBLE);
                        imageButton23.setVisibility(View.INVISIBLE);
                        imageButton24.setVisibility(View.INVISIBLE);
                        imageButton25.setVisibility(View.INVISIBLE);
                        imageButton26.setVisibility(View.INVISIBLE);
                        imageButton27.setVisibility(View.INVISIBLE);
                        imageButton28.setVisibility(View.INVISIBLE);
                        imageButton29.setVisibility(View.INVISIBLE);
                        imageButton30.setVisibility(View.INVISIBLE);
                        imageButton31.setVisibility(View.INVISIBLE);
                        imageButton32.setVisibility(View.INVISIBLE);
                        imageButton33.setVisibility(View.INVISIBLE);
                        imageButton34.setVisibility(View.INVISIBLE);

                        lib.showInfoWindow();
                        Toast.makeText(MapsActivity.this, "Click button to open video อาคารบรรณสาร",
                                Toast.LENGTH_LONG).show();

                    }
                    if (marker.equals(activity)){
                        imageButton8.setVisibility(View.VISIBLE);
                        imageButton7.setVisibility(View.INVISIBLE);
                        imageButton6.setVisibility(View.INVISIBLE);
                        imageButton5.setVisibility(View.INVISIBLE);
                        imageButton4.setVisibility(View.INVISIBLE);
                        imageButton3.setVisibility(View.INVISIBLE);
                        mainButton.setVisibility(View.INVISIBLE);
                        imageButton2.setVisibility(View.INVISIBLE);
                        imageButton9.setVisibility(View.INVISIBLE);
                        imageButton10.setVisibility(View.INVISIBLE);
                        imageButton11.setVisibility(View.INVISIBLE);
                        imageButton12.setVisibility(View.INVISIBLE);
                        imageButton13.setVisibility(View.INVISIBLE);
                        imageButton14.setVisibility(View.INVISIBLE);
                        imageButton15.setVisibility(View.INVISIBLE);
                        imageButton16.setVisibility(View.INVISIBLE);
                        imageButton17.setVisibility(View.INVISIBLE);
                        imageButton18.setVisibility(View.INVISIBLE);
                        imageButton19.setVisibility(View.INVISIBLE);
                        imageButton20.setVisibility(View.INVISIBLE);
                        imageButton21.setVisibility(View.INVISIBLE);
                        imageButton22.setVisibility(View.INVISIBLE);
                        imageButton23.setVisibility(View.INVISIBLE);
                        imageButton24.setVisibility(View.INVISIBLE);
                        imageButton25.setVisibility(View.INVISIBLE);
                        imageButton26.setVisibility(View.INVISIBLE);
                        imageButton27.setVisibility(View.INVISIBLE);
                        imageButton28.setVisibility(View.INVISIBLE);
                        imageButton29.setVisibility(View.INVISIBLE);
                        imageButton30.setVisibility(View.INVISIBLE);
                        imageButton31.setVisibility(View.INVISIBLE);
                        imageButton32.setVisibility(View.INVISIBLE);
                        imageButton33.setVisibility(View.INVISIBLE);
                        imageButton34.setVisibility(View.INVISIBLE);


                        activity.showInfoWindow();
                        Toast.makeText(MapsActivity.this, "Click button to open video อาคารกิจการนักศึกษา",
                                Toast.LENGTH_LONG).show();
                    }
                    if (marker.equals(b1)){
                        imageButton9.setVisibility(View.VISIBLE);
                        imageButton8.setVisibility(View.INVISIBLE);
                        imageButton7.setVisibility(View.INVISIBLE);
                        imageButton6.setVisibility(View.INVISIBLE);
                        imageButton5.setVisibility(View.INVISIBLE);
                        imageButton4.setVisibility(View.INVISIBLE);
                        imageButton3.setVisibility(View.INVISIBLE);
                        mainButton.setVisibility(View.INVISIBLE);
                        imageButton2.setVisibility(View.INVISIBLE);
                        imageButton10.setVisibility(View.INVISIBLE);
                        imageButton11.setVisibility(View.INVISIBLE);
                        imageButton12.setVisibility(View.INVISIBLE);
                        imageButton13.setVisibility(View.INVISIBLE);
                        imageButton14.setVisibility(View.INVISIBLE);
                        imageButton15.setVisibility(View.INVISIBLE);
                        imageButton16.setVisibility(View.INVISIBLE);
                        imageButton17.setVisibility(View.INVISIBLE);
                        imageButton18.setVisibility(View.INVISIBLE);
                        imageButton19.setVisibility(View.INVISIBLE);
                        imageButton20.setVisibility(View.INVISIBLE);
                        imageButton21.setVisibility(View.INVISIBLE);
                        imageButton22.setVisibility(View.INVISIBLE);
                        imageButton23.setVisibility(View.INVISIBLE);
                        imageButton24.setVisibility(View.INVISIBLE);
                        imageButton25.setVisibility(View.INVISIBLE);
                        imageButton26.setVisibility(View.INVISIBLE);
                        imageButton27.setVisibility(View.INVISIBLE);
                        imageButton28.setVisibility(View.INVISIBLE);
                        imageButton29.setVisibility(View.INVISIBLE);
                        imageButton30.setVisibility(View.INVISIBLE);
                        imageButton31.setVisibility(View.INVISIBLE);
                        imageButton32.setVisibility(View.INVISIBLE);
                        imageButton33.setVisibility(View.INVISIBLE);
                        imageButton34.setVisibility(View.INVISIBLE);


                        b1.showInfoWindow();
                        Toast.makeText(MapsActivity.this, "Click button to open video อาคารเรียนรวม 1",
                                Toast.LENGTH_LONG).show();

                    }
                    if (marker.equals(b2)){
                        imageButton10.setVisibility(View.VISIBLE);
                        imageButton9.setVisibility(View.INVISIBLE);
                        imageButton8.setVisibility(View.INVISIBLE);
                        imageButton7.setVisibility(View.INVISIBLE);
                        imageButton6.setVisibility(View.INVISIBLE);
                        imageButton5.setVisibility(View.INVISIBLE);
                        imageButton4.setVisibility(View.INVISIBLE);
                        imageButton3.setVisibility(View.INVISIBLE);
                        mainButton.setVisibility(View.INVISIBLE);
                        imageButton2.setVisibility(View.INVISIBLE);
                        imageButton11.setVisibility(View.INVISIBLE);
                        imageButton12.setVisibility(View.INVISIBLE);
                        imageButton13.setVisibility(View.INVISIBLE);
                        imageButton14.setVisibility(View.INVISIBLE);
                        imageButton15.setVisibility(View.INVISIBLE);
                        imageButton16.setVisibility(View.INVISIBLE);
                        imageButton17.setVisibility(View.INVISIBLE);
                        imageButton18.setVisibility(View.INVISIBLE);
                        imageButton19.setVisibility(View.INVISIBLE);
                        imageButton20.setVisibility(View.INVISIBLE);
                        imageButton21.setVisibility(View.INVISIBLE);
                        imageButton22.setVisibility(View.INVISIBLE);
                        imageButton23.setVisibility(View.INVISIBLE);
                        imageButton24.setVisibility(View.INVISIBLE);
                        imageButton25.setVisibility(View.INVISIBLE);
                        imageButton26.setVisibility(View.INVISIBLE);
                        imageButton27.setVisibility(View.INVISIBLE);
                        imageButton28.setVisibility(View.INVISIBLE);
                        imageButton29.setVisibility(View.INVISIBLE);
                        imageButton30.setVisibility(View.INVISIBLE);
                        imageButton31.setVisibility(View.INVISIBLE);
                        imageButton32.setVisibility(View.INVISIBLE);
                        imageButton33.setVisibility(View.INVISIBLE);
                        imageButton34.setVisibility(View.INVISIBLE);

                        b2.showInfoWindow();
                        Toast.makeText(MapsActivity.this, "Click button to open video อาคารเรียนรวม 2",
                                Toast.LENGTH_LONG).show();

                    }
                    if (marker.equals(surareang)){
                        imageButton11.setVisibility(View.VISIBLE);
                        imageButton10.setVisibility(View.INVISIBLE);
                        imageButton9.setVisibility(View.INVISIBLE);
                        imageButton8.setVisibility(View.INVISIBLE);
                        imageButton7.setVisibility(View.INVISIBLE);
                        imageButton6.setVisibility(View.INVISIBLE);
                        imageButton5.setVisibility(View.INVISIBLE);
                        imageButton4.setVisibility(View.INVISIBLE);
                        imageButton3.setVisibility(View.INVISIBLE);
                        mainButton.setVisibility(View.INVISIBLE);
                        imageButton2.setVisibility(View.INVISIBLE);
                        imageButton12.setVisibility(View.INVISIBLE);
                        imageButton13.setVisibility(View.INVISIBLE);
                        imageButton14.setVisibility(View.INVISIBLE);
                        imageButton15.setVisibility(View.INVISIBLE);
                        imageButton16.setVisibility(View.INVISIBLE);
                        imageButton17.setVisibility(View.INVISIBLE);
                        imageButton18.setVisibility(View.INVISIBLE);
                        imageButton19.setVisibility(View.INVISIBLE);
                        imageButton20.setVisibility(View.INVISIBLE);
                        imageButton21.setVisibility(View.INVISIBLE);
                        imageButton22.setVisibility(View.INVISIBLE);
                        imageButton23.setVisibility(View.INVISIBLE);
                        imageButton24.setVisibility(View.INVISIBLE);
                        imageButton25.setVisibility(View.INVISIBLE);
                        imageButton26.setVisibility(View.INVISIBLE);
                        imageButton27.setVisibility(View.INVISIBLE);
                        imageButton28.setVisibility(View.INVISIBLE);
                        imageButton29.setVisibility(View.INVISIBLE);
                        imageButton30.setVisibility(View.INVISIBLE);
                        imageButton31.setVisibility(View.INVISIBLE);
                        imageButton32.setVisibility(View.INVISIBLE);
                        imageButton33.setVisibility(View.INVISIBLE);
                        imageButton34.setVisibility(View.INVISIBLE);



                        surareang.showInfoWindow();
                        Toast.makeText(MapsActivity.this, "Click button to open video อาคารสุรเริงไชย",
                                Toast.LENGTH_LONG).show();

                    }
                    if (marker.equals(sportCenter)){
                        imageButton12.setVisibility(View.VISIBLE);
                        imageButton11.setVisibility(View.INVISIBLE);
                        imageButton10.setVisibility(View.INVISIBLE);
                        imageButton9.setVisibility(View.INVISIBLE);
                        imageButton8.setVisibility(View.INVISIBLE);
                        imageButton7.setVisibility(View.INVISIBLE);
                        imageButton6.setVisibility(View.INVISIBLE);
                        imageButton5.setVisibility(View.INVISIBLE);
                        imageButton4.setVisibility(View.INVISIBLE);
                        imageButton3.setVisibility(View.INVISIBLE);
                        mainButton.setVisibility(View.INVISIBLE);
                        imageButton2.setVisibility(View.INVISIBLE);
                        imageButton13.setVisibility(View.INVISIBLE);
                        imageButton14.setVisibility(View.INVISIBLE);
                        imageButton15.setVisibility(View.INVISIBLE);
                        imageButton16.setVisibility(View.INVISIBLE);
                        imageButton17.setVisibility(View.INVISIBLE);
                        imageButton18.setVisibility(View.INVISIBLE);
                        imageButton19.setVisibility(View.INVISIBLE);
                        imageButton20.setVisibility(View.INVISIBLE);
                        imageButton21.setVisibility(View.INVISIBLE);
                        imageButton22.setVisibility(View.INVISIBLE);
                        imageButton23.setVisibility(View.INVISIBLE);
                        imageButton24.setVisibility(View.INVISIBLE);
                        imageButton25.setVisibility(View.INVISIBLE);
                        imageButton26.setVisibility(View.INVISIBLE);
                        imageButton27.setVisibility(View.INVISIBLE);
                        imageButton28.setVisibility(View.INVISIBLE);
                        imageButton29.setVisibility(View.INVISIBLE);
                        imageButton30.setVisibility(View.INVISIBLE);
                        imageButton31.setVisibility(View.INVISIBLE);
                        imageButton32.setVisibility(View.INVISIBLE);
                        imageButton33.setVisibility(View.INVISIBLE);
                        imageButton34.setVisibility(View.INVISIBLE);



                        sportCenter.showInfoWindow();
                        Toast.makeText(MapsActivity.this, "Click button to open video อาคารกีฬา",
                                Toast.LENGTH_LONG).show();

                    }
                    if(marker.equals(farm)){
                        imageButton13.setVisibility(View.VISIBLE);
                        imageButton12.setVisibility(View.INVISIBLE);
                        imageButton11.setVisibility(View.INVISIBLE);
                        imageButton10.setVisibility(View.INVISIBLE);
                        imageButton9.setVisibility(View.INVISIBLE);
                        imageButton8.setVisibility(View.INVISIBLE);
                        imageButton7.setVisibility(View.INVISIBLE);
                        imageButton6.setVisibility(View.INVISIBLE);
                        imageButton5.setVisibility(View.INVISIBLE);
                        imageButton4.setVisibility(View.INVISIBLE);
                        imageButton3.setVisibility(View.INVISIBLE);
                        mainButton.setVisibility(View.INVISIBLE);
                        imageButton2.setVisibility(View.INVISIBLE);
                        imageButton14.setVisibility(View.INVISIBLE);
                        imageButton15.setVisibility(View.INVISIBLE);
                        imageButton16.setVisibility(View.INVISIBLE);
                        imageButton17.setVisibility(View.INVISIBLE);
                        imageButton18.setVisibility(View.INVISIBLE);
                        imageButton19.setVisibility(View.INVISIBLE);
                        imageButton20.setVisibility(View.INVISIBLE);
                        imageButton21.setVisibility(View.INVISIBLE);
                        imageButton22.setVisibility(View.INVISIBLE);
                        imageButton23.setVisibility(View.INVISIBLE);
                        imageButton24.setVisibility(View.INVISIBLE);
                        imageButton25.setVisibility(View.INVISIBLE);
                        imageButton26.setVisibility(View.INVISIBLE);
                        imageButton27.setVisibility(View.INVISIBLE);
                        imageButton28.setVisibility(View.INVISIBLE);
                        imageButton29.setVisibility(View.INVISIBLE);
                        imageButton30.setVisibility(View.INVISIBLE);
                        imageButton31.setVisibility(View.INVISIBLE);
                        imageButton32.setVisibility(View.INVISIBLE);
                        imageButton33.setVisibility(View.INVISIBLE);
                        imageButton34.setVisibility(View.INVISIBLE);



                        farm.showInfoWindow();

                        Toast.makeText(MapsActivity.this, "Click button to open video ฟาร์มหาวิทยลัย",
                                Toast.LENGTH_LONG).show();

                    }
                    if(marker.equals(vichakarn)){
                        imageButton14.setVisibility(View.VISIBLE);
                        imageButton13.setVisibility(View.INVISIBLE);
                        imageButton12.setVisibility(View.INVISIBLE);
                        imageButton11.setVisibility(View.INVISIBLE);
                        imageButton10.setVisibility(View.INVISIBLE);
                        imageButton9.setVisibility(View.INVISIBLE);
                        imageButton8.setVisibility(View.INVISIBLE);
                        imageButton7.setVisibility(View.INVISIBLE);
                        imageButton6.setVisibility(View.INVISIBLE);
                        imageButton5.setVisibility(View.INVISIBLE);
                        imageButton4.setVisibility(View.INVISIBLE);
                        imageButton3.setVisibility(View.INVISIBLE);
                        mainButton.setVisibility(View.INVISIBLE);
                        imageButton2.setVisibility(View.INVISIBLE);
                        imageButton15.setVisibility(View.INVISIBLE);
                        imageButton16.setVisibility(View.INVISIBLE);
                        imageButton17.setVisibility(View.INVISIBLE);
                        imageButton18.setVisibility(View.INVISIBLE);
                        imageButton19.setVisibility(View.INVISIBLE);
                        imageButton20.setVisibility(View.INVISIBLE);
                        imageButton21.setVisibility(View.INVISIBLE);
                        imageButton22.setVisibility(View.INVISIBLE);
                        imageButton23.setVisibility(View.INVISIBLE);
                        imageButton24.setVisibility(View.INVISIBLE);
                        imageButton25.setVisibility(View.INVISIBLE);
                        imageButton26.setVisibility(View.INVISIBLE);
                        imageButton27.setVisibility(View.INVISIBLE);
                        imageButton28.setVisibility(View.INVISIBLE);
                        imageButton29.setVisibility(View.INVISIBLE);
                        imageButton30.setVisibility(View.INVISIBLE);
                        imageButton31.setVisibility(View.INVISIBLE);
                        imageButton32.setVisibility(View.INVISIBLE);
                        imageButton33.setVisibility(View.INVISIBLE);
                        imageButton34.setVisibility(View.INVISIBLE);


                        vichakarn.showInfoWindow();
                        Toast.makeText(MapsActivity.this, "Click button to open video อาคารวิชาการ 1",
                                Toast.LENGTH_LONG).show();

                    }
                    if (marker.equals(vicharkarn2)){
                        imageButton15.setVisibility(View.VISIBLE);
                        imageButton14.setVisibility(View.INVISIBLE);
                        imageButton13.setVisibility(View.INVISIBLE);
                        imageButton12.setVisibility(View.INVISIBLE);
                        imageButton11.setVisibility(View.INVISIBLE);
                        imageButton10.setVisibility(View.INVISIBLE);
                        imageButton9.setVisibility(View.INVISIBLE);
                        imageButton8.setVisibility(View.INVISIBLE);
                        imageButton7.setVisibility(View.INVISIBLE);
                        imageButton6.setVisibility(View.INVISIBLE);
                        imageButton5.setVisibility(View.INVISIBLE);
                        imageButton4.setVisibility(View.INVISIBLE);
                        imageButton3.setVisibility(View.INVISIBLE);
                        mainButton.setVisibility(View.INVISIBLE);
                        imageButton16.setVisibility(View.INVISIBLE);
                        imageButton17.setVisibility(View.INVISIBLE);
                        imageButton18.setVisibility(View.INVISIBLE);
                        imageButton19.setVisibility(View.INVISIBLE);
                        imageButton20.setVisibility(View.INVISIBLE);
                        imageButton21.setVisibility(View.INVISIBLE);
                        imageButton22.setVisibility(View.INVISIBLE);
                        imageButton23.setVisibility(View.INVISIBLE);
                        imageButton24.setVisibility(View.INVISIBLE);
                        imageButton25.setVisibility(View.INVISIBLE);
                        imageButton26.setVisibility(View.INVISIBLE);
                        imageButton27.setVisibility(View.INVISIBLE);
                        imageButton28.setVisibility(View.INVISIBLE);
                        imageButton29.setVisibility(View.INVISIBLE);
                        imageButton30.setVisibility(View.INVISIBLE);
                        imageButton31.setVisibility(View.INVISIBLE);
                        imageButton32.setVisibility(View.INVISIBLE);
                        imageButton33.setVisibility(View.INVISIBLE);
                        imageButton34.setVisibility(View.INVISIBLE);



                        vicharkarn2.showInfoWindow();
                        Toast.makeText(MapsActivity.this, "Click button to open video อาคารวิชาการ 2",
                                Toast.LENGTH_LONG).show();
                    }
                    if (marker.equals(a)){
                        imageButton16.setVisibility(View.VISIBLE);
                        imageButton15.setVisibility(View.INVISIBLE);
                        imageButton14.setVisibility(View.INVISIBLE);
                        imageButton13.setVisibility(View.INVISIBLE);
                        imageButton12.setVisibility(View.INVISIBLE);
                        imageButton11.setVisibility(View.INVISIBLE);
                        imageButton10.setVisibility(View.INVISIBLE);
                        imageButton9.setVisibility(View.INVISIBLE);
                        imageButton8.setVisibility(View.INVISIBLE);
                        imageButton7.setVisibility(View.INVISIBLE);
                        imageButton6.setVisibility(View.INVISIBLE);
                        imageButton5.setVisibility(View.INVISIBLE);
                        imageButton4.setVisibility(View.INVISIBLE);
                        imageButton3.setVisibility(View.INVISIBLE);
                        mainButton.setVisibility(View.INVISIBLE);
                        imageButton17.setVisibility(View.INVISIBLE);
                        imageButton18.setVisibility(View.INVISIBLE);
                        imageButton19.setVisibility(View.INVISIBLE);
                        imageButton20.setVisibility(View.INVISIBLE);
                        imageButton21.setVisibility(View.INVISIBLE);
                        imageButton22.setVisibility(View.INVISIBLE);
                        imageButton23.setVisibility(View.INVISIBLE);
                        imageButton24.setVisibility(View.INVISIBLE);
                        imageButton25.setVisibility(View.INVISIBLE);
                        imageButton26.setVisibility(View.INVISIBLE);
                        imageButton27.setVisibility(View.INVISIBLE);
                        imageButton28.setVisibility(View.INVISIBLE);
                        imageButton29.setVisibility(View.INVISIBLE);
                        imageButton30.setVisibility(View.INVISIBLE);
                        imageButton31.setVisibility(View.INVISIBLE);
                        imageButton32.setVisibility(View.INVISIBLE);
                        imageButton33.setVisibility(View.INVISIBLE);
                        imageButton34.setVisibility(View.INVISIBLE);



                        a.showInfoWindow();
                        Toast.makeText(MapsActivity.this, "Click button to open video อาคารบริหาร",
                                Toast.LENGTH_LONG).show();


                    }
                    if (marker.equals(com_cen)){
                        imageButton17.setVisibility(View.VISIBLE);
                        imageButton16.setVisibility(View.INVISIBLE);
                        imageButton15.setVisibility(View.INVISIBLE);
                        imageButton14.setVisibility(View.INVISIBLE);
                        imageButton13.setVisibility(View.INVISIBLE);
                        imageButton12.setVisibility(View.INVISIBLE);
                        imageButton11.setVisibility(View.INVISIBLE);
                        imageButton10.setVisibility(View.INVISIBLE);
                        imageButton9.setVisibility(View.INVISIBLE);
                        imageButton8.setVisibility(View.INVISIBLE);
                        imageButton7.setVisibility(View.INVISIBLE);
                        imageButton6.setVisibility(View.INVISIBLE);
                        imageButton5.setVisibility(View.INVISIBLE);
                        imageButton4.setVisibility(View.INVISIBLE);
                        imageButton3.setVisibility(View.INVISIBLE);
                        mainButton.setVisibility(View.INVISIBLE);
                        imageButton18.setVisibility(View.INVISIBLE);
                        imageButton19.setVisibility(View.INVISIBLE);
                        imageButton20.setVisibility(View.INVISIBLE);
                        imageButton21.setVisibility(View.INVISIBLE);
                        imageButton22.setVisibility(View.INVISIBLE);
                        imageButton23.setVisibility(View.INVISIBLE);
                        imageButton24.setVisibility(View.INVISIBLE);
                        imageButton25.setVisibility(View.INVISIBLE);
                        imageButton26.setVisibility(View.INVISIBLE);
                        imageButton27.setVisibility(View.INVISIBLE);
                        imageButton28.setVisibility(View.INVISIBLE);
                        imageButton29.setVisibility(View.INVISIBLE);
                        imageButton30.setVisibility(View.INVISIBLE);
                        imageButton31.setVisibility(View.INVISIBLE);
                        imageButton32.setVisibility(View.INVISIBLE);
                        imageButton33.setVisibility(View.INVISIBLE);
                        imageButton34.setVisibility(View.INVISIBLE);



                        com_cen.showInfoWindow();

                        Toast.makeText(MapsActivity.this, "Click button to open video ศูนย์คอมพิวเตอร์",
                                Toast.LENGTH_LONG).show();
                    }
                    if (marker.equals(CANTEEN)){
                        imageButton18.setVisibility(View.VISIBLE);
                        imageButton17.setVisibility(View.INVISIBLE);
                        imageButton16.setVisibility(View.INVISIBLE);
                        imageButton15.setVisibility(View.INVISIBLE);
                        imageButton14.setVisibility(View.INVISIBLE);
                        imageButton13.setVisibility(View.INVISIBLE);
                        imageButton12.setVisibility(View.INVISIBLE);
                        imageButton11.setVisibility(View.INVISIBLE);
                        imageButton10.setVisibility(View.INVISIBLE);
                        imageButton9.setVisibility(View.INVISIBLE);
                        imageButton8.setVisibility(View.INVISIBLE);
                        imageButton7.setVisibility(View.INVISIBLE);
                        imageButton6.setVisibility(View.INVISIBLE);
                        imageButton5.setVisibility(View.INVISIBLE);
                        imageButton4.setVisibility(View.INVISIBLE);
                        imageButton3.setVisibility(View.INVISIBLE);
                        mainButton.setVisibility(View.INVISIBLE);
                        imageButton19.setVisibility(View.INVISIBLE);
                        imageButton20.setVisibility(View.INVISIBLE);
                        imageButton21.setVisibility(View.INVISIBLE);
                        imageButton22.setVisibility(View.INVISIBLE);
                        imageButton23.setVisibility(View.INVISIBLE);
                        imageButton24.setVisibility(View.INVISIBLE);
                        imageButton25.setVisibility(View.INVISIBLE);
                        imageButton26.setVisibility(View.INVISIBLE);
                        imageButton27.setVisibility(View.INVISIBLE);
                        imageButton28.setVisibility(View.INVISIBLE);
                        imageButton29.setVisibility(View.INVISIBLE);
                        imageButton30.setVisibility(View.INVISIBLE);
                        imageButton31.setVisibility(View.INVISIBLE);
                        imageButton32.setVisibility(View.INVISIBLE);
                        imageButton33.setVisibility(View.INVISIBLE);
                        imageButton34.setVisibility(View.INVISIBLE);




                        CANTEEN.showInfoWindow();

                        Toast.makeText(MapsActivity.this, "Click button to open video โรงอาหารกลาง",
                                Toast.LENGTH_LONG).show();
                    }
                        if (marker.equals(SURAPAT_1)){
                            imageButton19.setVisibility(View.VISIBLE);
                            imageButton18.setVisibility(View.INVISIBLE);
                            imageButton17.setVisibility(View.INVISIBLE);
                            imageButton16.setVisibility(View.INVISIBLE);
                            imageButton15.setVisibility(View.INVISIBLE);
                            imageButton14.setVisibility(View.INVISIBLE);
                            imageButton13.setVisibility(View.INVISIBLE);
                            imageButton12.setVisibility(View.INVISIBLE);
                            imageButton11.setVisibility(View.INVISIBLE);
                            imageButton10.setVisibility(View.INVISIBLE);
                            imageButton9.setVisibility(View.INVISIBLE);
                            imageButton8.setVisibility(View.INVISIBLE);
                            imageButton7.setVisibility(View.INVISIBLE);
                            imageButton6.setVisibility(View.INVISIBLE);
                            imageButton5.setVisibility(View.INVISIBLE);
                            imageButton4.setVisibility(View.INVISIBLE);
                            imageButton3.setVisibility(View.INVISIBLE);
                            mainButton.setVisibility(View.INVISIBLE);
                            imageButton20.setVisibility(View.INVISIBLE);
                            imageButton21.setVisibility(View.INVISIBLE);
                            imageButton22.setVisibility(View.INVISIBLE);
                            imageButton23.setVisibility(View.INVISIBLE);
                            imageButton24.setVisibility(View.INVISIBLE);
                            imageButton25.setVisibility(View.INVISIBLE);
                            imageButton26.setVisibility(View.INVISIBLE);
                            imageButton27.setVisibility(View.INVISIBLE);
                            imageButton28.setVisibility(View.INVISIBLE);
                            imageButton29.setVisibility(View.INVISIBLE);
                            imageButton30.setVisibility(View.INVISIBLE);
                            imageButton31.setVisibility(View.INVISIBLE);
                            imageButton32.setVisibility(View.INVISIBLE);
                            imageButton33.setVisibility(View.INVISIBLE);
                            imageButton34.setVisibility(View.INVISIBLE);




                            SURAPAT_1.showInfoWindow();

                            Toast.makeText(MapsActivity.this, "Click button to open video อาคารสุรพัฒน์ 1",
                                    Toast.LENGTH_LONG).show();
                        }
                        if (marker.equals(SURAPAT_2)){
                            imageButton20.setVisibility(View.VISIBLE);
                            imageButton19.setVisibility(View.INVISIBLE);
                            imageButton18.setVisibility(View.INVISIBLE);
                            imageButton17.setVisibility(View.INVISIBLE);
                            imageButton16.setVisibility(View.INVISIBLE);
                            imageButton15.setVisibility(View.INVISIBLE);
                            imageButton14.setVisibility(View.INVISIBLE);
                            imageButton13.setVisibility(View.INVISIBLE);
                            imageButton12.setVisibility(View.INVISIBLE);
                            imageButton11.setVisibility(View.INVISIBLE);
                            imageButton10.setVisibility(View.INVISIBLE);
                            imageButton9.setVisibility(View.INVISIBLE);
                            imageButton8.setVisibility(View.INVISIBLE);
                            imageButton7.setVisibility(View.INVISIBLE);
                            imageButton6.setVisibility(View.INVISIBLE);
                            imageButton5.setVisibility(View.INVISIBLE);
                            imageButton4.setVisibility(View.INVISIBLE);
                            imageButton3.setVisibility(View.INVISIBLE);
                            mainButton.setVisibility(View.INVISIBLE);
                            imageButton21.setVisibility(View.INVISIBLE);
                            imageButton22.setVisibility(View.INVISIBLE);
                            imageButton23.setVisibility(View.INVISIBLE);
                            imageButton24.setVisibility(View.INVISIBLE);
                            imageButton25.setVisibility(View.INVISIBLE);
                            imageButton26.setVisibility(View.INVISIBLE);
                            imageButton27.setVisibility(View.INVISIBLE);
                            imageButton28.setVisibility(View.INVISIBLE);
                            imageButton29.setVisibility(View.INVISIBLE);
                            imageButton30.setVisibility(View.INVISIBLE);
                            imageButton31.setVisibility(View.INVISIBLE);
                            imageButton32.setVisibility(View.INVISIBLE);
                            imageButton33.setVisibility(View.INVISIBLE);
                            imageButton34.setVisibility(View.INVISIBLE);




                            SURAPAT_2.showInfoWindow();
                            Toast.makeText(MapsActivity.this, "Click button to open video อาคารสุรพัฒน์ 2",
                                    Toast.LENGTH_LONG).show();
                        }
                    if (marker.equals(SURANAPA)){
                        imageButton21.setVisibility(View.VISIBLE);
                        imageButton20.setVisibility(View.INVISIBLE);
                        imageButton19.setVisibility(View.INVISIBLE);
                        imageButton18.setVisibility(View.INVISIBLE);
                        imageButton17.setVisibility(View.INVISIBLE);
                        imageButton16.setVisibility(View.INVISIBLE);
                        imageButton15.setVisibility(View.INVISIBLE);
                        imageButton14.setVisibility(View.INVISIBLE);
                        imageButton13.setVisibility(View.INVISIBLE);
                        imageButton12.setVisibility(View.INVISIBLE);
                        imageButton11.setVisibility(View.INVISIBLE);
                        imageButton10.setVisibility(View.INVISIBLE);
                        imageButton9.setVisibility(View.INVISIBLE);
                        imageButton8.setVisibility(View.INVISIBLE);
                        imageButton7.setVisibility(View.INVISIBLE);
                        imageButton6.setVisibility(View.INVISIBLE);
                        imageButton5.setVisibility(View.INVISIBLE);
                        imageButton4.setVisibility(View.INVISIBLE);
                        imageButton3.setVisibility(View.INVISIBLE);
                        mainButton.setVisibility(View.INVISIBLE);
                        imageButton22.setVisibility(View.INVISIBLE);
                        imageButton23.setVisibility(View.INVISIBLE);
                        imageButton24.setVisibility(View.INVISIBLE);
                        imageButton25.setVisibility(View.INVISIBLE);
                        imageButton26.setVisibility(View.INVISIBLE);
                        imageButton27.setVisibility(View.INVISIBLE);
                        imageButton28.setVisibility(View.INVISIBLE);
                        imageButton29.setVisibility(View.INVISIBLE);
                        imageButton30.setVisibility(View.INVISIBLE);
                        imageButton31.setVisibility(View.INVISIBLE);
                        imageButton32.setVisibility(View.INVISIBLE);
                        imageButton33.setVisibility(View.INVISIBLE);
                        imageButton34.setVisibility(View.INVISIBLE);



                        SURANAPA.showInfoWindow();
                        Toast.makeText(MapsActivity.this, "Click button to open video หอสุรนภา",
                                Toast.LENGTH_LONG).show();

                    }
                    if (marker.equals(F_7_Building)){
                        imageButton22.setVisibility(View.VISIBLE);
                        imageButton21.setVisibility(View.INVISIBLE);
                        imageButton20.setVisibility(View.INVISIBLE);
                        imageButton19.setVisibility(View.INVISIBLE);
                        imageButton18.setVisibility(View.INVISIBLE);
                        imageButton17.setVisibility(View.INVISIBLE);
                        imageButton16.setVisibility(View.INVISIBLE);
                        imageButton15.setVisibility(View.INVISIBLE);
                        imageButton14.setVisibility(View.INVISIBLE);
                        imageButton13.setVisibility(View.INVISIBLE);
                        imageButton12.setVisibility(View.INVISIBLE);
                        imageButton11.setVisibility(View.INVISIBLE);
                        imageButton10.setVisibility(View.INVISIBLE);
                        imageButton9.setVisibility(View.INVISIBLE);
                        imageButton8.setVisibility(View.INVISIBLE);
                        imageButton7.setVisibility(View.INVISIBLE);
                        imageButton6.setVisibility(View.INVISIBLE);
                        imageButton5.setVisibility(View.INVISIBLE);
                        imageButton4.setVisibility(View.INVISIBLE);
                        imageButton3.setVisibility(View.INVISIBLE);
                        mainButton.setVisibility(View.INVISIBLE);
                        imageButton23.setVisibility(View.INVISIBLE);
                        imageButton24.setVisibility(View.INVISIBLE);
                        imageButton25.setVisibility(View.INVISIBLE);
                        imageButton26.setVisibility(View.INVISIBLE);
                        imageButton27.setVisibility(View.INVISIBLE);
                        imageButton28.setVisibility(View.INVISIBLE);
                        imageButton29.setVisibility(View.INVISIBLE);
                        imageButton30.setVisibility(View.INVISIBLE);
                        imageButton31.setVisibility(View.INVISIBLE);
                        imageButton32.setVisibility(View.INVISIBLE);
                        imageButton33.setVisibility(View.INVISIBLE);
                        imageButton34.setVisibility(View.INVISIBLE);



                        F_7_Building.showInfoWindow();
                        Toast.makeText(MapsActivity.this, "Click button to open video อาคารเครื่องมือ 7",
                                Toast.LENGTH_LONG).show();

                    }
                    if (marker.equals(BUTTERFLY)){
                        imageButton23.setVisibility(View.VISIBLE);
                        imageButton22.setVisibility(View.INVISIBLE);
                        imageButton21.setVisibility(View.INVISIBLE);
                        imageButton20.setVisibility(View.INVISIBLE);
                        imageButton19.setVisibility(View.INVISIBLE);
                        imageButton18.setVisibility(View.INVISIBLE);
                        imageButton17.setVisibility(View.INVISIBLE);
                        imageButton16.setVisibility(View.INVISIBLE);
                        imageButton15.setVisibility(View.INVISIBLE);
                        imageButton14.setVisibility(View.INVISIBLE);
                        imageButton13.setVisibility(View.INVISIBLE);
                        imageButton12.setVisibility(View.INVISIBLE);
                        imageButton11.setVisibility(View.INVISIBLE);
                        imageButton10.setVisibility(View.INVISIBLE);
                        imageButton9.setVisibility(View.INVISIBLE);
                        imageButton8.setVisibility(View.INVISIBLE);
                        imageButton7.setVisibility(View.INVISIBLE);
                        imageButton6.setVisibility(View.INVISIBLE);
                        imageButton5.setVisibility(View.INVISIBLE);
                        imageButton4.setVisibility(View.INVISIBLE);
                        imageButton3.setVisibility(View.INVISIBLE);
                        mainButton.setVisibility(View.INVISIBLE);
                        imageButton24.setVisibility(View.INVISIBLE);
                        imageButton25.setVisibility(View.INVISIBLE);
                        imageButton26.setVisibility(View.INVISIBLE);
                        imageButton27.setVisibility(View.INVISIBLE);
                        imageButton28.setVisibility(View.INVISIBLE);
                        imageButton29.setVisibility(View.INVISIBLE);
                        imageButton30.setVisibility(View.INVISIBLE);
                        imageButton31.setVisibility(View.INVISIBLE);
                        imageButton32.setVisibility(View.INVISIBLE);
                        imageButton33.setVisibility(View.INVISIBLE);
                        imageButton34.setVisibility(View.INVISIBLE);





                        BUTTERFLY.showInfoWindow();
                        Toast.makeText(MapsActivity.this, "Click button to open video อุทยานผีเสื้อ",
                                Toast.LENGTH_LONG).show();

                    }
                    if (marker.equals(museum)){
                        imageButton24.setVisibility(View.VISIBLE);
                        imageButton23.setVisibility(View.INVISIBLE);
                        imageButton22.setVisibility(View.INVISIBLE);
                        imageButton21.setVisibility(View.INVISIBLE);
                        imageButton20.setVisibility(View.INVISIBLE);
                        imageButton19.setVisibility(View.INVISIBLE);
                        imageButton18.setVisibility(View.INVISIBLE);
                        imageButton17.setVisibility(View.INVISIBLE);
                        imageButton16.setVisibility(View.INVISIBLE);
                        imageButton15.setVisibility(View.INVISIBLE);
                        imageButton14.setVisibility(View.INVISIBLE);
                        imageButton13.setVisibility(View.INVISIBLE);
                        imageButton12.setVisibility(View.INVISIBLE);
                        imageButton11.setVisibility(View.INVISIBLE);
                        imageButton10.setVisibility(View.INVISIBLE);
                        imageButton9.setVisibility(View.INVISIBLE);
                        imageButton8.setVisibility(View.INVISIBLE);
                        imageButton7.setVisibility(View.INVISIBLE);
                        imageButton6.setVisibility(View.INVISIBLE);
                        imageButton5.setVisibility(View.INVISIBLE);
                        imageButton4.setVisibility(View.INVISIBLE);
                        imageButton3.setVisibility(View.INVISIBLE);
                        mainButton.setVisibility(View.INVISIBLE);
                        imageButton25.setVisibility(View.INVISIBLE);
                        imageButton26.setVisibility(View.INVISIBLE);
                        imageButton27.setVisibility(View.INVISIBLE);
                        imageButton28.setVisibility(View.INVISIBLE);
                        imageButton29.setVisibility(View.INVISIBLE);
                        imageButton30.setVisibility(View.INVISIBLE);
                        imageButton31.setVisibility(View.INVISIBLE);
                        imageButton32.setVisibility(View.INVISIBLE);
                        imageButton33.setVisibility(View.INVISIBLE);
                        imageButton34.setVisibility(View.INVISIBLE);




                        museum.showInfoWindow();
                        Toast.makeText(MapsActivity.this, "Click button to open video พิพิธภัณฑ์เทคโนโลยีไทยโบราณ",
                                Toast.LENGTH_LONG).show();

                    }
                    if (marker.equals(FLAG)){
                        imageButton25.setVisibility(View.VISIBLE);
                        imageButton24.setVisibility(View.INVISIBLE);
                        imageButton23.setVisibility(View.INVISIBLE);
                        imageButton22.setVisibility(View.INVISIBLE);
                        imageButton21.setVisibility(View.INVISIBLE);
                        imageButton20.setVisibility(View.INVISIBLE);
                        imageButton19.setVisibility(View.INVISIBLE);
                        imageButton18.setVisibility(View.INVISIBLE);
                        imageButton17.setVisibility(View.INVISIBLE);
                        imageButton16.setVisibility(View.INVISIBLE);
                        imageButton15.setVisibility(View.INVISIBLE);
                        imageButton14.setVisibility(View.INVISIBLE);
                        imageButton13.setVisibility(View.INVISIBLE);
                        imageButton12.setVisibility(View.INVISIBLE);
                        imageButton11.setVisibility(View.INVISIBLE);
                        imageButton10.setVisibility(View.INVISIBLE);
                        imageButton9.setVisibility(View.INVISIBLE);
                        imageButton8.setVisibility(View.INVISIBLE);
                        imageButton7.setVisibility(View.INVISIBLE);
                        imageButton6.setVisibility(View.INVISIBLE);
                        imageButton5.setVisibility(View.INVISIBLE);
                        imageButton4.setVisibility(View.INVISIBLE);
                        imageButton3.setVisibility(View.INVISIBLE);
                        mainButton.setVisibility(View.INVISIBLE);
                        imageButton26.setVisibility(View.INVISIBLE);
                        imageButton27.setVisibility(View.INVISIBLE);
                        imageButton28.setVisibility(View.INVISIBLE);
                        imageButton29.setVisibility(View.INVISIBLE);
                        imageButton30.setVisibility(View.INVISIBLE);
                        imageButton31.setVisibility(View.INVISIBLE);
                        imageButton32.setVisibility(View.INVISIBLE);
                        imageButton33.setVisibility(View.INVISIBLE);
                        imageButton34.setVisibility(View.INVISIBLE);


                        FLAG.showInfoWindow();
                        Toast.makeText(MapsActivity.this, "Click button to open video เสาธง",
                                Toast.LENGTH_LONG).show();


                    }
                    if (marker.equals(YAMO)){
                        imageButton26.setVisibility(View.VISIBLE);
                        imageButton25.setVisibility(View.INVISIBLE);
                        imageButton24.setVisibility(View.INVISIBLE);
                        imageButton23.setVisibility(View.INVISIBLE);
                        imageButton22.setVisibility(View.INVISIBLE);
                        imageButton21.setVisibility(View.INVISIBLE);
                        imageButton20.setVisibility(View.INVISIBLE);
                        imageButton19.setVisibility(View.INVISIBLE);
                        imageButton18.setVisibility(View.INVISIBLE);
                        imageButton17.setVisibility(View.INVISIBLE);
                        imageButton16.setVisibility(View.INVISIBLE);
                        imageButton15.setVisibility(View.INVISIBLE);
                        imageButton14.setVisibility(View.INVISIBLE);
                        imageButton13.setVisibility(View.INVISIBLE);
                        imageButton12.setVisibility(View.INVISIBLE);
                        imageButton11.setVisibility(View.INVISIBLE);
                        imageButton10.setVisibility(View.INVISIBLE);
                        imageButton9.setVisibility(View.INVISIBLE);
                        imageButton8.setVisibility(View.INVISIBLE);
                        imageButton7.setVisibility(View.INVISIBLE);
                        imageButton6.setVisibility(View.INVISIBLE);
                        imageButton5.setVisibility(View.INVISIBLE);
                        imageButton4.setVisibility(View.INVISIBLE);
                        imageButton3.setVisibility(View.INVISIBLE);
                        mainButton.setVisibility(View.INVISIBLE);
                        imageButton27.setVisibility(View.INVISIBLE);
                        imageButton28.setVisibility(View.INVISIBLE);
                        imageButton29.setVisibility(View.INVISIBLE);
                        imageButton30.setVisibility(View.INVISIBLE);
                        imageButton31.setVisibility(View.INVISIBLE);
                        imageButton32.setVisibility(View.INVISIBLE);
                        imageButton33.setVisibility(View.INVISIBLE);
                        imageButton34.setVisibility(View.INVISIBLE);


                        YAMO.showInfoWindow();
                        Toast.makeText(MapsActivity.this, "Click button to open video ลานสัญลักษณ์",
                                Toast.LENGTH_LONG).show();
                    }
                        if (marker.equals(AMPHI)){
                            imageButton27.setVisibility(View.VISIBLE);
                            imageButton26.setVisibility(View.INVISIBLE);
                            imageButton25.setVisibility(View.INVISIBLE);
                            imageButton24.setVisibility(View.INVISIBLE);
                            imageButton23.setVisibility(View.INVISIBLE);
                            imageButton22.setVisibility(View.INVISIBLE);
                            imageButton21.setVisibility(View.INVISIBLE);
                            imageButton20.setVisibility(View.INVISIBLE);
                            imageButton19.setVisibility(View.INVISIBLE);
                            imageButton18.setVisibility(View.INVISIBLE);
                            imageButton17.setVisibility(View.INVISIBLE);
                            imageButton16.setVisibility(View.INVISIBLE);
                            imageButton15.setVisibility(View.INVISIBLE);
                            imageButton14.setVisibility(View.INVISIBLE);
                            imageButton13.setVisibility(View.INVISIBLE);
                            imageButton12.setVisibility(View.INVISIBLE);
                            imageButton11.setVisibility(View.INVISIBLE);
                            imageButton10.setVisibility(View.INVISIBLE);
                            imageButton9.setVisibility(View.INVISIBLE);
                            imageButton8.setVisibility(View.INVISIBLE);
                            imageButton7.setVisibility(View.INVISIBLE);
                            imageButton6.setVisibility(View.INVISIBLE);
                            imageButton5.setVisibility(View.INVISIBLE);
                            imageButton4.setVisibility(View.INVISIBLE);
                            imageButton3.setVisibility(View.INVISIBLE);
                            mainButton.setVisibility(View.INVISIBLE);
                            imageButton28.setVisibility(View.INVISIBLE);
                            imageButton29.setVisibility(View.INVISIBLE);
                            imageButton30.setVisibility(View.INVISIBLE);
                            imageButton31.setVisibility(View.INVISIBLE);
                            imageButton32.setVisibility(View.INVISIBLE);
                            imageButton33.setVisibility(View.INVISIBLE);
                            imageButton34.setVisibility(View.INVISIBLE);

                            AMPHI.showInfoWindow();
                            Toast.makeText(MapsActivity.this, "Click button to open video แอมฟิเทียร์เตอร์",
                                    Toast.LENGTH_LONG).show();
                        }
                    if (marker.equals(KARN)){
                        imageButton28.setVisibility(View.VISIBLE);
                        imageButton27.setVisibility(View.INVISIBLE);
                        imageButton26.setVisibility(View.INVISIBLE);
                        imageButton25.setVisibility(View.INVISIBLE);
                        imageButton24.setVisibility(View.INVISIBLE);
                        imageButton23.setVisibility(View.INVISIBLE);
                        imageButton22.setVisibility(View.INVISIBLE);
                        imageButton21.setVisibility(View.INVISIBLE);
                        imageButton20.setVisibility(View.INVISIBLE);
                        imageButton19.setVisibility(View.INVISIBLE);
                        imageButton18.setVisibility(View.INVISIBLE);
                        imageButton17.setVisibility(View.INVISIBLE);
                        imageButton16.setVisibility(View.INVISIBLE);
                        imageButton15.setVisibility(View.INVISIBLE);
                        imageButton14.setVisibility(View.INVISIBLE);
                        imageButton13.setVisibility(View.INVISIBLE);
                        imageButton12.setVisibility(View.INVISIBLE);
                        imageButton11.setVisibility(View.INVISIBLE);
                        imageButton10.setVisibility(View.INVISIBLE);
                        imageButton9.setVisibility(View.INVISIBLE);
                        imageButton8.setVisibility(View.INVISIBLE);
                        imageButton7.setVisibility(View.INVISIBLE);
                        imageButton6.setVisibility(View.INVISIBLE);
                        imageButton5.setVisibility(View.INVISIBLE);
                        imageButton4.setVisibility(View.INVISIBLE);
                        imageButton3.setVisibility(View.INVISIBLE);
                        mainButton.setVisibility(View.INVISIBLE);
                        imageButton29.setVisibility(View.INVISIBLE);
                        imageButton30.setVisibility(View.INVISIBLE);
                        imageButton31.setVisibility(View.INVISIBLE);
                        imageButton32.setVisibility(View.INVISIBLE);
                        imageButton33.setVisibility(View.INVISIBLE);
                        imageButton34.setVisibility(View.INVISIBLE);

                        KARN.showInfoWindow();
                        Toast.makeText(MapsActivity.this, "Click button to open video อาคารกาจณาภิเษก",
                                Toast.LENGTH_LONG).show();
                    }
                    if (marker.equals(STAR)){
                        imageButton29.setVisibility(View.VISIBLE);
                        imageButton28.setVisibility(View.INVISIBLE);
                        imageButton27.setVisibility(View.INVISIBLE);
                        imageButton26.setVisibility(View.INVISIBLE);
                        imageButton25.setVisibility(View.INVISIBLE);
                        imageButton24.setVisibility(View.INVISIBLE);
                        imageButton23.setVisibility(View.INVISIBLE);
                        imageButton22.setVisibility(View.INVISIBLE);
                        imageButton21.setVisibility(View.INVISIBLE);
                        imageButton20.setVisibility(View.INVISIBLE);
                        imageButton19.setVisibility(View.INVISIBLE);
                        imageButton18.setVisibility(View.INVISIBLE);
                        imageButton17.setVisibility(View.INVISIBLE);
                        imageButton16.setVisibility(View.INVISIBLE);
                        imageButton15.setVisibility(View.INVISIBLE);
                        imageButton14.setVisibility(View.INVISIBLE);
                        imageButton13.setVisibility(View.INVISIBLE);
                        imageButton12.setVisibility(View.INVISIBLE);
                        imageButton11.setVisibility(View.INVISIBLE);
                        imageButton10.setVisibility(View.INVISIBLE);
                        imageButton9.setVisibility(View.INVISIBLE);
                        imageButton8.setVisibility(View.INVISIBLE);
                        imageButton7.setVisibility(View.INVISIBLE);
                        imageButton6.setVisibility(View.INVISIBLE);
                        imageButton5.setVisibility(View.INVISIBLE);
                        imageButton4.setVisibility(View.INVISIBLE);
                        imageButton3.setVisibility(View.INVISIBLE);
                        mainButton.setVisibility(View.INVISIBLE);
                        imageButton30.setVisibility(View.INVISIBLE);
                        imageButton31.setVisibility(View.INVISIBLE);
                        imageButton32.setVisibility(View.INVISIBLE);
                        imageButton33.setVisibility(View.INVISIBLE);
                        imageButton34.setVisibility(View.INVISIBLE);


                        STAR.showInfoWindow();
                        Toast.makeText(MapsActivity.this, "Click button to open video หอดูดาว",
                                Toast.LENGTH_LONG).show();

                    }
                    if (marker.equals(HOSPITAL)){
                        imageButton30.setVisibility(View.VISIBLE);
                        imageButton29.setVisibility(View.INVISIBLE);
                        imageButton28.setVisibility(View.INVISIBLE);
                        imageButton27.setVisibility(View.INVISIBLE);
                        imageButton26.setVisibility(View.INVISIBLE);
                        imageButton25.setVisibility(View.INVISIBLE);
                        imageButton24.setVisibility(View.INVISIBLE);
                        imageButton23.setVisibility(View.INVISIBLE);
                        imageButton22.setVisibility(View.INVISIBLE);
                        imageButton21.setVisibility(View.INVISIBLE);
                        imageButton20.setVisibility(View.INVISIBLE);
                        imageButton19.setVisibility(View.INVISIBLE);
                        imageButton18.setVisibility(View.INVISIBLE);
                        imageButton17.setVisibility(View.INVISIBLE);
                        imageButton16.setVisibility(View.INVISIBLE);
                        imageButton15.setVisibility(View.INVISIBLE);
                        imageButton14.setVisibility(View.INVISIBLE);
                        imageButton13.setVisibility(View.INVISIBLE);
                        imageButton12.setVisibility(View.INVISIBLE);
                        imageButton11.setVisibility(View.INVISIBLE);
                        imageButton10.setVisibility(View.INVISIBLE);
                        imageButton9.setVisibility(View.INVISIBLE);
                        imageButton8.setVisibility(View.INVISIBLE);
                        imageButton7.setVisibility(View.INVISIBLE);
                        imageButton6.setVisibility(View.INVISIBLE);
                        imageButton5.setVisibility(View.INVISIBLE);
                        imageButton4.setVisibility(View.INVISIBLE);
                        imageButton3.setVisibility(View.INVISIBLE);
                        mainButton.setVisibility(View.INVISIBLE);
                        imageButton31.setVisibility(View.INVISIBLE);
                        imageButton32.setVisibility(View.INVISIBLE);
                        imageButton33.setVisibility(View.INVISIBLE);
                        imageButton34.setVisibility(View.INVISIBLE);

                        HOSPITAL.showInfoWindow();
                        Toast.makeText(MapsActivity.this, "Click button to open video โรงพยาบาลมหาวิทยาลัยเทคโนโลยีสุรนารี",
                                Toast.LENGTH_LONG).show();

                    }
                    if (marker.equals(HOTEL)){
                        imageButton31.setVisibility(View.VISIBLE);
                        imageButton30.setVisibility(View.INVISIBLE);
                        imageButton29.setVisibility(View.INVISIBLE);
                        imageButton28.setVisibility(View.INVISIBLE);
                        imageButton27.setVisibility(View.INVISIBLE);
                        imageButton26.setVisibility(View.INVISIBLE);
                        imageButton25.setVisibility(View.INVISIBLE);
                        imageButton24.setVisibility(View.INVISIBLE);
                        imageButton23.setVisibility(View.INVISIBLE);
                        imageButton22.setVisibility(View.INVISIBLE);
                        imageButton21.setVisibility(View.INVISIBLE);
                        imageButton20.setVisibility(View.INVISIBLE);
                        imageButton19.setVisibility(View.INVISIBLE);
                        imageButton18.setVisibility(View.INVISIBLE);
                        imageButton17.setVisibility(View.INVISIBLE);
                        imageButton16.setVisibility(View.INVISIBLE);
                        imageButton15.setVisibility(View.INVISIBLE);
                        imageButton14.setVisibility(View.INVISIBLE);
                        imageButton13.setVisibility(View.INVISIBLE);
                        imageButton12.setVisibility(View.INVISIBLE);
                        imageButton11.setVisibility(View.INVISIBLE);
                        imageButton10.setVisibility(View.INVISIBLE);
                        imageButton9.setVisibility(View.INVISIBLE);
                        imageButton8.setVisibility(View.INVISIBLE);
                        imageButton7.setVisibility(View.INVISIBLE);
                        imageButton6.setVisibility(View.INVISIBLE);
                        imageButton5.setVisibility(View.INVISIBLE);
                        imageButton4.setVisibility(View.INVISIBLE);
                        imageButton3.setVisibility(View.INVISIBLE);
                        mainButton.setVisibility(View.INVISIBLE);
                        imageButton32.setVisibility(View.INVISIBLE);
                        imageButton33.setVisibility(View.INVISIBLE);
                        imageButton34.setVisibility(View.INVISIBLE);


                        HOTEL.showInfoWindow();
                        Toast.makeText(MapsActivity.this, "Click button to open video โรงแรมสุรสัมนาคาร",
                                Toast.LENGTH_LONG).show();

                    }
                    if(marker.equals(TRANSPORT)){
                        imageButton32.setVisibility(View.VISIBLE);
                        imageButton31.setVisibility(View.INVISIBLE);
                        imageButton30.setVisibility(View.INVISIBLE);
                        imageButton29.setVisibility(View.INVISIBLE);
                        imageButton28.setVisibility(View.INVISIBLE);
                        imageButton27.setVisibility(View.INVISIBLE);
                        imageButton26.setVisibility(View.INVISIBLE);
                        imageButton25.setVisibility(View.INVISIBLE);
                        imageButton24.setVisibility(View.INVISIBLE);
                        imageButton23.setVisibility(View.INVISIBLE);
                        imageButton22.setVisibility(View.INVISIBLE);
                        imageButton21.setVisibility(View.INVISIBLE);
                        imageButton20.setVisibility(View.INVISIBLE);
                        imageButton19.setVisibility(View.INVISIBLE);
                        imageButton18.setVisibility(View.INVISIBLE);
                        imageButton17.setVisibility(View.INVISIBLE);
                        imageButton16.setVisibility(View.INVISIBLE);
                        imageButton15.setVisibility(View.INVISIBLE);
                        imageButton14.setVisibility(View.INVISIBLE);
                        imageButton13.setVisibility(View.INVISIBLE);
                        imageButton12.setVisibility(View.INVISIBLE);
                        imageButton11.setVisibility(View.INVISIBLE);
                        imageButton10.setVisibility(View.INVISIBLE);
                        imageButton9.setVisibility(View.INVISIBLE);
                        imageButton8.setVisibility(View.INVISIBLE);
                        imageButton7.setVisibility(View.INVISIBLE);
                        imageButton6.setVisibility(View.INVISIBLE);
                        imageButton5.setVisibility(View.INVISIBLE);
                        imageButton4.setVisibility(View.INVISIBLE);
                        imageButton3.setVisibility(View.INVISIBLE);
                        mainButton.setVisibility(View.INVISIBLE);
                        imageButton33.setVisibility(View.INVISIBLE);
                        imageButton34.setVisibility(View.INVISIBLE);

                        TRANSPORT.showInfoWindow();
                        Toast.makeText(MapsActivity.this, "Click button to open video อาคารขนส่ง",
                                Toast.LENGTH_LONG).show();
                    }
                    if(marker.equals(SINCROTON)){
                        imageButton33.setVisibility(View.VISIBLE);
                        imageButton32.setVisibility(View.INVISIBLE);
                        imageButton31.setVisibility(View.INVISIBLE);
                        imageButton30.setVisibility(View.INVISIBLE);
                        imageButton29.setVisibility(View.INVISIBLE);
                        imageButton28.setVisibility(View.INVISIBLE);
                        imageButton27.setVisibility(View.INVISIBLE);
                        imageButton26.setVisibility(View.INVISIBLE);
                        imageButton25.setVisibility(View.INVISIBLE);
                        imageButton24.setVisibility(View.INVISIBLE);
                        imageButton23.setVisibility(View.INVISIBLE);
                        imageButton22.setVisibility(View.INVISIBLE);
                        imageButton21.setVisibility(View.INVISIBLE);
                        imageButton20.setVisibility(View.INVISIBLE);
                        imageButton19.setVisibility(View.INVISIBLE);
                        imageButton18.setVisibility(View.INVISIBLE);
                        imageButton17.setVisibility(View.INVISIBLE);
                        imageButton16.setVisibility(View.INVISIBLE);
                        imageButton15.setVisibility(View.INVISIBLE);
                        imageButton14.setVisibility(View.INVISIBLE);
                        imageButton13.setVisibility(View.INVISIBLE);
                        imageButton12.setVisibility(View.INVISIBLE);
                        imageButton11.setVisibility(View.INVISIBLE);
                        imageButton10.setVisibility(View.INVISIBLE);
                        imageButton9.setVisibility(View.INVISIBLE);
                        imageButton8.setVisibility(View.INVISIBLE);
                        imageButton7.setVisibility(View.INVISIBLE);
                        imageButton6.setVisibility(View.INVISIBLE);
                        imageButton5.setVisibility(View.INVISIBLE);
                        imageButton4.setVisibility(View.INVISIBLE);
                        imageButton3.setVisibility(View.INVISIBLE);
                        mainButton.setVisibility(View.INVISIBLE);
                        imageButton34.setVisibility(View.INVISIBLE);

                        SINCROTON.showInfoWindow();
                        Toast.makeText(MapsActivity.this, "Click button to open video สถาบันวิจัยเเสงซินโครตอน",
                                Toast.LENGTH_LONG).show();
                    }
                    if(marker.equals(TRAFIC)){
                        imageButton34.setVisibility(View.VISIBLE);
                        imageButton33.setVisibility(View.INVISIBLE);
                        imageButton32.setVisibility(View.INVISIBLE);
                        imageButton31.setVisibility(View.INVISIBLE);
                        imageButton30.setVisibility(View.INVISIBLE);
                        imageButton29.setVisibility(View.INVISIBLE);
                        imageButton28.setVisibility(View.INVISIBLE);
                        imageButton27.setVisibility(View.INVISIBLE);
                        imageButton26.setVisibility(View.INVISIBLE);
                        imageButton25.setVisibility(View.INVISIBLE);
                        imageButton24.setVisibility(View.INVISIBLE);
                        imageButton23.setVisibility(View.INVISIBLE);
                        imageButton22.setVisibility(View.INVISIBLE);
                        imageButton21.setVisibility(View.INVISIBLE);
                        imageButton20.setVisibility(View.INVISIBLE);
                        imageButton19.setVisibility(View.INVISIBLE);
                        imageButton18.setVisibility(View.INVISIBLE);
                        imageButton17.setVisibility(View.INVISIBLE);
                        imageButton16.setVisibility(View.INVISIBLE);
                        imageButton15.setVisibility(View.INVISIBLE);
                        imageButton14.setVisibility(View.INVISIBLE);
                        imageButton13.setVisibility(View.INVISIBLE);
                        imageButton12.setVisibility(View.INVISIBLE);
                        imageButton11.setVisibility(View.INVISIBLE);
                        imageButton10.setVisibility(View.INVISIBLE);
                        imageButton9.setVisibility(View.INVISIBLE);
                        imageButton8.setVisibility(View.INVISIBLE);
                        imageButton7.setVisibility(View.INVISIBLE);
                        imageButton6.setVisibility(View.INVISIBLE);
                        imageButton5.setVisibility(View.INVISIBLE);
                        imageButton4.setVisibility(View.INVISIBLE);
                        imageButton3.setVisibility(View.INVISIBLE);
                        mainButton.setVisibility(View.INVISIBLE);

                        TRAFIC.showInfoWindow();

                        Toast.makeText(MapsActivity.this, "Click button to open video เมืองจราจรจำลอง",
                                Toast.LENGTH_LONG).show();
                    }
                   return true;
             }
          });

        }

        float wide = 350;
        float height = 340;

        float w = 130;
        float h = 130;


        LatLng NEWARK = new LatLng(14.878891, 102.016291);

        GroundOverlayOptions newarkMap = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.library))
                .position(NEWARK, w, h);
        mMap.addGroundOverlay(newarkMap);


        LatLng building_1 = new LatLng(14.881554, 102.016575);

        GroundOverlayOptions building1 = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.building1))
                .position(building_1, w, h);
        mMap.addGroundOverlay(building1);



        LatLng building_2 = new LatLng(14.881855, 102.014976);

        GroundOverlayOptions building2 = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.studybuilding2))
                .position(building_2, w, h);
        mMap.addGroundOverlay(building2);



        LatLng kitjakarn = new LatLng(14.884681, 102.015506);

        GroundOverlayOptions activity_student = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.kitjakarn))
                .position(kitjakarn, w, h);
        mMap.addGroundOverlay(activity_student);



        LatLng SURARENGCHAI = new LatLng(14.886108, 102.017716);

        GroundOverlayOptions surarengchai = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.surareanchai))
                .position(SURARENGCHAI, w, h);
        mMap.addGroundOverlay(surarengchai);


        LatLng SPORT_CENTER = new LatLng(14.88689, 102.01518);

        GroundOverlayOptions sport_center = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.sportcenter))
                .position(SPORT_CENTER, w, h);
        mMap.addGroundOverlay(sport_center);


        LatLng TOOL_1 = new LatLng (14.877858, 102.017595);

        GroundOverlayOptions tool_1 = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.f1))
                .position(TOOL_1, w, h);
        mMap.addGroundOverlay(tool_1);



        LatLng TOOL_2 = new LatLng (14.876975, 102.018098);

        GroundOverlayOptions tool_2 = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.f2))
                .position(TOOL_2, w, h);
        mMap.addGroundOverlay(tool_2);









        LatLng TOOL_3 = new LatLng(14.87621, 102.01876);

        GroundOverlayOptions tool_3 = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.f3))
                .position(TOOL_3, w, h);
        mMap.addGroundOverlay(tool_3);


        LatLng TOOL_4 = new LatLng(14.87721, 102.01627);

        GroundOverlayOptions tool_4 = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.f4))
                .position(TOOL_4, w, h);
        mMap.addGroundOverlay(tool_4);



        LatLng TOOL_5 = new LatLng(14.87634, 102.01694);

        GroundOverlayOptions tool_5 = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.f5))
                .position(TOOL_5, w, h);
        mMap.addGroundOverlay(tool_5);

        LatLng TOOL_6 = new LatLng(14.87544, 102.01761);

        GroundOverlayOptions tool_6 = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.f6))
                .position(TOOL_6, w, h);
        mMap.addGroundOverlay(tool_6);

        LatLng FARM = new LatLng(14.890170, 102.004617);

        GroundOverlayOptions FA = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.farm))
                .position(FARM, w, h);
        mMap.addGroundOverlay(FA);


        LatLng ANIMAL = new LatLng(14.888717, 102.004639);

        GroundOverlayOptions animal = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.animal))
                .position(ANIMAL, w, h);
        mMap.addGroundOverlay(animal);


        LatLng FARM_FLOWER = new LatLng(14.892119, 102.005486);

        GroundOverlayOptions farm_flower = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.farmflower))
                .position(FARM_FLOWER, w, h);
        mMap.addGroundOverlay(farm_flower);

        LatLng TREE_R1 = new LatLng(14.887256, 102.005733);

        GroundOverlayOptions tree_r1 = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.treer_1))
                .position(TREE_R1, w, h);
        mMap.addGroundOverlay(tree_r1);

        LatLng TREE_R2 = new LatLng(14.887215, 102.004649);

        GroundOverlayOptions tree_r2 = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.treer_2))
                .position(TREE_R2, w, h);
        mMap.addGroundOverlay(tree_r2);

        LatLng SUN_FLOWER = new LatLng(14.893425, 102.007160);

        GroundOverlayOptions sun_flower = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.sunflower))
                .position(SUN_FLOWER, w, h);
        mMap.addGroundOverlay(sun_flower);


        LatLng VICHARKARN_1 = new LatLng(14.878742, 102.018703);

        GroundOverlayOptions vicharkarn_1 = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.vicharkarn1))
                .position(VICHARKARN_1, w, h);
        mMap.addGroundOverlay(vicharkarn_1);

        LatLng VICHARKARN_2 = new LatLng(14.879616, 102.019868);

        GroundOverlayOptions vicharkarn_2 = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.vicharkarn2))
                .position(VICHARKARN_2, w, h);
        mMap.addGroundOverlay(vicharkarn_2);



        LatLng A_BUILDING = new LatLng(14.880497, 102.020936);

        GroundOverlayOptions a_building = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.director))
                .position(A_BUILDING, w, h);
        mMap.addGroundOverlay(a_building);

        LatLng COM_CENTER = new LatLng(14.877739, 102.019425);

        GroundOverlayOptions com_center = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.com_center))
                .position(COM_CENTER, w, h);
        mMap.addGroundOverlay(com_center);

        LatLng CANTEEN_CENTER = new LatLng(14.876847, 102.020133);

        GroundOverlayOptions canteen_center = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.canteen))
                .position(CANTEEN_CENTER, w, h);
        mMap.addGroundOverlay(canteen_center);

        LatLng SURAPAT_ONE = new LatLng(14.876353, 102.022526);

        GroundOverlayOptions surapat_one = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.surapat1))
                .position(SURAPAT_ONE, w, h);
        mMap.addGroundOverlay(surapat_one);

        LatLng SURAPAT_TWO = new LatLng(14.874476, 102.023738);

        GroundOverlayOptions surapat_two = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.surapat2))
                .position(SURAPAT_TWO, w, h);
        mMap.addGroundOverlay(surapat_two);

        LatLng HOR_SURANAPA = new LatLng(14.872998, 102.023689);

        GroundOverlayOptions hor_suranapa = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.horsuranapa))
                .position(HOR_SURANAPA, w, h);
        mMap.addGroundOverlay(hor_suranapa);



        LatLng F7_Building = new LatLng(14.874905, 102.021026);

        GroundOverlayOptions f7_buildung = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.f7))
                .position(F7_Building, w, h);
        mMap.addGroundOverlay(f7_buildung);


        LatLng BUTTER_FLY = new LatLng(14.870852, 102.022868);

        GroundOverlayOptions butterfly = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.butterfly))
                .position(BUTTER_FLY, w, h);
        mMap.addGroundOverlay(butterfly);

        LatLng MUSEUM_THAI = new LatLng(14.871021, 102.023604);

        GroundOverlayOptions museum_thai = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.museum))
                .position(MUSEUM_THAI, w, h);
        mMap.addGroundOverlay(museum_thai);

        LatLng Flag_F = new LatLng(14.882408, 102.020789);

        GroundOverlayOptions flag_f = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.flag))
                .position(Flag_F, w, h);
        mMap.addGroundOverlay(flag_f);

        LatLng YAMO_SIGN = new LatLng(14.880822, 102.018461);

        GroundOverlayOptions yamo_sign = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.yamo))
                .position(YAMO_SIGN, w, h);
        mMap.addGroundOverlay(yamo_sign);

        LatLng AMPHITEATHER = new LatLng(14.872006, 102.024499);

        GroundOverlayOptions amphiteather = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.amphi))
                .position(AMPHITEATHER, w, h);
        mMap.addGroundOverlay(amphiteather);

        LatLng KARNJANA = new LatLng(14.873261, 102.026355);

        GroundOverlayOptions karnjana = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.kanchanapisak))
                .position(KARNJANA, w, h);
        mMap.addGroundOverlay(karnjana);

        LatLng STAR_BUILDING = new LatLng(14.874173, 102.028136);

        GroundOverlayOptions star= new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.star))
                .position(STAR_BUILDING, w, h);
        mMap.addGroundOverlay(star);

        LatLng HOSPITAL_SUT = new LatLng(14.864226, 102.035625);

        GroundOverlayOptions hospital= new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.hopital))
                .position(HOSPITAL_SUT, w, h);
        mMap.addGroundOverlay(hospital);

        LatLng HOTEL_SUT = new LatLng(14.876963, 102.025626);

        GroundOverlayOptions hotel_sut= new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.hotel))
                .position(HOTEL_SUT, w, h);
        mMap.addGroundOverlay(hotel_sut);

        LatLng STRNASPORT_SUT = new LatLng(14.877603, 102.021248);

        GroundOverlayOptions stransport_sut= new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.transport))
                .position(STRNASPORT_SUT, w, h);
        mMap.addGroundOverlay(stransport_sut);

        LatLng SINCROTRON_sut = new LatLng(14.873274, 102.021999);

        GroundOverlayOptions sincroton_sut = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.sincroton))
                .position(SINCROTRON_sut, w, h);
        mMap.addGroundOverlay(sincroton_sut);

        LatLng TRAFIC_SUT = new LatLng(14.872476, 102.021007);

        GroundOverlayOptions trafic = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.trafic))
                .position(TRAFIC_SUT, w, h);
        mMap.addGroundOverlay(trafic);




    }






   @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;




    }

//-----------------Intent to video F1---------------------------------------------//
    public void sentTovideo(View v){
        Intent intent =  new Intent(MapsActivity.this,Main2Activity.class);
        startActivity(intent);
    }

    public void sendToVideo_one(View v){
        Intent intent = new Intent(MapsActivity.this,Video_one.class);
        startActivity(intent);
    }
    public void sendToVideo_two(View v){
        Intent intent = new Intent(MapsActivity.this,F3_Video.class);
        startActivity(intent);
    }
    public void sendToVideo_three(View v){
        Intent intent = new Intent(MapsActivity.this,F4_Video.class);
        startActivity(intent);

    }
    public void sendToVideo_four(View v){
        Intent intent = new Intent(MapsActivity.this,F5_Video.class);
        startActivity(intent);
    }
    public void sendToVideo_five(View v){
        Intent intent = new Intent(MapsActivity.this,F6_Video.class);
        startActivity(intent);
    }
    public void sendToLibrary(View v){
        Intent intent= new Intent(MapsActivity.this, com.example.sudsangdoaw.sutvirtour.Library.class);
        startActivity(intent);
    }
    public void sendTobuilding1(View v){
        Intent intent = new Intent(MapsActivity.this,Study_Building1.class);
        startActivity(intent);
    }
    public void sendToActivity_student(View v){
        Intent intent = new Intent(MapsActivity.this,Student_Activity.class);
        startActivity(intent);
    }
    public void sentToSuraSport(View v){
        Intent intent = new Intent(MapsActivity.this,Sura_Sport.class);
        startActivity(intent);
    }
    public void sendToSportCenter(View v){
        Intent intent = new Intent(MapsActivity.this,Sport_center.class);
        startActivity(intent);
    }
    public void sendToFarm(View v){
        Intent farm = new Intent(MapsActivity.this,Farm_Video.class);
        startActivity(farm);
    }
    public void sendToSuranapa(View v){
        Intent suranapa = new Intent(MapsActivity.this,Suranapa_Video.class);
        startActivity(suranapa);
    }
    public void sendToHospital(View v){
        Intent hospital = new Intent(MapsActivity.this,Hospital_Video.class);
        startActivity(hospital);
    }
    public void sendToYamo(View v){
        Intent yamo = new Intent(MapsActivity.this,Yamo_Video.class);
        startActivity(yamo);
    }
    public void sendToStudyBuilding_2(View v){
        Intent i = new Intent(MapsActivity.this,Building2.class);
        startActivity(i);
    }
    public void sendToFlag(View v){
        Intent i = new Intent(MapsActivity.this, com.example.sudsangdoaw.sutvirtour.Flag.class);
        startActivity(i);
    }
    public void sendToBuilding_c_1(View v){
        Intent i = new Intent(MapsActivity.this,Building_C.class);
        startActivity(i);
    }
    public void sendToBuilding_c_2(View v){
        Intent i = new Intent(MapsActivity.this,Building_C.class);
        startActivity(i);
    }
    public void sendToBuilding_a(View v){
        Intent a = new Intent(MapsActivity.this, com.example.sudsangdoaw.sutvirtour.Building_A.class);
        startActivity(a);
    }
    public void sendToHotel(View v){
        Intent i = new Intent(MapsActivity.this, com.example.sudsangdoaw.sutvirtour.Hotel.class);
        startActivity(i);
    }
    public void sendToBus(View v){
        Intent i = new Intent(MapsActivity.this, com.example.sudsangdoaw.sutvirtour.Transport.class);
        startActivity(i);
    }


}
