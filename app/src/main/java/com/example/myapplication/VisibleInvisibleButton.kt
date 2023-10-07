package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.TextView

class VisibleInvisibleButton : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_visible_invisible_button)
        val togle=findViewById<Button>(R.id.toggle)
        val offer=findViewById<Button>(R.id.offers)
        var flag=1
        val sp = getSharedPreferences("mysp", MODE_PRIVATE)
        Log.i("mytag1",sp.getString("name","Noname").toString())
        val text=findViewById<TextView>(R.id.text)
        val name=intent.getStringExtra("name")
        val username=findViewById<TextView>(R.id.username)
        username.text=name
        username.setOnClickListener({
            startActivity(Intent(this@VisibleInvisibleButton,SharedPreferences::class.java))
        })
        togle.setOnClickListener{
            if (flag==1){
                flag=0
                offer.visibility=VISIBLE
                text.text="Visible"
            }
        else{
                flag=1
                offer.visibility=INVISIBLE
                text.text="Invisible"
            }

    }}
    override fun onResume() {
        super.onResume()
        Log.i("mytag","Visible: on resume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("mytag","Visible: on restart")

    }

    override fun onStart() {
        super.onStart()
        Log.i("mytag","Visible: on start")
    }

    override fun onStop() {
        super.onStop()
        Log.i("mytag","Visible: on stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("mytag","Visible: on destroy")
    }
}