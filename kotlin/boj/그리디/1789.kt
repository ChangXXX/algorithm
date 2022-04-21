package boj

// boj 1789 그리디

import java.io.BufferedReader
import java.io.InputStreamReader

fun sol1789(s: Long) {
    var sum: Long = 0
    var cnt: Long = 1

    while (sum <= s) {
        sum += cnt
        cnt += 1
    }

    println(cnt - 2)
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine().toLong()

    sol1789(s)
}