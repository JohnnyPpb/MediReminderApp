package com.example.rediminder1

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 2
        private const val DATABASE_NAME = "users.db"
        private const val TABLE_NAME = "users"
        private const val COLUMN_ID = "id"
        private const val COLUMN_USERNAME = "username"
        private const val COLUMN_EMAIL = "email"
        private const val COLUMN_PASSWORD = "password"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMN_USERNAME TEXT, $COLUMN_EMAIL TEXT, $COLUMN_PASSWORD TEXT)"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS users")

        onCreate(db)
    }
    fun insertUser(username: String, email: String, password: String): Long {
        val values = ContentValues()
        values.put(COLUMN_USERNAME, username)
        values.put(COLUMN_EMAIL, email)
        values.put(COLUMN_PASSWORD, password)
        val db = this.writableDatabase
        val id = db.insert(TABLE_NAME, null, values)
        db.close()
        return id
    }

    @SuppressLint("Range")
    fun getUser(email: String): User? {
        val selectQuery = "SELECT * FROM $TABLE_NAME WHERE $COLUMN_EMAIL = ?"
        val db = this.readableDatabase
        val cursor = db.rawQuery(selectQuery, arrayOf(email))
        val user: User? = if (cursor.moveToFirst()) {
            val id = cursor.getLong(cursor.getColumnIndex(COLUMN_ID))
            val username = cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME))
            val password = cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD))
            User(id, username, email, password)
        } else {
            null
        }
        cursor.close()
        db.close()
        return user
    }
    @SuppressLint("Range")
    fun getUserById(userId: Long): User? {
        val selectQuery = "SELECT * FROM $TABLE_NAME WHERE $COLUMN_ID = ?"
        val db = this.readableDatabase
        val cursor = db.rawQuery(selectQuery, arrayOf(userId.toString()))
        val user: User? = if (cursor.moveToFirst()) {
            val username = cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME))
            val email = cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL))
            val password = cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD))
            User(userId, username, email, password)
        } else {
            null
        }
        cursor.close()
        db.close()
        return user
    }
}