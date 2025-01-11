package com.shruti.intentrevision

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.shruti.intentrevision.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnregister.setOnClickListener {
            if(binding.etname.text.isNullOrEmpty()){
                binding.etname.error ="Enter name"
            }else if(binding.etemail.text.isNullOrEmpty()){
                binding.etemail.error ="Enter email"
            }else if(binding.etcontact.text.isNullOrEmpty()){
                binding.etcontact.error ="Enter contact"
            }else if(binding.etpassword.text.isNullOrEmpty()){
                binding.etpassword.error ="Enter password"
            }else if(binding.etconfirmpassword.text.isNullOrEmpty()){
                binding.etconfirmpassword.error ="Enter confirm password"
            }else if(binding.etpassword.text.toString() != binding.etconfirmpassword.text.toString()){
                    Toast.makeText(this,"Passwords are not matched", Toast.LENGTH_SHORT).show()
                }
            else{
                    val intent = Intent(this,DataPassing::class.java)
                    intent.putExtra("name", binding.etname.text.toString())
                    intent.putExtra("email", binding.etemail.text.toString())
                    intent.putExtra("contact", binding.etcontact.text.toString())
                    startActivity(intent)
                    Toast.makeText(this,"Passwords are  matched", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

