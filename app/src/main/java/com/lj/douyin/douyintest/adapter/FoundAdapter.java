package com.lj.douyin.douyintest.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lj.douyin.douyintest.R;
import com.lj.douyin.douyintest.bean.FoundBanner;
import com.lj.douyin.douyintest.bean.FoundList;
import com.lj.douyin.douyintest.bean.SearchBean;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2018/2/22.
 */

public class FoundAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder> {

    private Context context;
    private List<FoundBanner.BannerBean> ban;
    private List<FoundList.CategoryListBean> list;
    private List<SearchBean.DataBean> search;
    private ArrayList<String> listimg;
    private boolean flag;

    public FoundAdapter(Context context, List<FoundBanner.BannerBean> ban, List<FoundList.CategoryListBean> list, List<SearchBean.DataBean> search) {
        this.context = context;
        this.ban = ban;
        this.list = list;
        this.search = search;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else {
            return 2;
        }

    }

    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_search, null);
            ViewHolder0 viewHolder0 = new ViewHolder0(view);
            return viewHolder0;

        } else if (viewType == 1) {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_banner, null);
            ViewHolder1 viewHolder1 = new ViewHolder1(view);
            return viewHolder1;
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_user, null);
            ViewHolder2 viewHolder2 = new ViewHolder2(view);
            return viewHolder2;
        }

    }

    @Override
    public void onBindViewHolder(XRecyclerView.ViewHolder holder, int position) {
      if (holder instanceof  ViewHolder0){
            ViewHolder0 viewHolder0 = (ViewHolder0) holder;
            viewHolder0.search_rc.setLayoutManager(new GridLayoutManager(context,2));
             SearchAdapter searchAdapter=new SearchAdapter(context,search);
             viewHolder0.search_rc.setAdapter(searchAdapter);
        }
        else if (holder instanceof ViewHolder1) {
            ViewHolder1 v1 = (ViewHolder1) holder;

            listimg = new ArrayList<>();
            ArrayList<String> listtitle = new ArrayList<>();
            listimg.clear();
            listtitle.clear();
            for (int i = 0; i < ban.size(); i++) {
                String s = ban.get(i).getBanner_url().getUrl_list().get(0);
                String title = ban.get(i).getTitle();
                listimg.add(s);
                listtitle.add(title);
            }
            if (!flag) {
                v1.banner.setData(listimg, null);
                v1.banner.setmAdapter(new XBanner.XBannerAdapter() {
                    @Override
                    public void loadBanner(XBanner banner, Object model, View view, int position) {
                        Glide.with(context).load(listimg.get(position)).into((ImageView) view);
                    }

                });
                flag = true;
            } else {

            }

            v1.banner.setPageTransformer(Transformer.Default);
            v1.banner.setPageChangeDuration(1000);
        }

      else if (holder instanceof ViewHolder2) {
          ViewHolder2 viewHolder2 = (ViewHolder2) holder;
          viewHolder2.user_rc.setLayoutManager(new GridLayoutManager(context, 1, GridLayoutManager.VERTICAL, false));
          MyVideoAdapter myVideoAdapter = new MyVideoAdapter(context, list);
          viewHolder2.user_rc.setAdapter(myVideoAdapter);
      }

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    static class ViewHolder1 extends XRecyclerView.ViewHolder {
        @BindView(R.id.banner)
        XBanner banner;

        ViewHolder1(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    class ViewHolder2 extends XRecyclerView.ViewHolder {
        @BindView(R.id.user_rc)
        RecyclerView user_rc;

        ViewHolder2(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    static class ViewHolder0 extends XRecyclerView.ViewHolder{
        @BindView(R.id.search_rc)
        RecyclerView search_rc;

        ViewHolder0(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
