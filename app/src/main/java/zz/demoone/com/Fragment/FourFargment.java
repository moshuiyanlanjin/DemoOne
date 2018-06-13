package zz.demoone.com.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import zz.demoone.com.R;
import zz.demoone.com.View.App;

/**
 * Created by Administrator on 2018/6/12.
 */

public class FourFargment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View view = initView();
        return view;
    }

    private View initView() {
        View view = View.inflate(App.Appcontext,R.layout.fragment_one,null);
        TextView text = view.findViewById(R.id.text);
        text.setText("测试4");
        return view;
    }
}
