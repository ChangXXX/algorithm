package boj

// boj 15486 퇴사2

import java.io.BufferedReader
import java.io.InputStreamReader

data class Consult(val t: Int, val p: Int)

fun sol15486(n: Int, arr: ArrayList<Consult>) {
    val dp = IntArray(n + 1)

    for (i in 0 until n) {
        if (i > 0) dp[i] = dp[i].coerceAtLeast(dp[i - 1])
        if (i + arr[i].t < n + 1 && (dp[i + arr[i].t] < dp[i] + arr[i].p))
            dp[i + arr[i].t] = dp[i] + arr[i].p
    }

    println(dp[n].coerceAtLeast(dp[n - 1]))
}


fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = ArrayList<Consult>()

    for (i in 0 until n) {
        val (t, p) = br.readLine().split(" ").map { it.toInt() }
        arr.add(Consult(t, p))
    }

    sol15486(n, arr)
}