package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

/**
 * 16926 배열 돌리기 1, 구현
 */

class P16926 {

    fun solution(n: Int, m: Int, arr: Array<IntArray>) {
        val tmpArr = Array<IntArray>(n) { IntArray(m) { 0 } }
        val rotate = min(n, m) / 2
        for (i in 0 until rotate) {
            val x = i
            val y = i
            val maxX = n - 1 - i
            val maxY = m - 1 - i
            // 아래
            for (j in x + 1..maxX) tmpArr[j][y] = arr[j - 1][y]
            // 오른쪽
            for (j in y + 1..maxY) tmpArr[maxX][j] = arr[maxX][j - 1]
            // 위
            for (j in maxX - 1 downTo x) tmpArr[j][maxY] = arr[j + 1][maxY]
            // 왼쪽
            for (j in maxY - 1 downTo y) tmpArr[x][j] = arr[x][j + 1]
        }

        for (i in 0 until n) {
            for (j in 0 until m) {
                arr[i][j] = tmpArr[i][j]
            }
        }
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, r) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array<IntArray>(n) { IntArray(m) { 0 } }

    for (i in 0 until n) arr[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    for (i in 0 until r) P16926().solution(n, m, arr)

    for (i in 0 until n) {
        for (j in 0 until m) {
            print("${arr[i][j]} ")
        }
        println()
    }
}