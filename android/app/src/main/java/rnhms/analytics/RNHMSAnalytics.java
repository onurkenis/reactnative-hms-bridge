package rnhms.analytics;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.huawei.hianalytics.hms.HiAnalyticsTools;
import com.huawei.hms.analytics.HiAnalytics;
import com.huawei.hms.analytics.HiAnalyticsInstance;
import com.testrnhms.utils.JsonUtils;

import rnhms.Constants;

public class RNHMSAnalytics extends ReactContextBaseJavaModule {

    private HiAnalyticsInstance instance;

    public RNHMSAnalytics(ReactApplicationContext reactContext) {
        super(reactContext);
        HiAnalyticsTools.enableLog();

        instance = HiAnalytics.getInstance(reactContext);

        Log.i(Constants.ANALYTICS_TAG, instance.toString());
    }

    @Override
    public String getName() {
        return "HMSAnalytics";
    }

    @ReactMethod
    public void sendEvent(String eventName, String bundleString) {
        Bundle bundle = JsonUtils.jsonStringToBundle(bundleString);

        Log.i(Constants.ANALYTICS_TAG, "eventName: " + eventName);
        Log.i(Constants.ANALYTICS_TAG, "bundle: " + bundleString);

        Toast.makeText(getReactApplicationContext(),
                "eventName: " + eventName + " bundle: " + bundleString, Toast.LENGTH_SHORT)
                .show();

        instance.onEvent(eventName, bundle);
    }
}
