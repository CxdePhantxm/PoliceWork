package com.example.police

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Paint : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paint)
    }

    fun bck1(view: View)
    {
        val intent = Intent(this,New_PR::class.java)
        startActivity(intent)
    }
    fun shr(view: View) {}
}