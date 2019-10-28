package com.example.myfirstandroidapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    private var points = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pickRandomNumbers()
    }

    private fun checkIfCorrectAnswer(isLeft: Boolean){
        val leftButton = findViewById<Button>(R.id.left_button)
        val rightButton = findViewById<Button>(R.id.right_button)

        val leftNum = leftButton.text.toString().toInt()
        val rightNum = rightButton.text.toString().toInt()

        if (isLeft && leftNum > rightNum || !isLeft && leftNum < rightNum) {
            points++
            Toast.makeText(this, "You got it!", Toast.LENGTH_SHORT).show()
        } else {
            points--
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
        }
        findViewById<TextView>(R.id.points).text = "Points: $points"
        pickRandomNumbers()
    }

    fun leftButtonClick(view: View){
        checkIfCorrectAnswer(true)
    }

    fun rightButtonClick(view: View){
        checkIfCorrectAnswer(false)
    }

    fun pickRandomNumbers(){
        val leftButton = findViewById<Button>(R.id.left_button)
        val rightButton = findViewById<Button>(R.id.right_button)
        val r = Random()
        var num1 = r.nextInt(10)
        var num2 = r.nextInt(10)

        while (num1 == num2) {
            num2 = r.nextInt(10)
        }

        leftButton.text = "$num1"
        rightButton.text = "$num2"
    }
}
