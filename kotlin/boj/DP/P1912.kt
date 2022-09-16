package boj

/**
 * https://www.acmicpc.net/problem/1912
 *
 * boj, 1912 연속합, DP
 */

import java.io.BufferedReader
import java.io.InputStreamReader

class P1912 {
    fun solution(n: Int, arr: IntArray) {
        val dp = IntArray(n) { 0 }
        dp[0] = arr[0]
        for (i in 1 until arr.size) {
            if (dp[i - 1] + arr[i] > arr[i]) {
                dp[i] = dp[i - 1] + arr[i]
            } else {
                dp[i] = arr[i]
            }
        }
        println(dp.maxOrNull())
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    P1912().solution(n, arr)
}