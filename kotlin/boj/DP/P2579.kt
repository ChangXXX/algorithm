package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

/**
 * boj 2579 계단 오르기, DP
 */

class P2579 {

    fun solution(n: Int, stairs: IntArray) {
        val dp = IntArray(300) { 0 }

        if(n <= 1){
            var sum = 0
            stairs.forEach { it ->
                sum += it
            }
            println(sum)
            return
        }

        dp[0] = stairs[0]
        dp[1] = stairs[0] + stairs[1]
        dp[2] = max(stairs[0], stairs[1]) + stairs[2]

        for (i in 3 until n) {
            dp[i] = max(dp[i - 3] + stairs[i - 1], dp[i - 2]) + stairs[i]
        }

        println(dp[n - 1])
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val stairs = IntArray(300) { 0 }
    for (i in 0 until n) stairs[i] = br.readLine().toInt()

    P2579().solution(n, stairs)
}