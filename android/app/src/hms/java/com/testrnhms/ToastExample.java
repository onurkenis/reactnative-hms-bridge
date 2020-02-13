package com.testrnhms;

import android.widget.Toast;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.Map;
import java.util.HashMap;

public class ToastExample extends ReactContextBaseJavaModule {

    public ToastExample(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "ToastComponent";
    }

    @ReactMethod
    public void toastMe() {
        Toast.makeText(getReactApplicationContext(), "hms", Toast.LENGTH_SHORT).show();
    }
}