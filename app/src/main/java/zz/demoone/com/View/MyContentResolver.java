package zz.demoone.com.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pub.devrel.easypermissions.EasyPermissions;
import zz.demoone.com.BaseActivity;
import zz.demoone.com.R;
import zz.demoone.com.Utlis.TitleView;

/**
 * Created by Administrator on 2018-06-19.
 */

public class MyContentResolver extends BaseActivity implements EasyPermissions.PermissionCallbacks {

    @BindView(R.id.title)
    TitleView title;
    @BindView(R.id.phone)
    TextView phone;
    @BindView(R.id.add)
    TextView add;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contentresolver);
        ButterKnife.bind(this);
    }

    @Override
    protected void initDate() {

    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {

    }

    @OnClick({R.id.phone, R.id.add})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.phone:
                intent = new Intent(MyContentResolver.this,AddressBookActivity.class);
                startActivity(intent);
                break;
            case R.id.add:
                break;
        }
    }
}
