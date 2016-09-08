package com.poverbover.daily.web.request;

import com.poverbover.daily.AppConfig;
import com.poverbover.daily.web.response.GirlsResponse;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by void on 2016/9/8.
 */
public interface GirlsRequest {

    @GET(AppConfig.GIRLS_URL)
    Observable<GirlsResponse>getGirls(@Header("apikey")String key, @Query("id")int id);
}
