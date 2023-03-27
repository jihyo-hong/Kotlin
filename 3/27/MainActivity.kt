package com.example.march27

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.march27.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var name: String = ""
    private var interval: String = ""
    private var color: String = ""
    private var arr: Array<(String, Int, String) -> Any> = arrayOf({ name, interval, color -> Bus(name, interval, color) }, { name, interval, color -> ElectricBus(name, interval, color) })
    private var bus: Any = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.generalBus.setOnClickListener {
            createBus(0)
        }

        binding.electronicBus.setOnClickListener {
            createBus(1)
        }

        binding.start.setOnClickListener {
            if (bus is Bus) {
                var b = bus as Bus
                b.drive()
                binding.velocity.setText("운행 속도: ${b.speed}")
            }
            else
                showToast("버스가 없습니다")
        }

        binding.accel.setOnClickListener {
            if (bus as? Bus == null)
                showToast("버스가 없습니다")
            else if (bus is ElectricBus) {
                var b = bus as ElectricBus
                b.accelerate()
                if (b.speed > 200)
                    showToast("최대 속력입니다")
                else
                    binding.velocity.setText("운행 속도: ${b.speed}")
            }
            else
                showToast("일반 버스는 가속할 수 없습니다")

        }
    }

    private fun showToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }

    private fun isValid(): Boolean {
        name = binding.busName.text.toString()
        interval = binding.busInterval.text.toString()
        color = binding.busColor.text.toString()

        var ret = true
        if (name == "" || interval == "" || color == "") {
            showToast("입력이 유효하지 않습니다")
            ret = false
        }
        else {
            try {
                interval.toInt()
            }
            catch (e: NumberFormatException) {
                showToast("배차 간격: 숫자를 입력하세요")
                ret = false
            }
        }
        return ret
    }

    private fun createBus(idx: Int) {
        if (isValid()) {
            bus = arr[idx](name, interval.toInt(), color)
            binding.busName.setText("")
            binding.busInterval.setText("")
            binding.busColor.setText("")
            var b = bus as Bus
            binding.velocity.setText("운행 속도: 0")
            showToast(
                "노선 추가됨 [이름: ${b.name}, 배차 간격: ${b.interval}, 색상: ${b.color}, 특징: ${
                    if (bus is ElectricBus) {
                        "전기버스]"
                    } else {
                        "일반버스]"
                    }
                }"
            )
        }
    }
}