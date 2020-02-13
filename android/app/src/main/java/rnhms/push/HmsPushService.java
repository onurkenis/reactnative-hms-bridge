package rnhms.push;

import android.util.Log;
import android.widget.Toast;

import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;

import rnhms.Constants;

public class HmsPushService extends HmsMessageService {
    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        Log.i(Constants.PUSH_TAG, "receive token:" + s);
        Toast.makeText(getApplicationContext(), "receive token:" + s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        if (remoteMessage.getData().    length() > 0) {
            Log.i(Constants.PUSH_TAG, "Message data payload: " + remoteMessage.getData());
        }
        if (remoteMessage.getNotification() != null) {
            Log.i(Constants.PUSH_TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }
    }

    @Override
    public void onMessageSent(String s) {
    }

    @Override
    public void onSendError(String s, Exception e) {
    }
}
