package boj

//boj 2293 동전 1

import java.io.BufferedReader
import java.io.InputStreamReader

fun sol2293(coins: IntArray, n: Int, k: Int) {
    val dp = IntArray(10001) { 0 }
    dp[0] = 1

    for (i in coins.indices) {
        for(j in coins[i]..k){
            dp[j] += dp[j - coins[i]]
        }
    }

    println(dp[k])
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val coins = IntArray(n)

    for (i in 0 until n) {
        coins[i] = br.readLine().toInt()
    }

    sol2293(coins, n, k)
}