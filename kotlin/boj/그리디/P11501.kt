package boj

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * https://www.acmicpc.net/problem/11501
 *
 * boj, 11501 주식, 그리디
 */

class P11501 {
    fun solution(n: Int, arr: IntArray) {
        var sum: Long = 0
        var max = arr[n - 1]
        for (i in n - 2 downTo 0) {
            if (arr[i] > max) {
                max = arr[i]
            } else if (arr[i] < max) {
                sum += (max - arr[i])
            }
        }
        println(sum)
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    for (i in 0 until t) {
        val n = br.readLine().toInt()
        val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        P11501().solution(n, arr)
    }
}