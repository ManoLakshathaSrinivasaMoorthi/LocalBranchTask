package com.example.myapplication.model

class UserLoginInfo {
    companion object{
        var user:User? = null
    }
}

data class User(val username:String)