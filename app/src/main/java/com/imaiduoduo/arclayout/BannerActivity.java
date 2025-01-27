package com.imaiduoduo.arclayout;
//  ┏┓　　　┏┓
//┏┛┻━━━┛┻┓
//┃　　　　　　　┃
//┃　　　━　　　┃
//┃　┳┛　┗┳　┃
//┃　　　　　　　┃
//┃　　　┻　　　┃
//┃　　　　　　　┃
//┗━┓　　　┏━┛
//    ┃　　　┃                  神兽保佑
//    ┃　　　┃                  永无BUG！
//    ┃　　　┗━━━┓
//    ┃　　　　　　　┣┓
//    ┃　　　　　　　┏┛
//    ┗┓┓┏━┳┓┏┛
//      ┃┫┫　┃┫┫
//      ┗┻┛　┗┻┛

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.transformer.AccordionTransformer;
import com.youth.banner.transformer.BackgroundToForegroundTransformer;
import com.youth.banner.transformer.CubeInTransformer;
import com.youth.banner.transformer.CubeOutTransformer;
import com.youth.banner.transformer.DefaultTransformer;
import com.youth.banner.transformer.DepthPageTransformer;
import com.youth.banner.transformer.FlipHorizontalTransformer;
import com.youth.banner.transformer.FlipVerticalTransformer;
import com.youth.banner.transformer.ForegroundToBackgroundTransformer;
import com.youth.banner.transformer.RotateDownTransformer;
import com.youth.banner.transformer.RotateUpTransformer;
import com.youth.banner.transformer.ScaleInOutTransformer;
import com.youth.banner.transformer.StackTransformer;
import com.youth.banner.transformer.TabletTransformer;
import com.youth.banner.transformer.ZoomInTransformer;
import com.youth.banner.transformer.ZoomOutSlideTransformer;
import com.youth.banner.transformer.ZoomOutTranformer;

import java.util.ArrayList;
import java.util.List;

/**
 * CN:      BannerActivity
 * Author： JSYL-DINGCL (dingcl@jsyl.com.cn)
 * Date:   2019/11/29
 * Des:    弧度Banner
 */
public class BannerActivity extends AppCompatActivity implements OnBannerListener {
    private Banner mBannerNormal;
    private Banner mBannerInside;
    private Banner mBannerOutside;
    private LinearLayout llIndicatorNormal;
    private LinearLayout llIndicatorInside;
    private LinearLayout llIndicatorOutside;
    private List<Integer> bannerList_a;
    private List<Integer> bannerList_b;
    private List<Integer> bannerList_c;
    private int mCurrentItem = 0;
    private int mCurrentInsideItem = 0;
    private int mCurrentOutsideItem = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getData();
        setContentView(R.layout.arclayout_activity_banner);
        mBannerNormal = findViewById(R.id.mBannerNormal);
        llIndicatorNormal = findViewById(R.id.llIndicatorNormal);
        mBannerInside = findViewById(R.id.mBannerInside);
        llIndicatorInside = findViewById(R.id.llIndicatorInside);

        mBannerOutside = findViewById(R.id.mBannerOutside);
        llIndicatorOutside = findViewById(R.id.llIndicatorOutside);

        initBanner(mBannerNormal,bannerList_a);
        initBanner(mBannerInside,bannerList_b);
        initBanner(mBannerOutside,bannerList_c);
        setIndicator(llIndicatorNormal, R.drawable.selector_custom_indicator,15,15,bannerList_a);
        setIndicator(llIndicatorInside, R.drawable.selector_custom_indicator_outside,20,20,bannerList_b);
        setIndicator(llIndicatorOutside, R.drawable.selector_custom_indicator_inside,20,20,bannerList_c);

        addListener();

    }



    /**
     * 动态添加指示器
     *
     * @param view 指示器的父控件
     */
    private void setIndicator(LinearLayout view, @DrawableRes int selectIndicator,int width,int height,List<Integer> datas) {
        View viewIndicator;
        for (int i = 0; i < datas.size(); i++) {
            //创建imageview作为小圆点
            viewIndicator = new View(this);
            //设置默认背景
            viewIndicator.setBackgroundResource(selectIndicator);
            viewIndicator.setEnabled(false);
            //设置指示器宽高
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width,height);
            //除了第一个小圆点，其他小圆点都设置边距
            if (i != 0) {
                layoutParams.leftMargin = 20;
            }
            //设置布局参数
            viewIndicator.setLayoutParams(layoutParams);
            //添加指示器到布局
            view.addView(viewIndicator);
        }

        //默认选中第一个指示器
        view.getChildAt(0).setEnabled(true);
    }


    private void initBanner(Banner mBanner,List<Integer> datas) {
        List<String> titles = new ArrayList<>();
        if (titles != null && titles.size() > 0) titles.clear();
        initAnim();
        for (int i = 0; i < datas.size(); i++) {
            titles.add("");
        }
        //默认是NUM_INDICATOR_TITLE
        mBanner.setImages(datas)
                //.setBannerTitles(titles)
                .setBannerStyle(BannerConfig.NOT_INDICATOR)
                .setImageLoader(new GlideImageLoader())
                .setOnBannerListener(this)
                .setIndicatorGravity(BannerConfig.CENTER)
                //设置指示器位置（当banner模式中有指示器时）
                .setIndicatorGravity(BannerConfig.LEFT)
                .isAutoPlay(true)
                .setBannerAnimation(transformers.get(1))
                .setDelayTime(3000)
                .start();


    }


    private void addListener() {
        mBannerNormal.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                llIndicatorNormal.getChildAt(mCurrentItem).setEnabled(false);
                llIndicatorNormal.getChildAt(i).setEnabled(true);
                mCurrentItem = i;
            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });


        mBannerInside.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                llIndicatorInside.getChildAt(mCurrentInsideItem).setEnabled(false);
                llIndicatorInside.getChildAt(i).setEnabled(true);
                mCurrentInsideItem = i;
            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });


        mBannerOutside.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                llIndicatorOutside.getChildAt(mCurrentOutsideItem).setEnabled(false);
                llIndicatorOutside.getChildAt(i).setEnabled(true);
                mCurrentOutsideItem = i;
            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });

    }

    /**
     * 轮播图
     *
     * @param position
     */
    @Override
    public void OnBannerClick(int position) {
        Toast.makeText(BannerActivity.this, "点击：" + position, Toast.LENGTH_SHORT).show();
    }

    /**
     * banner动画
     */
    private List<Class<? extends ViewPager.PageTransformer>> transformers = new ArrayList<>();

    private void initAnim() {
        transformers.add(DefaultTransformer.class);
        transformers.add(AccordionTransformer.class);
        transformers.add(BackgroundToForegroundTransformer.class);
        transformers.add(ForegroundToBackgroundTransformer.class);
        transformers.add(CubeInTransformer.class);//兼容问题，慎用
        transformers.add(CubeOutTransformer.class);
        transformers.add(DepthPageTransformer.class);
        transformers.add(FlipHorizontalTransformer.class);//7
        transformers.add(FlipVerticalTransformer.class);
        transformers.add(RotateDownTransformer.class);
        transformers.add(RotateUpTransformer.class);
        transformers.add(ScaleInOutTransformer.class);
        transformers.add(StackTransformer.class);
        transformers.add(TabletTransformer.class);
        transformers.add(ZoomInTransformer.class);
        transformers.add(ZoomOutTranformer.class);
        transformers.add(ZoomOutSlideTransformer.class);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBannerNormal != null) {
            mBannerNormal.stopAutoPlay();
        }

        if (mBannerInside != null) {
            mBannerInside.stopAutoPlay();
        }
    }

    private void getData() {
        if (bannerList_a != null) bannerList_a.clear();
        else bannerList_a = new ArrayList<>();
        if (bannerList_b != null) bannerList_b.clear();
        else bannerList_b = new ArrayList<>();
        if (bannerList_c != null) bannerList_c.clear();
        else bannerList_c = new ArrayList<>();

        //数据1
        bannerList_a.add(R.mipmap.banner_a);
        bannerList_a.add(R.mipmap.banner_b);
        bannerList_a.add(R.mipmap.banner_c);
        bannerList_a.add(R.mipmap.banner_d);
        bannerList_a.add(R.mipmap.banner_e);
        bannerList_a.add(R.mipmap.banner_f);
        bannerList_a.add(R.mipmap.banner_g);

        //数据2
        bannerList_c.add(R.mipmap.banner_2_a);
        bannerList_c.add(R.mipmap.banner_2_b);
        bannerList_c.add(R.mipmap.banner_2_c);
        bannerList_c.add(R.mipmap.banner_2_d);
        bannerList_c.add(R.mipmap.banner_2_e);
        bannerList_c.add(R.mipmap.banner_2_f);
        bannerList_c.add(R.mipmap.banner_2_g);


        //数据3
        bannerList_b.add(R.mipmap.banner_3_a);
        bannerList_b.add(R.mipmap.banner_3_b);
        bannerList_b.add(R.mipmap.banner_3_c);
        bannerList_b.add(R.mipmap.banner_3_d);
        bannerList_b.add(R.mipmap.banner_3_e);
        bannerList_b.add(R.mipmap.banner_3_f);
        bannerList_b.add(R.mipmap.banner_3_g);
    }

}
