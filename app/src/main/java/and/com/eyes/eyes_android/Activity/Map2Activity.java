package and.com.eyes.eyes_android.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

import java.io.IOException;

import and.com.eyes.eyes_android.Model.LocationVO;
import and.com.eyes.eyes_android.Network.RetrofitClient;
import and.com.eyes.eyes_android.R;
import and.com.eyes.eyes_android.Utils.GpsInfo;
import and.com.eyes.eyes_android.Utils.PatientManager;
import retrofit2.Call;


public class Map2Activity extends Activity {
    private MapView mapView;
    private MapPoint startPoint;
    private MapPoint endPoint;
    private GpsInfo gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map2);

        mapView=new MapView(this);
        mapView.setDaumMapApiKey("525341d4a643ee64ec4766d561a2bd43");
        RelativeLayout container=(RelativeLayout)findViewById(R.id.map_view);
        container.addView(mapView);

        gps = new GpsInfo(this);
        // GPS 사용유무 가져오기
        if (gps.isGetLocation()) {
            startPoint = MapPoint.mapPointWithGeoCoord(gps.getLatitude(), gps.getLongitude());
        } else {
            startPoint = MapPoint.mapPointWithGeoCoord(36.5655455, 127.01013969999997);
            gps.showSettingsAlert();

        }

        setMapDefault();
    }

    private void setMapDefault() {
        if(PatientManager.getInstance().getPatientVO()!= null){
            requestLocation();
        }else{
            endPoint = MapPoint.mapPointWithGeoCoord(37.527346, 127.02735499999994);
        }
        // 중심점 변경
        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(37.53737528, 127.00557633), true);
        // 줌 레벨 변경
        mapView.setZoomLevel(7, true);
        mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(33.41, 126.52), 9, true);
        mapView.zoomIn(true);
        mapView.zoomOut(true);
    }

    private void requestLocation(){
        String patientId = PatientManager.getInstance().getPatientVO().getPatientId();
        Call<LocationVO> call = RetrofitClient.getInstance().getService().getLocation(patientId);
        try {
            LocationVO locationVO = call.execute().body();
            endPoint = MapPoint.mapPointWithGeoCoord(locationVO.getLatitude(), locationVO.getLongitude());
        } catch (IOException e) {
            endPoint = MapPoint.mapPointWithGeoCoord(37.527346, 127.02735499999994);
        }
    }

}
