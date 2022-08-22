package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

/**
 * boj 11497 통나무 건너뛰기, 그리디, 정렬
 */

class P11497 {

    fun solution(n: Int, logs: IntArray) {
        var ans = 0

        val sortedLogs = logs.sorted()

        for(i in 2 until n){
            if(abs(sortedLogs[i - 2] - sortedLogs[i]) > ans) ans = abs(sortedLogs[i - 2] - sortedLogs[i])
        }

        println(ans)
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    for (i in 0 until t) {
        val n = br.readLine().toInt()
        val logs = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        P11497().solution(n, logs)
    }
}