package com.example.myapplication.actfragview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.myapplication.R

@Suppress("DEPRECATION")
class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        Handler().postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }, 2000
        )
    }
}