package com.bbeniful.badandgoodexamples.godObject

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
//Separate classes by grouping them by their responsibility
class UserSession(
    private val userObject: UserObject,
    private val sessionObject: SessionObject,
)

class CachedData(val cacheObject: CacheObject)