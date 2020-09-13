package com.indrul.egyptology.Activities

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.webkit.WebView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.indrul.egyptology.R

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        ///////////////////////////////////
        val window = this.window
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = this.resources.getColor(R.color.top_color)
        window.navigationBarColor = this.resources.getColor(R.color.bottom_color)
        ///////////////////
        playVideo()

    }
    fun playVideo(){
        val url :Uri= Uri.parse("https://cdn.kapwing.com/final_5f548191caad200040039b4f_847350.mp4")
        val webview:VideoView=findViewById(R.id.wwebview)
        val cardvideo:CardView=findViewById(R.id.videocard);
        webview.setVideoURI(url)
        webview.start()
        webview.setOnCompletionListener {
            webview.start()
            Handler().postDelayed(Runnable { webview.stopPlayback() },100)

            }
        cardvideo.setOnClickListener {
            webview.setVideoURI(url)
            webview.start() }
    }

    override fun onResume() {
        super.onResume()
        playVideo()
    }

    fun kings(view: View) {
        val intent = Intent(this, KingsActivity::class.java)
        startActivity(intent);
        overridePendingTransition(R.anim.slide_out_bottom, R.anim.slide_in_bottom);
    }
}