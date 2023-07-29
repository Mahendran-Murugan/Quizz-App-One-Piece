package com.example.myquizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnSubmit:Button = findViewById(R.id.btnSubmit1)
        val txtField:EditText = findViewById(R.id.TextField1)
        btnSubmit.setOnClickListener {
            if(txtField.text.isEmpty()){
                Toast.makeText(this,"Please Enter your name",Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this, QuestionActivity::class.java)
                intent.putExtra(Constants.tv_usr_name,txtField.text.toString())
                startActivity(intent)
            }
        }
    }
}