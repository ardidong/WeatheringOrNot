package com.ardidong.weatherornot.core.util.serialize

import com.google.gson.Gson

class Deserializer<T> (private val javaClassName: Class<T>){
    fun deserialize(content: String): T = Gson().fromJson(content, javaClassName)
}