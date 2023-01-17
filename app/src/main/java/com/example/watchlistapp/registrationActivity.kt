package com.example.watchlistapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class registrationActivity : AppCompatActivity() {
    lateinit var password : EditText
    lateinit var email : EditText
    lateinit var register: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        init()

        RegisterActivityListeners()
    }

    private fun init(){
        password=findViewById(R.id.password)
        email=findViewById(R.id.name)
        register=findViewById(R.id.Register)
    }

    private fun RegisterActivityListeners(){
        register.setOnClickListener {
            val email=email.text.toString()
            val pass=password.text.toString()

            if (email.isEmpty() || pass.isEmpty()){
                Toast.makeText(this, "ველების შევსება სავალდებულოა", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, pass).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "მონაცემები არასწორია", Toast.LENGTH_SHORT).show()
                }
            }
            }
        }

    fun clickMe(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
    }

}


