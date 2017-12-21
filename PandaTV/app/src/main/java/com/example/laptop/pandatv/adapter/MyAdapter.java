package com.example.laptop.pandatv.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.laptop.pandatv.R;
import com.example.laptop.pandatv.bean.Student;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.HolderOne> implements View.OnClickListener{
    private List<Student.DataBean.PandaeyeBean.ItemsBean> list;
    private Context mContext;
    private Student.DataBean.PandaeyeBean pandaeyeBean;

    public MyAdapter(List<Student.DataBean.PandaeyeBean.ItemsBean> list, Context mContext, Student.DataBean.PandaeyeBean pandaeyeBean) {
        this.list = list;
        this.mContext = mContext;
        this.pandaeyeBean = pandaeyeBean;
    }

    @Override
    public HolderOne onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment, parent, false);
        HolderOne holderOne = new HolderOne(view);
        view.setOnClickListener(this);
        return holderOne;
    }

    @Override
    public void onBindViewHolder(HolderOne holder, int position) {
        Student.DataBean.PandaeyeBean.ItemsBean itemsBean = list.get(position);
        holder.mNmae1.setText(itemsBean.getBrief());
        holder.mName2.setText(itemsBean.getTitle());
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class HolderOne extends RecyclerView.ViewHolder {
        private TextView  mNmae1, mName2;
        public HolderOne(View itemView) {
            super(itemView);
            mNmae1 = (TextView) itemView.findViewById(R.id.Namae);
            mName2 = (TextView) itemView.findViewById(R.id.Namae1);
        }
    }
    public interface OnItemSet{
        void onItem(View v, int position);
    }
    private OnItemSet item;
    @Override
    public void onClick(View view) {
        if (item!=null){
            item.onItem(view,(int)view.getTag());
        }
    }
    public void onClick(OnItemSet item){
        this.item = item;
    }
}
