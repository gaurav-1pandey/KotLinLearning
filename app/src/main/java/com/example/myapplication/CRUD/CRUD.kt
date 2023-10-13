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


        save.setOnClickListener({
            savedata()
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
            Students(0,name.text.toString()
            , email.text.toString())
        )
        email.text.clear()
        name.text.clear()
    }

    private fun updatedata(){
        viewModel.updateStudent(
            Students(0,name.text.toString()
            , email.text.toString())
        )
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
        Toast.makeText(this,"the student is ${stu.name}",Toast.LENGTH_SHORT).show()
    }
}