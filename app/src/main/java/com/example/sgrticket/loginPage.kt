package com.example.sgrticket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sgrticket.databinding.ActivityLoginPageBinding


private lateinit var binding:ActivityLoginPageBinding
class loginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginPageBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.login.setOnClickListener {
            var getMain = Intent(applicationContext, MainActivity::class.java)
            startActivity(getMain)
        }

        binding.signin.setOnClickListener {
            var getSignup = Intent(applicationContext, sign_up::class.java)
            startActivity(getSignup)
        }


    }
}