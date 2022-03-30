package boj

// boj 1744 수 묶기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun sol1744(plus: MutableList<Int>, minus: MutableList<Int>) {
    var ans = 0

    plus.sort()
    while (plus.isNotEmpty()) {
        if (plus.size >= 2) {
            if (plus[plus.size - 1] == 1 || plus[plus.size - 2] == 1) {
                ans += plus[plus.size - 1] + plus[plus.size - 2]
            } else ans += plus[plus.size - 1] * plus[plus.size - 2]
            plus.removeLast()
        } else {
            ans += plus[plus.size - 1]
        }
        plus.removeLast()
    }

    minus.sortDescending()
    while (minus.isNotEmpty()) {
        if (minus.size >= 2) {
            ans += minus[minus.size - 1] * minus[minus.size - 2]
            minus.removeLast()
        } else {
            ans += minus[minus.size - 1]
        }
        minus.removeLast()
    }

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    bw.write(ans.toString())
    bw.flush()
    bw.close()
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val plus = mutableListOf<Int>()
    val minus = mutableListOf<Int>()

    for (i in 0 until n) {
        val input = br.readLine().toInt()
        if (input > 0) {
            plus.add(input)
            continue
        }
        minus.add(input)
    }

    sol1744(plus, minus)
    br.close()
}