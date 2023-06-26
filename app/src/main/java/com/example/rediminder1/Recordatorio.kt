package com.example.rediminder1


import android.content.Context
import java.io.Serializable

class Recordatorio (id: Int =0, medicationName: String =  "", dose: String = "", frequency: String = "", reminderTime: String = "", context: Context): Serializable  {
    private var id: Int=  id
    private var medicationName: String = medicationName
    private var dose: String = dose
    private var frequency: String = frequency
    private var reminderTime: String = reminderTime
    private var db = DatabaseHelper(context)
}