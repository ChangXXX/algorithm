package boj

// boj 17086 아기상어2 bfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun sol17086(n: Int, m: Int, maps: Array<IntArray>) {
    val dx = intArrayOf(-1, -1, -1, 0, 1, 0, 1, 1)
    val dy = intArrayOf(-1, 0, 1, 1, 1, -1, 0, -1)
    val q: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()

    for (i in maps.indices) {
        for (j in maps[i].indices) {
            if (maps[i][j] == 1) q.offer(Pair(i, j))
        }
    }

    while (q.isNotEmpty()) {
        val (x, y) = q.poll()

        for (i in dx.indices) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                continue

            if (maps[nx][ny] == 0) {
                q.offer(Pair(nx, ny))
                maps[nx][ny] = maps[x][y] + 1
            }
        }
    }

    var ans = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            ans = ans.coerceAtLeast(maps[i][j])
        }
    }

    println(ans - 1)
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val maps = Array(n) { IntArray(m) }
    for (i in 0 until n) {
        maps[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    sol17086(n, m, maps)
}