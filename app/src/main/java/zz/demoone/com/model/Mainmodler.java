package zz.demoone.com.model;

import java.util.ArrayList;
import java.util.List;

import zz.demoone.com.Interface.MainInterface;

/**
 * Created by Administrator on 2018-06-12.
 */

public interface Mainmodler{

    void GetDate(CreateDate createDate);

    interface CreateDate{
        void getlistdate(List<String> date);
    }

}
