package com.example.android.register

object Utils {

    //This is a regex to match Nigerian phone numbers only
    var REGEX = Regex("^(\\+044|0)(8([01])|([79])([0]))\\d{8}$")

    //Validators
    fun nameValidator(name:String) = name.isNotEmpty()
    fun emailValidator(email:String) = email.isNotEmpty()
    fun phoneNumberValidator(phone:String) = phone.matches(REGEX)

}