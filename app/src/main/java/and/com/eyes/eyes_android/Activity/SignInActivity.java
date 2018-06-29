package and.com.eyes.eyes_android.Activity;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;

import and.com.eyes.eyes_android.Network.RetrofitClient;
import and.com.eyes.eyes_android.R;
import and.com.eyes.eyes_android.databinding.ActivitySigninBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivity extends Activity {

    private ActivitySigninBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signin);
        binding.setActivity(this);
    }


    public void sendData(){
        Call<String> call = RetrofitClient.getInstance().getService().sendPost("a", "b","c");
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                // you  will get the reponse in the response parameter
                if(response.isSuccessful()) {
                    //mAdapter.updateAnswers(response.body().getItems());
                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code

                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("Login Activity", "error from Login Activity");
            }
        });
    }

    public void moveActivity(){
        Intent intent = new Intent(SignInActivity.this, PhotoEnrollActivity.class);
        startActivity(intent);
    }

    public void captureImage(){

    }



}
