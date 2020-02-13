package rnhms.push;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.HmsInstanceId;

import rnhms.Constants;

public class RNHMSPush extends ReactContextBaseJavaModule {
    private Activity activity;
    private String pushtoken;

    public RNHMSPush(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "HMSPush";
    }

    @ReactMethod
    public void getToken() {
        Log.i(Constants.PUSH_TAG, "get token: begin");
        this.activity = getCurrentActivity();

        // get token
        new Thread() {
            @Override
            public void run() {
                try {
                    String appId = AGConnectServicesConfig.fromContext(activity).getString("client/app_id");
                    Log.i(Constants.PUSH_TAG, "appId: " + appId);
                    pushtoken = HmsInstanceId.getInstance(activity).getToken(appId, "HCM");
                    Log.i(Constants.PUSH_TAG, "thread token: " + pushtoken);

                    if(!TextUtils.isEmpty(pushtoken)) {
                        Toast.makeText(getReactApplicationContext(), "get token:" + pushtoken, Toast.LENGTH_SHORT).show();
                        Log.i(Constants.PUSH_TAG, "get token:" + pushtoken);
                    }
                } catch (Exception e) {
                    Log.i(Constants.PUSH_TAG,"getToken failed, " + e);

                }
            }
        }.start();
    }
}