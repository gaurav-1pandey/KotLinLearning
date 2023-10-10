package com.example.myapplication

import kotlinx.coroutines.delay

data class appUsers(var age:Int,var name:String)

class UserDataRepositary {
    suspend fun getusers() :List<appUsers>{
        delay(2000)
        val users : List<appUsers> = listOf(
            appUsers(21,"gaurav"),
            appUsers(22,"ankit"),
            appUsers(23,"raj"),
            appUsers(24,"harshit"),
            appUsers(25,"mamta"),
            appUsers(26,"gauri")
        )
        return users
    }
}