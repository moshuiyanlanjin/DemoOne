package zz.demoone.com.View;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pub.devrel.easypermissions.EasyPermissions;
import zz.demoone.com.BaseActivity;
import zz.demoone.com.R;
import zz.demoone.com.Utlis.TitleView;
import zz.demoone.com.Utlis.ToastUtlis;

/**
 * Created by Administrator on 2018-06-20.
 */

public class PhotographActivity extends BaseActivity implements EasyPermissions.PermissionCallbacks{

    @BindView(R.id.title)
    TitleView title;
    @BindView(R.id.camera)
    TextView camera;
    @BindView(R.id.photo_album)
    TextView photoAlbum;
    @BindView(R.id.image)
    ImageView image;
    private String[] parem = new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE};
    boolean isNull=false;//判断照相机返回数据是否为空

    private Uri uri;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photograph);
        ButterKnife.bind(this);
    }

    @Override
    protected void initDate() {

    }

    @OnClick({R.id.camera, R.id.photo_album})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.camera:
                if(EasyPermissions.hasPermissions(PhotographActivity.this,parem)){
                    CameraCall();
                }else{
                 EasyPermissions.requestPermissions(PhotographActivity.this,"请开启相应权限",1,parem);
                }
                break;
            case R.id.photo_album:
                break;
        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        CameraCall();
    }

    private void CameraCall() {
        File outimage = new File(getExternalCacheDir(),"out_image.jpg");
        try {
            if(outimage.exists()){//判断是否存在
                outimage.delete();
            }
            outimage.createNewFile();//创建路径
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(Build.VERSION.SDK_INT >= 24){
            uri = FileProvider.getUriForFile(PhotographActivity.this, "zz.demoone.com.View.PhotographActivity", outimage);
        }else{
            uri = Uri.fromFile(outimage);
        }
        //启动相机程序
        Log.d("ceshis",outimage.toString());
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, outimage);
        isNull = true;
        startActivityForResult(intent, 2);
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        EasyPermissions.requestPermissions(this,"请开启相机相关权限！",1,parem);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults,PhotographActivity.this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode){
            case 2:

                if(resultCode == RESULT_OK){
                    try {
                      /*  if(data == null){
                            if(isNull){
                                File outimage = new File(Environment.getExternalStoragePublicDirectory("").getPath()+"out_image.jpg");
                                Log.d("lidh","imagesize = "+outimage.toString());
                                if(Build.VERSION.SDK_INT >= 24){
                                    uri = FileProvider.getUriForFile(PhotographActivity.this, "zz.demoone.com.View.PhotographActivity", outimage);
                                }else{
                                    uri = Uri.fromFile(outimage);
                                }
                                Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
                                image.setImageBitmap(bitmap);
                                isNull = false;
                            }
                        }*/



                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
                        //Bitmap bitmap = decodeUri(PhotographActivity.this, uri, 200, 200);
                       // ToastUtlis.showtoast(PhotographActivity.this,bitmap.toString());
                        /*DisplayMetrics dm = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(dm);
                        int screenWidth=dm.widthPixels;
                        if(bitmap.getWidth()<=screenWidth){
                            image.setImageBitmap(bitmap);
                        }else{
                            Bitmap bmp=Bitmap.createScaledBitmap(bitmap, screenWidth, bitmap.getHeight()*screenWidth/bitmap.getWidth(), true);
                            image.setImageBitmap(bmp);
                        }*/
                        image.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
                }
                break;
        }
    }


    /**
     * 读取一个缩放后的图片，限定图片大小，避免OOM
     * @param uri       图片uri，支持“file://”、“content://”
     * @param maxWidth  最大允许宽度
     * @param maxHeight 最大允许高度
     * @return  返回一个缩放后的Bitmap，失败则返回null
     */
    public static Bitmap decodeUri(Context context, Uri uri, int maxWidth, int maxHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true; //只读取图片尺寸
        resolveUri(context, uri, options);

        //计算实际缩放比例
        int scale = 1;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if ((options.outWidth / scale > maxWidth &&
                    options.outWidth / scale > maxWidth * 1.4) ||
                    (options.outHeight / scale > maxHeight &&
                            options.outHeight / scale > maxHeight * 1.4)) {
                scale++;
            } else {
                break;
            }
        }

        options.inSampleSize = scale;
        options.inJustDecodeBounds = false;//读取图片内容
        options.inPreferredConfig = Bitmap.Config.RGB_565; //根据情况进行修改
        Bitmap bitmap = null;
        try {
            bitmap = resolveUriForBitmap(context, uri, options);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return bitmap;
    }


    private static void resolveUri(Context context, Uri uri, BitmapFactory.Options options) {
        if (uri == null) {
            return;
        }

        String scheme = uri.getScheme();
        if (ContentResolver.SCHEME_CONTENT.equals(scheme) ||
                ContentResolver.SCHEME_FILE.equals(scheme)) {
            InputStream stream = null;
            try {
                stream = context.getContentResolver().openInputStream(uri);
                BitmapFactory.decodeStream(stream, null, options);
            } catch (Exception e) {
                Log.w("resolveUri", "Unable to open content: " + uri, e);
            } finally {
                if (stream != null) {
                    try {
                        stream.close();
                    } catch (IOException e) {
                        Log.w("resolveUri", "Unable to close content: " + uri, e);
                    }
                }
            }
        } else if (ContentResolver.SCHEME_ANDROID_RESOURCE.equals(scheme)) {
            Log.w("resolveUri", "Unable to close content: " + uri);
        } else {
            Log.w("resolveUri", "Unable to close content: " + uri);
        }
    }

    private static Bitmap resolveUriForBitmap(Context context, Uri uri, BitmapFactory.Options options) {
        if (uri == null) {
            return null;
        }

        Bitmap bitmap = null;
        String scheme = uri.getScheme();
        if (ContentResolver.SCHEME_CONTENT.equals(scheme) ||
                ContentResolver.SCHEME_FILE.equals(scheme)) {
            InputStream stream = null;
            try {
                stream = context.getContentResolver().openInputStream(uri);
                bitmap = BitmapFactory.decodeStream(stream, null, options);
            } catch (Exception e) {
                Log.w("resolveUriForBitmap", "Unable to open content: " + uri, e);
            } finally {
                if (stream != null) {
                    try {
                        stream.close();
                    } catch (IOException e) {
                        Log.w("resolveUriForBitmap", "Unable to close content: " + uri, e);
                    }
                }
            }
        } else if (ContentResolver.SCHEME_ANDROID_RESOURCE.equals(scheme)) {
            Log.w("resolveUriForBitmap", "Unable to close content: " + uri);
        } else {
            Log.w("resolveUriForBitmap", "Unable to close content: " + uri);
        }

        return bitmap;
    }
}
