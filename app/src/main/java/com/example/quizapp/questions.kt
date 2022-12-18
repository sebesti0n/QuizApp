package com.example.quizapp

object questions {

    fun getquestion():ArrayList<Question> {
    val Qlist=ArrayList<Question>()

      val q1=Question(
          1,"what is capital of india?",R.drawable.ic_bg,"Mumbai","Kolkata","New Delhi","Bengaluru",
          3
      )
        Qlist.add(q1)
        val q2=Question(
            2,"what is capital of Bihar?",R.drawable.ic_bg,"Patna","Darbhanga","Gaya","Begusarai",
            1
        )
        Qlist.add(q2)
        val q3=Question(
            3,"what is the Number of Union Territories?",R.drawable.ic_bg,"8","7","9","6",
            1
        )
        Qlist.add(q3)

        return  Qlist
    }
}