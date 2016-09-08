package com.poverbover.daily.request;

import com.poverbover.daily.AppConfig;
import com.poverbover.daily.model.GirlsResult;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by void on 2016/9/8.
 */
public interface GirlsRequest {

    @GET(AppConfig.GIRLS_URL)
    Observable<GirlsResult>getGirls(@Header("apikey")String key, @Query("id")int id);
}
