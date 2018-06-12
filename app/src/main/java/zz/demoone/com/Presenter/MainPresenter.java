package zz.demoone.com.Presenter;

import java.util.List;

import zz.demoone.com.Interface.MainInterface;
import zz.demoone.com.model.Mainmodelimple;
import zz.demoone.com.model.Mainmodler;

/**
 * Created by Administrator on 2018-06-12.
 */

public class MainPresenter implements MainInterface.Presenter{

    private MainInterface.View view;
    private Mainmodler modle;
    public MainPresenter(MainInterface.View view){
        this.view = view;
        this.modle = new Mainmodelimple();
    }

    @Override
    public void LatDate() {
        modle.GetDate(new Mainmodler.CreateDate() {
            @Override
            public void getlistdate(List<String> date) {
                view.SDetate(date);
            }
        });
    }
}
