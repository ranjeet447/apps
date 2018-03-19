package com.example.webview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class webviewActivity extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        //Get the bundle
        Bundle bundle = getIntent().getExtras();
        //Extract the data…
        String URL = bundle.getString("URL");


        webView =(WebView)findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                setProgressBarIndeterminateVisibility(false);
                super.onPageFinished(view, url);
            }
        });
        webView.setWebViewClient(new MyBrowser());
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl(URL);
    }
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
    @Override
    public void onBackPressed(){
        Intent inten = new Intent(this, webviewActivity.class);
        super.onBackPressed();
        startActivity(inten);

    }
}
