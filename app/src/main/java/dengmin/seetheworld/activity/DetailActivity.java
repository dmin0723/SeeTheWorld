package dengmin.seetheworld.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

import dengmin.seetheworld.R;
import dengmin.seetheworld.bean.Constant;
import dengmin.seetheworld.bean.NewsItem;

/**
 * Created by dmin on 2016/5/1.
 */
public class DetailActivity extends AppCompatActivity {
    private WebView webView;
    private Toolbar toolbar;
    private ProgressBar progressBar;
    private NewsItem newsItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //初始化视图
        initView();
    }

    private void initView() {
        webView = (WebView) findViewById(R.id.web_view);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        //添加标题栏
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);//左上角可点击
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//左上角有图标显示

        //反序列化，取出数据 使用Intent来传递对象
        Bundle bundle = getIntent().getExtras();
        newsItem = (NewsItem) bundle.getSerializable(Constant.NEWS_ITEM);

        //显示页面的进度条
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if(newProgress == 100){
                    progressBar.setVisibility(View.INVISIBLE);
                }else{
                    if(progressBar.getVisibility() == View.INVISIBLE){
                        progressBar.setVisibility(View.VISIBLE);
                    }
                    progressBar.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }
        });

        //页面下载的地址
        webView.loadUrl(newsItem.getUrl());
    }
}
