package com.example.myapplication.CRUD

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.StudentsRVAdapter

class CRUD : AppCompatActivity() {
    private lateinit var name:EditText
    private lateinit var email:EditText
    private lateinit var save:Button
    private lateinit var clear:Button
    private lateinit var rv:RecyclerView
    private lateinit var viewModel: StudentsViewModel
    lateinit var adapter:StudentsRVAdapter
    private var flag:Boolean =false
    private lateinit var selectedstu:Students

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud)

        name =findViewById(R.id.etname)
        email =findViewById(R.id.etemail)
        save=findViewById(R.id.btnsave)
        clear=findViewById(R.id.btnclear)
        rv=findViewById(R.id.rvstudent)

        val dao = StudentsDatabase.getInstance(application).studentDao()
        val faactory = StudentViewModelFactory(dao)
        viewModel = ViewModelProvider(this,faactory).get(StudentsViewModel::class.java)


        clear.setOnClickListener(){
            if (flag){
                deletedata()}
            else{
                name.text.clear()
                email.text.clear()}
            flag=false
        }

        save.setOnClickListener({
            if (flag){
                updatedata()
            }
            else{
                savedata()
            }
            flag=false
        })

        initrecyclerview()
    }

    private fun savedata(){
        viewModel.insertStudent(
            Students(0,name.text.toString()
            , email.text.toString())
        )
        email.text.clear()
        name.text.clear()
    }

    private fun deletedata(){
        viewModel.deleteStudent(
            Students(selectedstu.id,selectedstu.name
                , selectedstu.email)
        )
        email.text.clear()
        name.text.clear()
        flag=false
        save.text="SAVE"
        clear.text="CLEAR"
    }

    private fun updatedata(){
        viewModel.updateStudent(
            Students(selectedstu.id,name.text.toString()
            , email.text.toString())
        )
        save.text="SAVE"
        clear.text="CLEAR"
        name.text.clear()
        email.text.clear()
        flag=false
    }
    fun initrecyclerview(){
        rv.layoutManager=LinearLayoutManager(this)
        adapter=StudentsRVAdapter() {stu:Students ->
            itemclicked(stu)
        }
        rv.adapter=adapter
        dispalydata()
    }

    fun dispalydata(){
        viewModel.students.observe(this,{
            adapter.serArr(it)
            adapter.notifyDataSetChanged()
        })
    }

    fun itemclicked(stu:Students){
//        Toast.makeText(this,"the student is ${stu.name}",Toast.LENGTH_SHORT).show()
        flag=true
        selectedstu=stu
        save.text="UPDATE"
        clear.text="DELETE"

    }
}