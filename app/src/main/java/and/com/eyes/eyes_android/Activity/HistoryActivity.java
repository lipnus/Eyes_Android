package and.com.eyes.eyes_android.Activity;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import and.com.eyes.eyes_android.R;
import and.com.eyes.eyes_android.Adaptor.HistoryAdapter;

public class HistoryActivity extends Activity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        /* 위젯과 멤버변수 참조 획득 */
        mListView = (ListView)findViewById(R.id.historyList);

        /* 아이템 추가 및 어댑터 등록 */
        dataSetting();
    }

    private void dataSetting(){

        HistoryAdapter mMyAdapter = new HistoryAdapter();


        for (int i=0; i<10; i++) {
            mMyAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.mipmap.ic_launcher), "add_" + i, "deveopTime_" + i,
                    "endTime_" + i,"handover");
        }

        /* 리스트뷰에 어댑터 등록 */
        mListView.setAdapter(mMyAdapter);
    }

}
