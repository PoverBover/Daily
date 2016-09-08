package com.poverbover.daily.model;

import com.google.gson.annotations.SerializedName;
import com.poverbover.daily.AppConfig;
import com.poverbover.daily.request.GirlsRequest;

import java.io.Serializable;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by void on 2016/9/8.
 */
public class GirlsBean implements Serializable{

    public static final String PRE_URL="http://tnfs.tngou.net/img";

    private int gallery;
    private int id;
    @SerializedName("src")
    private String imgUrl;

    public int getGallery() {
        return gallery;
    }

    public void setGallery(int gallery) {
        this.gallery = gallery;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgUrl() {
        return PRE_URL+imgUrl;
    }

    public void setImgUrl(String src) {
        this.imgUrl = src;
    }

    public static void getGirls(){
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(AppConfig.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofit.create(GirlsRequest.class)
                .getGirls(AppConfig.API_KEY,1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<GirlsResult>() {
                    @Override
                    public void call(GirlsResult girlsResult) {
                        //TODO return result by callback
                    }
                });
    }
}
