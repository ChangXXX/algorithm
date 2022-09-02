package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

/**
 * https://www.acmicpc.net/problem/2138
 * boj 2138 전구와 스위치, 그리디
 */

class P2138 {

    fun solution(n: Int, org: CharArray, trg: CharArray): Int {
        var ans = 0

        for (i in 1 until n) {
            if (org.contentEquals(trg)) {
                return ans
            }

            if (org[i - 1] != trg[i - 1]) {
                switch(org, i, n)
                ans++
            }
        }
        if (org.contentEquals(trg)) {
            return ans
        }

        return -1
    }

    fun switch(org: CharArray, pos: Int, n: Int) {
        if (pos > 0) org[pos - 1] = if (org[pos - 1] == '0') '1' else '0'
        org[pos] = if (org[pos] == '0') '1' else '0'
        if (pos < n - 1) org[pos + 1] = if (org[pos + 1] == '0') '1' else '0'
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val org = br.readLine().toString().toCharArray()
    val trg = br.readLine().toString().toCharArray()

    val cpy = org.copyOf()
    P2138().switch(cpy, 0, n)

    val first = P2138().solution(n, cpy, trg)
    val second = P2138().solution(n, org, trg)

    if (first != -1 && second != -1) println(min(first + 1, second))
    else if (first != -1 && second == -1) println(first + 1)
    else if (first == -1 && second != -1) println(second)
    else if (first == -1 && second == -1) println(-1)
}