package and.com.eyes.eyes_android.Adaptor;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import and.com.eyes.eyes_android.Model.HistoryItem;
import and.com.eyes.eyes_android.R;
import and.com.eyes.eyes_android.databinding.HistoryCustomBinding;

public class HistoryAdapter extends BaseAdapter{

    /* 아이템을 세트로 담기 위한 어레이 */
    private ArrayList<HistoryItem> Items = new ArrayList<>();
    private Activity activity;
    public HistoryAdapter(Activity activity){
        this.activity = activity;
    }

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
        HistoryCustomBinding binding;

        if(convertView == null){
            convertView = LayoutInflater.from(activity).inflate(R.layout.history_custom, null);
            binding = DataBindingUtil.bind(convertView);
            convertView.setTag(binding);
        }else{
            binding = (HistoryCustomBinding) convertView.getTag();
        }

        binding.tvAddress.setText(getItem(position).getAddress());
        binding.tvDevelopTime.setText(getItem(position).getStartTime());
        binding.tvEndTime.setText(getItem(position).getEndTime());
        binding.tvHandover.setText(getItem(position).getHandover());

        return convertView;
    }

    public void addItem(HistoryItem historyItem) {
        Items.add(historyItem);
        notifyDataSetChanged();
    }
}