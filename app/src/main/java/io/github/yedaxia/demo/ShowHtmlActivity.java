package io.github.yedaxia.demo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.util.List;

import io.github.yedaxia.demo.adapter.HtmlAdapter;
import io.github.yedaxia.demo.html.HtmlParser;
import io.github.yedaxia.demo.html.IHtmlElement;


/**
 * @author Darcy https://yedaxia.github.io/
 * @version 2017/5/20.
 */

public class ShowHtmlActivity extends AppCompatActivity {

    public static final String SHOW_TYPE = "SHOW_TYPE";
    public static final String TYPE_WEBVIEW = "TYPE_WEBVIEW";
    public static final String TYPE_RECYCLERVIEW = "TYPE_RECYCLERVIEW";

    public static void launchWithWebView(Context context) {
        Intent intent = new Intent(context, ShowHtmlActivity.class);
        intent.putExtra(SHOW_TYPE, TYPE_WEBVIEW);
        context.startActivity(intent);
    }

    public static void launchWitRecyclerView(Context context) {
        Intent intent = new Intent(context, ShowHtmlActivity.class);
        intent.putExtra(SHOW_TYPE, TYPE_RECYCLERVIEW);
        context.startActivity(intent);
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_html);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        WebView webView = findViewById(R.id.webView);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        if (getIntent().getStringExtra(SHOW_TYPE).equals(TYPE_WEBVIEW)) {
            webView.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);

            webView.setHorizontalScrollBarEnabled(false);
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
//        webSettings.setUseWideViewPort(true);    //设置webView推荐使用的窗口，使html界面自适应屏幕
//        webSettings.setLoadWithOverviewMode(true);     //缩放至屏幕的大小
            webSettings.setSupportZoom(true);    //设置支持缩放
            webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
            webSettings.setBlockNetworkImage(false);
            webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
            }

            webView.loadData(getHtml(), "text/html", "utf-8");
        } else {
            webView.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);

            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            SpHelper spHelper = new SpHelper(this);
            List<IHtmlElement> htmlElementList = HtmlParser.parse(spHelper.getContent());
            recyclerView.setAdapter(new HtmlAdapter(this, htmlElementList));
        }

    }

    public String getHtml() {
        SpHelper spHelper = new SpHelper(this);

        return "<html><body>" +
                spHelper.getContent() +
                "</body></html>";
    }


}
