package zz.demoone.com.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import zz.demoone.com.BaseActivity;
import zz.demoone.com.Interface.MainInterface;
import zz.demoone.com.Presenter.MainPresenter;
import zz.demoone.com.R;
import zz.demoone.com.Utlis.TitleView;
import zz.demoone.com.View.Adapter.MainAdapter;

/**
 * demo总集合
 */
public class MainActivity extends BaseActivity implements MainInterface.View{

    @BindView(R.id.title)
    TitleView title;
    @BindView(R.id.recy)
    RecyclerView recy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MainPresenter presenter = new MainPresenter(this);
        presenter.LatDate();
    }

    @Override
    protected void initDate() {

    }

    @Override
    public void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
        recy.setLayoutManager(manager);
    }

    @Override
    public void SDetate(List<String> date) {
        Log.d("测试",date.get(0));
        MainAdapter adapter = new MainAdapter(MainActivity.this,date);
        recy.setAdapter(adapter);
        adapter.setOnMainClike(new MainAdapter.OnMainClike() {
            @Override
            public void onmainclikeitem(int position) {

            }
        });
    }
}
