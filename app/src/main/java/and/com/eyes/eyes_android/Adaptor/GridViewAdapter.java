package and.com.eyes.eyes_android.Adaptor;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import and.com.eyes.eyes_android.Model.GridViewItem;
import and.com.eyes.eyes_android.R;


public class GridViewAdapter extends BaseAdapter {

    private Context mContext; //쓸까?
    private ArrayList<GridViewItem> gridViewItems = new ArrayList<>() ;

    // Constructor
    public GridViewAdapter(){}

    public GridViewAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return gridViewItems.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.girdview_photoenroll, parent, false);
        }

        //레이아웃
        ImageView gridIv = convertView.findViewById(R.id.grid_title_iv);
        TextView gridTv = convertView.findViewById(R.id.grid_title_tv);

        //데이터
        GridViewItem item = gridViewItems.get(pos);

        //적용
        gridTv.setText(item.text);

        //이미지뷰에 고른 사진을 보여줌
        Glide.with(context)
                .load(item.image)
                .into(gridIv);

        return convertView;
    }


    // 아이템 데이터 추가
    public void addItem(int id,String text) {
        GridViewItem item = new GridViewItem(id,text);
        gridViewItems.add(item);
    }

    // 이미지 설정
    public void setImage(Uri uri, int pos){
        gridViewItems.get(pos).image = uri;
    }


}
