package com.example.myapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Students")
class Students (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id :Int =0,
    @ColumnInfo(name = "name")
    var name : String,
    @ColumnInfo(name = "email")
    var email : String
        )