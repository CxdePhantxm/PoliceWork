package com.example.police

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper (context:Context): SQLiteOpenHelper(context, dbname, factory, version){
    companion object {
        internal val dbname = "userDB"
        internal val factory = null
        internal val version = 1
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("create table user(id integer primary key autoincrement," +
                "login varchar(8), password varchar(4))")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insertUserData(login: String, password: String):Boolean{
        val db: SQLiteDatabase = writableDatabase
        val values: ContentValues = ContentValues()
        values.put("login", login)
        values.put("password", password)

        if(login.isNotEmpty() && password.isNotEmpty()){
            db.insert("user", null, values)
            db.close()
            return true
        }

        return false
    }

    fun userPresent(login: String, password: String):Boolean{
        val db = writableDatabase
        val query = "select * from user where login = '$login' and password = '$password'"
        val cursor = db.rawQuery(query, null)
        if (cursor.count<=0){
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }
}

