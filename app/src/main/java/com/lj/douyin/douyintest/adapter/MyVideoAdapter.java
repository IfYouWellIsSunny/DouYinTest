package com.lj.douyin.douyintest.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.lj.douyin.douyintest.R;
import com.lj.douyin.douyintest.bean.FoundList;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2018/2/22.
 */

public class MyVideoAdapter extends RecyclerView.Adapter<MyVideoAdapter.ViewHolder1> {
    private Context context;
    private List<FoundList.CategoryListBean> list;

    public MyVideoAdapter(Context context, List<FoundList.CategoryListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyVideoAdapter.ViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_video, null);
        ViewHolder1 viewHolder = new ViewHolder1(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyVideoAdapter.ViewHolder1 holder, int position) {

        holder.userText.setText(list.get(position).getDesc());
      FoundList.CategoryListBean.ChallengeInfoBean challenge_info = list.get(position).getChallenge_info();

            String desc = challenge_info.getCha_name();
            holder.userTitle.setText(desc);

        List<FoundList.CategoryListBean.AwemeListBean> aweme_list1 = list.get(position).getAweme_list();
        MyVideoAdapter2 myVideoAdapter2 = new MyVideoAdapter2(context, aweme_list1);
        holder.rcVideo.setAdapter(myVideoAdapter2);
        holder.rcVideo.setLayoutManager(new GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {
        @BindView(R.id.user_text)
        TextView userText;
        @BindView(R.id.user_title)
        TextView userTitle;
        @BindView(R.id.rc_video)
        RecyclerView rcVideo;

        ViewHolder1(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }

}
