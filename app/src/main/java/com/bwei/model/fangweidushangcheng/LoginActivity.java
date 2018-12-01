package com.bwei.model.fangweidushangcheng;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText loginName, loginPassword;
    private CheckBox loginBox;
    private TextView loginRegister, loginEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //初始化控件
        initView();

    }

    private void initView() {
        loginName = (EditText)findViewById(R.id.login_name);
        loginPassword = (EditText)findViewById(R.id.login_password);
        loginBox = (CheckBox) findViewById(R.id.login_box);
        loginRegister = (TextView) findViewById(R.id.login_register);
        loginEnter = (TextView) findViewById(R.id.login_enter);
    }
}
