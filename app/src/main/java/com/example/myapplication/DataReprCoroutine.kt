package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext

class DataReprCoroutine : AppCompatActivity() {
    private lateinit var data:coroutineExample
    lateinit var providedData:List<appUsers>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_repr_coroutine)

        val recycler=findViewById<ListView>(R.id.recycler)

        data= ViewModelProvider(this).get(coroutineExample::class.java)
        data.getdata()

        Toast.makeText(this,"hello hello",Toast.LENGTH_SHORT).show()
        data.mutableLiveData.observe(this,Observer { found ->
            Toast.makeText(this,"hello",Toast.LENGTH_SHORT).show()

            providedData= found
        })
        var arr = mutableListOf<String>()
        arr.add("gaurav")
        if (true){
            Toast.makeText(this@DataReprCoroutine,"hrllo",Toast.LENGTH_SHORT).show()
            for (i in 0..5){
            arr.add(providedData.get(i).name+" "+providedData.get(i).age)
                Log.i("mytag2",providedData.get(i).name+" "+providedData.get(i).age)
            }
        }


        val adater = ArrayAdapter<String>(this,R.layout.data_repr_item,R.id.textView,arr)
        recycler.adapter=adater


    }
}