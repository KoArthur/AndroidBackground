package com.example.androidbackground.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.androidbackground.R;

public class SplashActivity extends AppCompatActivity {

    private ConstraintLayout splash;
    private ImageView iv_1;
    private ImageView iv_2;
    private ImageView iv_3;
    private ImageView iv_4;
    private ImageView iv_5;
    private SharedPreferences sharedPreferences;
    private String account;
    private String password;
    private int register_number = 0;
    private Boolean mIsChecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);           //隐藏状态栏
        setContentView(R.layout.activity_splash);
        splash = findViewById(R.id.splash);
        iv_1 = findViewById(R.id.iv_1);
        iv_2 = findViewById(R.id.iv_2);
        iv_3 = findViewById(R.id.iv_3);
        iv_4 = findViewById(R.id.iv_4);
        iv_5 = findViewById(R.id.iv_5);
        sharedPreferences = getApplicationContext().getSharedPreferences("config", Context.MODE_PRIVATE);

        AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
        alphaAnimation.setDuration(1000);                                           //设置动画时间
        splash.startAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new AnimationImpl());

    }
    private class AnimationImpl implements Animation.AnimationListener {

        @Override
        public void onAnimationStart(Animation animation) {
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            // 动画结束后跳转到别的页面
            if (sharedPreferences == null) {
                sharedPreferences = getApplicationContext().getSharedPreferences("config", Context.MODE_PRIVATE);
            }
            register_number = sharedPreferences.getInt("register_number", 0);
            account = sharedPreferences.getString("phone", null);
            password = sharedPreferences.getString("password", null);
            mIsChecked = sharedPreferences.getBoolean("IsChecked", false);
            //对用户以前的操作判断加载哪个界面与提示语
            if (mIsChecked) {
                if (account != null && password != null) {
                    Toast.makeText(SplashActivity.this, "已自动登陆！", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SplashActivity.this, PhonePictureActivity.class));
                    finish();
                } else {
                    Toast.makeText(SplashActivity.this, "正在前往登陆界面！", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SplashActivity.this, RegisterActivity.class));
                    finish();
                }
            } else {
                if (account != null && password != null) {
                    Toast.makeText(SplashActivity.this, "正在前往登陆界面！", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SplashActivity.this, "正在前往注册界面！", Toast.LENGTH_SHORT).show();
                }
                startActivity(new Intent(SplashActivity.this, RegisterActivity.class));
                finish();
            }
        }

        @Override
        public void onAnimationRepeat(Animation animation) {}

    }

}
