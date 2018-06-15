package zz.demoone.com.View;

import android.app.Application;
import android.content.Context;

import org.litepal.LitePal;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018-06-12.
 */

public class App extends Application {

    public static Context Appcontext;
    @Override
    public void onCreate() {
        super.onCreate();
        Appcontext = this;
        LitePal.initialize(this);
    }
}
