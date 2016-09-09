package com.poverbover.daily.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.poverbover.apputillibrary.ui.ToastUtil;
import com.poverbover.apputillibrary.ui.base.BaseActivity;
import com.poverbover.daily.R;
import com.poverbover.daily.bmob.UserBmobBean;
import com.poverbover.daily.web.bmob.UserHelper;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @Bind(R.id.et_username)EditText etUsername;
    @Bind(R.id.et_password)EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_login)
    public void onLoginClick(){
        UserHelper.login(etUsername.getText().toString(), etPassword.getText().toString(), new UserHelper.OnUserBmobBeanListener() {
            @Override
            public void onUserBombBean(UserBmobBean result) {
                if(result!=null){
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                    finish();
                }else {
                    ToastUtil.show("fail");
                }
            }
        });
    }

    @OnClick(R.id.btn_regist)
    public void onRegistClick(){
        UserHelper.regist(etUsername.getText().toString(), etPassword.getText().toString(), new UserHelper.OnRegistListener() {
            @Override
            public void onRegist(boolean result, String message) {
                if(result){
                    ToastUtil.show("success");
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                    finish();
                }else {
                    ToastUtil.show(message);
                }
            }
        });
    }
}
