package rnhms;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.testrnhms.ToastExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import rnhms.account.RNHMSLogin;
import rnhms.analytics.RNHMSAnalytics;
import rnhms.push.RNHMSPush;

public class RNHMSPackage implements ReactPackage {

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();
        modules.add(new RNHMSLogin(reactContext));
        modules.add(new RNHMSPush(reactContext));
        modules.add(new ToastExample(reactContext));
        modules.add(new RNHMSAnalytics(reactContext));
        return modules;
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }
}