package com.example.guessthenumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onGuessClick(view: View) {
        val intent = Intent(this, GameActivity::class.java)
        val begin = findViewById<EditText>(R.id.begin)
        val end = findViewById<EditText>(R.id.end)

        try {
            val beginnum = begin.text.toString().toInt()
            val endnum = end.text.toString().toInt()

            if (endnum <= beginnum) {
                val tvMessage = findViewById<TextView>(R.id.message)
                tvMessage.text = "The final value cannot be less than or equal the initial value"
            } else {
                intent.putExtra("begin", beginnum)
                intent.putExtra("end", endnum)
                startActivity(intent)
            }
        } catch (e: NumberFormatException) {
            // Handle the case when input is not a valid integer
            val tvMessage = findViewById<TextView>(R.id.message)
            tvMessage.text = "Please enter valid numbers"
        }
    }

}