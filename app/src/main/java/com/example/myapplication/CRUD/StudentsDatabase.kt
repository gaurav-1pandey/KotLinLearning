package com.example.myapplication.CRUD

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Students::class], version = 1, exportSchema = false)
abstract class StudentsDatabase() : RoomDatabase() {
    abstract fun studentDao(): StudentDAO

    companion object{
        @Volatile
        private var Instance : StudentsDatabase? = null

        fun getInstance(context : Context): StudentsDatabase {
            synchronized(this){
                var instance= Instance
                if (instance == null){
                    instance = Room.databaseBuilder(context.applicationContext
                        , StudentsDatabase::class.java,"Students_Database").build()

                }
                return instance
            }
        }
    }
}