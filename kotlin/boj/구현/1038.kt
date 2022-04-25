package boj

// boj 1038 감소하는 수

import java.io.BufferedReader
import java.io.InputStreamReader

private val list = mutableListOf<Long>()

fun sol1038(n: Int) {

    for (i in 0 until 10) {
        getDecreaseNum(i.toLong(), 1)
    }

    list.sort()

    println(list[n])
}

fun getDecreaseNum(num: Long, pos: Int) {
    if (pos > 10) return

    list.add(num)
    for (i in 0 until num % 10) {
        getDecreaseNum((num * 10) + i, pos + 1)
    }
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    // 2^10-1 번째 숫자
    if (n > 1022) {
        println(-1)
    } else sol1038(n)
}