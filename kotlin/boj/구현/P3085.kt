package boj

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * boj 3085 사탕게임, 구현, 브루트포스
 * n = board size
 * 한 줄로 연결된 사탕 최대 개수
 */

class P3085 {

    fun solution(n: Int, maps: Array<CharArray>) {
        var max = count(n, maps)

        if (max == n) {
            println(max)
            return
        }

        val dx = intArrayOf(-1, 0, 1, 0)
        val dy = intArrayOf(0, -1, 0, 1)

        for (i in 0 until n) {
            for (j in 0 until n) {

                for (k in 0 until 4) {
                    val nx = i + dx[k]
                    val ny = j + dy[k]

                    if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue
                    if(maps[i][j] == maps[nx][ny]) continue

                    swap(maps, i, j, nx, ny)
                    val cnt = count(n, maps)
                    if(max < cnt) max = cnt
                    swap(maps, i, j, nx, ny)
                }
            }
        }

        println(max)
    }

    fun swap(maps: Array<CharArray>, orgX: Int, orgY: Int, targetX: Int, targetY: Int){
        val tmp = maps[targetX][targetY]
        maps[targetX][targetY] = maps[orgX][orgY]
        maps[orgX][orgY] = tmp
    }

    fun count(n: Int, maps: Array<CharArray>): Int{
        var max = 0

        for (i in 0 until n) {
            val row = countRow(i, n, maps)
            val col = countColumn(i, n, maps)
            if(max < row) max = row
            if(max < col) max = col
        }

        return max
    }

    fun countRow(row: Int, n: Int, maps: Array<CharArray>): Int {
        var cnt = 1
        var max = 1

        for (i in 1 until n) {
            if (maps[row][i] == maps[row][i - 1]) cnt++
            else {
                if(max < cnt) max = cnt
                cnt = 1
            }
        }

        return if(max < cnt) cnt else max
    }

    fun countColumn(column: Int, n: Int, maps: Array<CharArray>): Int {
        var cnt = 1
        var max = 1

        for (i in 1 until n) {
            if (maps[i][column] == maps[i - 1][column]) cnt++
            else {
                if(max < cnt) max = cnt
                cnt = 1
            }
        }

        return if(max < cnt) cnt else max
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val maps = Array<CharArray>(n) { charArrayOf() }

    for (i in 0 until n) {
        maps[i] = br.readLine().toCharArray()
    }

    P3085().solution(n, maps)

    data class Person(val age: Int)
    val p = Person().let {  }
}