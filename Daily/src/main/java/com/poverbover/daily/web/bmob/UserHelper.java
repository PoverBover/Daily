package com.poverbover.daily.web.bmob;

import android.support.annotation.NonNull;

import com.poverbover.daily.bmob.UserBmobBean;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by void on 2016/9/9.
 */
public class UserHelper {

    /**
     * 注册
     */
    public static void regist(final String username, final String password, final OnRegistListener listener) {
        checkExist(username, new OnUserBmobBeanListener() {
            @Override
            public void onUserBombBean(UserBmobBean result) {
                if (result==null) {
                    doRegist(username, password,listener);
                }else {
                if(listener!=null){
                        listener.onRegist(false,"用户名已存在");
                    }
                }
            }
        });

    }

    /**登录*/
    public static void login(String username, String password, final OnUserBmobBeanListener listener){
        BmobQuery<UserBmobBean> query = new BmobQuery<>();
        query.addWhereEqualTo("userName", username);
        query.addWhereEqualTo("passWord",password);
        query.setLimit(1);
        query.findObjects(new FindListener<UserBmobBean>() {
            @Override
            public void done(List<UserBmobBean> list, BmobException e) {
                if (list!=null&&list.size() > 0) {
                    listener.onUserBombBean(list.get(0));
                } else {
                    listener.onUserBombBean(null);
                }
            }
        });
    }

    /**注册到bmob*/
    private static void doRegist(String username, String password, final OnRegistListener listener) {
        new UserBmobBean(username,password).save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if(s!=null){
                    listener.onRegist(true,null);
                }else {
                    listener.onRegist(false,e.toString());
                }
            }
        });
    }

    /**
     * 用户名是存在
     */
    public static void checkExist(String username, @NonNull final OnUserBmobBeanListener listener) {

        BmobQuery<UserBmobBean> query = new BmobQuery<>();
        query.addWhereEqualTo("userName", username);
        query.setLimit(1);
        query.findObjects(new FindListener<UserBmobBean>() {
            @Override
            public void done(List<UserBmobBean> list, BmobException e) {
                if (list!=null&&list.size() > 0) {
                    listener.onUserBombBean(list.get(0));
                } else {
                    listener.onUserBombBean(null);
                }
            }
        });
    }

    public interface OnUserBmobBeanListener {
        void onUserBombBean(UserBmobBean result);
    }

    public interface OnRegistListener{
        void onRegist(boolean result,String message);
    }

}
