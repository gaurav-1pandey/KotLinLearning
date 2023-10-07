package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CoroutineDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_demo)
        var with=findViewById<Button>(R.id.with)
        with.setOnClickListener({
            startActivity(Intent(this,WithCoroutine::class.java))
        })
        var without=findViewById<Button>(R.id.without)
        without.setOnClickListener({
            startActivity(Intent(this,WithoutCoroutine::class.java))
        })
    }
}