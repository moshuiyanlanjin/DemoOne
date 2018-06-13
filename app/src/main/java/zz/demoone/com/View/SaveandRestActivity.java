package zz.demoone.com.View;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import zz.demoone.com.BaseActivity;

/**
 * Created by Administrator on 2018-06-13.
 * onSaveInstanceStat和onRestoreInstanceState调用时机
 */

public class SaveandRestActivity extends BaseActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null){
            String date = savedInstanceState.getString("date");
            Log.d("date",date);
        }
    }

    @Override
    protected void initDate() {

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        String date = "save";
        outState.putString("date",date);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String date = "rest";
        savedInstanceState.putString("date",date);
    }
}
