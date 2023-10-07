package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.EditText

class SharedPreferences : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)

        val entry1=findViewById<EditText>(R.id.entry1)
        val entry2=findViewById<EditText>(R.id.entry2)
        val btn = findViewById<Button>(R.id.button)

        var sp=getSharedPreferences("mysp", MODE_PRIVATE)
        var editor=sp.edit()
        editor.apply({
            putString("name","Gaurav")
            putInt("age",21)
            commit()
        })
        editor.putString("class","AIML")
        editor.apply()
        editor.commit()

        entry1.setText(sp.getString("name","noname"))
        entry2.setText(sp.getInt("age",0).toString()+sp.getString("class","noclass"))

        var ds = getSharedPreferences("mysp", MODE_PRIVATE)
        Log.i("mytag1",ds.getString("name","noname").toString())





    }
}