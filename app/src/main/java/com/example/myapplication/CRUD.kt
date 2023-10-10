package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider

class CRUD : AppCompatActivity() {
    private lateinit var name:EditText
    private lateinit var email:EditText
    private lateinit var save:Button
    private lateinit var clear:Button
    private lateinit var viewModel: StudentsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud)

        name =findViewById(R.id.etname)
        email =findViewById(R.id.etemail)
        save=findViewById(R.id.btnsave)
        clear=findViewById(R.id.btnclear)




        val dao = StudentsDatabase.getInstance(application).studentDao()
        val faactory = StudentViewModelFactory(dao)
        viewModel = ViewModelProvider(this,faactory).get(StudentsViewModel::class.java)


        save.setOnClickListener({
            savedata()

        })


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
        viewModel.deleteStudent(Students(0,name.text.toString()
            , email.text.toString()))
        email.text.clear()
        name.text.clear()
    }

    private fun updatedata(){
        viewModel.updateStudent(Students(0,name.text.toString()
            , email.text.toString()))
    }
}