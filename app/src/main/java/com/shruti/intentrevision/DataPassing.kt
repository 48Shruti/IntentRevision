package com.shruti.intentrevision

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shruti.intentrevision.databinding.ActivityDataPassingBinding

class DataPassing : AppCompatActivity() {
    lateinit var binding: ActivityDataPassingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataPassingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var getName = intent.getStringExtra("name")
        var getEmail = intent.getStringExtra("email")
        var getContact = intent.getStringExtra("contact")
        binding.tvname.setText(getName)
        binding.tvemail.setText(getEmail)
        binding.tvcontact.setText(getContact)
        binding.tvemail.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("mailto:${binding.tvemail.text}"))
            startActivity(intent)
        }
        binding.tvcontact.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("sms:${binding.tvcontact.text}"))
            startActivity(intent)
        }

    }
}