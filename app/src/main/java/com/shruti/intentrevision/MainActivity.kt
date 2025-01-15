package com.shruti.intentrevision

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import com.shruti.intentrevision.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    var isPasswordVisible = false
    var isConfirmVisible = false
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
            }else if(binding.etconfpassword.text.isNullOrEmpty()){
                binding.etconfpassword.error ="Enter confirm password"
            }else if(binding.etpassword.text.toString() != binding.etconfpassword.text.toString()){
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
        binding.iveyeclosedPass.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            if (isPasswordVisible){
                binding.etpassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                binding.iveyeclosedPass.setImageResource(R.drawable.baseline_remove_red_eye_24)
            }else{
                binding.etpassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                binding.iveyeclosedPass.setImageResource(R.drawable.img)
            }
            binding.etpassword.setSelection(binding.etpassword.text.length)
        }
        binding.iveyeclosedconf.setOnClickListener {
            isConfirmVisible = !isConfirmVisible
            if (isConfirmVisible){
                binding.etconfpassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                binding.iveyeclosedconf.setImageResource(R.drawable.baseline_remove_red_eye_24)
            }else{
                binding.etconfpassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                binding.iveyeclosedconf.setImageResource(R.drawable.img)
            }
            binding.etconfpassword.setSelection(binding.etconfpassword.text.length)
        }
        }
    }

