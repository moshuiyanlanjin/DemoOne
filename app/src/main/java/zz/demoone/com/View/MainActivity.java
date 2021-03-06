package zz.demoone.com.View;

import android.content.Intent;
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
import zz.demoone.com.Utlis.ToastUtlis;
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

        initView();
    }

    @Override
    protected void initDate() {

    }

    public void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recy.setLayoutManager(manager);

    }

    @Override
    public void SDetate(final List<String> date) {
        Log.d("测试",date.get(0));

        MainAdapter adapter = new MainAdapter(MainActivity.this,date);
        recy.setAdapter(adapter);
        adapter.setOnMainClike(new MainAdapter.OnMainClike() {
            @Override
            public void onmainclikeitem(int position) {
                ToastUtlis.showtoast(MainActivity.this,date.get(position));
                Intent intent;
                switch (position){
                    case 0:
                        intent = new Intent(MainActivity.this,FragmentesActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this,SaveandRestActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        //广播
                        intent = new Intent(MainActivity.this,BroadcastActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        //存储
                        intent = new Intent(MainActivity.this,StorageActivity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(MainActivity.this,MySqliteActivity.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(MainActivity.this,MyLitePalActivity.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(MainActivity.this,MyContentResolver.class);
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent(MainActivity.this,MyMultimediaActivity.class);
                        startActivity(intent);
                        break;
                    case 8:
                        intent = new Intent(MainActivity.this,PhotographActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
