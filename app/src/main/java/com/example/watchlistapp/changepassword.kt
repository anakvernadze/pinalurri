package com.example.watchlistapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class changepassword : AppCompatActivity() {
    private lateinit var oldPassword : EditText
    private lateinit var newPassword: EditText
    private lateinit var changePassword : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_changepassword)
    }

    private fun init()  {
        oldPassword = findViewById(R.id.oldPassword)
        newPassword = findViewById(R.id.newPassword)
        changePassword = findViewById(R.id.changePass)
    }

    private fun registerListeners () {
        changePassword.setOnClickListener {
            val oldPassword = oldPassword.text.toString()
            val newPassword = newPassword.text.toString()

            if (oldPassword.isEmpty() || newPassword.isEmpty()) {
                Toast.makeText(this, "Fields are empty", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            } else if (oldPassword != newPassword) {
                Toast.makeText(this, "Passwords doesn't match", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (oldPassword == newPassword) {
                FirebaseAuth.getInstance().currentUser?.updatePassword(newPassword)
                    ?.addOnCompleteListener { task ->
                        if (task.isSuccessful){
                            Toast.makeText(this, "Password has been changed", Toast.LENGTH_LONG).show()
                        } else {
                            Toast.makeText(this, "Password didn't change", Toast.LENGTH_LONG).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Passwords don't match", Toast.LENGTH_LONG).show()
            }
        }
    }
}