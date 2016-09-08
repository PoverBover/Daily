package com.poverbover.daily.web.response;

import com.poverbover.daily.model.NewsBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by void on 2016/9/6.
 */
public class NewsResponse implements Serializable{
    private int code;
    private NewsResultBody data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public NewsResultBody getData() {
        return data;
    }

    public void setData(NewsResultBody data) {
        this.data = data;
    }

    public class NewsResultBody implements Serializable{

        private String channel;
        private List<NewsBean> article;

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public List<NewsBean> getArticle() {
            return article;
        }

        public void setArticle(List<NewsBean> article) {
            this.article = article;
        }
    }
}
