package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.databinding.ActivityNewButtonsBinding

class NewButtons : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_buttons)

//        val binding = ActivityNewButtonsBinding.inflate(layoutInflater)
//        setContentView(binding.root)

          val viewbinding = findViewById<Button>(R.id.viewbindingexample)
        viewbinding.setOnClickListener{
            startActivity(Intent(this, ViewBindingExample::class.java))

        }
    }
}