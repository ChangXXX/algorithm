package boj

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * boj 1080 행렬, 그리디
 */

class P1080 {

    fun solution(n: Int, m: Int, org: Array<IntArray>, trg: Array<IntArray>): Int {
        var ans = 0

        for (i in 0 until n - 2) {
            for (j in 0 until m - 2) {
                if (org[i][j] != trg[i][j]) {
                    flip(i, j, org, n, m)
                    ans += 1
                }
            }
        }

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (org[i][j] != trg[i][j]) return -1
            }
        }

        return ans
    }

    fun flip(row: Int, col: Int, org: Array<IntArray>, n: Int, m: Int) {
        for (i in row until row + 3) {
            for (j in col until col + 3) {
                org[i][j] = 1 - org[i][j]
            }
        }
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val org = Array<IntArray>(n) { IntArray(m) { 0 } }
    val trg = Array<IntArray>(n) { IntArray(m) { 0 } }


    for (i in 0 until n) {
        val input = br.readLine().toString()
        for (j in input.indices) {
            org[i][j] = Character.getNumericValue(input[j])
        }
    }

    for (i in 0 until n) {
        val input = br.readLine().toString()
        for (j in input.indices) {
            trg[i][j] = Character.getNumericValue(input[j])
        }
    }
    println(P1080().solution(n, m, org, trg))
}