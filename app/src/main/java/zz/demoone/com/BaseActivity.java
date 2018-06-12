package zz.demoone.com;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import zz.demoone.com.Utlis.ActivityCollector;

/**
 * Created by Administrator on 2018-06-12.
 */

public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("活动名：",getClass().getSimpleName());
        ActivityCollector.addavtivity(this);
        initView();
        initDate();
    }

    protected abstract void initDate();

    public abstract void initView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.romeactivity(this);
    }
}
