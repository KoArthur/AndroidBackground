package com.example.androidbackground.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.androidbackground.Class.Comment;
import com.example.androidbackground.Class.HttpConnect;
import com.example.androidbackground.R;
import com.squareup.picasso.Picasso;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DownloadComputerPictureActivity extends AppCompatActivity implements View.OnClickListener {

    //图片基本信息
    private List<String> tag;       //标签
    private Double atime;           //更新时间
    private int ranks;              //点赞数
    private int views;              //查看数
    private int favs;               //收藏数
    private String wp;              //下载地址
    private String id;              //壁纸ID
    private String url;             //壁纸地址
    private String commentUrl;      //评论地址
    private String pictureUrl;      //图片信息地址
    private int user_rank = 0;
    private int user_fav = 0;

    //布局
    private ImageView iv_back;
    private TextView tv_title;
    private TextView tv_atime;
    private ImageView iv_specificPicture;
    private ImageView iv_rank;
    private TextView tv_rank;
    private ImageView iv_favs;
    private TextView tv_favs;
    private ImageView iv_wp;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ImageView comment_new;

    //List
    private List<Comment> commentList = new ArrayList<>();
    private List<String> userNames = new ArrayList<>();                 //用户名字
    private List<String> userContents = new ArrayList<>();              //用户评论
    private List<String> avaters = new ArrayList<>();                   //用户头像
    private List<String> userIds = new ArrayList<>();                   //用户ID

    private HttpConnect httpConnect;

    private Bitmap bitmap;

    public static void actionStart(Context context, List<String> tag, Double atime, int ranks, int views,
                                   int favs, String wp, String id, String url) {
        Intent intent = new Intent(context, DownloadComputerPictureActivity.class);
        intent.putStringArrayListExtra("tag", (ArrayList<String>) tag);
        intent.putExtra("atime", atime);
        intent.putExtra("ranks", ranks);
        intent.putExtra("views", views);
        intent.putExtra("favs", favs);
        intent.putExtra("wp", wp);
        intent.putExtra("id", id);
        intent.putExtra("url", url);
        Log.d("Download", "启动了");
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_computer_picture);

        //获取数据
        Intent intent = getIntent();
        this.tag = intent.getStringArrayListExtra("tag");
        this.atime = intent.getDoubleExtra("atime", -1);
        this.ranks = intent.getIntExtra("ranks", -1);
        this.views = intent.getIntExtra("views", -1);
        this.favs = intent.getIntExtra("favs", -1);
        this.wp = intent.getStringExtra("wp");
        this.id = intent.getStringExtra("id");
        this.url = intent.getStringExtra("url");

        //初始化布局
        initView();

        //设置标题与点击事件
        initTitle();

        //下拉刷新布局
        swipeRefreshLayout = findViewById(R.id.refresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(DownloadComputerPictureActivity.this, "刷新完毕！", Toast.LENGTH_SHORT).show();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void initView() {
        //获取实例
        tv_atime = findViewById(R.id.tv_atime);
        iv_specificPicture = findViewById(R.id.iv_specificPicture);
        iv_rank = findViewById(R.id.iv_rank);
        tv_rank = findViewById(R.id.tv_rank);
        iv_favs = findViewById(R.id.iv_favs);
        tv_favs = findViewById(R.id.tv_favs);
        iv_wp = findViewById(R.id.iv_wp);
        comment_new = findViewById(R.id.comment_new);

        //设置更新时间
        Double time = atime % 86400;
        int hour, minute, stop;
        stop = (int) (time % 60);
        hour = (int) (time - stop) / 60;
        minute = (hour % 60);
        hour = (hour - minute) / 60;
        String h, m, s;
        h = getTime(hour+8);
        m = getTime(minute);
        s = getTime(stop);
        if (hour == 16) {
            tv_atime.setText("更新于：00:00:00");
        } else {
            tv_atime.setText("更新于：" + h + ":" + m + ":" + s);
        }

        //加载图片
        Picasso.with(DownloadComputerPictureActivity.this).load(url).placeholder(R.drawable.tacitly_approve_picture).
                error(R.drawable.wrong_picture_computer).into(iv_specificPicture);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("user_rank", Context.MODE_PRIVATE);
        user_rank = sharedPreferences.getInt("user_rank" + id, 0);
        if (user_rank == 1) {
            iv_rank.setImageResource(R.drawable.rank_2);
        }

        SharedPreferences sharedPreferences1 = getApplicationContext().getSharedPreferences("user_fav", Context.MODE_PRIVATE);
        user_fav = sharedPreferences1.getInt("user_fav" + id, 0);
        if (user_fav == 1) {
            iv_favs.setImageResource(R.drawable.favs_2);
        }

        tv_rank.setText(String.valueOf(ranks));
        tv_favs.setText(String.valueOf(favs));
        iv_wp.setOnClickListener(this);
        iv_favs.setOnClickListener(this);
        iv_rank.setOnClickListener(this);
        comment_new.setOnClickListener(this);

    }

    private String getTime(int time) {
        if (time < 10) {
            return "0" + time;
        } else {
            return String.valueOf(time);
        }
    }

    private void initTitle() {
        iv_back = findViewById(R.id.im_back);
        tv_title = findViewById(R.id.tv_picture_information);

        iv_back.setOnClickListener(this);

        if (tag != null) {
            String title1 = tag.toString().replace("[", "");
            String title = title1.replace("]", "");
            title = title.replace(",", " ");
            tv_title.setText(title);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_wp:
                new Thread(t).start();
                Toast.makeText(DownloadComputerPictureActivity.this, "下载完成！", Toast.LENGTH_SHORT).show();
                break;

            case R.id.iv_rank:
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("user_rank", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                if (user_rank == 0) {
                    iv_rank.setImageResource(R.drawable.rank_2);
                    editor.putInt("user_rank" + id, 1);
                    Toast.makeText(DownloadComputerPictureActivity.this, "已点赞！", Toast.LENGTH_SHORT).show();
                    user_rank = 1;
                } else if (user_rank == 1) {
                    iv_rank.setImageResource(R.drawable.rank);
                    editor.putInt("user_rank" + id, 0);
                    Toast.makeText(DownloadComputerPictureActivity.this, "已取消点赞！", Toast.LENGTH_SHORT).show();
                    user_rank = 0;
                } else {
                    editor.putInt("user_rank" + id, 0);
                    iv_rank.setImageResource(R.drawable.rank);
                }
                editor.commit();
                break;

            case R.id.iv_favs:
                SharedPreferences sharedPreferences1 = getApplicationContext().getSharedPreferences("user_fav", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor1 = sharedPreferences1.edit();
                if (user_fav == 0) {
                    iv_favs.setImageResource(R.drawable.favs_2);
                    editor1.putInt("user_fav" + id, 1);
                    Toast.makeText(DownloadComputerPictureActivity.this, "已收藏！", Toast.LENGTH_SHORT).show();
                    user_fav = 1;
                } else if (user_fav == 1) {
                    iv_favs.setImageResource(R.drawable.fav);
                    editor1.putInt("user_fav" + id, 0);
                    Toast.makeText(DownloadComputerPictureActivity.this, "已取消收藏！", Toast.LENGTH_SHORT).show();
                    user_fav = 0;
                } else {
                    editor1.putInt("user_fav" + id, 0);
                    iv_favs.setImageResource(R.drawable.fav);
                }
                editor1.commit();
                break;

            case R.id.im_back:
                finish();
                break;

            case R.id.comment_new:
                Toast.makeText(DownloadComputerPictureActivity.this, "电脑壁纸没有评论！", Toast.LENGTH_SHORT).show();
        }
    }

    //为了下载图片资源，开辟一个新的子线程
    Thread t=new Thread(){
        public void run() {
            //下载图片的路径
            String iPath = url;
            try {
                //对资源链接
                URL url = new URL(iPath);
                //打开输入流
                InputStream inputStream = url.openStream();
                //对网上资源进行下载转换位图图片
                bitmap = BitmapFactory.decodeStream(inputStream);
                inputStream.close();

                //储存Bitmap
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Bitmap_" + id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 50, bos);
                String Base64 = new String(android.util.Base64.encodeToString(bos.toByteArray(), android.util.Base64.DEFAULT));
                editor.putString("bitmap_" + id, Base64);
                editor.commit();

//                //获取Bitmap
//                SharedPreferences sharedPreferences1 = getApplicationContext().getSharedPreferences("Bitmap_" + id, Context.MODE_PRIVATE);
//                String bt = sharedPreferences.getString("bitmap_" + id, "");
//                ByteArrayInputStream bis = new ByteArrayInputStream(android.util.Base64.encode(bt.getBytes(), android.util.Base64.DEFAULT));
//                Drawable drawable = Drawable.createFromStream(bis, "");

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

}
