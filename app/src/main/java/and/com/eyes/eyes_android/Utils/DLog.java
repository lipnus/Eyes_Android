package and.com.eyes.eyes_android.Utils;

import android.util.Log;

public class DLog {
    private static DLog instance;
    private String TAG = "Eyes_Android";
    private boolean logFlag = true;
    /**
     * Log Level Error
     **/

    public static and.com.eyes.eyes_android.Utils.DLog getInstance() {
        if(instance == null){
            instance = new DLog();
        }
        return instance;
    }

    public final void e(String message) {
        if (logFlag) Log.e(TAG, buildLogMsg(message));
    }

    /**
     * Log Level Warning
     **/
    public final void w(String message) {
        if (logFlag) Log.w(TAG, buildLogMsg(message));
    }

    /**
     * Log Level Information
     **/
    public final void i(String message) {
        if (logFlag) Log.i(TAG, buildLogMsg(message));
    }

    /**
     * Log Level Debug
     **/
    public final void d(String message) {
        if (logFlag) Log.d(TAG, buildLogMsg(message));
    }

    /**
     * Log Level Verbose
     **/
    public final void v(String message) {
        if (logFlag) Log.v(TAG, buildLogMsg(message));
    }

    private String buildLogMsg(String message) {
        StackTraceElement ste = Thread.currentThread().getStackTrace()[4];
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(ste.getFileName().replace(".java", ""));
        sb.append("::");
        sb.append(ste.getMethodName());
        sb.append("] ");
        sb.append(message);
        return sb.toString();
    }
}