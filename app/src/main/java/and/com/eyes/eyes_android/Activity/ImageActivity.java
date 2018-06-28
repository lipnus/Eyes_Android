package and.com.eyes.eyes_android.Activity;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import and.com.eyes.eyes_android.R;

public class ImageActivity extends Activity {

    private String state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PermissionListener permissionlistener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                Toast.makeText(ImageActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();

                checkExternalStorage();

                String data = "파일 생성내용....";

                try {
                    File path = Environment.getExternalStoragePublicDirectory
                            (Environment.DIRECTORY_PICTURES);
                    File f = new File(path, "external.txt"); // 경로, 파일명
                    FileWriter write = new FileWriter(f, false);
                    PrintWriter out = new PrintWriter(write);
                    out.println(data);
                    out.close();
                    Log.d("test", "저장완료");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                Toast.makeText(ImageActivity.this, "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
            }


        };


        TedPermission.with(this)
                .setPermissionListener(permissionlistener)
                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION)
                .check();
    }

    boolean checkExternalStorage() {
        state = Environment.getExternalStorageState();

        // 외부메모리 상태
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            // 읽기 쓰기 모두 가능
            Log.d("test", "외부메모리 읽기 쓰기 모두 가능");
            return true;
        } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)){
            //읽기전용
            Log.d("test", "외부메모리 읽기만 가능");
            return false;
        } else {
            // 읽기쓰기 모두 안됨
            Log.d("test", "외부메모리 읽기쓰기 모두 안됨 : "+ state);
            return false;
        }
    }

    public void captureImage(){

    }

}
