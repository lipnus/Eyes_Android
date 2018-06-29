package and.com.eyes.eyes_android.Activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import and.com.eyes.eyes_android.R;
import and.com.eyes.eyes_android.databinding.ActivityMainBinding;


public class MainActivity extends Activity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setActivity(this);
    }
}
