package com.example.march27

class ElectricBus(name: String, interval: Int, color: String, var electric: String = "전기버스"): Bus(name, interval, color) {
    init {
        println("전기버스!")
    }

    override fun drive() {
        speed = 60
    }

    fun accelerate() {
        speed += 10
    }
}