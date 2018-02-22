package com.lj.douyin.douyintest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Found2Activity extends AppCompatActivity {

    @BindView(R.id.vv)
    VideoView vv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found2);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        vv.setVideoURI(Uri.parse(url));
        vv.start();
    }

}
