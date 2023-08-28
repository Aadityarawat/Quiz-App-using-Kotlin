package com.example.quiz20

object Constant {

    var username : String = "username"
    const val totalquestion : String = "totalquestion"
    const val correctans : String = "Correctanswers"
    fun getQuestion():ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val que1 = Question(
            1,
            "What Country Flag is This",
            R.drawable.ic_flag_of_australia,
            "India",
            "America",
            "Australia",
            "Argentina",
            3
        )
        questionList.add(que1)

        val que2 = Question(
            2,
            "What Country Flag is This",
            R.drawable.ic_flag_of_belgium,
            "India",
            "America",
            "Belgium",
            "Argentina",
            3
        )
        questionList.add(que2)
        val que3 = Question(
            3,
            "What Country Flag is This",
            R.drawable.ic_flag_of_argentina,
            "India",
            "America",
            "Brazil",
            "Argentina",
            4
        )
        questionList.add(que3)
        val que4 = Question(
            4,
            "What Country Flag is This",
            R.drawable.ic_flag_of_brazil,
            "India",
            "America",
            "Australia",
            "brazil",
            4
        )
        questionList.add(que4)
        val que5 = Question(
            4,
            "What Country Flag is This",
            R.drawable.ic_flag_of_fiji,
            "India",
            "America",
            "Australia",
            "Fiji",
            4
        )
        questionList.add(que5)
        val que6 = Question(
            4,
            "What Country Flag is This",
            R.drawable.ic_flag_of_denmark,
            "India",
            "Denmark",
            "Australia",
            "brazil",
            2
        )
        questionList.add(que6)
        val que7 = Question(
            4,
            "What Country Flag is This",
            R.drawable.ic_flag_of_germany,
            "India",
            "Germany",
            "Australia",
            "brazil",
            2
        )
        questionList.add(que7)
        val que8 = Question(
            4,
            "What Country Flag is This",
            R.drawable.ic_flag_of_india,
            "India",
            "Denmark",
            "Australia",
            "brazil",
            1
        )
        questionList.add(que8)
        val que9 = Question(
            4,
            "What Country Flag is This",
            R.drawable.ic_flag_of_kuwait,
            "India",
            "Denmark",
            "Kuwait",
            "brazil",
            3
        )
        questionList.add(que9)
        val que10 = Question(
            4,
            "What Country Flag is This",
            R.drawable.ic_flag_of_new_zealand,
            "India",
            "New Zealand",
            "Australia",
            "brazil",
            2
        )
        questionList.add(que10)
        return questionList
    }
}