package com.example.pr4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var actionbar = supportActionBar
        actionbar!!.title = "SignIn Page"


        var bsign = findViewById<Button>(R.id.main2btn)
        bsign.setOnClickListener {
            val intent = Intent(this, main2::class.java)
            startActivity(intent)

        }

    }
}
