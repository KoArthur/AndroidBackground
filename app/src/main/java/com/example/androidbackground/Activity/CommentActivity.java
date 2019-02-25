package com.example.androidbackground.Activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.androidbackground.Class.Comment;
import com.example.androidbackground.Class.HttpConnect;
import com.example.androidbackground.R;
import com.example.androidbackground.adapter.CommentAdapter;
import com.example.androidbackground.jsonParse.CommentByGson;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

public class CommentActivity extends AppCompatActivity {

    private static final int COMMENT = 0;

    //List
    private List<Comment> commentList = new ArrayList<>();
    private List<String> userNames = new ArrayList<>();                 //用户名字
    private List<String> userContents = new ArrayList<>();              //用户评论
    private List<String> avaters = new ArrayList<>();                   //用户头像
    private List<String> userIds = new ArrayList<>();                   //用户ID

    private String commentUrl = null;

    //布局
    private TextView tv_picture_information;
    private ImageView im_back;
    private EditText write_comment;
    private Button publish_comment;

    public void actionStart(Context context, String commentUrl) {
        Intent intent = new Intent(context, CommentActivity.class);
        intent.putExtra("commentUrl", commentUrl);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        Intent intent = getIntent();
        commentUrl = intent.getStringExtra("commentUrl");
        im_back = findViewById(R.id.im_back);
        im_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv_picture_information = findViewById(R.id.tv_picture_information);
        tv_picture_information.setText("最新评论");

        write_comment = findViewById(R.id.write_comment);
        publish_comment = findViewById(R.id.publish_comment);
        publish_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (write_comment.getText().toString() != null) {
                    Toast.makeText(CommentActivity.this, "发表评论：" + write_comment.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        HttpConnect httpConnect = new HttpConnect(commentUrl);
        httpConnect.sendRequestWithHttpURLConnection(new HttpConnect.Callback() {
            @Override
            public void finish(String respone) {
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Json", Context.MODE_PRIVATE);
                if (respone == null) {
                    respone = sharedPreferences.getString("commentJson", null);
                } else {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("commentJson", respone);
                    editor.commit();
                }
                Gson gson = new Gson();
                CommentByGson commentByGson = gson.fromJson(respone, CommentByGson.class);
                List<CommentByGson.ResBean.CommentBean> commentBeans = commentByGson.getRes().getComment();
                for (int i = 0; i < commentBeans.size(); i++) {
                    CommentByGson.ResBean.CommentBean.UserBean userBean = commentBeans.get(i).getUser();
                    avaters.add(userBean.getAvatar());
                    userNames.add(userBean.getName());
                    userContents.add(commentBeans.get(i).getContent());
                    userIds.add(userBean.getId());
                }
                Message message = new Message();
                message.what = COMMENT;
                handler.sendMessage(message);
            }
        });
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        public void handleMessage(Message message) {
            switch (message.what) {
                case COMMENT:
                    if (userIds.size() != 0) {
                        for (int i = 0; i < userIds.size(); i++) {
                            Comment comment = new Comment(avaters.get(i), userNames.get(i), userContents.get(i), userIds.get(i));
                            commentList.add(comment);
                            if (i == userIds.size() - 1) {
                                RecyclerView recyclerView = findViewById(R.id.recycler_comment);
                                StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1,
                                        StaggeredGridLayoutManager.VERTICAL);
                                recyclerView.setLayoutManager(staggeredGridLayoutManager);
                                CommentAdapter commentAdapter = new CommentAdapter();
                                commentAdapter.setData(commentList);
                                recyclerView.setAdapter(commentAdapter);
                            }
                        }
                    } else {
                        Toast.makeText(CommentActivity.this, "暂时没有评论哦！", Toast.LENGTH_LONG).show();
                        finish();
                    }
                    break;
            }
        }
    };
}
