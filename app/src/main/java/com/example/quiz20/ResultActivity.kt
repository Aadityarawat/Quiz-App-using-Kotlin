package com.example.quiz20

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class ResultActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val tv_name = findViewById<TextView>(R.id.tv_name)
        val username = Constant.username
        tv_name.text = username

        val totalque = intent.getIntExtra(Constant.totalquestion,0)
        val correctans = intent.getIntExtra(Constant.correctans,0)

        val tvscore = findViewById<TextView>(R.id.tv_score)
        tvscore.text = "YOUR SCORE IS $correctans out of $totalque"

        val btn = findViewById<Button>(R.id.btn_finish)
        btn.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}