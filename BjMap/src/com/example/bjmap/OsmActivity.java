package com.example.bjmap;

import org.osmdroid.ResourceProxy;
import org.osmdroid.tileprovider.MapTile;
import org.osmdroid.tileprovider.tilesource.OnlineTileSourceBase;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.PathOverlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.gesture.GestureOverlayView.OnGestureListener;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;


public class OsmActivity extends Activity {
 
	private MapView mMapView;
	private MapController mController;		
	private double[] lats=new double[50];
	private double[] lons=new double[50];
	private String begin;
	private String end;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
				
		setContentView(R.layout.activity_osm);
		//连接地图控件
		mMapView = (MapView) findViewById(R.id.myOSMmapview);	
		//获取地图控制器
		mController = mMapView.getController();
		//引用离线地图资源并设置地图放大级数和图片大小
		mMapView.setTileSource(new OnlineTileSourceBase("Google Maps China",
			ResourceProxy.string.unknown,0, 13, 256, ".png","http://mt3.google.com/vt/v=w2.97"){
			@Override

			public 

			String getTileURLString(MapTile aTile) {

			return getBaseUrl() + "&x=" + aTile.getX() + "&y="+ aTile.getY() + "&z=" + aTile.getZoomLevel();

			}

		});
		//设置启用离线地图
		mMapView.setUseDataConnection(false);	
		
		Intent intent = getIntent();  
		begin=intent.getStringExtra("begin");
		end=intent.getStringExtra("end");
		Bundle nodeinfo=this.getIntent().getExtras();
		lats=nodeinfo.getDoubleArray("lat");
		lons=nodeinfo.getDoubleArray("lon");
		
		mMapView.setBuiltInZoomControls(true);
        mMapView.setMultiTouchControls(true);

        GeoPoint center = new GeoPoint(lats[0], lons[0]);
        mController.setZoom(13); // 先设置缩放，后设置中心点，不然会出现偏差。
        mController.setCenter(center);
        mMapView.setMinZoomLevel(0);
        mMapView.setMaxZoomLevel(16);
        mMapView.computeScroll();
        mMapView.getController();
         
        PathOverlay line = new PathOverlay(Color.BLUE, this); 
        int i=0;
        while(lats[i]!=0){
        	i++;
        	GeoPoint gp = new GeoPoint(lats[i], lons[i]);
        	line.addPoint(gp);
        }
        mMapView.getOverlays().add(line);
	}
		
  


}
