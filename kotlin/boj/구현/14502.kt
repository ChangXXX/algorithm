package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * boj 14502 연구소, 구현, bfs, dfs
 * n*m 직사각형
 * 0 빈칸, 1 벽, 2 바이러스
 * 벽이 없으면 바이러스는 퍼짐
 * 벽은 최대 3개만 가능, 바이러스가 퍼질 수 없는 영역의 최댓값
 */
class P14502 {
    var ans = -1

    fun sol14502(maps: Array<IntArray>, n: Int, m: Int) {
        dfs(0, maps, n, m)
        println(ans)
    }

    fun bfs(maps: Array<IntArray>, n: Int, m: Int) {
        val q: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
        val cpy = Array<IntArray>(n) { IntArray(m) { 0 } }

        for (i in 0 until n) {
            for (j in 0 until m) {
                cpy[i][j] = maps[i][j]
                if (maps[i][j] == 2) q.offer(Pair(i, j))
            }
        }

        val dx = intArrayOf(-1, 0, 1, 0)
        val dy = intArrayOf(0, -1, 0, 1)

        while (q.isNotEmpty()) {
            val top = q.poll()

            for (i in 0 until 4) {
                val nx = dx[i] + top.first
                val ny = dy[i] + top.second

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue

                if (cpy[nx][ny] == 0) {
                    cpy[nx][ny] = 2
                    q.offer(Pair(nx, ny))
                }
            }
        }

        var cnt = 0

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (cpy[i][j] == 0) cnt++
            }
        }

        ans = ans.coerceAtLeast(cnt)
    }

    fun dfs(depth: Int, maps: Array<IntArray>, n: Int, m: Int) {
        if (depth == 3) {
            bfs(maps, n, m)
            return
        }

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (maps[i][j] == 0) {
                    maps[i][j] = 1
                    dfs(depth + 1, maps, n, m)
                    maps[i][j] = 0
                }
            }
        }
    }
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val maps = Array<IntArray>(n) { intArrayOf() }

    for (i in 0 until n) {
        val inputs = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        maps[i] = inputs
    }

    P14502().sol14502(maps, n, m)
}