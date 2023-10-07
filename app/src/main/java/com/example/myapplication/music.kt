package com.example.myapplication

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Button
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class music : AppCompatActivity() {
    private lateinit var sound:MediaPlayer
    private lateinit var handler:Handler
    private lateinit var tplayed:TextView
    private lateinit var tleft:TextView

    private lateinit var runnable: Runnable
    private lateinit var seekbar: SeekBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)



        handler=Handler(Looper.getMainLooper())



        sound= MediaPlayer.create(this,R.raw.music)
        var playpause=findViewById<FloatingActionButton>(R.id.playpause)
        var flag =0
        playpause.setOnClickListener({
            if (sound.isPlaying()){
                sound.pause()
                playpause.setImageResource(R.drawable.img_play)
            }
            else{
                playpause.setImageResource(R.drawable.img_pause)
                initialiseseek()
                sound.start()
            }
        })


        var stop=findViewById<FloatingActionButton>(R.id.stop)
        stop.setOnClickListener({

            sound.stop()
            playpause.setImageResource(R.drawable.img_play)
            sound=MediaPlayer.create(this,R.raw.music)
            handler.removeCallbacks(runnable)
            seekbar.progress=0

        })
        seekbar=findViewById(R.id.seekBar)




        tplayed=findViewById<TextView>(R.id.timeplayed)
        tleft=findViewById<TextView>(R.id.timeleft)


        sound.setOnCompletionListener{ mp->
            seekbar.progress=0
            playpause.setImageResource(R.drawable.img_play)
        }

    }
    private fun updateseek(){
        if (sound.isPlaying( )){
            val curpos=sound.currentPosition
            seekbar.progress=curpos
            handler.postDelayed({updateseek()},1000)
        }
    }
    private fun initialiseseek(){
        seekbar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(skbar: SeekBar?, progress: Int, fromuser: Boolean) {
            if (fromuser) sound.seekTo(progress)
            }

            override fun onStartTrackingTouch(skbar: SeekBar?) {

            }

            override fun onStopTrackingTouch(skbar: SeekBar?) {

            }

        })
        seekbar.max=sound.duration
        runnable= Runnable {
            tplayed.text="00:"+(sound.currentPosition/1000).toString()
            tleft.text="00:"+((sound.duration-sound.currentPosition)/1000).toString()
            seekbar.progress=sound.currentPosition
            handler.postDelayed(runnable,15)
        }
        handler.postDelayed(runnable,15)
    }
}