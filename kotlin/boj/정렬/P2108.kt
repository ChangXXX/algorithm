package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.roundToInt

/**
 * boj 2108 통계학, 정렬, 구현
 */

class P2108 {

    fun solution(n: Int, arr: IntArray, sum: Int) {
        println((sum.toDouble() / n).roundToInt())

        var cnt = 0
        for (i in 0 until 8001) {
            for (j in 0 until arr[i]) {
                cnt += 1
                if (cnt == (n + 1) / 2) {
                    println(i - 4000)
                    break
                }
            }
        }

        var flag = 0
        var max = 0
        for(i in 0 until 8001){
            if(arr[i] > max){
                flag = i
                max = arr[i]
            }
        }
        for(i in flag+1 until 8001){
            if(arr[i] == max){
                flag = i
                break
            }
        }
        println(flag-4000)

        var min = 0
        for (i in 0 until 8001) {
            if (arr[i] != 0) {
                min = i - 4000
                break
            }
        }

        max = 0
        for (i in 8000 downTo 0) {
            if (arr[i] != 0) {
                max = i - 4000
                break
            }
        }

        println(max - min)
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = IntArray(8001) { 0 }
    var sum = 0

    for (i in 0 until n) {
        val input = br.readLine().toInt()
        arr[input + 4000] += 1
        sum += input
    }

    P2108().solution(n, arr, sum)
}