package com.mohzahran.loginapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mohzahran.loginapp.databinding.ActivitySignUpBinding

class SignUp : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        callback()
    }

    private fun callback(){
        binding.btnCreateAccount.setOnClickListener {
            checkData(binding.etUserName.editText?.text.toString() ,binding.etEmail.editText?.text.toString()
                ,binding.etPassword.editText?.text.toString(),binding.etRepeatPassword.editText?.text.toString())
        }
        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun checkData(userName :String , email:String , password:String , repeatPassword : String) {
        if(userName.isEmpty() || email.isEmpty() || password.isEmpty() || repeatPassword.isEmpty()){
            Toast.makeText(this,"Please Enter Your UserName,Email and password", Toast.LENGTH_LONG).show()
        }
        else if (userName.length >= 8 && email.length >= 8 && email.contains('@')&& email.contains('.')
            && password.length >= 8 && repeatPassword.length >= 8 && password.toString() == repeatPassword.toString())
        {
            saveData(email.toString(),password.toString())
        }else{
            Toast.makeText(this,"Wrong Data", Toast.LENGTH_LONG).show()
        }
    }

    private fun saveData(email:String ,password :String) {
        intent = Intent(this,MainActivity::class.java)
        intent.putExtra("email",email)
        intent.putExtra("password",password)
        startActivity(intent)
        finish()
    }

}