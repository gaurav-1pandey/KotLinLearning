package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

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

class Users : ViewModel()  {
    private val myjob = Job()
    private val coroutine= CoroutineScope(Dispatchers.IO+myjob)

    fun getdata(){

        coroutine.launch {
            //some code
        }
    }

    override fun onCleared() {
        myjob.cancel()
        super.onCleared()
    }
}


class coroutineExample :ViewModel(){
    private val userdata = UserDataRepositary()
    val mutableLiveData : MutableLiveData<List<appUsers>> = MutableLiveData()

    fun getdata (){
        viewModelScope.launch {
             var res:List<appUsers>
            withContext(Dispatchers.IO){
                res=userdata.getusers()
            }
            mutableLiveData.value=res
        }
    }
}