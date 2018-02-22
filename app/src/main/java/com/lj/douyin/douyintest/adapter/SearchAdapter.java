package com.lj.douyin.douyintest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.lj.douyin.douyintest.R;
import com.lj.douyin.douyintest.bean.SearchBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2018/2/22.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder0> {

    private Context context;
    private List<SearchBean.DataBean> list;

    public SearchAdapter(Context context, List<SearchBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder0 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_search_adapter, null);
        ViewHolder0 viewHolder = new ViewHolder0(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder0 holder, int position) {

        if (list.get(position).getType() == 2) {
            holder.search_tv.setText(list.get(position).getChallenge().getCha_name());
        } else {
            holder.search_tv.setText(list.get(position).getMusic().getTitle());
        }
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    static class ViewHolder0 extends RecyclerView.ViewHolder {
        @BindView(R.id.search_tv)
        TextView search_tv;

        ViewHolder0(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
