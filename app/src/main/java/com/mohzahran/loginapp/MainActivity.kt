package com.mohzahran.loginapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.mohzahran.loginapp.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        callback()
        getData()
    }
    private fun callback(){
        binding.btnLogIn.setOnClickListener {
            checkData(binding.etEmail.editText?.text.toString(),binding.etPassword.editText?.text.toString())
        }
        binding.btnSignUp.setOnClickListener {
            startSignUp()
        }
        binding.forgetPassword.setOnClickListener {
            // here code when you forget password
        }
    }
    private fun checkData(email:String , password:String) {
        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(this,"Please Enter Your Email And password",Toast.LENGTH_LONG).show()
        }
        else if (email.length >= 8 && email.contains('@')&& email.contains('.') && password.length >= 8 ){
            startHome()
        }else{
            Toast.makeText(this,"Wrong Email Or Password",Toast.LENGTH_LONG).show()
        }
    }
    private fun startHome() {
        val intent = Intent(this,Home::class.java)
        intent.putExtra("name",binding.etEmail.editText?.text.toString().substringBefore('@'))
        startActivity(intent)
    }
    private fun startSignUp() {
        val intent = Intent(this,SignUp::class.java)
        startActivity(intent)
        binding.etEmail.editText?.setText("")
        binding.etPassword.editText?.setText("")
    }
    private fun getData() {
        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("password")
        if (email.toString().isNotEmpty() && password.toString().isNotEmpty()){
            binding.etEmail.editText?.setText(email)
            binding.etPassword.editText?.setText(password)

        }else{

        }
    }
}

