package and.com.eyes.eyes_android.Activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.widget.ListView;

import java.util.List;

import and.com.eyes.eyes_android.Model.HistoryItem;
import and.com.eyes.eyes_android.Model.PatientVO;
import and.com.eyes.eyes_android.Network.RetrofitClient;
import and.com.eyes.eyes_android.Network.RetrofitService;
import and.com.eyes.eyes_android.R;
import and.com.eyes.eyes_android.Adaptor.HistoryAdapter;
import and.com.eyes.eyes_android.Utils.DLog;
import and.com.eyes.eyes_android.Utils.PatientManager;
import and.com.eyes.eyes_android.databinding.ActivityHistoryBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryActivity extends Activity {
    private ActivityHistoryBinding binding;
    private HistoryAdapter historyAdapter;

    @RequiresApi(api = Build.VERSION_CODES.ECLAIR)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        historyAdapter = new HistoryAdapter(this);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_history);
        binding.setActivity(this);
        binding.historyList.setAdapter(historyAdapter);

        overridePendingTransition(0, 0);

    }

    @Override
    protected void onStart(){
        super.onStart();
        requestHistories();

    }

    private void requestHistories(){
        String patientId = PatientManager.getInstance().getPatientVO().getPatientId();
        Call<List<HistoryItem>> call = RetrofitClient.getInstance().getService().getHistories(patientId);
        call.enqueue(new Callback<List<HistoryItem>>() {
            @Override
            public void onResponse(Call<List<HistoryItem>> call, Response<List<HistoryItem>> response) {
                // you  will get the reponse in the response parameter
                if (response.isSuccessful()) {
                    setHistories(response.body());
                } else {
                    DLog.getInstance().e("Main Activity");
                }
            }

            @Override
            public void onFailure(Call<List<HistoryItem>> call, Throwable t) {
                DLog.getInstance().e("Main Activity");
            }
        });
    }

    private void setHistories(List<HistoryItem> historyItems){

        for(HistoryItem historyItem:historyItems){
            historyAdapter.addItem(historyItem);
        }
    }


}
