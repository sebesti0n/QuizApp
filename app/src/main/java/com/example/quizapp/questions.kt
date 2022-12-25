package com.example.quizapp

object questions {
    const val USER_NAME:String="user_name"
    const val TOTAL_QUESTION: String="total soln"
    const val CORRECT_ANSWER: String="correct_ans"
    fun getquestion():ArrayList<Question> {
    val Qlist=ArrayList<Question>()

      val q1=Question(
          1,"what is capital of india?","Mumbai","Kolkata","New Delhi","Bengaluru",
          3
      )
        Qlist.add(q1)
        val q2=Question(
            2,"what is capital of Bihar?","Patna","Darbhanga","Gaya","Begusarai",
            1
        )
        Qlist.add(q2)
        val q3=Question(
            3,"what is the Number of Union Territories?","8","7","9","6",
            1
        )
        Qlist.add(q3)

        return  Qlist
    }
}