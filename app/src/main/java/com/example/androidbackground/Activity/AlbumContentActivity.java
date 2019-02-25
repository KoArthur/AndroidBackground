package com.example.androidbackground.Activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.androidbackground.Class.AlbumPicture;
import com.example.androidbackground.Class.HttpConnect;
import com.example.androidbackground.R;
import com.example.androidbackground.adapter.OneAlbumAdapter;
import com.example.androidbackground.jsonParse.OneAlbumGson;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

public class AlbumContentActivity extends AppCompatActivity {

    private static final int ALBUM = 0;

    private String id;
    private String name;
    private String newUrl;
    private String hotUrl;
    private String lcoverUrl;

    private ImageView album_head;
    private TextView album_title;
    private RecyclerView album_recycler;
    private ImageView im_back;

    private List<Double> atimeList = new ArrayList<>();                                             //每张图片发布的时间
    private List<Integer> rankList = new ArrayList<>();                                             //每张图片的点赞数量
    private List<Integer> favsList = new ArrayList<>();                                             //每张图片得收藏数量
    private List<String> thumbList = new ArrayList<>();                                             //每张图片（三种图片中为中等大小）
    private List<String> imgList = new ArrayList<>();                                               //每张图片（三种图片中最大）
    private List<String> previewList = new ArrayList<>();                                           //每张图片（三种图片中最小）
    private List<String> idList = new ArrayList<>();                                                //每张图片的ID
    private List<String> wpList = new ArrayList<>();                                                //每张图片得下载地址

    private List<AlbumPicture> albumPictureList = new ArrayList<>();                                //专辑图片

    public void actionStart(Context context, String id, String name, String lcoverUrl) {
        Intent intent = new Intent(context, AlbumContentActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("name", name);
        intent.putExtra("lcoverUrl", lcoverUrl);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_content);

        initData();

        initView();
    }

    private void initView() {
        im_back = findViewById(R.id.im_back);
        im_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        album_head = findViewById(R.id.album_head);
        album_title = findViewById(R.id.album_title);
        album_recycler = findViewById(R.id.album_recycler);
        Picasso.with(AlbumContentActivity.this).load(lcoverUrl).placeholder(R.drawable.tacitly_approve_picture).
                error(R.drawable.wrong_picture_computer).into(album_head);

        album_title.setText(name);

        parseAlbumJson();
    }

    private void parseAlbumJson() {
        HttpConnect httpConnect = new HttpConnect(newUrl);
        httpConnect.sendRequestWithHttpURLConnection(new HttpConnect.Callback() {
            @Override
            public void finish(String respone) {
                Gson gson = new Gson();
                OneAlbumGson oneAlbumGson = gson.fromJson(respone, OneAlbumGson.class);
                List<OneAlbumGson.ResBean.WallpaperBean> wallpaperBeanList = oneAlbumGson.getRes().getWallpaper();
                for (int i = 0; i < wallpaperBeanList.size(); i++) {
                    OneAlbumGson.ResBean.WallpaperBean wallpaperBean = wallpaperBeanList.get(i);
                    atimeList.add(wallpaperBean.getAtime());
                    rankList.add(wallpaperBean.getRank());
                    favsList.add(wallpaperBean.getFavs());
                    thumbList.add(wallpaperBean.getThumb());
                    imgList.add(wallpaperBean.getImg());
                    previewList.add(wallpaperBean.getPreview());
                    idList.add(wallpaperBean.getId());
                    wpList.add(wallpaperBean.getWp());
                }
                Message message = new Message();
                message.what = ALBUM;
                handler.sendMessage(message);
            }
        });

    }

    private void initData() {
        Intent intent = getIntent();
        this.id = intent.getStringExtra("id");
        this.name = intent.getStringExtra("name");
        this.lcoverUrl = intent.getStringExtra("lcoverUrl");
        newUrl = "http://service.picasso.adesk.com/v1/wallpaper/album/" + id + "/wallpaper?limit=48&adult=false&first=1&order=new";
        hotUrl = "http://service.picasso.adesk.com/v1/wallpaper/album/" + id + "/wallpaper?limit=48&adult=false&first=1&order=hot";
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        public void handleMessage(Message message) {
            switch (message.what) {
                case ALBUM:
                    for (int i = 0; i < atimeList.size(); i++) {
                        AlbumPicture albumPicture = new AlbumPicture();
                        albumPicture.setData(atimeList.get(i), rankList.get(i), favsList.get(i), thumbList.get(i),
                                imgList.get(i), previewList.get(i), idList.get(i), wpList.get(i));
                        albumPictureList.add(albumPicture);
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3,
                            StaggeredGridLayoutManager.VERTICAL);
                    album_recycler.setLayoutManager(staggeredGridLayoutManager);
                    OneAlbumAdapter oneAlbumAdapter = new OneAlbumAdapter();
                    oneAlbumAdapter.setData(albumPictureList);
                    album_recycler.setAdapter(oneAlbumAdapter);
                    oneAlbumAdapter.notifyDataSetChanged();
                    break;
            }
        }
    };
}
