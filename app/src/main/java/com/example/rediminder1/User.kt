package com.example.rediminder1

data class User(val id: Long, val username: String, val email: String, val password: String) {
    fun validate(): Boolean {
        // Validar el nombre de usuario
        if (username.isBlank()) {
            return false
        }

        // Validar el correo electrónico
        val emailRegex = Regex(pattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
        if (!email.matches(emailRegex)) {
            return false
        }

        // Validar la contraseña
        if (password.length < 6) {
            return false
        }

        // Si todas las validaciones pasan, retorna true
        return true
    }

    fun getUserInfo(): String {
        return "ID: $id, Username: $username, Email: $email"
    }
}