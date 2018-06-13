package zz.demoone.com.View;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import zz.demoone.com.BaseActivity;
import zz.demoone.com.Fragment.FourFargment;
import zz.demoone.com.Fragment.OneFargment;
import zz.demoone.com.Fragment.ThreeFargment;
import zz.demoone.com.Fragment.TwoFargment;
import zz.demoone.com.R;

/**
 * Created by Administrator on 2018/6/12.
 * 对fragment的简单操作
 */

public class FragmentesActivity extends BaseActivity {
    @BindView(R.id.fragmentes)
    FrameLayout fragmentes;
    @BindView(R.id.butt1)
    RadioButton butt1;
    @BindView(R.id.butt2)
    RadioButton butt2;
    @BindView(R.id.butt3)
    RadioButton butt3;
    @BindView(R.id.butt4)
    RadioButton butt4;
    @BindView(R.id.buttgroup)
    RadioGroup buttgroup;
    private List<Fragment> list;
    private Fragment listfragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {

        buttgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.butt1:
                        ReplaceFragment(0);
                        break;
                    case R.id.butt2:
                        ReplaceFragment(1);
                        break;
                    case R.id.butt3:
                        ReplaceFragment(2);
                        break;
                    case R.id.butt4:
                        ReplaceFragment(3);
                        break;
                }
            }
        });
    }

    @Override
    protected void initDate() {
        list=new ArrayList<Fragment>();
        list.add(new OneFargment());
        list.add(new TwoFargment());
        list.add(new ThreeFargment());
        list.add(new FourFargment());


        ReplaceFragment(0);
    }

    private void ReplaceFragment(int i) {
        //获取管理器
        FragmentManager manger = getSupportFragmentManager();
        //开启事务
        FragmentTransaction transaction = manger.beginTransaction();
        //向容器添加或替换碎片
      //  transaction.replace(R.id.fragmentes, fragment);
        //上一个不为空 隐藏上一个
        if (listfragment!= null) {
            transaction.hide(listfragment);
        }

        Fragment fragment = list.get(i);
        if (fragment.isAdded()) {
            transaction.show(fragment);
        }else{
            transaction.add(R.id.fragmentes, fragment);
        }
        //不会直接退出fragment
       // transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();
        //提交事务
       // transaction.commit();
        listfragment = fragment;
    }
}
