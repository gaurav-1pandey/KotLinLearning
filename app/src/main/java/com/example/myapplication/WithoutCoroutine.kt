package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class WithoutCoroutine : AppCompatActivity() {
    lateinit var tvdownload:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var cnt=0
        setContentView(R.layout.activity_without_coroutine)
        var tvcount=findViewById<TextView>(R.id.tvcount)
        tvdownload=findViewById<TextView>(R.id.tvdownload)
        var count=findViewById<Button>(R.id.count)
        var download=findViewById<Button>(R.id.download)
        download.setOnClickListener({
            update()
            for (i in 1..20){
                tvdownload.text="Downloading file $i"
                Thread.sleep(300)
            }

        })

        count.setOnClickListener({
            tvcount.text=(++cnt).toString()
        })





    }
    fun update(){

    }
}