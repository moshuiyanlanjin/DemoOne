package zz.demoone.com.Utlis;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2018-06-12.
 */

public class ToastUtlis {
    private static Toast toast = null;
    public static void showtoast(Context context,String msg){
        if(toast == null){
            toast = Toast.makeText(context,msg,Toast.LENGTH_SHORT);
        }else{
            toast.setText(msg);
        }
       toast.show();
    }
}
