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

import com.example.androidbackground.Class.Album;
import com.example.androidbackground.Class.HttpConnect;
import com.example.androidbackground.R;
import com.example.androidbackground.adapter.MyFragmentAdapterByComputer;
import com.example.androidbackground.fragment.PictureFragmentByComputer;
import com.example.androidbackground.jsonParse.AlbumArtGson;
import com.example.androidbackground.jsonParse.SortGson;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

public class ComputerPictureActivity extends AppCompatActivity implements View.OnClickListener {

    private MyFragmentAdapterByComputer adapter;
    private int decide = 0;
    private static final int ALBUM = 3;
    private static final int SORT = 2;

    //Layout
    private TabLayout mTabLayout = null;
    private ViewPager mViewPager = null;
    private ImageView phone_picture = null;
    private ImageView computer_picture = null;

    //Url
    private String sortUrl = "http://service.picasso.adesk.com/v1/wallpaper/category";
    private String albumArtHotUrl = "http://service.picasso.adesk.com/v1/wallpaper/album?limit=48&adult=false&first=1&order=hot";
    private String albumArtNewUrl = "http://service.picasso.adesk.com/v1/wallpaper/album?limit=48&adult=false&first=1&order=new";

    //List
    private List<String> titles = new ArrayList<>();                                                //TabLayout的标题
    private List<PictureFragmentByComputer> pictureFragmentByComputers = new ArrayList<>();         //图片碎片

    private List<String> albumDescList = new ArrayList<>();                                         //专辑描述
    private List<String> albumNameList = new ArrayList<>();                                         //专辑名字
    private List<String> albumCoverUrlList = new ArrayList<>();                                     //专辑封面地址
    private List<String> albumIdList = new ArrayList<>();                                           //专辑ID
    private List<Integer> albumFavsList = new ArrayList<>();                                        //专辑收藏数
    private List<String> albumLcoverUrlList = new ArrayList<>();                                    //专辑大封面地址
    private List<String> albumBannerThumUrlList = new ArrayList<>();                                //推荐专辑封面地址
    private List<String> albumBannerIdList = new ArrayList<>();                                     //推荐专辑ID
    private List<String> albumBannerDescList = new ArrayList<>();                                   //推荐专辑的描述
    private List<String> albumBannerNameList = new ArrayList<>();                                   //推荐专辑的名字
    private List<String> sortNames = new ArrayList<>();                                             //类别名字
    private List<String> sortCoverUrls = new ArrayList<>();                                         //类别封面地址
    private List<String> sortIds = new ArrayList<>();                                               //类别ID

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        public void handleMessage(Message message) {
            switch (message.what) {
                case ALBUM:
                    PictureFragmentByComputer pictureFragmentByComputer = new PictureFragmentByComputer();
                    pictureFragmentByComputer.setData(albumNameList, albumCoverUrlList, albumIdList, albumFavsList,
                            null, null, null, albumLcoverUrlList, albumBannerThumUrlList,
                            albumBannerIdList, albumDescList, albumBannerDescList, albumBannerNameList);
                    pictureFragmentByComputers.add(pictureFragmentByComputer);
                    adapter = new MyFragmentAdapterByComputer(getSupportFragmentManager(), pictureFragmentByComputers, titles);
                    mViewPager.setAdapter(adapter);
                    mTabLayout.setupWithViewPager(mViewPager);
                    adapter.notifyDataSetChanged();
                    break;
                case SORT:
                    adapter = new MyFragmentAdapterByComputer(getSupportFragmentManager(), pictureFragmentByComputers, titles);
                    mViewPager.setAdapter(adapter);
                    mTabLayout.setupWithViewPager(mViewPager);
                    adapter.notifyDataSetChanged();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        phone_picture = findViewById(R.id.phone_picture);
        phone_picture.setOnClickListener(this);
        computer_picture = findViewById(R.id.computer_picture);
        mTabLayout = findViewById(R.id.title_tabLayout);
        mViewPager = findViewById(R.id.picture_viewPager);
        computer_picture.setImageResource(R.drawable.computer_picture_click);
        phone_picture.setImageResource(R.drawable.phone_picture);

        titles.add("分类");
        titles.add("专辑");

        //初始化专辑
        initAlbum();

        //初始化分类
        initSort();

    }

    private void initAlbum() {
        HttpConnect httpConnect1 = new HttpConnect(albumArtNewUrl);
        httpConnect1.sendRequestWithHttpURLConnection(new HttpConnect.Callback() {
            @Override
            public void finish(String respone) {
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Json", Context.MODE_PRIVATE);
                if (respone == null) {
                    respone = sharedPreferences.getString("albumArtNewUrl", null);
                } else {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("albumArtNewUrl", respone);
                    editor.commit();
                }
                Gson gson1 = new Gson();
                AlbumArtGson albumArtGson1 = gson1.fromJson(respone, AlbumArtGson.class);
                List<AlbumArtGson.ResBean.AlbumBean> albumBeanList1 = albumArtGson1.getRes().getAlbum();
                for (int i = 0; i < albumBeanList1.size(); i++) {
                    AlbumArtGson.ResBean.AlbumBean albumBean = albumBeanList1.get(i);
                    albumNameList.add(albumBean.getName());
                    albumCoverUrlList.add(albumBean.getCover());
                    albumIdList.add(albumBean.getId());
                    albumFavsList.add(albumBean.getFavs());
                    albumLcoverUrlList.add(albumBean.getLcover());
                    albumDescList.add(albumBean.getDesc());
                }
                if (decide != 0) {
                    Message message = new Message();
                    message.what = ALBUM;
                    handler.sendMessage(message);
                } else {
                    decide = 1;
                }
            }
        });

        HttpConnect httpConnect = new HttpConnect(albumArtHotUrl);
        httpConnect.sendRequestWithHttpURLConnection(new HttpConnect.Callback() {
            @Override
            public void finish(String respone) {
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Json", Context.MODE_PRIVATE);
                if (respone == null) {
                    respone = sharedPreferences.getString("albumArtHotUrl", null);
                } else {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("albumArtHotUrl", respone);
                    editor.commit();
                }
                Gson gson = new Gson();
                AlbumArtGson albumArtGson = gson.fromJson(respone, AlbumArtGson.class);
                List<AlbumArtGson.ResBean.AlbumBean> albumBeanList = albumArtGson.getRes().getAlbum();
                for (int i = 0; i < albumBeanList.size(); i++) {
                    AlbumArtGson.ResBean.AlbumBean albumBean = albumBeanList.get(i);
                    albumNameList.add(albumBean.getName());
                    albumCoverUrlList.add(albumBean.getLcover());
                    albumIdList.add(albumBean.getId());
                    albumFavsList.add(albumBean.getFavs());
                    albumLcoverUrlList.add(albumBean.getLcover());
                    albumDescList.add(albumBean.getDesc());
                }
                List<AlbumArtGson.ResBean.BannerBean> bannerBeanList = albumArtGson.getRes().getBanner();
                for (int i = 0; i < bannerBeanList.size(); i++) {
                    AlbumArtGson.ResBean.BannerBean bannerBean = bannerBeanList.get(i);
                    albumBannerThumUrlList.add(bannerBean.getThumb());
                    albumBannerIdList.add(bannerBean.getId());
                    albumBannerDescList.add(bannerBean.getValue().getDesc());
                    albumBannerNameList.add(bannerBean.getValue().getName());
                }
                if (decide != 0) {
                    Message message = new Message();
                    message.what = ALBUM;
                    handler.sendMessage(message);
                } else {
                    decide = 1;
                }
            }
        });
    }

    private void initSort() {
        HttpConnect httpConnect1 = new HttpConnect(sortUrl);
        httpConnect1.sendRequestWithHttpURLConnection(new HttpConnect.Callback() {
            @Override
            public void finish(String respone) {
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Json", Context.MODE_PRIVATE);
                if (respone == null) {
                    respone = sharedPreferences.getString("sortComputerUrl", null);
                } else {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("sortComputerUrl", respone);
                    editor.commit();
                }
                Gson gson2 = new Gson();
                SortGson sortGson = gson2.fromJson(respone, SortGson.class);
                if (sortGson != null) {
                    Log.d("sort", "!NULL");
                } else {
                    Log.d("sort", "NULL");
                }
                List<SortGson.ResBean.CategoryBean> categoryBeanList = sortGson.getRes().getCategory();
                for (int i = 0; i < categoryBeanList.size(); i++) {
                    SortGson.ResBean.CategoryBean categoryBean = categoryBeanList.get(i);
                    sortNames.add(categoryBean.getName());
                    sortCoverUrls.add(categoryBean.getCover());
                    sortIds.add(categoryBean.getId());
                }
                PictureFragmentByComputer pictureFragmentByComputer1 = new PictureFragmentByComputer();
                pictureFragmentByComputer1.setData(null, null, null,
                        null, sortNames, sortCoverUrls, sortIds, null,
                        null, null, null,null,
                        null);
                pictureFragmentByComputers.add(pictureFragmentByComputer1);
                Message message = new Message();
                message.what = SORT;
                handler.sendMessage(message);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.phone_picture:
                startActivity(new Intent(ComputerPictureActivity.this, PhonePictureActivity.class));
                finish();
                break;
        }
    }
}
