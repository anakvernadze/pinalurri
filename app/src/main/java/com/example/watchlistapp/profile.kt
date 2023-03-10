package com.example.watchlistapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class profile : AppCompatActivity() {
    private lateinit var changePass : Button
    private lateinit var signout : Button
    private lateinit var toHome:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        init()
        registerListeners()
    }
    private fun init() {
        changePass = findViewById(R.id.changePass)
        signout = findViewById(R.id.signOut)
        toHome=findViewById(R.id.login1)
    }

    private fun registerListeners () {
        changePass.setOnClickListener {
            startActivity(Intent(this, changepassword::class.java))
        }
        signout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
        }
        toHome.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}