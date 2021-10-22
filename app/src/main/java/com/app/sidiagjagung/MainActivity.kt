package com.app.sidiagjagung

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.RenderProcessGoneDetail
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.app.sidiagjagung.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.webView.settings.builtInZoomControls = true
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.settings.useWideViewPort = true


        binding.webView.webViewClient = object : WebViewClient() {

            override fun onPageFinished(view: WebView, url: String) {
                binding.spinKit.visibility = View.INVISIBLE
            }
        }
        binding.webView.webChromeClient = object : WebChromeClient() {
            override fun onJsAlert(view: WebView, url: String, message: String, result: android.webkit.JsResult): Boolean {
                Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG).show()
                result.confirm()
                return true
            }
        }
        binding.webView.loadUrl("https://mangasee123.com/")
    }
}