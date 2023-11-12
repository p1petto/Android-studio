package com.example.guessthenumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView


class GameActivity : AppCompatActivity() {
    var begin: Int = 0
    var end: Int = 100
    var left: Int = 0
    var right: Int = 0
    var mid: Int = 0
    var flag: Boolean = false
    lateinit var tvQuestion:TextView
    lateinit var btYes:Button
    lateinit var btNo:Button
    lateinit var btRestart:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_game)
        tvQuestion = findViewById<TextView>(R.id.question)
        btYes = findViewById<Button>(R.id.yes)
        btNo = findViewById<Button>(R.id.no)
        btRestart = findViewById<Button>(R.id.restart)

        begin = intent.getIntExtra("begin", 0)
        end = intent.getIntExtra("end", 100)
        left = begin
        right = end
        mid = (begin + end) / 2
        Log.d("mytag", "begin = " + begin)
        Log.d("mytag", "end = " + end)

        tvQuestion.text = "Your number more than $mid?"
    }

    fun win(){
        btYes.visibility = View.GONE
        btNo.visibility = View.GONE
        btRestart.visibility = View.VISIBLE
    }

    fun onRestart(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun onYesNoClick(view: View) {
        when (view.id) {
            R.id.yes -> {
                Log.d("mytag", "yes")
                if (flag){
                    tvQuestion.text = "Great! Your number is $right!"
                    win()
                }
                else{
                    if (right - left > 1) {
                        left = mid
                        mid = (left + right)/2
                        tvQuestion.text = "Your number more than $mid?"
                    }
                    else{
                        tvQuestion.text = "Your number is $right?"
                        flag = true
                    }
                }


//                tvQuestion.text = "yes"


            }
            R.id.no -> {
                Log.d("mytag", "no")

                if (flag){
                    "Great! Your number is $left!"
                    win()
                }
                else{
                    if (right - left > 1) {
                        right = mid
                        mid = (left + right)/2
                        tvQuestion.text = "Your number more than $mid?"
                    }
                    else{
                        tvQuestion.text = "Your number is $right?"
                        flag = true
                    }
                }

//                tvQuestion.text = "no"


            }

        }

    }


}
