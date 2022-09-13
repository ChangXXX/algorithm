package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * https://www.acmicpc.net/problem/10026
 *
 * boj, 10026 적록색약, dfs, bfs
 */

class P10026 {
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, -1, 0, 1)
    fun solution(arr: Array<CharArray>, n: Int) {
        var norm = 0
        var extra = 0

        var visited = Array<BooleanArray>(n) { BooleanArray(n) { false } }

        for (x in 0 until n) {
            for (y in 0 until n) {
                if (!visited[x][y]) {
                    bfs(visited, arr, x, y)
                    norm++
                }
            }
        }

        visited = Array<BooleanArray>(n) { BooleanArray(n) { false } }

        for (x in 0 until n) {
            for (y in 0 until n) {
                if (arr[x][y] == 'G') arr[x][y] = 'R'
            }
        }

        for (x in 0 until n) {
            for (y in 0 until n) {
                if (!visited[x][y]) {
                    bfs(visited, arr, x, y)
                    extra++
                }
            }
        }

        println("$norm $extra")
    }

    fun bfs(visited: Array<BooleanArray>, arr: Array<CharArray>, x: Int, y: Int) {
        val q: Queue<Pair<Int, Int>> = LinkedList()
        q.offer(Pair(x, y))
        visited[x][y] = true

        while (q.isNotEmpty()) {
            val front = q.poll()

            for (i in 0 until 4) {
                val nx = front.first + dx[i]
                val ny = front.second + dy[i]

                if (nx < 0 || nx >= arr.size || ny < 0 || ny >= arr.size) continue

                if (!visited[nx][ny] && arr[x][y] == arr[nx][ny]) {
                    q.offer(Pair(nx, ny))
                    visited[nx][ny] = true
                }
            }
        }
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = Array<CharArray>(n) { charArrayOf() }
    for (i in 0 until n) {
        arr[i] = br.readLine().toCharArray()
    }
    P10026().solution(arr, n)
}