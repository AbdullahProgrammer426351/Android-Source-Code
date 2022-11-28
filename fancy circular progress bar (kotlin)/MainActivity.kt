package com.example.fancyprogressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var progr = 0
    lateinit var progress_bar:ProgressBar
    lateinit var text_view_progress:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button_incr: Button = findViewById(R.id.button_incr)
        val button_decr: Button = findViewById(R.id.button_decr)
        progress_bar = findViewById(R.id.progress_bar)
        text_view_progress = findViewById(R.id.text_view_progress)

        updateProgressBar()

        button_incr.setOnClickListener {
            if (progr <= 90) {
                progr += 10
                updateProgressBar()
            }
        }
        button_decr.setOnClickListener {
            if (progr >= 10) {
                progr -= 10
                updateProgressBar()
            }
        }
    }

    private fun updateProgressBar() {
        progress_bar.progress = progr
        text_view_progress.text = "$progr%"

    }
}