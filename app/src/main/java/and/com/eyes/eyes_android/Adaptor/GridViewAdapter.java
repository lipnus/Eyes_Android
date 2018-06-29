package and.com.eyes.eyes_android.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

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
            convertView = inflater.inflate(R.layout.gridview_photoenroll, parent, false);
        }

        //레이아웃
        ImageView gridIv = convertView.findViewById(R.id.grid_title_iv);
        TextView gridTv = convertView.findViewById(R.id.grid_title_tv);

        //데이터
        GridViewItem item = gridViewItems.get(pos);

        //적용
        gridTv.setText(item.text);


        return convertView;
    }


    // 아이템 데이터 추가
    public void addItem(int id, String imagePath, String text) {
        GridViewItem item = new GridViewItem(id, imagePath, text);
        gridViewItems.add(item);
    }

}
