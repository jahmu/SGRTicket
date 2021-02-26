package com.example.sgrticket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sgrticket.databinding.ActivityLoginPageBinding
import com.example.sgrticket.databinding.ActivitySignUpBinding

private lateinit var binding: ActivitySignUpBinding

class sign_up : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sign.setOnClickListener {
            var getSignupp = Intent(applicationContext, MainActivity::class.java)
            startActivity(getSignupp)
        }

        binding.log.setOnClickListener {
            var getLogin = Intent(applicationContext, loginPage::class.java)
            startActivity(getLogin)
        }


    }
}