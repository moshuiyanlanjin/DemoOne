package zz.demoone.com.Interface;

import java.util.List;

/**
 * Created by Administrator on 2018-06-12.
 */

public interface MainInterface {
    //搭建桥梁

    interface Presenter{
        void LatDate();
    }
    interface View{
        void SDetate(List<String> date);
    }
}
