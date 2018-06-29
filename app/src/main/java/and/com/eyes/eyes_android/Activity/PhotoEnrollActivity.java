package and.com.eyes.eyes_android.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import and.com.eyes.eyes_android.Adaptor.GridViewAdapter;
import and.com.eyes.eyes_android.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoEnrollActivity extends AppCompatActivity {

    GridView gridView;
    GridViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_enroll);

        //그리드뷰 촉기설정
        gridView = findViewById(R.id.gridView);
        adapter = new GridViewAdapter(this);
        gridView.setAdapter(adapter);

        //그리드뷰에 데이터 추가
        adapter.addItem(1,"imagePath", "text1");
        adapter.addItem(2,"imagePath", "text2");
        adapter.addItem(3,"imagePath", "text3");
        adapter.addItem(3,"imagePath", "text4");
        adapter.notifyDataSetChanged();
    }


    //사진업로드
    public void onClick_selectImage(View v){
        Intent iT = new Intent(Intent.ACTION_PICK);
        iT.setType("image/*");
        startActivityForResult(iT, GALLERY_INTENT);
    }
}
