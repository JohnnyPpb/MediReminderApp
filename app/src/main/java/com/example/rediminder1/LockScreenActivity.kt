package com.example.rediminder1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LockScreenActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lock_screen)
        val Logingbutton: Button = findViewById(R.id.loginButton)
        val Registerbutton: Button = findViewById(R.id.registerButton)

        Logingbutton.setOnClickListener {
            val intent2 = Intent(this@LockScreenActivity, LoginActivity::class.java)
            startActivity(intent2)
        }

        Registerbutton.setOnClickListener {
            val intent = Intent(this@LockScreenActivity, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }
}