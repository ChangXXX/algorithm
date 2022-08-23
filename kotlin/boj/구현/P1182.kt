package boj

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * boj 1182 부분수열의 합, 브루트 포스, 백트래킹, dfs
 */

class P1182 {
    var ans = 0
    fun solution(n: Int, s: Int, arr: IntArray) {

        dfs(n, s, 0, 0, arr)
        println(ans)
    }

    fun dfs(n: Int, s: Int, cnt: Int, sum: Int, arr: IntArray) {
        if (n == cnt) {
            return
        }
        if (s == sum + arr[cnt]) ans++

        dfs(n, s, cnt + 1, sum, arr)
        dfs(n, s, cnt + 1, sum + arr[cnt], arr)
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, s) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    P1182().solution(n, s, arr)
}