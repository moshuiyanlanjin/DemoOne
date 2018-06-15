package zz.demoone.com.Sqlite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import zz.demoone.com.Utlis.ToastUtlis;
import zz.demoone.com.View.App;

/**
 * Created by Administrator on 2018-06-14.
 */

public class MyDateBaseHelper extends SQLiteOpenHelper{

    private Context mContext;
    /**
     * primary key设为主键
     * autoincrement 设为自增长
     */
    public static final String CREATE_BOOK = "create table Book("
            + "id integer primary key autoincrement,"
            + "author text,"
            + "price real,"
            + "pages integer,"
            + "name text)";

    public static final String CREATE_CATEGORY = "create table Category ("
            + "id integer primary key autoincrement,"
            + "category_name text,"
            + "category_code integer)";
    public MyDateBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);
        ToastUtlis.showtoast(App.Appcontext,"数据库创建成功");
    }

    //drop table if exists表示是否有改表，有就删除
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Book");
        db.execSQL("drop table if exists Category");
        onCreate(db);
    }
}
