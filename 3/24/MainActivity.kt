package com.example.march24

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.march24.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            Toast.makeText(applicationContext, "확인1", Toast.LENGTH_LONG).show()
            val input = binding.editText1.text.toString()
            binding.textView.setText("${input}")
        }

        binding.button2.setOnClickListener {
            Toast.makeText(applicationContext, "확인2", Toast.LENGTH_LONG).show()
            val input = binding.editText2.text.toString()
            binding.textView.setText("${input}")
        }
    }
}