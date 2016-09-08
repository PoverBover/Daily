package com.poverbover.daily.web.request;

import com.poverbover.daily.AppConfig;
import com.poverbover.daily.web.response.NewsResponse;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by void on 2016/9/6.
 */
public interface NewsRequest {

    @GET(AppConfig.NEWS_URL)
    Observable<NewsResponse> getNews(@Header("apikey")String key, @Query("id")String channelId, @Query("page")int page);
}
