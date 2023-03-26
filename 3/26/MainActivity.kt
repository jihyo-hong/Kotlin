package com.example.march26

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.march26.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var first: Int = 0
    private var second: Int = 0
    private var oper: Array<(Int, Int) -> Int> = arrayOf({x, y -> x + y}, {x, y -> x - y}, {x, y -> x * y}, {x, y -> x / y})

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        fun isValid(a: String, b: String): Boolean {
            var ret = false
            if (a == "" || b == "")
                Toast.makeText(applicationContext, "두 개의 숫자를 입력하세요", Toast.LENGTH_LONG).show()
            else {
                try {
                    first = a.toInt()
                    second = b.toInt()
                    ret = true
                }
                catch (e: NumberFormatException) {
                    Toast.makeText(applicationContext, "유효한 입력이 아닙니다", Toast.LENGTH_LONG).show()
                }
            }
            return ret
        }

        fun execute(idx: Int) {
            try {
                binding.result.setText("결과: ${oper[idx](first, second)}")
            }
            catch (e: ArithmeticException) {
                Toast.makeText(applicationContext, "0으로 나눌 수 없습니다", Toast.LENGTH_LONG).show()
            }
        }

        binding.addButton.setOnClickListener {
            if (isValid(binding.value1.text.toString(), binding.value2.text.toString()))
                execute(binding.addButton.hint.toString().toInt())
        }

        binding.subButton.setOnClickListener {
            if (isValid(binding.value1.text.toString(), binding.value2.text.toString()))
                execute(binding.subButton.hint.toString().toInt())
        }

        binding.mulButton.setOnClickListener {
            if (isValid(binding.value1.text.toString(), binding.value2.text.toString()))
                execute(binding.mulButton.hint.toString().toInt())
        }

        binding.divButton.setOnClickListener {
            if (isValid(binding.value1.text.toString(), binding.value2.text.toString()))
                execute(binding.divButton.hint.toString().toInt())
        }
    }

    /*fun show(message: String) {
        println("show -> $message")
    }*/
}