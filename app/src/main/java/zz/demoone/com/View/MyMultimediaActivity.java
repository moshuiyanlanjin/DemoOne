package zz.demoone.com.View;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zz.demoone.com.BaseActivity;
import zz.demoone.com.R;
import zz.demoone.com.Utlis.TitleView;

/**
 * Created by Administrator on 2018-06-19.
 */

class MyMultimediaActivity extends BaseActivity {

    @BindView(R.id.title)
    TitleView title;
    @BindView(R.id.infromone)
    TextView infromone;
    @BindView(R.id.infromtwo)
    TextView infromtwo;
    @BindView(R.id.infromthree)
    TextView infromthree;
    NotificationManager manager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multimedia);
        ButterKnife.bind(this);
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    }

    @Override
    protected void initDate() {

    }

    @OnClick({R.id.infromone, R.id.infromtwo, R.id.infromthree})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.infromone:

                Notification notification = new NotificationCompat.Builder(App.Appcontext)
                        .setContentTitle("标题")
                        .setContentText("内容")
                        .setWhen(System.currentTimeMillis())//指定被创建时间，以毫秒为单位
                        .setSmallIcon(R.mipmap.ic_launcher)//指定小图标
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher_round))//指定大图标
                        .build();
                manager.notify(1, notification);
                break;
            case R.id.infromtwo:
                break;
            case R.id.infromthree:
                break;
        }
    }
}
