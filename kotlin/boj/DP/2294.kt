package boj

// boj 2294 동전2

import java.io.BufferedReader
import java.io.InputStreamReader

fun sol2294(coins: IntArray, n: Int, k: Int) {
    val dp = IntArray(10001) { 100001 }
    dp[0] = 0

    for (i in 0 until n) {
        for (j in coins[i]..k) {
            dp[j] = dp[j].coerceAtMost(dp[j - coins[i]] + 1)
        }
    }

    if (dp[k] == 100001) dp[k] = -1
    println(dp[k])
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val coins = IntArray(n)

    for (i in 0 until n) {
        coins[i] = br.readLine().toInt()
    }

    sol2294(coins, n, k)
}