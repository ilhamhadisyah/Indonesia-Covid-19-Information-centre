package com.ilham.masive.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.ilham.masive.R
import kotlinx.android.synthetic.main.activity_news_reader.*

class NewsReaderActivity : AppCompatActivity() {
    companion object {
        const val DATA = "data_result"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_reader)
        supportActionBar?.title = "News Reader"
        val url = intent.getStringExtra(DATA)
        news_read.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: String
            ): Boolean {
                view?.loadUrl(request)
                return false
            }
        }
        news_read.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            allowContentAccess = true
            loadWithOverviewMode = true
            useWideViewPort = true
            cacheMode = WebSettings.LOAD_DEFAULT
        }
        news_read.loadUrl(url!!)
    }

}