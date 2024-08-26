package com.bbeniful.badandgoodexamples.longFunctions

class LongAndTooComplexFunctions {

    //Bad example
    //Very hard to maintain and understand
    //Harder to debug
    fun processUserData(name: String, email: String) {
        // 1. Validate the email format.
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            throw IllegalArgumentException("Invalid email format")
        }

        // 2. Save user data to the database.
        val user = User(name, email)
        val userDao = UserDao() // Assuming you have a UserDao class
        userDao.insert(user)

        // 3. Send a welcome email.
        val emailService = EmailService() // Assuming you have an EmailService class
        emailService.sendWelcomeEmail(email)
    }

    //Solution
    //Each method does only one thing and does it well.
    //Easy to read, maintain and understand

    fun registerUser(name: String, email: String) {
        if (!isValidEmail(email)) {
            throw IllegalArgumentException("Invalid email format")
        }

        val user = User(name, email)
        saveUser(user)
        sendWelcomeEmail(email)
    }

    // Function to validate email format
    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    // Function to save user data
    private fun saveUser(user: User) {
        val userDao = UserDao()
        userDao.insert(user)
    }

    // Function to send a welcome email
    private fun sendWelcomeEmail(email: String) {
        val emailService = EmailService()
        emailService.sendWelcomeEmail(email)
    }

}

class EmailService {
    fun sendWelcomeEmail(email: String) {}
}

class UserDao {
    fun insert(user: User) {}
}

data class User(
    val name: String,
    val email: String
)
