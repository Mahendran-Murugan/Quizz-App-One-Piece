package com.example.myquizzapp

data class Question(
    val id : Int,
    val question : String,
    val image : Int,
    val OptionOne : String,
    val OptionTwo : String,
    val OptionThree : String,
    val OptionFour : String,
    val CorrectOption : Int
)
