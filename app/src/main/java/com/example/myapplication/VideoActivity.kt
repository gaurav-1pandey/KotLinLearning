package com.example.myapplication


import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity


class VideoActivity : AppCompatActivity() {
    private var left=0
    private lateinit var video:VideoView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        video = findViewById(R.id.videoView)
        val mediaController=MediaController(this)

        mediaController.setAnchorView(video)



        video.setMediaController(mediaController)

        @Suppress("DEPRECATION") val uri:Uri?=intent.getParcelableExtra("uri")
        if (uri!=null){
            video.setVideoURI(uri)

        }


    }


    override fun onPause() {
        super.onPause()
        video.pause()
        left=video.currentPosition

    }

    override fun onResume() {
        super.onResume()
        video.seekTo(left)
    }

}