package and.com.eyes.eyes_android.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import and.com.eyes.eyes_android.Adaptor.GridViewAdapter;
import and.com.eyes.eyes_android.R;

public class PhotoEnrollActivity extends AppCompatActivity {

    GridView gridView;
    GridViewAdapter adapter;

    //이미지 업로드
    private static final int GALLERY_INTENT = 2;

    //지금 선택한 그리드뷰의 위치
    int gridPosition=0;

    ImageView testIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_enroll);
        overridePendingTransition(0, 0);


        //테스트용 ImageView
        testIv = findViewById(R.id.testIv);

        //그리드뷰 설정
        settingGridView();
    }

    //그리드뷰 설정
    public void settingGridView(){

        //그리드뷰 설정
        gridView = findViewById(R.id.gridView);
        adapter = new GridViewAdapter(this);
        gridView.setAdapter(adapter);

        //클릭리스너
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(), "위치:" + position, Toast.LENGTH_SHORT).show();

                //갤러리에서 불러올 이미지 호출
                gridPosition = position;
                Intent iT = new Intent(Intent.ACTION_PICK);
                iT.setType("image/*");
                startActivityForResult(iT, GALLERY_INTENT);

            }
        });

        //ㅁㄴㅇㄹ

        //그리드뷰 빈칸 추가
        for(int i=0; i<15; i++){
            adapter.addItem(i, ""+i);
        }
        adapter.notifyDataSetChanged();
    }


    //사진첩 호출의 결과
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY_INTENT && resultCode == RESULT_OK) {

            try {

                //이미지뷰에 고른 사진을 보여줌
                Glide.with(this)
                        .load(data.getData())
                        .into(testIv);

                //그리드뷰 선택한 칸에 이미지 삽입(url경로 보냄)
                adapter.setImage( data.getData(), gridPosition);
                adapter.notifyDataSetChanged();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }//if

    }
}
