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


    @Override
    protected void onStart() {
        super.onStart();
        getPatient();

    }

    private void getPatient() {
        String userId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

        Call<PatientVO> call = RetrofitClient.getInstance().getService().getPatient(userId);//, patientId);
        call.enqueue(new Callback<PatientVO>() {
            @Override
            public void onResponse(Call<PatientVO> call, Response<PatientVO> response) {
                // you  will get the reponse in the response parameter
                if (response.isSuccessful()) {
                    //Binding으로 PatientVO 설정해줘야함
                } else {
                    DLog.getInstance().e("Main Activity");
                }
            }

            @Override
            public void onFailure(Call<PatientVO> call, Throwable t) {
                DLog.getInstance().e("Main Activity");
            }
        });
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
