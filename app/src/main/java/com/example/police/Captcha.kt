package com.example.police

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_captcha.*
import kotlinx.android.synthetic.main.activity_captcha.login
import kotlinx.android.synthetic.main.activity_captcha.pass
import kotlinx.android.synthetic.main.activity_sign_in.*

class Captcha : AppCompatActivity() {
    lateinit var handler: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_captcha)

        handler = DatabaseHelper(this)

        editTextTextPersonName.setText(getRandomString())
    }

    fun getRandomString():String{
        val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        return (1..STRING_LENGTH)
            .map { i -> kotlin.random.Random.nextInt(0, charPool.size) }
            .map(charPool::get).joinToString("")
    }

    fun ok(view: android.view.View)
    {
        if(handler.userPresent(login.text.toString(), pass.text.toString()) && login.text.isNotEmpty() && pass.text.isNotEmpty()){
            val intent = Intent(this,MainMenu::class.java)
            startActivity(intent)
        }
    }

    companion object {
        const val STRING_LENGTH = 10
        const val ALPHANUMERIC_REGEX = "[a-zA-Z0-9]+"
    }
}