package zz.demoone.com.View.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import zz.demoone.com.R;
import zz.demoone.com.View.MainActivity;

/**
 * Created by Administrator on 2018-06-12.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{

    private Context context;
    private List<String> date;
    private OnMainClike onMainClike;
    public MainAdapter(MainActivity mainActivity, List<String> strings) {
        this.context = mainActivity;
        this.date = strings;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_text, parent);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.text.setText(date.get(position));
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMainClike.onmainclikeitem(position);
            }
        });
    }
    public interface OnMainClike{
        void onmainclikeitem(int position);
    }
    public void setOnMainClike(OnMainClike onMainClike){
        this.onMainClike = onMainClike;
    }
    @Override
    public int getItemCount() {
        return date.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        View view;
        public ViewHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
            view = itemView;
        }
    }
}
