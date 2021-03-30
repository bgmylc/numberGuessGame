package com.begumyolcu.sayitahminoyunu

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val randomSayi = Random.nextInt(1, 101)
        var score = 100
        buttonGuess.setOnClickListener {
            val guess = Integer.parseInt(numberText.text.toString())
            if (guess == randomSayi){
                val alertString = "Tebrikler! Puanınız: ${score}"
                textViewScore.visibility = View.INVISIBLE
                textViewAlert.setText(alertString)
                numberText.setFocusable(false)
                buttonReplay.visibility = View.VISIBLE
                buttonReplay.setOnClickListener {
                    val intent = intent
                    finish()
                    overridePendingTransition(0, 0);
                    startActivity(intent)
                    overridePendingTransition(0, 0);

                }
            }
            else if (guess != randomSayi && score == 1) {
                score -= 1
                val alertString = "Üzgünüm, oyunu kaybettiniz. Puanınız: 0"
                textViewAlert.setText(alertString)
                numberText.setFocusable(false)
                buttonReplay.visibility = View.VISIBLE
                buttonReplay.setOnClickListener {
                    val intent = intent
                    finish()
                    overridePendingTransition(0, 0);
                    startActivity(intent)
                    overridePendingTransition(0, 0);

                }
            }
            else if (guess < randomSayi){
                val alertString = "Lütfen daha büyük bir sayı deneyin"
                score -= 1
                val scoreString = "Puanınız: ${score}"
                textViewAlert.setText(alertString)
                textViewScore.setText(scoreString)
            }
            else if (guess > randomSayi){
                val alertString = "Lütfen daha küçük bir sayı deneyin"
                score -= 1
                val scoreString = "Puanınız: ${score}"
                textViewAlert.setText(alertString)
                textViewScore.setText(scoreString)
            }
        }
        numberText.setOnClickListener {
          onClick(numberText)
        }
    }
    fun onClick(v: View?) {
        if (v==numberText) {
            numberText.text?.clear()
        }
    }
}




