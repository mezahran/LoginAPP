package com.mohzahran.loginapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mohzahran.loginapp.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {

   private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

     binding = ActivityHomeBinding.inflate(layoutInflater)
     setContentView(binding.root)
        getData()
    }

    private fun getData() {
        val data = intent.getStringExtra("name")
        checkData(data.toString())
    }

    private fun checkData(str:String) {
        if(str != null){
            binding.txtName.setText("hello $str").toString()
        }else{
            binding.txtName.setText("hello").toString()
        }
    }

}