package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Integer.max

fun sol9251(first: String, second: String): String {
    val dp = MutableList(first.length + 1) { MutableList<Int>(second.length + 1) { 0 } }

    for (i in 1 until first.length + 1) {
        for (j in 1 until second.length + 1) {
            if (first[i - 1] == second[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }

    return dp[first.length][second.length].toString()
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val first = br.readLine().toString()
    val second = br.readLine().toString()

    bw.write(sol9251(first, second))
    bw.flush()
    br.close()
    bw.close()
}