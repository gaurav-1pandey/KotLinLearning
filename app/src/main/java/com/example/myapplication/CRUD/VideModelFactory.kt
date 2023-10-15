package com.example.myapplication.CRUD

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class StudentViewModelFactory(
    private val dao: StudentDAO
    ) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom((StudentsViewModel::class.java))){
            return StudentsViewModel(dao) as T
        }
        throw IllegalArgumentException("unknown input")
    }
}