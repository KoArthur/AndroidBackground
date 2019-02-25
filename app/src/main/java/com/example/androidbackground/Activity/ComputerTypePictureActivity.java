package com.example.androidbackground.Activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.androidbackground.Class.HttpConnect;
import com.example.androidbackground.R;
import com.example.androidbackground.adapter.MyFragmentPagerAdapterBySort;
import com.example.androidbackground.fragment.PictureFragmentByType;
import com.example.androidbackground.jsonParse.OneAlbumGson;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

public class ComputerTypePictureActivity extends AppCompatActivity {

    private MyFragmentPagerAdapterBySort myFragmentPagerAdapterBySort;
    private static final int HOT = 0;
    private static final int NEW = 1;

    //布局
    private ImageView im_back;
    private TextView tv_picture_information;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private String typeNewUrl;
    private String typeHotUrl;
    private String name;

    private List<String> titles = new ArrayList<>();
    private List<PictureFragmentByType> pictureFragmentByTypeList = new ArrayList<>();

    private List<Double> newAtimeList = new ArrayList<>();                                             //最新图片发布时间
    private List<Integer> newFavsList = new ArrayList<>();                                             //最新图片收藏数
    private List<Integer> newRankList = new ArrayList<>();                                             //最新图片点赞数
    private List<String> newIdList = new ArrayList<>();                                                //最新图片ID
    private List<String> newImgUrlList = new ArrayList<>();                                            //最新图片大缩略图地址
    private List<String> newThumUrlList = new ArrayList<>();                                           //最新图片小缩略图
    private List<String> newPreviewUrlList = new ArrayList<>();                                        //最新壁纸地址
    private List<List<String>> newTagList = new ArrayList<>();                                         //最新图片标签
    private List<String> newWpList = new ArrayList<>();                                                //最新图片下载地址
    private List<Double> hotAtimeList = new ArrayList<>();                                             //热门图片发布时间
    private List<Integer> hotFavsList = new ArrayList<>();                                             //热门图片收藏数
    private List<Integer> hotRankList = new ArrayList<>();                                             //热门图片点赞数
    private List<String> hotIdList = new ArrayList<>();                                                //热门图片ID
    private List<String> hotImgUrlList = new ArrayList<>();                                            //热门图片大缩略图地址
    private List<String> hotThumUrlList = new ArrayList<>();                                           //热门图片小缩略图
    private List<String> hotPreviewUrlList = new ArrayList<>();                                        //热门壁纸地址
    private List<List<String>> hotTagList = new ArrayList<>();                                         //热门图片标签
    private List<String> hotWpList = new ArrayList<>();                                                //热门图片下载地址

    public static void actionStart(Context context, String name, String typeNewUrl, String typeHotUrl) {
        Intent intent = new Intent(context, ComputerTypePictureActivity.class);
        intent.putExtra("typeNewUrl", typeNewUrl);
        intent.putExtra("typeHotUrl", typeHotUrl);
        intent.putExtra("name", name);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort_picture);

        initData();

        initTitle();

        initView();

    }

    private void initData() {
        Intent intent = getIntent();
        this.typeHotUrl = intent.getStringExtra("typeHotUrl");
        this.typeNewUrl = intent.getStringExtra("typeNewUrl");
        this.name = intent.getStringExtra("name");
    }

    private void initTitle() {
        im_back = findViewById(R.id.im_back);
        tv_picture_information = findViewById(R.id.tv_picture_information);
        im_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv_picture_information.setText(name);
    }

    //获取数据
    private void initView() {
        titles.add("最新");
        titles.add("热门");
        mViewPager = findViewById(R.id.picture_viewPagerBySort);
        mTabLayout = findViewById(R.id.title_tabLayoutBySort);
        initSort();
    }

    private void initSort() {
        initHot();
        initNew();
    }

    private void initHot() {
        HttpConnect httpConnect = new HttpConnect(typeHotUrl);
        httpConnect.sendRequestWithHttpURLConnection(new HttpConnect.Callback() {
            @Override
            public void finish(String respone) {
                Gson gson = new Gson();
                OneAlbumGson oneAlbumGson = gson.fromJson(respone, OneAlbumGson.class);
                List<OneAlbumGson.ResBean.WallpaperBean> wallpaperBeanList = oneAlbumGson.getRes().getWallpaper();
                for (int i = 0; i < wallpaperBeanList.size(); i++) {
                    OneAlbumGson.ResBean.WallpaperBean wallpaperBean = wallpaperBeanList.get(i);
                    hotAtimeList.add(wallpaperBean.getAtime());
                    hotFavsList.add(wallpaperBean.getFavs());
                    hotRankList.add(wallpaperBean.getRank());
                    hotIdList.add(wallpaperBean.getId());
                    hotImgUrlList.add(wallpaperBean.getImg());
                    hotThumUrlList.add(wallpaperBean.getThumb());
                    hotPreviewUrlList.add(wallpaperBean.getPreview());
                    hotTagList.add(wallpaperBean.getTag());
                    hotWpList.add(wallpaperBean.getWp());
                }
                Message message = new Message();
                message.what = HOT;
                handler.sendMessage(message);
            }
        });
    }

    private void initNew() {
        HttpConnect httpConnect = new HttpConnect(typeNewUrl);
        httpConnect.sendRequestWithHttpURLConnection(new HttpConnect.Callback() {
            @Override
            public void finish(String respone) {
                Gson gson = new Gson();
                OneAlbumGson oneAlbumGson = gson.fromJson(respone, OneAlbumGson.class);
                List<OneAlbumGson.ResBean.WallpaperBean> wallpaperBeanList = oneAlbumGson.getRes().getWallpaper();
                for (int i = 0; i < wallpaperBeanList.size(); i++) {
                    OneAlbumGson.ResBean.WallpaperBean wallpaperBean = wallpaperBeanList.get(i);
                    newAtimeList.add(wallpaperBean.getAtime());
                    newFavsList.add(wallpaperBean.getFavs());
                    newRankList.add(wallpaperBean.getRank());
                    newIdList.add(wallpaperBean.getId());
                    newImgUrlList.add(wallpaperBean.getImg());
                    newThumUrlList.add(wallpaperBean.getThumb());
                    newPreviewUrlList.add(wallpaperBean.getPreview());
                    newTagList.add(wallpaperBean.getTag());
                    newWpList.add(wallpaperBean.getWp());
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
                    pictureFragmentByType.setData(hotPreviewUrlList, hotIdList, hotRankList, hotFavsList, hotAtimeList,
                            hotThumUrlList, hotImgUrlList, hotTagList, hotWpList, "computer");
                    pictureFragmentByTypeList.add(pictureFragmentByType);
                    myFragmentPagerAdapterBySort = new MyFragmentPagerAdapterBySort(getSupportFragmentManager(),
                            pictureFragmentByTypeList, titles);
                    mViewPager.setAdapter(myFragmentPagerAdapterBySort);
                    mTabLayout.setupWithViewPager(mViewPager);
                    myFragmentPagerAdapterBySort.notifyDataSetChanged();
                    break;
                case NEW:
                    PictureFragmentByType pictureFragmentByType1 = new PictureFragmentByType();
                    pictureFragmentByType1.setData(newPreviewUrlList, newIdList, newRankList, newFavsList, newAtimeList,
                            newThumUrlList, newImgUrlList, newTagList, newWpList, "computer");
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
