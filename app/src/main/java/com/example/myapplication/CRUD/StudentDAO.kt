package com.example.myapplication.CRUD

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentDAO {
    @Insert
    suspend fun insertStudent(student : Students)

    @Update
    suspend fun updateStudent(student : Students)

    @Delete
    suspend fun deleteStudent(student : Students)

    @Query("SELECT * FROM Students")
    fun get_all_students():LiveData<List<Students>>
}