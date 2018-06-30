package and.com.eyes.eyes_android.Activity;

/* Map Activities with Google Maps
public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {
    private LatLng startLatLng = new LatLng(36.5655455, 127.01013969999997);
    private LatLng endLatLng = new LatLng(37.527346, 127.02735499999994);

    //polyline 설정
    // 구글 맵 참조변수 생성
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path);

        // SupportMapFragment을 통해 레이아웃에 만든 fragment의 ID를 참조하고 구글맵을 호출한다.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this); // getMapAsync must be called on the main thread.
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // 구글 맵 객체를 불러온다.
        mMap = googleMap;

        // 구글 맵에 표시할 마커에 대한 옵션 설정
        MarkerOptions makerOptions = new MarkerOptions();
        makerOptions
                .position(startLatLng)
                .title("원하는 위치(위도, 경도)에 마커를 표시했습니다.");

        mMap.addPolyline(new PolylineOptions().add(startLatLng, endLatLng).width(10).color(Color.RED));
        // 마커를 생성한다.
        mMap.addMarker(makerOptions);

        CameraPosition cameraPosition = new CameraPosition.Builder().target(startLatLng).zoom(15).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        //카메라를 서울 위치로 옮긴다.
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(startLatLng));
    }

}
*/