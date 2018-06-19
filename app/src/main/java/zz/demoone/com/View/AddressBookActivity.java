package zz.demoone.com.View;

import android.Manifest;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pub.devrel.easypermissions.EasyPermissions;
import pub.devrel.easypermissions.PermissionRequest;
import zz.demoone.com.BaseActivity;
import zz.demoone.com.R;
import zz.demoone.com.Utlis.TitleView;
import zz.demoone.com.View.Adapter.AddressBookAdapter;
import zz.demoone.com.model.PhoneModler;

/**
 * Created by Administrator on 2018-06-19.
 */

public class AddressBookActivity extends BaseActivity implements EasyPermissions.PermissionCallbacks {

    @BindView(R.id.title)
    TitleView title;
    @BindView(R.id.recy)
    RecyclerView recy;
    private List<PhoneModler> modlerlist = new ArrayList<>();
    PhoneModler modler = new PhoneModler();
    private String[] pream = new String[]{Manifest.permission.READ_CONTACTS};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addressbook);
        ButterKnife.bind(this);
        if(EasyPermissions.hasPermissions(this,pream)){
            initView();
        }else{
            EasyPermissions.requestPermissions(this,"请开启相关权限！",1,pream);
        }

    }

    private void initView() {

        Cursor cursor = null;
        try {
            /**
             * 参数1：访问的url（某个程序下的某张表）
             * 参数2：指定查询的列名
             * 参数三：指定where的约束条件
             * 参数四：为where提供具体的占位符
             * 参数五：排序
             */
            cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    String phones = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHONETIC_NAME));
                    modler.setName(name);
                    modler.setPhone(phones);
                    modlerlist.add(modler);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        LinearLayoutManager manager = new LinearLayoutManager(AddressBookActivity.this);
        recy.setLayoutManager(manager);
        AddressBookAdapter adapter = new AddressBookAdapter(AddressBookActivity.this,modlerlist);
        recy.setAdapter(adapter);
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        initView();
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        EasyPermissions.requestPermissions(this,"请开启相关权限！",1,pream);
    }

    @Override
    protected void initDate() {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults,AddressBookActivity.this);
    }
}
