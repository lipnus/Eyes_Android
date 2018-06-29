package and.com.eyes.eyes_android.Activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

import and.com.eyes.eyes_android.Model.PatientVO;
import and.com.eyes.eyes_android.Network.RetrofitClient;
import and.com.eyes.eyes_android.R;
import and.com.eyes.eyes_android.Utils.DLog;
import and.com.eyes.eyes_android.databinding.ActivityMainBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends Activity {

    private ActivityMainBinding binding;
    private PatientVO patientVO;
    private final int PICK_IMAGE = 1;
    private ProgressDialog detectionProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setActivity(this);
    }



        /*
        binding.btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itReg = new Intent(MainActivity.this, PhotoEnrollActivity.class);
                overridePendingTransition(0,0);
                startActivity(itReg);
                finish();
            }
        });
        binding.btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itCall = new Intent(MainActivity.this, CalActivity.class);
                overridePendingTransition(0,0);
                startActivity(itCall);
                finish();
            }
        });
        binding.btnHis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itHis = new Intent(MainActivity.this, HistoryActivity.class);
                overridePendingTransition(0,0);
                startActivity(itHis);
                finish();
            }
        });
        binding.btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itMain = new Intent(MainActivity.this, MainActivity.class);
                overridePendingTransition(0,0);
                startActivity(itMain);
                finish();
            }
        });
        */


}
