package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Recyclerview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        var sk="ninetysennk jgauravbkbven"


        var rv=findViewById<RecyclerView>(R.id.myrv)
        rv.layoutManager=GridLayoutManager(this,3)
        val adapter=rvAdapter(listOf<String>("Gaurav","ankit","Rajnsh","Gauri","Gaurav","ankit","Rajnsh"
            ,"Gauri","Gauraav","ankit","Rajnish",
            "Gauri","Gauraav","ankit","Rajnish",
            "Gauri","Gauraav","ankit","Rajnish","Gauri","Gauraav","ankit","Rajnish","Gauri","Gauraav","ankit","Rajnish"
            ,"Gauri","Gauraav","ankit","Rajnish",
            "Gauri","Gauraav","ankit","Rajnish",
            "Gauri","Gauraav","ankit","Rajnish","Gauri","Gauraav","ankit","Rajnish","Gauri","Gauraav","ankit","Rajnish"
            ,"Gauri","Gauraav","ankit","Rajnish",
            "Gauri","Gauraav","ankit","Rajnish",
            "Gauri","Gauraav","ankit","Rajnish","Gauri"))
        rv.adapter=adapter
    }
}