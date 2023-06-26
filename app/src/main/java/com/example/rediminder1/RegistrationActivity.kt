package com.example.rediminder1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class RegistrationActivity : AppCompatActivity() {
    private lateinit var databaseHelper: DatabaseHelper

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        databaseHelper = DatabaseHelper(this)
        val usernameEditText: EditText = findViewById(R.id.UserEditText)
        val emailEditText: EditText = findViewById(R.id.emailEditText)
        val passwordEditText: EditText = findViewById(R.id.passwordEditText)


        val registerButton: Button = findViewById(R.id.registerButton)
        registerButton.setOnClickListener {
            val username = usernameEditText.text.toString() // Obtén el nombre de usuario ingresado por el usuario
            val email = emailEditText.text.toString() // Obtén el correo electrónico ingresado por el usuario
            val password = passwordEditText.text.toString() // Obtén la contraseña ingresada por el usuario

            // Insertar el usuario en la base de datos
            val id = databaseHelper.insertUser(username, email, password)

            // Realizar cualquier otra acción necesaria después del registro

            // Cerrar la actividad de registro
            finish()
        }

    }
    override fun onDestroy() {
        super.onDestroy()
        databaseHelper.close()
    }
}