package boj

// boj 2178 미로탐색

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

private lateinit var maps: Array<IntArray>

fun sol2178(x: Int, y: Int, n: Int, m: Int): String {
    var ans: Int = 0
    val dx: Array<Int> = arrayOf(-1, 1, 0, 0)
    val dy: Array<Int> = arrayOf(0, 0, -1, 1)
    val q: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()

    q.offer(Pair(x, y))
    while (q.isNotEmpty()) {
        val curr = q.poll()

        for (i in 0 until 4) {
            val nx = curr.first + dx[i]
            val ny = curr.second + dy[i]

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue
            if (maps[nx][ny] == 0) continue
            if (maps[nx][ny] == 1) {
                maps[nx][ny] = maps[curr.first][curr.second] + 1
                q.offer(Pair(nx, ny))
            }
        }
    }

    return maps[n - 1][m - 1].toString()
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    maps = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        val inputs = br.readLine().toString()

        for (j in inputs.indices) {
            maps[i][j] = inputs[j] - '0'
        }
    }

    br.close()
    bw.write(sol2178(0, 0, n, m))
    bw.flush()
    bw.close()
}