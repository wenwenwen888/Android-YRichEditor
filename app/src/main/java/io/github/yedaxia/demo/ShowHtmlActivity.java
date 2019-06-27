package io.github.yedaxia.demo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebSettings;
import android.webkit.WebView;


/**
 * @author Darcy https://yedaxia.github.io/
 * @version 2017/5/20.
 */

public class ShowHtmlActivity extends AppCompatActivity {

    private WebView webView;

    public static void launch(Context context) {
        Intent intent = new Intent(context, ShowHtmlActivity.class);
        context.startActivity(intent);
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_html);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        webView = findViewById(R.id.webView);

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
//        webView.loadUrl("https://github.com/wenwenwen888");

//        RecyclerView recyclerView = findViewById(R.id.recyclerview);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        SpHelper spHelper = new SpHelper(this);
//        List<IHtmlElement> htmlElementList =  HtmlParser.parse(spHelper.getContent());
//        recyclerView.setAdapter(new HtmlAdapter(this, htmlElementList));
    }

    public String getHtml() {
        SpHelper spHelper = new SpHelper(this);

        StringBuffer html = new StringBuffer();
        html.append("<html><body>");
        html.append(spHelper.getContent());
        html.append("</body></html>");
        return html.toString();
    }


}
