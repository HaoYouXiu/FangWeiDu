package com.bwei.model.fangweidushangcheng;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwei.model.fangweidushangcheng.Util.ToasUtil;
import com.bwei.model.fangweidushangcheng.mvp.OnPresenter;
import com.bwei.model.fangweidushangcheng.mvp.view.OnView;

public class LoginActivity extends AppCompatActivity implements OnView {

    private EditText loginName, loginPassword;
    private CheckBox loginBox;
    private TextView loginRegister, loginEnter;
    private OnPresenter mPresenter;
    private ImageView loginConceal;
    private boolean ishide = true;
    private SharedPreferences loginSp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //初始化控件
        initView();

        initListener();

        mPresenter = new OnPresenter(this);

    }

    private void initJzmima() {
        loginSp = getSharedPreferences("login", Context.MODE_PRIVATE);
        if (loginSp.getString("userName","")!=null){
            String name = loginSp.getString("userName", "");
            String pass = loginSp.getString("password", "");
            boolean Box = loginSp.getBoolean("loginBox", false);
            loginName.setText(name);
            loginPassword.setText(pass);
            loginBox.setChecked(Box);
        }
    }

    private void initListener() {

        loginEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = loginName.getText().toString().trim();
                String password = loginPassword.getText().toString();

                mPresenter.login(userName, password);
                if (loginBox.isChecked()){
                    SharedPreferences.Editor editor = loginSp.edit();
                    editor.putString("userName", userName);
                    editor.putString("password", password);
                    editor.putBoolean("loginBox",true);
                    editor.commit();
                    return;
                }else {
                    SharedPreferences.Editor editor = loginSp.edit();
                    editor.clear();
                    editor.commit();
                }
            }
        });



    }

    private void initView() {
        loginName = (EditText)findViewById(R.id.login_name);
        loginPassword = (EditText)findViewById(R.id.login_password);
        loginBox = (CheckBox) findViewById(R.id.login_box);
        loginRegister = (TextView) findViewById(R.id.login_register);
        loginEnter = (TextView) findViewById(R.id.login_enter);
        loginConceal = (ImageView) findViewById(R.id.login_conceal);

        //隐藏密码
        loginPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
        //隐藏显示密码
        loginConceal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ishide){
                    //不隐藏
                    loginPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    ishide = false;
                }else {
                    loginPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    ishide = true;
                }
            }
        });

        loginRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //记住密码
        initJzmima();
    }


    @Override
    public void LoginSuccess(String success) {
        ToasUtil.showToas( success );
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void registerSuccess(String registersuccess) {

    }


    @Override
    public void onFail(String fail) {
        Toast.makeText(this, fail, Toast.LENGTH_SHORT).show();
    }
}
