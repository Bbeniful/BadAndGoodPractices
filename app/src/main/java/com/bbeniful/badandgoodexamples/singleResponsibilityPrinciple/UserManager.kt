package com.bbeniful.badandgoodexamples.singleResponsibilityPrinciple


//Bad Example
//This class does too many things
class UserManager {
    fun createUser() {}

    fun sendEmail() {}

    fun saveToDatabase() {}
}

//Good Example
// Classes are responsible for one thing
// Easy to maintain and read
class UserCreator {
    fun createUser() {}
}

//We can create not just email, but any kind of messages
interface MessageSender {
    fun sendMessage(message: String)
}

class EmailSender: MessageSender {
    override fun sendMessage(message: String) {}
}

class Sender(private val sender: MessageSender) {

    fun send(message: String) {
        sender.sendMessage(message)
    }
}

class UserRepository {
    fun saveToDatabase() {}
}

