package com.example.quiz20

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        var btn =findViewById<Button>(R.id.btn_start)
        var name = findViewById<EditText>(R.id.et_name)

        btn.setOnClickListener{
            if(name.text.toString().isEmpty()){
                Toast.makeText(this,"Please enter your name",Toast.LENGTH_LONG).show()
            }
            else{
                Constant.username = name.text.toString()
                var intent = Intent(this,QuizQuestion::class.java)
                intent.putExtra("username", name.text)
                startActivity(intent)
                finish()
            }
        }
    }
}