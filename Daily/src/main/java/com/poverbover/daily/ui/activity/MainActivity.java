package com.poverbover.daily.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.poverbover.apputillibrary.ui.base.BaseActivity;
import com.poverbover.daily.R;
import com.poverbover.daily.model.GirlsBean;
import com.poverbover.daily.model.NewsBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements NewsBean.OnNewsListListener {

    @Bind(R.id.tv_temp)TextView tvTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        NewsBean.getNews(this);
        GirlsBean.getGirls();
    }

    //region NewsBean.OnNewsListListener
    @Override
    public void onSuccess(List<NewsBean> list) {
        tvTemp.setText(list.get(0).getTitle());
    }

    @Override
    public void onFail(int errorCode) {
        tvTemp.setText("error:"+errorCode);
    }
    //endregion
}
