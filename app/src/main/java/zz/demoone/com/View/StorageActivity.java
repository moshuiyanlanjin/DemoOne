package zz.demoone.com.View;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import butterknife.BindView;
import butterknife.ButterKnife;
import zz.demoone.com.BaseActivity;
import zz.demoone.com.R;
import zz.demoone.com.Utlis.TitleView;

/**
 * 存储
 * Created by Administrator on 2018-06-13.
 */

public class StorageActivity extends BaseActivity {
    @BindView(R.id.title)
    TitleView title;
    @BindView(R.id.edit)
    EditText edit;
    FileOutputStream output;
    BufferedWriter writer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        String load = load();
        if(TextUtils.isEmpty(load)){

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String s = edit.getText().toString();
        asve(s);
    }

    //存储
    private void asve(String s) {
        try {
            //存储文件 接受两个参数 文件名和操作模式  操作模式有两种可选1、MODE_APPEND表示该文件已经存在，直接覆盖   2、MODE_PRIVATE默认 有的话追加，没有的话创建
            output = openFileOutput("date", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(output));
            writer.write(s);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //取出
    private String load() {
        FileInputStream date;
        BufferedReader reader = null;
        StringBuilder conton = new StringBuilder();
        try {
            date = openFileInput("date");
            reader = new BufferedReader(new InputStreamReader(date));
            String line = "";
            while ((line = reader.readLine()) != null) {
                conton.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return conton.toString();
    }

    @Override
    protected void initDate() {

    }
}
