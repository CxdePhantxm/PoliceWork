package com.example.police

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class New_PR : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_pr)
    }

    fun bck(view: View)
    {
        val intent = Intent(this,PhotoRobot::class.java)
        startActivity(intent)
    }

    fun share(view: View)
    {
        val intent = Intent(this,Paint::class.java)
        startActivity(intent)
    }
}