package zz.demoone.com.Utlis;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018-06-12.
 * activity的集合控制
 */

public class ActivityCollector {

    public static List<Activity> activitylist = new ArrayList<>();

    public static void addavtivity(Activity activity){
        activitylist.add(activity);
    }
    public static void romeactivity(Activity activity){
        activitylist.remove(activity);
    }
    public static void AllfinshActivity(){
        for(Activity activity : activitylist){
            if(activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
