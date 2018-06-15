package zz.demoone.com.View;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
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
        setContentView(R.layout.activity_sqlite);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        date = new MyDateBaseHelper(MySqliteActivity.this, "BokkStore.db", null, 2);

    }

    @Override
    protected void initDate() {

    }

    @OnClick({R.id.chuangjian, R.id.add,R.id.update, R.id.delete, R.id.query})
    public void onViewClicked(View view) {
        SQLiteDatabase db;
        switch (view.getId()) {
            case R.id.chuangjian:
                date.getWritableDatabase();
                break;
            case R.id.add:
                db = date.getWritableDatabase();
                ContentValues va = new ContentValues();
                va.put("author", "左宗棠");
                va.put("price", 25.50);
                va.put("pages", 300);
                va.put("name", "方圆");
                db.insert("Book", null, va);//插入第一条数据
                va.clear();
                va.put("author", "我吃西红柿");
                va.put("price", 20.14);
                va.put("pages", 300);
                va.put("name", "盘龙");
                db.insert("Book", null, va);//插入第二条数据
                break;
            case R.id.update:
                db = date.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("price","50");
                db.update("Book",values,"name = ?",new String[]{"盘龙"});
                break;
            case R.id.delete:
                db = date.getWritableDatabase();
                db.delete("Book","price > ?",new String[]{"40"});
                break;
            case R.id.query:
                db = date.getWritableDatabase();
                /**
                 * 参数一：表名
                 * 参数二：查询的列名，如null则全部查询
                 * 参数三、四：用于约束查询某一行或几行的数据，null则查询所有的数据
                 * 参数五：指定需要去group by的列，不指定则表示不对查询结果进行group by
                 * 参数六：对group by的数据进行过滤，null表示不过滤
                 * 参数七：对查询结果进行排序，null则默认
                 */
                Cursor cursor = db.query("Book", null, null, null, null, null, null);
                if(cursor.moveToFirst()){
                    do {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        int price = cursor.getInt(cursor.getColumnIndex("price"));
                        int id = cursor.getInt(cursor.getColumnIndex("id"));
                        Log.d("name",name);
                        Log.d("price", price+"");
                        Log.d("id", id+"");
                    } while (cursor.moveToNext());
                }
                cursor.close();
                break;
        }
    }


}
