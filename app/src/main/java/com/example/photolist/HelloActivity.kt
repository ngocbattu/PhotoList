package com.example.photolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class HelloActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)
        Handler().postDelayed(Runnable {
            startActivity(Intent(this@HelloActivity , MainActivity::class.java))
        },3000)
    }
}