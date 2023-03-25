package com.example.march25

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.march25.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var name:String= ""
    private var mobile:String= ""
    private var firstStr = ""
    private var secondStr = ""
    private var first:Int = 0
    private var second:Int = 0
    private var res:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            name = binding.nameInput.text.toString()
            mobile = binding.mobileInput.text.toString()

            Toast.makeText(applicationContext, "name: $name, mobile: $mobile", Toast.LENGTH_LONG).show()
        }

        binding.addButton.setOnClickListener {
            firstStr = binding.value1.text.toString()
            secondStr = binding.value2.text.toString()

            if (firstStr == "" || secondStr == "") {
                Toast.makeText(applicationContext, "2개의 숫자를 입력하세요", Toast.LENGTH_LONG).show()
            }
            else {
                try {
                    first = firstStr.toInt()
                    second = secondStr.toInt()
                    res = first + second
                    binding.result.setText("결과: $res")
                }
                catch (e: NumberFormatException){
                    Toast.makeText(applicationContext, "입력 오류입니다", Toast.LENGTH_LONG).show()
                }
            }
        }

        binding.subButton.setOnClickListener {
            firstStr = binding.value1.text.toString()
            secondStr = binding.value2.text.toString()

            if (firstStr == "" || secondStr == "") {
                Toast.makeText(applicationContext, "2개의 숫자를 입력하세요", Toast.LENGTH_LONG).show()
            }
            else {
                try {
                    first = firstStr.toInt()
                    second = secondStr.toInt()
                    res = first - second
                    binding.result.setText("결과: $res")
                }
                catch (e: NumberFormatException){
                    Toast.makeText(applicationContext, "입력 오류입니다", Toast.LENGTH_LONG).show()
                }
            }
        }

        binding.mulButton.setOnClickListener {
            firstStr = binding.value1.text.toString()
            secondStr = binding.value2.text.toString()

            if (firstStr == "" || secondStr == "") {
                Toast.makeText(applicationContext, "2개의 숫자를 입력하세요", Toast.LENGTH_LONG).show()
            }
            else {
                try {
                    first = firstStr.toInt()
                    second = secondStr.toInt()
                    res = first * second
                    binding.result.setText("결과: $res")
                }
                catch (e: NumberFormatException){
                    Toast.makeText(applicationContext, "입력 오류입니다", Toast.LENGTH_LONG).show()
                }
            }
        }

        binding.divButton.setOnClickListener {
            firstStr = binding.value1.text.toString()
            secondStr = binding.value2.text.toString()

            if (firstStr == "" || secondStr == "") {
                Toast.makeText(applicationContext, "2개의 숫자를 입력하세요", Toast.LENGTH_LONG).show()
            }
            else {
                try {
                    first = firstStr.toInt()
                    second = secondStr.toInt()
                    try {
                        res = first / second
                        binding.result.setText("결과: $res")
                    }
                    catch (e: ArithmeticException) {
                        Toast.makeText(applicationContext, "0으로 나눌 수 없습니다", Toast.LENGTH_LONG).show()
                    }
                }
                catch (e: NumberFormatException){
                    Toast.makeText(applicationContext, "입력 오류입니다", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}