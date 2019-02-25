package com.example.androidbackground.Activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.example.androidbackground.Class.HttpConnect;
import com.example.androidbackground.R;
import com.example.androidbackground.jsonParse.CommendGson;
import com.example.androidbackground.jsonParse.TypeGson;
import com.example.androidbackground.adapter.MyFragmentPagerAdapter;
import com.example.androidbackground.fragment.PictureFragment;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

public class PhonePictureActivity extends AppCompatActivity implements View.OnClickListener {

    private HttpConnect httpConnect;
    private int decide = 0;
    private static final int COMMEND = 3;
    private static final int COMMENDNEW = 0;
    private static final int COMMENDHOT = 1;
    private static final int SORT = 2;
    private MyFragmentPagerAdapter myFragmentPagerAdapter;
    //Layout
    private TabLayout mTabLayout = null;
    private ViewPager mViewPager = null;
    private ImageView phone_picture;
    private ImageView computer_picture;

    //URL
    private String sortURL = "http://service.picasso.adesk.com/v1/vertical/category?adult=false&first=1";                                               //图片分类的获取网址
    private String commendURLHot = "http://service.picasso.adesk.com/v1/vertical/vertical?limit=48&skip=180&adult=false&first=0&order=hot";                //推荐图片的获取网址
    private String commendURLNew = "http://service.picasso.adesk.com/v1/vertical/vertical?limit=48&skip=180&adult=false&first=0&order=new";                //推荐图片的获取网址

    //List
    private List<String> sortIDs = new ArrayList<>();                               //类别图片ID
    private List<String> commendIDs = new ArrayList<>();                            //推荐图片ID
    private List<String> typeNames = new ArrayList<>();                             //图片标签
    private List<List<String>> tagList = new ArrayList<>();                         //壁纸标签
    private List<String> wpList = new ArrayList<>();                                //手机壁纸下载地址
    private List<Integer> viewsList = new ArrayList<>();                            //查看数
    private List<Integer> rankList = new ArrayList<>();                             //点赞数
    private List<Integer> favsList = new ArrayList<>();                             //收藏数
    private List<Double> atimeList = new ArrayList<>();                             //创建时间（单位：秒）
    private List<String> pictureThumbList = new ArrayList<>();                      //小缩略图壁纸
    private List<String> pictureImgList = new ArrayList<>();                        //大缩略图壁纸
    private List<String> coverUrls = new ArrayList<>();                             //分类的封面图片
    private List<String> typeNewUrls = new ArrayList<>();                           //某种类型图片的最新图片
    private List<String> typeHotUrls = new ArrayList<>();                           //某种类型图片的热门图片.
    private List<String> previewUrls = new ArrayList<>();                           //推荐的图片
    private List<String> titles = new ArrayList<>();                                //TabLayout的标题
    private List<PictureFragment> pictureFragments = new ArrayList<>();             //图片碎片

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        public void handleMessage(Message message) {
            switch (message.what) {
                case COMMENDHOT:
                    Bundle bundle = message.getData();
                    Gson gson = new Gson();
                    CommendGson commendGson = gson.fromJson(bundle.getString("CommendResponeHot"), CommendGson.class);
                    List<CommendGson.ResBean.VerticalBean> verticalBeans = commendGson.getRes().getVertical();
                    for (int i = 0; i < verticalBeans.size(); i++) {
                        CommendGson.ResBean.VerticalBean verticalBean = verticalBeans.get(i);
                        commendIDs.add(verticalBean.getId());
                        previewUrls.add(verticalBean.getPreview());
                        rankList.add(verticalBean.getRank());
                        favsList.add(verticalBean.getFavs());
                        atimeList.add(verticalBean.getAtime());
                        pictureThumbList.add(verticalBean.getThumb());
                        pictureImgList.add(verticalBean.getImg());
                        tagList.add(verticalBean.getTag());
                        viewsList.add(verticalBean.getViews());
                        wpList.add(verticalBean.getWp());
                    }
                    if (decide != 0) {
                        Message message1 = new Message();
                        message1.what = COMMEND;
                        handler.sendMessage(message1);
                    } else {
                        decide = 1;
                    }
                    break;
                case COMMENDNEW:
                    Gson gson2 = new Gson();
                    Bundle bundle1 = message.getData();
                    CommendGson commendGson2 = gson2.fromJson(bundle1.getString("CommendResponeNew"), CommendGson.class);
                    List<CommendGson.ResBean.VerticalBean> verticalBeans1= commendGson2.getRes().getVertical();
                    for (int i = 0; i < verticalBeans1.size(); i++) {
                        CommendGson.ResBean.VerticalBean verticalBean = verticalBeans1.get(i);
                        commendIDs.add(verticalBean.getId());
                        previewUrls.add(verticalBean.getPreview());
                        rankList.add(verticalBean.getRank());
                        favsList.add(verticalBean.getFavs());
                        atimeList.add(verticalBean.getAtime());
                        pictureThumbList.add(verticalBean.getThumb());
                        pictureImgList.add(verticalBean.getImg());
                        tagList.add(verticalBean.getTag());
                        viewsList.add(verticalBean.getViews());
                        wpList.add(verticalBean.getWp());
                    }
                    if (decide != 0) {
                        Message message1 = new Message();
                        message1.what = COMMEND;
                        handler.sendMessage(message1);
                    } else {
                        decide = 1;
                    }
                    break;
                case COMMEND:
                    PictureFragment pictureFragment = new PictureFragment();
                    pictureFragment.setData(previewUrls, "commend", null, null,
                            null, commendIDs, rankList, favsList, atimeList, pictureThumbList, pictureImgList, tagList, viewsList, wpList);
                    pictureFragments.add(pictureFragment);
                    myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), pictureFragments, titles);
                    mViewPager.setAdapter(myFragmentPagerAdapter);
                    mTabLayout.setupWithViewPager(mViewPager);
                    myFragmentPagerAdapter.notifyDataSetChanged();
                    break;
                case SORT:
                    Bundle bundle2 = message.getData();
                    Gson gson1 = new Gson();
                    TypeGson typeGson = gson1.fromJson(bundle2.getString("SortRespone"), TypeGson.class);
                    List<TypeGson.ResBean.CategoryBean> categoryBeans = typeGson.getRes().getCategory();
                    for (int i = 0; i < categoryBeans.size(); i++) {
                        TypeGson.ResBean.CategoryBean categoryBean = categoryBeans.get(i);
                        coverUrls.add(categoryBean.getCover());
                        typeNames.add(categoryBean.getName());
                        sortIDs.add(categoryBean.getId());
                        typeNewUrls.add("http://service.picasso.adesk.com/v1/vertical/category/" + categoryBean.getId()
                                + "/vertical?limit=48&adult=false&first=1&order=new");
                        typeHotUrls.add("http://service.picasso.adesk.com/v1/vertical/category/" + categoryBean.getId()
                                + "/vertical?limit=48&adult=false&first=1&order=hot");
                    }
                    PictureFragment pictureFragment1 = new PictureFragment();
                    pictureFragment1.setData(coverUrls, "sort", typeNewUrls, typeHotUrls, typeNames, sortIDs,
                            null, null, null, null, null,
                            null, null, null);
                    pictureFragments.add(pictureFragment1);
                    myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), pictureFragments, titles);
                    mViewPager.setAdapter(myFragmentPagerAdapter);
                    mTabLayout.setupWithViewPager(mViewPager);
                    myFragmentPagerAdapter.notifyDataSetChanged();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化布局
        initView();
    }

    private void initView() {
        phone_picture = findViewById(R.id.phone_picture);
        computer_picture = findViewById(R.id.computer_picture);
        computer_picture.setOnClickListener(this);
        mTabLayout = findViewById(R.id.title_tabLayout);
        mViewPager = findViewById(R.id.picture_viewPager);
        phone_picture.setImageResource(R.drawable.phone_picture_click);
        computer_picture.setImageResource(R.drawable.computer_picture);
        initSort();                                                         //初始化分类布局
        initCommendPicture();                                               //初始化推荐布局

    }

    //初始化推荐布局
    private void initCommendPicture() {
        titles.add("推荐");
        if (isMobileConnected(getApplicationContext())) {
            httpConnect = new HttpConnect(commendURLHot);
            httpConnect.sendRequestWithHttpURLConnection(new HttpConnect.Callback() {
                @Override
                public void finish(String respone) {
                    SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Json", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("commendHotJson", respone);
                    editor.commit();

                    Message message = new Message();
                    message.what = COMMENDHOT;
                    Bundle mbundle = new Bundle();
                    mbundle.putString("CommendResponeHot", respone);
                    message.setData(mbundle);
                    handler.sendMessage(message);
                }
            });


            httpConnect = new HttpConnect(commendURLNew);
            httpConnect.sendRequestWithHttpURLConnection(new HttpConnect.Callback() {
                @Override
                public void finish(String respone) {
                    SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Json", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("commendNewJson", respone);
                    editor.commit();

                    Message message = new Message();
                    message.what = COMMENDNEW;
                    Bundle mbundle = new Bundle();
                    mbundle.putString("CommendResponeNew", respone);
                    message.setData(mbundle);
                    handler.sendMessage(message);
                }
            });
        } else {
            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Json", Context.MODE_PRIVATE);
            String hotRespone = sharedPreferences.getString("commendHotJson", "");
            String newRespone = sharedPreferences.getString("commendNewJson", "");
            Message message = new Message();
            message.what = COMMENDHOT;
            Bundle mbundle = new Bundle();
            mbundle.putString("CommendResponeHot", hotRespone);
            message.setData(mbundle);
            handler.sendMessage(message);
            Log.d("responeHot", hotRespone);

            Message message1 = new Message();
            message1.what = COMMENDNEW;
            Bundle mbundle1 = new Bundle();
            mbundle1.putString("CommendResponeHot", newRespone);
            message1.setData(mbundle1);
            handler.sendMessage(message1);
            Log.d("responeNew", newRespone);
        }

    }


    //初始化分类布局
    private void initSort() {
        titles.add("分类");
        if (isMobileConnected(getApplicationContext())) {
            HttpConnect httpConnect = new HttpConnect(sortURL);
            httpConnect.sendRequestWithHttpURLConnection(new HttpConnect.Callback() {
                @Override
                public void finish(String respone) {
                    SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Json", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("sortJson", respone);
                    editor.commit();

                    Message message = new Message();
                    message.what = SORT;
                    Bundle bundle = new Bundle();
                    bundle.putString("SortRespone", respone);
                    message.setData(bundle);
                    handler.sendMessage(message);
                }
            });
        } else {
            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Json", Context.MODE_PRIVATE);
            String respone = sharedPreferences.getString("sortJson", "");
            Message message = new Message();
            message.what = SORT;
            Bundle bundle = new Bundle();
            bundle.putString("SortRespone", respone);
            message.setData(bundle);
            handler.sendMessage(message);
            Log.d("json", respone);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.computer_picture:
                startActivity(new Intent(PhonePictureActivity.this, ComputerPictureActivity.class));
                finish();
                break;
        }
    }

    //判断是否有网
    public static boolean isMobileConnected(Context context) {
        if (context != null) {
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (info != null) {
                return info.isConnected();
            }
        }
        return false;
    }
}
