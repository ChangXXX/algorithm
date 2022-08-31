package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

/**
 * https://www.acmicpc.net/problem/2156
 * boj 2156 포도주 시식, DP
 */

class P2156 {

    fun solution(n: Int, grapes: IntArray) {
        val dp = IntArray(n) { 0 }

        if (n <= 2) {
            println(grapes.sum())
            return
        }

        dp[0] = grapes[0]
        dp[1] = grapes[0] + grapes[1]
        dp[2] = max(dp[1], max(grapes[0], grapes[1]) + grapes[2])

        for (i in 3 until n) {
            dp[i] = max(dp[i - 1], max(dp[i - 3] + grapes[i - 1] + grapes[i], dp[i - 2] + grapes[i]))
        }

        println(dp[n - 1])
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val grapes = IntArray(n) { 0 }

    for (i in 0 until n) {
        grapes[i] = br.readLine().toInt()
    }

    P2156().solution(n, grapes)
}