package and.com.eyes.eyes_android.Activity;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import and.com.eyes.eyes_android.R;
import and.com.eyes.eyes_android.databinding.ActivityIntroBinding;

public class IntroActivity extends Activity {

    private ActivityIntroBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_intro);
        binding.setActivity(this);
    }

    public void startApplication(){
        Intent intent = new Intent(IntroActivity.this, MainActivity.class);
        startActivity(intent);
    }

}
