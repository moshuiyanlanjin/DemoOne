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
        createDate.getlistdate(date);
    }
}
