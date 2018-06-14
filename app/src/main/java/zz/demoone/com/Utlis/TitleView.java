package zz.demoone.com.Utlis;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import zz.demoone.com.R;

/**
 * Created by Administrator on 2018-06-12.
 * 自定义标题头
 */

public  class TitleView extends LinearLayout{

    TextView back;
    TextView start;
    TextView titlename;
    private OnTitleCleke onTitleCleke;
    public TitleView(Context context) {
        super(context);
    }

    public TitleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.view_title, this);
        back = findViewById(R.id.back);
        start = findViewById(R.id.start);
        titlename = findViewById(R.id.title_name);
        initView();
    }

    private void initView() {
        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

               onTitleCleke.finsh1();
            }
        });
        start.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
               onTitleCleke.starte1();
            }
        });
    }
    public interface OnTitleCleke{
        void finsh1();
        void starte1();
    }
    public void SetOnTitleCleke(OnTitleCleke onTitleCleke){
        this.onTitleCleke = onTitleCleke;
    }
    //定义标题名
    public void setTitlename(String name){
        titlename.setText(name);
    }
    //定义返回名
    public void setBackname(String name){
        back.setText(name);
    }
    //定义下一步
    public void setStartname(String name){
        start.setText(name);
    }
}
