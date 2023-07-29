package com.example.myquizzapp

object Constants {

    const val tv_usr_name:String = "Mahendran"
    const val correct_answer:String ="0"
    const val total_question:String = "4"
    fun getQuestion():ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val question1 = Question(
            1,
            "What is the name of this Character?",
            R.drawable.ic_uffy,
            "Luffy",
            "Zoro",
            "Sanji",
            "Ussop",
            1
        )
        val question2 = Question(
            2,
            "What is the name of this Character?",
            R.drawable.ic_sanji,
            "Luffy",
            "Zoro",
            "Sanji",
            "Ussop",
            3
        )
        val question3= Question(
            3,
            "What is the name of this Character?",
            R.drawable.ic_ussop,
            "Luffy",
            "Zoro",
            "Sanji",
            "Ussop",
            4
        )
        val question4 = Question(
            4,
            "What is the name of this Character?",
            R.drawable.ic_zoro,
            "Luffy",
            "Zoro",
            "Sanji",
            "Ussop",
            2
        )

        questionList.add(question1)
        questionList.add(question2)
        questionList.add(question3)
        questionList.add(question4)

        return questionList
    }
}