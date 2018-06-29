package and.com.eyes.eyes_android.Adaptor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import and.com.eyes.eyes_android.R;

public class HistoryAdapter extends BaseAdapter{

    /* 아이템을 세트로 담기 위한 어레이 */
    private ArrayList<HistoryItem> Items = new ArrayList<>();

    @Override
    public int getCount() {
        return Items.size();
    }

    @Override
    public HistoryItem getItem(int position) {  return Items.get(position); }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Context context = parent.getContext();

        /* 'listview_custom' Layout을 inflate하여 convertView 참조 획득 */
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.history_custom, parent, false);
        }

        /* 'listview_custom'에 정의된 위젯에 대한 참조 획득 */
        ImageView iv_img = (ImageView) convertView.findViewById(R.id.iv_img) ;
        TextView tv_address = (TextView) convertView.findViewById(R.id.tv_address) ;
        TextView tv_developTime = (TextView) convertView.findViewById(R.id.tv_developTime) ;
        TextView tv_endTime = (TextView) convertView.findViewById(R.id.tv_endTime) ;
        TextView tv_handover = (TextView) convertView.findViewById(R.id.tv_handover) ;

        /* 각 리스트에 뿌려줄 아이템을 받아오는데 mMyItem 재활용 */
        HistoryItem myItem = getItem(position);

        /* 각 위젯에 세팅된 아이템을 뿌려준다 */
        iv_img.setImageDrawable(myItem.getIcon());
        tv_address.setText(myItem.getAddress());
        tv_developTime.setText(myItem.getDevelopTIme());
        tv_endTime.setText(myItem.getEndTIme());
        tv_handover.setText(myItem.getHandover());

        /* (위젯에 대한 이벤트리스너를 지정하고 싶다면 여기에 작성하면된다..)  */


        return convertView;
    }

    /* 아이템 데이터 추가를 위한 함수. 자신이 원하는대로 작성 */
    public void addItem(Drawable img, String address, String developTIme, String endTime, String handover) {

        HistoryItem mItem = new HistoryItem();

        /* MyItem에 아이템을 setting한다. */
        mItem.setIcon(img);
        mItem.setAddress(address);
        mItem.setDevelopTIme(developTIme);
        mItem.setEndTIme(endTime);
        mItem.setHandover(handover);

        /* mItems에 MyItem을 추가한다. */
        Items.add(mItem);

    }
}