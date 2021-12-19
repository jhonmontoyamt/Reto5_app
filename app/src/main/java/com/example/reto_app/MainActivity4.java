package com.example.reto_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.osmdroid.config.Configuration;
import org.osmdroid.library.BuildConfig;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {

    ArrayList<OverlayItem> puntos = new ArrayList<OverlayItem>();
    private MapView myOpenMapView;
    private MapController myMapController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        /* ---- necesitamos establecer el valor del agente de usuario en la configuración ------- */
        //pre 5.6
        //OpenStreetMapTileProviderConstants.setUserAgentValue(BuildConfig.APPLICATION_ID);
        //5.6 and newer
        Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);
        /* -------------------------------------------------------------------------------------- */

        /*   punto de geolocalizacion de ejemplo */
        GeoPoint Ibague = new GeoPoint(4.4368, -75.2010);
        GeoPoint Ibague1 = new GeoPoint(4.4409, -75.2044);
        GeoPoint Ibague2 = new GeoPoint(4.4451, -75.2051);
        //GeoPoint Madrid = new GeoPoint(40.416775, -3.70379);
        //GeoPoint Sydney = new GeoPoint(5.71666667, -72.92083333);
        //----------------------------------------------------------------------------------

        myOpenMapView = (MapView) findViewById(R.id.openmapview);
        myOpenMapView.setBuiltInZoomControls(true);

        myMapController = (MapController) myOpenMapView.getController();
        myMapController.setCenter(Ibague);
        myMapController.setZoom(15);

        myOpenMapView.setMultiTouchControls(true);
        puntos.add(new OverlayItem("Ibague", "Centro comercial Multicentro", Ibague));
        puntos.add(new OverlayItem("Ibague", "Centro comercial Acqua", Ibague1));
        puntos.add(new OverlayItem("Ibague", "Centro comercial la Estacion", Ibague2));
        refrescaPuntos();
    }




    ItemizedIconOverlay.OnItemGestureListener<OverlayItem> tap = new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
        @Override
        public boolean onItemLongPress(int arg0, OverlayItem arg1) {
            return false;
        }
        @Override
        public boolean onItemSingleTapUp(int index, OverlayItem item) {
            return true;
        }
    };
    private void refrescaPuntos() {
        myOpenMapView.getOverlays().clear();
        ItemizedIconOverlay.OnItemGestureListener<OverlayItem> tap = new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
            @Override
            public boolean onItemLongPress(int arg0, OverlayItem arg1) {
                return false;
            }

            @Override
            public boolean onItemSingleTapUp(int index, OverlayItem item) {
                return true;
            }
        };

        ItemizedOverlayWithFocus<OverlayItem> capa = new ItemizedOverlayWithFocus<>(this, puntos, tap);
        capa.setFocusItemsOnTap(true);
        myOpenMapView.getOverlays().add(capa);
    }
}