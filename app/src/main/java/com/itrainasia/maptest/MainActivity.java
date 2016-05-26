package com.itrainasia.maptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private final LatLng LOCATION_MALAYSIA = new LatLng(3.161647, 101.716924);
    private final LatLng LOCATION_KUALA_LUMPUR = new LatLng(3.161647,
            101.716924);
    private final LatLng LOCATION_ITRAIN = new LatLng(3.161647, 101.716924);
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }
    public void onClickMalayisa(View v) {
		/*
		 * Set the Map type Normal and use Camera Update to get zooming as set
		 * here 5
		 */
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(
                LOCATION_MALAYSIA, 5);
        map.animateCamera(update);

    }

	/*
	 * Set the Map type Terrain and use Camera Update to get zooming as set here
	 * 9
	 */

    public void onClickKualaLumpur(View v) {
        map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(
                LOCATION_KUALA_LUMPUR, 9);
        map.animateCamera(update);
    }


	/*
	 * Set the Map type Satellite and use Camera Update to get zooming as set
	 * here 16
	 */

    public void onClickItrain(View v) {
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(
                LOCATION_ITRAIN, 16);
        map.animateCamera(update);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.addMarker(new MarkerOptions().position(LOCATION_ITRAIN)
                .title("iTrain").snippet("We Train Hard Core Heros!"));
    }
}
