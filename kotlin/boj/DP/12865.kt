package boj

// 백준 12865 평범한 배낭 DP, 배낭 문제

import java.io.BufferedReader
import java.io.InputStreamReader

fun sol12865(items: Array<Pair<Int, Int>>, k: Int) {
    val dp = Array<IntArray>(items.size + 1) { IntArray(k + 1) { 0 } }

    for (i in 1..items.size) {
        for (j in 1..k) {
            if(items[i-1].first <= j){
                dp[i][j] = if(dp[i-1][j-items[i-1].first] + items[i-1].second > dp[i-1][j]) dp[i-1][j-items[i-1].first] + items[i-1].second else dp[i-1][j]
            } else dp[i][j] = dp[i-1][j]
        }
    }

    println(dp[items.size][k])
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val items = Array<Pair<Int, Int>>(n) { Pair(0, 0) }
    for (i in 0 until n) {
        val (w, v) = br.readLine().split(" ").map { it.toInt() }
        items[i] = Pair(w, v)
    }

    sol12865(items, k)
}