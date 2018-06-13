package zz.demoone.com.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import zz.demoone.com.Utlis.ToastUtlis;

/**
 * 广播监听器
 * 监听开机广播
 */
public class BootCompleteReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        ToastUtlis.showtoast(context,"开机了");
    }
}
