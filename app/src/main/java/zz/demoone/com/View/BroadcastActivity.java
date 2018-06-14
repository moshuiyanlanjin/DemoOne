package zz.demoone.com.View;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zz.demoone.com.BaseActivity;
import zz.demoone.com.R;
import zz.demoone.com.Utlis.TitleView;
import zz.demoone.com.Utlis.ToastUtlis;

/**
 * Created by Administrator on 2018-06-13.
 */

public class BroadcastActivity extends BaseActivity {

    @BindView(R.id.title)
    TitleView title;
    IntentFilter intentFilter;
    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.text1)
    TextView text1;
    private NetworkChangeReceiver networkChangeReceiver;
    private  LocalBroadcastManager localBroadcastManager;
    private LostBroadcastReceiver lostBroadcastReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        ButterKnife.bind(this);
        intentFilter = new IntentFilter();
        //网络变化时，系统会发出android.net.conn.CONNECTIVITY_CHANGE
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        //实例
        networkChangeReceiver = new NetworkChangeReceiver();
        //注册
        registerReceiver(networkChangeReceiver, intentFilter);
        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消注册
        unregisterReceiver(networkChangeReceiver);
        localBroadcastManager.unregisterReceiver(lostBroadcastReceiver);
    }

    private void initView() {
        title.setTitlename("广播");
        title.SetOnTitleCleke(new TitleView.OnTitleCleke() {
            @Override
            public void finsh1() {
                finish();
            }

            @Override
            public void starte1() {

            }


        });
    }

    @Override
    protected void initDate() {

    }

    @OnClick({R.id.text, R.id.text1})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.text:
                intent = new Intent("zz.demoone.com.my");
                intent.putExtra("cc", "yunyun");
                //无序
                // sendBroadcast(intent);
                //有序
                sendOrderedBroadcast(intent, null);
                break;
            case R.id.text1:
                //本地广播
                localBroadcastManager = LocalBroadcastManager.getInstance(BroadcastActivity.this);
                intentFilter = new IntentFilter();
                intentFilter.addAction("zz.demoone.boradcast.lost");
                lostBroadcastReceiver = new LostBroadcastReceiver();
                localBroadcastManager.registerReceiver(lostBroadcastReceiver,intentFilter);
                intent = new Intent("zz.demoone.boradcast.lost");
                localBroadcastManager.sendBroadcast(intent);
                break;
        }
    }

    class NetworkChangeReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            // ToastUtlis.showtoast(context,"网络状态变化");
            //系统服务类，主要用于管理网络；
            ConnectivityManager manager = (ConnectivityManager) getSystemService(context.CONNECTIVITY_SERVICE);

            NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
            //通过activeNetwork.isAvailable判断是否有网络
            if (activeNetwork != null && activeNetwork.isAvailable()) {
                ToastUtlis.showtoast(context, "打开网络");
            } else {
                ToastUtlis.showtoast(context, "关闭网络");
            }
        }
    }
    class LostBroadcastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            ToastUtlis.showtoast(context,"haha");
        }
    }
}
