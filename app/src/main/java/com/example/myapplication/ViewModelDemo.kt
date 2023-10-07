package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelDemo : ViewModel() {
    var count=0
    var cnt=MutableLiveData<Int>()
    fun updateCount(){
        ++count
    }
    init{
        cnt.value=0
    }
    fun updtccnt(){
        cnt.value=cnt.value?.plus(1)
    }
}