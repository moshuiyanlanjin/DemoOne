package zz.demoone.com.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import zz.demoone.com.BaseActivity;
import zz.demoone.com.R;
import zz.demoone.com.Sqlite.MyDateBaseHelper;
import zz.demoone.com.Utlis.TitleView;

/**
 * Created by Administrator on 2018-06-14.
 */

public class MySqliteActivity extends BaseActivity {

    @BindView(R.id.title)
    TitleView title;
    @BindView(R.id.chuangjian)
    TextView chuangjian;
    MyDateBaseHelper date;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        date = new MyDateBaseHelper(MySqliteActivity.this,"BokkStore.db",null,1);
        chuangjian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date.getWritableDatabase();
            }
        });
    }

    @Override
    protected void initDate() {

    }
}
