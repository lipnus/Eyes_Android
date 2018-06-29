package and.com.eyes.eyes_android.Activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import and.com.eyes.eyes_android.R;
import and.com.eyes.eyes_android.Adaptor.HistoryAdapter;
import and.com.eyes.eyes_android.databinding.ActivityHistoryBinding;

public class HistoryActivity extends Activity {

    private ActivityHistoryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_history);

        /* 아이템 추가 및 어댑터 등록 */
        dataSetting();
    }

    @Override
    protected void onStart(){
        super.onStart();

    }

    private void dataSetting(){

        HistoryAdapter mMyAdapter = new HistoryAdapter();


        for (int i=0; i<10; i++) {
            mMyAdapter.addItem(getResources().getDrawable(R.mipmap.ic_launcher), "add_" + i, "deveopTime_" + i,
                    "endTime_" + i,"handover");
        }

        /* 리스트뷰에 어댑터 등록 */
        binding.historyList.setAdapter(mMyAdapter);
    }

}
