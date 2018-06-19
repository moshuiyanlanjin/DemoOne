package zz.demoone.com.View.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import zz.demoone.com.View.AddressBookActivity;
import zz.demoone.com.model.PhoneModler;

/**
 * Created by Administrator on 2018-06-19.
 */

public class AddressBookAdapter extends RecyclerView.Adapter<AddressBookAdapter.ViewHolder>{

    private List<PhoneModler> modlerlist;
    private AddressBookActivity addressBookActivity;
    public AddressBookAdapter(AddressBookActivity addressBookActivity, List<PhoneModler> modlerlist) {
        this.modlerlist = modlerlist;
        this.addressBookActivity = addressBookActivity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
