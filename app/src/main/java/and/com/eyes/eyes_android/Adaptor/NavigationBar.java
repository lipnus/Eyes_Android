package and.com.eyes.eyes_android.Adaptor;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import and.com.eyes.eyes_android.Activity.CalActivity;
import and.com.eyes.eyes_android.Activity.HistoryActivity;
import and.com.eyes.eyes_android.Activity.MainActivity;
import and.com.eyes.eyes_android.Activity.PhotoEnrollActivity;
import and.com.eyes.eyes_android.R;
import and.com.eyes.eyes_android.databinding.ActivityMainBinding;
import and.com.eyes.eyes_android.databinding.NavigationMenuBinding;

public class NavigationBar extends RelativeLayout {

    private NavigationMenuBinding binding;
    private final int PICK_IMAGE = 1;
    private ProgressDialog detectionProgressDialog;

    public NavigationBar(Context context) {
        super(context);
        initView(context);
    }

    public NavigationBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public NavigationBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs);
        initView(context);
    }


    private void initView(Context context) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.navigation_menu, this, true);
        binding.setNavigation(this);
    }

    public String getActivityName()    {
        ActivityManager manager = (ActivityManager) getContext().getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> info = manager.getRunningTasks(1);
        ComponentName cn = info.get(0).topActivity;
        return cn.getShortClassName().substring(1);
    }

    public void gotoMain(){
        String activityName = getActivityName();
        if(!activityName.equals("Activity.MainActivity")) {
            Intent intent = new Intent(getContext(), MainActivity.class);
            getContext().startActivity(intent);
        }
    }

    public void gotoReg(){
        String activityName = getActivityName();
        if(!activityName.equals("Activity.PhotoEnrollActivity")) {
            Intent intent = new Intent(getContext(), PhotoEnrollActivity.class);
            getContext().startActivity(intent);
        }
    }
    public void gotoHistory(){
        String activityName = getActivityName();
        if(!activityName.equals("Activity.HistoryActivity")) {
            Intent intent = new Intent(getContext(), HistoryActivity.class);
            getContext().startActivity(intent);
        }
    }
    public void gotoNotify(){
        String activityName = getActivityName();
        if(!activityName.equals("Activity.CalActivity")) {
            Intent intent = new Intent(getContext(), CalActivity.class);
            getContext().startActivity(intent);
        }
    }
}