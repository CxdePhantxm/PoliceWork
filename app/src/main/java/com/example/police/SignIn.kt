package com.example.police

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignIn : AppCompatActivity() {

    lateinit var handler: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        handler = DatabaseHelper(this)
    }

    fun sign_in(view: android.view.View)
    {
        if(handler.userPresent(login.text.toString(), pass.text.toString()) && login.text.isNotEmpty() && pass.text.isNotEmpty()){
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,Captcha::class.java)
            startActivity(intent)
        }
        else
            Toast.makeText(this, "Incorrect login or password or fields are empty", Toast.LENGTH_SHORT).show()
    }

    fun sign_Up(view: View) {
        if(handler.insertUserData(login.text.toString(), pass.text.toString())){
            Toast.makeText(this, "SignUp Success", Toast.LENGTH_SHORT).show()
        }
        else
            Toast.makeText(this, "SignUp Failed", Toast.LENGTH_SHORT).show()
    }
}