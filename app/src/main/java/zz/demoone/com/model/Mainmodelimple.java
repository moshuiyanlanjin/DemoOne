package zz.demoone.com.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018-06-12.
 */

public class Mainmodelimple implements Mainmodler{
    private List<String> date = new ArrayList<>();

    @Override
    public void GetDate(CreateDate createDate) {
        date.add("fragment");
        date.add("activity的临时数据");
        date.add("安卓的广播");
        date.add("文件储存");
        date.add("Sqlite");
        date.add("LitePal");
        date.add("内容提供者");
        date.add("多媒体");
        date.add("摄像头及相册");
        createDate.getlistdate(date);
    }
}
