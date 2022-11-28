package com.example.swiperefreshlayoutyoutube;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.webView);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);

        webView.loadUrl("https://www.youtube.com");

//        WebViewClient webViewClient = new WebViewClient();
//        --> By using this simple line, the refresher icon will not disappear when page has completely refreshed
//        therefor we have used this line like given bellow:
        WebViewClient webViewClient = new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                swipeRefreshLayout.setRefreshing(false);
            }
        };

        webView.setWebViewClient(webViewClient);// This line is for opening youtube in our app.
        // otherwise it will open it in youtube app not our app
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

//        To do something when swiped, we have to apply listener
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                webView.reload();
            }
        });
    }
}