package zz.demoone.com.View;

import android.app.Application;
import android.content.Context;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018-06-12.
 */

public class App extends Application {

    public Context Appcontext;
    @Override
    public void onCreate() {
        super.onCreate();
        Appcontext = this;

    }
}
