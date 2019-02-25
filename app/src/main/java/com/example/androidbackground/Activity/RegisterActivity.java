package com.example.androidbackground.Activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.androidbackground.R;

public class RegisterActivity extends AppCompatActivity {

    private int register_number = 0;
    private Button register;
    private EditText et_phone;
    private EditText et_password;
    private CheckBox remember_password;
    private SharedPreferences sharedPreferences;
    private Boolean mIsChecked = false;
    private ImageView im_back;
    private TextView tv_picture_information;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();

        iniData();
    }

    private void iniData() {
        //实例化SharePreference
        if (sharedPreferences == null) {
            sharedPreferences = getApplicationContext().getSharedPreferences("config", Context.MODE_PRIVATE);
        }

        mIsChecked = sharedPreferences.getBoolean("IsChecked", false);
        //回写数据
        et_phone.setText(sharedPreferences.getString("phone", ""));
        if (mIsChecked) {
            et_password.setText(sharedPreferences.getString("password", ""));
        }
        remember_password.setChecked(mIsChecked);
    }

    private void initView() {
        if (sharedPreferences == null) {
            sharedPreferences = getApplicationContext().getSharedPreferences("config", Context.MODE_PRIVATE);
        }
        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (register_number != 0 && et_phone.getText().toString().equals(sharedPreferences.getString("phone", ""))
                        && et_password.getText().toString().equals(sharedPreferences.getString("password", ""))) {
                    Toast.makeText(RegisterActivity.this, "正在登陆！", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this, PhonePictureActivity.class));
                    finish();
                } else if (register_number == 0 && et_phone.getText().toString() != null && et_password.getText().toString() != null) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("register_number", 1);
                    editor.putString("password", et_password.getText().toString());
                    editor.commit();
                    startActivity(new Intent(RegisterActivity.this, PhonePictureActivity.class));
                    Toast.makeText(RegisterActivity.this, "注册成功，正在登陆！", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(RegisterActivity.this, "密码错误！", Toast.LENGTH_SHORT).show();
                }
            }
        });

        im_back = findViewById(R.id.im_back);
        tv_picture_information = findViewById(R.id.tv_picture_information);

        tv_picture_information.setText("用户密码登陆");
        im_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //获取电话与密码
        et_phone = findViewById(R.id.et_phone);
        et_phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            //文本改变之后记录用户电话
            @Override
            public void afterTextChanged(Editable s) {
                    if (sharedPreferences == null) {
                        //getSharedPreferences有两个参数  |  第一个参数： 数据存储在以第一个名字命名的文件里 |  第二个参数表示数据私有化程度
                        sharedPreferences = getApplicationContext().getSharedPreferences("config", Context.MODE_PRIVATE);
                    }
                int register_number = sharedPreferences.getInt("register_number", 0);
                if (register_number == 0) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("phone", et_phone.getText().toString());
                    edit.commit();
                }
            }
        });

        et_password = (EditText) findViewById(R.id.et_password);
        et_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            //文本改变之后记录用户密码
            @Override
            public void afterTextChanged(Editable s) {
                if (mIsChecked) {
                    if (sharedPreferences == null) {
                        //getSharedPreferences有两个参数  |  第一个参数： 数据存储在以第一个名字命名的文件里 |  第二个参数表示数据私有化程度
                        sharedPreferences = getApplicationContext().getSharedPreferences("config", Context.MODE_PRIVATE);
                    }
                    int register_number = sharedPreferences.getInt("register_number", 0);
                    if (register_number == 0) {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString("password", et_password.getText().toString());
                        edit.commit();
                    }
                }
            }
        });

        //多选控件
        remember_password = (CheckBox) findViewById(R.id.remember_password);
        remember_password.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("CommitPrefEdits")
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                Log.d("TAG", "状态为" + isChecked);
                    //实例化SharePreferences对象
                if (sharedPreferences == null) {
                    //getSharedPreferences有两个参数  |  第一个参数： 数据存储在以第一个名字命名的文件里 |  第二个参数表示数据私有化程度
                    sharedPreferences = getApplicationContext().getSharedPreferences("config", Context.MODE_PRIVATE);
                }

                mIsChecked = isChecked;
                    //实例化SharePreferences的编辑对象
                SharedPreferences.Editor edit = sharedPreferences.edit();
                    //存储数据
                edit.putBoolean("IsChecked", mIsChecked);
                Log.d("mIsChecked", String.valueOf(mIsChecked));

                    //提交
                edit.commit();
            }
        });


        if (sharedPreferences == null) {
            sharedPreferences = getApplicationContext().getSharedPreferences("config", Context.MODE_PRIVATE);
        }
        register_number = sharedPreferences.getInt("register_number", 0);
        if (register_number == 0) {
            register.setText("注册");
        }

        mIsChecked = sharedPreferences.getBoolean("IsChecked", false);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("IsChecked", mIsChecked);
    }
}
