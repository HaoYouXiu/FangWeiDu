package com.bwei.model.fangweidushangcheng;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwei.model.fangweidushangcheng.mvp.LoginPresenter;
import com.bwei.model.fangweidushangcheng.mvp.view.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity implements LoginView {


    @BindView(R.id.register_conceal)
    ImageView registerConceal;
    private boolean ishide = true;

    @BindView(R.id.register_phone_phone)
    ImageView registerPhonePhone;
    @BindView(R.id.register_name)
    EditText registerName;
    @BindView(R.id.register_phone)
    RelativeLayout registerPhone;
    @BindView(R.id.register_verify_verify)
    ImageView registerVerifyVerify;
    @BindView(R.id.register_verify)
    EditText registerVerify;
    @BindView(R.id.register_getverify)
    View registerGetverify;
    @BindView(R.id.register_Validate)
    RelativeLayout registerValidate;
    @BindView(R.id.register_lock)
    ImageView registerLock;
    @BindView(R.id.register_password)
    EditText registerPassword;
    @BindView(R.id.register_mima)
    RelativeLayout registerMima;
    @BindView(R.id.register_login)
    TextView registerLogin;
    @BindView(R.id.register_enter)
    TextView registerEnter;
    private LoginPresenter mPresenter;
    private String mUserName;
    private String mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_home);
        ButterKnife.bind(this);

        //显示隐藏密码
        registerPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());

        mPresenter = new LoginPresenter(this);

    }

    @OnClick(R.id.register_phone_phone)
    public void onRegisterPhonePhoneClicked() {
    }

    @OnClick(R.id.register_name)
    public void onRegisterNameClicked() {
    }

    @OnClick(R.id.register_phone)
    public void onRegisterPhoneClicked() {
    }

    @OnClick(R.id.register_verify_verify)
    public void onRegisterVerifyVerifyClicked() {
    }

    @OnClick(R.id.register_verify)
    public void onRegisterVerifyClicked() {
    }

    @OnClick(R.id.register_getverify)
    public void onRegisterGetverifyClicked() {
    }

    @OnClick(R.id.register_Validate)
    public void onRegisterValidateClicked() {
    }

    @OnClick(R.id.register_lock)
    public void onRegisterLockClicked() {
    }

    @OnClick(R.id.register_password)
    public void onRegisterPasswordClicked() {
    }

    @OnClick(R.id.register_mima)
    public void onRegisterMimaClicked() {
    }

    @OnClick(R.id.register_login)
    public void onRegisterLoginClicked() {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @OnClick(R.id.register_enter)
    public void onRegisterEnterClicked() {
        mUserName = registerName.getText().toString().trim();
        mPassword = registerPassword.getText().toString();
        mPresenter.register( mUserName, mPassword );

    }

    @OnClick(R.id.register_conceal)
    public void onViewClicked() {
        if (ishide){
            //不隐藏
            registerPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            ishide = false;
        }else {
            registerPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            ishide = true;
        }
    }

    @Override
    public void LoginSuccess(String success) {

    }

    @Override
    public void registerSuccess(String registersuccess) {
        Toast.makeText(this, registersuccess, Toast.LENGTH_SHORT).show();
        //传值
        Intent intent = new Intent();
        intent.putExtra("phone", mUserName);
        intent.putExtra( "pass",mPassword );
        setResult(RESULT_OK, intent);
        finish();
    }


    @Override
    public void onFail(String fail) {
        Toast.makeText(this, fail, Toast.LENGTH_SHORT).show();
    }
}
