package com.example.sudsangdoaw.sutvirtour;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.Image;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.location.Address;
import android.location.Geocoder;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.IOException;
import java.util.List;

public class Map_Direction extends FragmentActivity {


    private ImageButton btnRequestDirection;
    private GoogleMap googleMap;
    private String serverKey = " AIzaSyArMuTCkaZe1tvlGK-s-xTtrvUjnLMMUM0";
    private LatLng camera = new LatLng(37.782437, -122.4281893);
    private LatLng origin = new LatLng(37.7849569, -122.4068855);
    private LatLng destination = new LatLng(37.7814432, -122.4460177);
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
    private static final LatLng Hotel = new LatLng(14.874173, 102.028136);
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map__direction);
        setUpMapIfNeeded();

        mMap.moveCamera((CameraUpdateFactory.newLatLngZoom(Study_Building_one, 5)));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16), 2000, null);

        mMap.setInfoWindowAdapter(new BalloonAdapter(getLayoutInflater()));
        final Marker m = mMap.addMarker(new MarkerOptions().position(F_1).title("อาคารเครื่องมือ 1")
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
        final Marker museum = mMap.addMarker(new MarkerOptions().position(MUSEUM).title("พิพิธพันธ์เทคโนโลยีไทยโบราณ")
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





    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }


    public void onSearch(View view) {
        EditText location_tf = (EditText) findViewById(R.id.TFaddress);
        String location = location_tf.getText().toString();
        List<Address> addressList = null;
        if (location != null || !location.equals("")) {
            Geocoder geocoder = new Geocoder(this);
            try {
                addressList = geocoder.getFromLocationName(location, 1);


            } catch (IOException e) {
                e.printStackTrace();
            }

            Address address = addressList.get(0);
            LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
            mMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));

        }
    }

    public void onZoom(View view) {
        if (view.getId() == R.id.Bzoomin) {
            mMap.animateCamera(CameraUpdateFactory.zoomIn());
        }
        if (view.getId() == R.id.Bzoomout) {
            mMap.animateCamera(CameraUpdateFactory.zoomOut());
        }
    }

    public void changeType(View view) {
        if (mMap.getMapType() == GoogleMap.MAP_TYPE_NORMAL) {
            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        } else
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        mMap.setMyLocationEnabled(true);


    }
}
