package boj

// boj 1303 전쟁-전투
// 후기.. 가로 세로 주의하자

import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var isVisited: Array<BooleanArray>
var count = 0

fun sol1303(x: Int, y: Int, map: Array<CharArray>, now: Char, n: Int, m: Int) {
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    isVisited[x][y] = true
    count++

    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue
        if (now == map[nx][ny] && !isVisited[nx][ny]) sol1303(nx, ny, map, now, n, m)
    }
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (m, n) = br.readLine().split(" ").map { it.toInt() }
    val map: Array<CharArray> = Array<CharArray>(n) { CharArray(m) }
    isVisited = Array<BooleanArray>(n) { BooleanArray(m) { false } }
    var wCnt = 0
    var bCnt = 0

    for (i in 0 until n) {
        map[i] = br.readLine().toCharArray()
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (!isVisited[i][j]) {
                if (map[i][j] == 'W') { // W 경우
                    sol1303(i, j, map, map[i][j], n, m)
                    wCnt += count * count
                } else { // B 경우
                    sol1303(i, j, map, map[i][j], n, m)
                    bCnt += count * count
                }
                count = 0
            }
        }
    }
    println("$wCnt $bCnt")
}