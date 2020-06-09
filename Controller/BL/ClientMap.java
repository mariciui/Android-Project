/**
 * clasa responsabila cu fereastra hartilor
 */

package com.example.bookgo.Controller.BL;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.example.bookgo.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ClientMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng Zalau = new LatLng(47.193068, 23.063369);
        mMap.addMarker(new MarkerOptions().position(Zalau).title("Marker in Zalau"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Zalau));

        LatLng Cluj = new LatLng(46.789412, 23.600709);
        mMap.addMarker(new MarkerOptions().position(Cluj).title("Marker in Cluj"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Cluj));

        LatLng Medias = new LatLng(46.165585, 24.358062);
        mMap.addMarker(new MarkerOptions().position(Medias).title("Marker in Medias"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Medias));

        LatLng Micasasa = new LatLng(46.089084, 24.111085);
        mMap.addMarker(new MarkerOptions().position(Micasasa).title("Marker in Micasasa"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Micasasa));
    }
}
