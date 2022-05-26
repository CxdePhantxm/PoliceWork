package com.example.police

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class PhotoRobot : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_robot)
    }

    fun us(view: View)
    {
        val intent = Intent(this,AboutUs::class.java)
        startActivity(intent)
    }

    fun addph(view: View)
    {
        val intent = Intent(this,New_PR::class.java)
        startActivity(intent)
    }
}