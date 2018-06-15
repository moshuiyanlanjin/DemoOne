package zz.demoone.com.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;
import org.litepal.crud.callback.FindMultiCallback;
import org.litepal.tablemanager.Connector;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zz.demoone.com.BaseActivity;
import zz.demoone.com.R;
import zz.demoone.com.Utlis.TitleView;
import zz.demoone.com.model.Company;

/**
 * Created by Administrator on 2018-06-15.
 */

public class MyLitePalActivity extends BaseActivity {

    @BindView(R.id.title)
    TitleView title;
    @BindView(R.id.chuangjian)
    TextView chuangjian;
    @BindView(R.id.add)
    TextView add;
    @BindView(R.id.update)
    TextView update;
    @BindView(R.id.delete)
    TextView delete;
    @BindView(R.id.query)
    TextView query;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lirepal);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        title.setTitlename("LitePal");
        title.SetOnTitleCleke(new TitleView.OnTitleCleke() {
            @Override
            public void finsh1() {
                finish();
            }

            @Override
            public void starte1() {

            }
        });
    }

    @Override
    protected void initDate() {

    }

    @OnClick({R.id.chuangjian, R.id.add, R.id.update, R.id.delete, R.id.query})
    public void onViewClicked(View view) {
        Company company = new Company();
        switch (view.getId()) {
            case R.id.chuangjian:
                //创建数据库
                Connector.getDatabase();
                break;
            case R.id.add:

                company.setName("朱立");
                company.setAge(25);
                company.setGender("男");
                company.save();
                break;
            case R.id.update:
                company.setName("朱良晨");
                company.setAge(26);
               // company.updateAll("gender = ?","男");
                company.update(1);
                break;
            case R.id.delete:
                LitePal.deleteAll(Company.class,"age > ?","25");
                break;
            case R.id.query:
                LitePal.findAllAsync(Company.class).listen(new FindMultiCallback() {
                    @Override
                    public <T> void onFinish(List<T> t) {
                        List<Company> ss = (List<Company>) t;
                        String name = ss.get(1).getName();
                        int age = ss.get(1).getAge();
                        int id = ss.get(1).getId();
                        Log.d("name", name+""+age+""+id);
                    }
                });
                break;
        }
    }
}
