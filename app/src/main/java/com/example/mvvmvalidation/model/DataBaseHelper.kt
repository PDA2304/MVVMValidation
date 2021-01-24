package com.example.mvvmvalidation.model

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import kotlin.math.sqrt

class DataBaseHelper(context: Context?):SQLiteOpenHelper(context, "authentication1.db", null, 1) {
    val TABLE_NAME = "authentication_table"
    val COL = "EMAIL"
    val COL2 = "PASSWORD"

    override fun onCreate(p0: SQLiteDatabase?) {
        val createTable  = "CREATE TABLE $TABLE_NAME (ID INTEGER PRIMARY KEY AUTOINCREMENT, EMAIL TEXT,PASSWORD TEXT)"
        p0!!.execSQL(createTable)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }

    fun addData(pass: String?, email: String?):Boolean
    {
       val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL, email)
        contentValues.put(COL2, pass)
        val result = db.insert(TABLE_NAME, null, contentValues)
        return result != -1L;
    }

}