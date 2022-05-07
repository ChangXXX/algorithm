package boj

// boj 15989 1, 2, 3 더하기 4

import java.io.BufferedReader
import java.io.InputStreamReader

fun sol15989(n: Int) {
    val dp = IntArray(10001) { 0 }
    dp[0] = 1

    for (i in 1..3) {
        for (j in i..n) {
            dp[j] += dp[j - i]
        }
    }
    println(dp[n])
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    for (i in 0 until t) {
        sol15989(br.readLine().toInt())
    }
}