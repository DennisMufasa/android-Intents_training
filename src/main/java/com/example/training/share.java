package com.example.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class share extends AppCompatActivity {
    WebView share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        share = findViewById(R.id.share);
        share.setWebViewClient(new WebViewClient());

        share.getSettings().setLoadsImagesAutomatically(true);
        share.getSettings().setJavaScriptEnabled(true);

        share.loadUrl("http://reddit.com");
    }
}
