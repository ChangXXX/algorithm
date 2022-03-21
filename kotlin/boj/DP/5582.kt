package boj

// BOJ 5582 공통부분 문자열

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun sol5582(first: CharArray, second: CharArray): String {
    var ans: Int = 0

    val dp: Array<IntArray> = Array(first.size + 1) { IntArray(second.size + 1) { 0 } }

    for (i in 1 until second.size + 1) {
        for (j in 1 until first.size + 1) {
            if (first[j - 1] == second[i - 1]) {
                dp[j][i] = dp[j - 1][i - 1] + 1
                if (dp[j][i] > ans) ans = dp[j][i]
            }
        }
    }

    return ans.toString()
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val first = br.readLine().toCharArray()
    val second = br.readLine().toCharArray()

    bw.write(sol5582(first, second))
    bw.flush()
    bw.close()
    br.close()
}