package com.example.march27

open class Bus constructor (var name: String?, var interval: Int, var color: String) {
    init {
        println("노선 추가 [버스 번호: ${name}번, 배차 간격: ${interval}분, 색상: ${color}")
    }

    var speed = 0
    open fun drive() {
        speed = 50
    }
}