package zz.demoone.com.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import zz.demoone.com.Utlis.ToastUtlis;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        ToastUtlis.showtoast(context,intent.getStringExtra("cc"));
        //拦截，不在向下传递
        abortBroadcast();
    }
}
