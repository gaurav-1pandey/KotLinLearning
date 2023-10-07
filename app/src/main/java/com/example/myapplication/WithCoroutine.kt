package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WithCoroutine : AppCompatActivity() {
    lateinit var tvdownload: TextView
    var cnt = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_coroutine)

        tvdownload = findViewById<TextView>(R.id.tvdownload)
        var tvcount = findViewById<TextView>(R.id.tvcount)
        var count = findViewById<Button>(R.id.count)
        var download = findViewById<Button>(R.id.download)

        download.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                update()
            }
        }

        count.setOnClickListener {
            tvcount.text = (++cnt).toString()
        }
    }

    suspend fun update() {
        for (i in 1..2000000) {
            runOnUiThread {
                tvdownload.text = "Downloading file $i"
            }
            delay(30)
        }
    }
}
