package com.bbeniful.badandgoodexamples.godObject_no

class UserObject
class SessionObject
class CacheObject

//This class is not good example
// This class knows and does too much
class GodObject {
    val userObject = UserObject()
    val sessionObject = SessionObject()
    val cacheObject = CacheObject()
}

//Good example
//Decompose the GodObject into smaller classes with single responsibility
class UserSession(
    private val userObject: UserObject,
    private val sessionObject: SessionObject,
)

class CachedData(val cacheObject: CacheObject)