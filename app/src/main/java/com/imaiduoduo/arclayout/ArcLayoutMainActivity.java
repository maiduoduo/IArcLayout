package com.imaiduoduo.arclayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * CN:      BannerActivity
 * Author： JSYL-DINGCL (dingcl@jsyl.com.cn)
 * Date:   2019/11/29
 * Des:    弧度ImageView 支持渐变移动
 */
public class ArcLayoutMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arclayout_activity_main);
        FloatingActionButton flb_banner = findViewById(R.id.flb_banner);
        flb_banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ArcLayoutMainActivity.this,BannerActivity.class));
            }
        });
    }
}
