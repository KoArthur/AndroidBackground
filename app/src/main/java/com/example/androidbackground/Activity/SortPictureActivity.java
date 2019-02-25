package com.example.androidbackground.Activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.androidbackground.Class.HttpConnect;
import com.example.androidbackground.R;
import com.example.androidbackground.adapter.MyFragmentPagerAdapterBySort;
import com.example.androidbackground.fragment.PictureFragmentByType;
import com.example.androidbackground.jsonParse.CommendGson;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

public class SortPictureActivity extends AppCompatActivity {

    private MyFragmentPagerAdapterBySort myFragmentPagerAdapterBySort;
    private static final int HOT = 0;
    private static final int NEW = 1;

    //Layout
    TabLayout mTabLayout = null;
    ViewPager mViewPager = null;
    ImageView im_back = null;
    TextView tv_picture_type = null;

    //List
    private List<List<String>> hotTagList = new ArrayList<>();                         //壁纸标签
    private List<String> hotWpList = new ArrayList<>();                                //手机壁纸下载地址
    private List<Integer> hotViewsList = new ArrayList<>();                            //查看数
    private List<List<String>> newTagList = new ArrayList<>();                         //壁纸标签
    private List<String> newWpList = new ArrayList<>();                                //手机壁纸下载地址
    private List<Integer> newViewsList = new ArrayList<>();                            //查看数
    private List<Integer> hotRankList = new ArrayList<>();                             //点赞数--热门
    private List<Integer> hotFavsList = new ArrayList<>();                             //收藏数--热门
    private List<Double> hotAtimeList = new ArrayList<>();                             //创建时间（单位：秒）--热门
    private List<String> hotPictureThumbList = new ArrayList<>();                      //小缩略图壁纸--热门
    private List<String> hotPictureImgList = new ArrayList<>();                        //大缩略图壁纸--热门
    private List<Integer> newRankList = new ArrayList<>();                             //点赞数--最新
    private List<Integer> newFavsList = new ArrayList<>();                             //收藏数--最新
    private List<Double> newAtimeList = new ArrayList<>();                             //创建时间（单位：秒）--最新
    private List<String> newPictureThumbList = new ArrayList<>();                      //小缩略图壁纸--最新
    private List<String> newPictureImgList = new ArrayList<>();                        //大缩略图壁纸--最新
    private List<String> hotIDs = new ArrayList<>();
    private List<String> newIDs = new ArrayList<>();
    private List<String> newpreviewUrlList = new ArrayList<>();                                           //某种类型图片的最新图片
    private List<String> hotPreviewUrls = new ArrayList<>();                                           //某种类型图片的热门图片
    private List<String> titles = new ArrayList<>();
    private List<PictureFragmentByType> pictureFragmentByTypeList = new ArrayList<>();

    //URL
    private String typeNewUrl = null;
    private String typeHotUrl = null;

    private String name = null;

    //从MainActivity传递数据到SortPictureActivity
    public static void actionStart(Context context, String name, String typeNewUrl, String typeHotUrl) {
        Intent intent = new Intent(context, SortPictureActivity.class);
        intent.putExtra("typeNewUrl", typeNewUrl);
        intent.putExtra("typeHotUrl", typeHotUrl);
        intent.putExtra("name", name);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort_picture);
        Intent intent = getIntent();
        this.typeNewUrl = intent.getStringExtra("typeNewUrl");
        this.typeHotUrl = intent.getStringExtra("typeHotUrl");
        this.name = intent.getStringExtra("name");

        //初始化
        initView();
        initTitle();

    }

    private void initTitle() {
        im_back = findViewById(R.id.im_back);
        tv_picture_type = findViewById(R.id.tv_picture_information);

        im_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tv_picture_type.setText(name);
    }

    private void initView() {
        mTabLayout = findViewById(R.id.title_tabLayoutBySort);
        mViewPager = findViewById(R.id.picture_viewPagerBySort);

        titles.add("最新");
        titles.add("热门");

        initNew();
        initHot();

    }

    private void initHot() {
        //解析热门图片数据
        HttpConnect httpConnect = new HttpConnect(typeHotUrl);
        httpConnect.sendRequestWithHttpURLConnection(new HttpConnect.Callback() {
            @Override
            public void finish(String respone) {
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Json", Context.MODE_PRIVATE);
                if (respone == null) {
                    respone = sharedPreferences.getString("hotJson", null);
                } else {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("hotJson", respone);
                    editor.commit();
                }
                Gson gson = new Gson();
                CommendGson commendGson = gson.fromJson(respone, CommendGson.class);
                List<CommendGson.ResBean.VerticalBean> verticalBeans = commendGson.getRes().getVertical();
                for (CommendGson.ResBean.VerticalBean verticalBean : verticalBeans) {
                    hotPreviewUrls.add(verticalBean.getPreview());
                    hotIDs.add(verticalBean.getId());
                    hotRankList.add(verticalBean.getRank());
                    hotAtimeList.add(verticalBean.getAtime());
                    hotFavsList.add(verticalBean.getFavs());
                    hotPictureImgList.add(verticalBean.getImg());
                    hotPictureThumbList.add(verticalBean.getThumb());
                    hotViewsList.add(verticalBean.getViews());
                    hotTagList.add(verticalBean.getTag());
                    hotWpList.add(verticalBean.getWp());
                }
                Message message = new Message();
                message.what = HOT;
                handler.sendMessage(message);
            }
        });

    }

    private void initNew() {
        //解析最新图片数据
        HttpConnect httpConnect = new HttpConnect(typeNewUrl);
        httpConnect.sendRequestWithHttpURLConnection(new HttpConnect.Callback() {
            @Override
            public void finish(String respone) {
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Json", Context.MODE_PRIVATE);
                if (respone == null) {
                    respone = sharedPreferences.getString("newJson", null);
                } else {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("newJson", respone);
                    editor.commit();
                }
                Gson gson = new Gson();
                CommendGson commendGson = gson.fromJson(respone, CommendGson.class);
                List<CommendGson.ResBean.VerticalBean> verticalBeans = commendGson.getRes().getVertical();
                for (CommendGson.ResBean.VerticalBean verticalBean : verticalBeans) {
                    newpreviewUrlList.add(verticalBean.getPreview());
                    newIDs.add(verticalBean.getId());
                    newRankList.add(verticalBean.getRank());
                    newAtimeList.add(verticalBean.getAtime());
                    newFavsList.add(verticalBean.getFavs());
                    newPictureImgList.add(verticalBean.getImg());
                    newPictureThumbList.add(verticalBean.getThumb());
                    newViewsList.add(verticalBean.getViews());
                    newTagList.add(verticalBean.getTag());
                    newWpList.add(verticalBean.getWp());
                }
                Message message = new Message();
                message.what = NEW;
                handler.sendMessage(message);
            }
        });

    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        public void handleMessage(Message message) {
            switch (message.what) {
                case HOT:
                    PictureFragmentByType pictureFragmentByType = new PictureFragmentByType();
                    Log.d("Computer", "size = " + hotPreviewUrls.size() + " " + hotIDs.size());
                    pictureFragmentByType.setData(hotPreviewUrls, hotIDs, hotRankList, hotFavsList, hotAtimeList,
                            hotPictureThumbList, hotPictureImgList, hotTagList, hotWpList, "phone");
                    pictureFragmentByTypeList.add(pictureFragmentByType);
                    myFragmentPagerAdapterBySort = new MyFragmentPagerAdapterBySort(getSupportFragmentManager(),
                            pictureFragmentByTypeList, titles);
                    mViewPager.setAdapter(myFragmentPagerAdapterBySort);
                    mTabLayout.setupWithViewPager(mViewPager);
                    myFragmentPagerAdapterBySort.notifyDataSetChanged();
                    break;
                case NEW:
                    PictureFragmentByType pictureFragmentByType1 = new PictureFragmentByType();
                    Log.d("Computer", "size = " + newpreviewUrlList.size() + " " + newIDs.size());
                    pictureFragmentByType1.setData(newpreviewUrlList, newIDs, newRankList, newFavsList, newAtimeList,
                            newPictureThumbList, newPictureImgList, newTagList, newWpList, "phone");
                    pictureFragmentByTypeList.add(pictureFragmentByType1);
                    myFragmentPagerAdapterBySort = new MyFragmentPagerAdapterBySort(getSupportFragmentManager(),
                            pictureFragmentByTypeList, titles);
                    mViewPager.setAdapter(myFragmentPagerAdapterBySort);
                    mTabLayout.setupWithViewPager(mViewPager);
                    myFragmentPagerAdapterBySort.notifyDataSetChanged();
                    break;

            }
        }
    };

}
