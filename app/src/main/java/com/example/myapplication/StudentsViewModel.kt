package com.example.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class StudentsViewModel(private val dao:StudentDAO) : ViewModel(){
    val students =dao.get_all_students()

    fun insertStudent(student:Students){
        viewModelScope.launch {
            dao.insertStudent(student)
        }
    }

    fun updateStudent(student:Students){
        viewModelScope.launch {
            dao.updateStudent(student)
        }
    }

    fun deleteStudent(student:Students){
        viewModelScope.launch {
            dao.deleteStudent(student)
        }
    }
}