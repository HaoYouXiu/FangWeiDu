package com.bwei.model.fangweidushangcheng;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.bwei.model.fangweidushangcheng.mvp.LoginPresenter;
import com.bwei.model.fangweidushangcheng.mvp.view.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView{

    private EditText loginName, loginPassword;
    private CheckBox loginBox;
    private TextView loginRegister, loginEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //初始化控件
        initView();
        initData();

        LoginPresenter loginPresenter = new LoginPresenter(this);

    }

    private void initData() {

    }

    private void initView() {
        loginName = (EditText)findViewById(R.id.login_name);
        loginPassword = (EditText)findViewById(R.id.login_password);
        loginBox = (CheckBox) findViewById(R.id.login_box);
        loginRegister = (TextView) findViewById(R.id.login_register);
        loginEnter = (TextView) findViewById(R.id.login_enter);
    }

    @Override
    public String LoginSuccess(String success) {
        return null;
    }

    @Override
    public String onFail(String fail) {
        return null;
    }
}
