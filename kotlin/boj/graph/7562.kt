package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun sol7562(l: Int, x: Int, y: Int, targetX: Int, targetY: Int): Int {
    val dx = intArrayOf(-2, -1, 1, 2, 2, 1, -1, -2)
    val dy = intArrayOf(1, 2, 2, 1, -1, -2, -2, -1)
    val maps = Array(l) { IntArray(l) { 0 } }
    val q: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>() // x, y, cnt
    q.offer(Pair(x, y))
    maps[x][y] = 1

    while (q.isNotEmpty()) {
        val top = q.poll()

        if (top.first == targetX && top.second == targetY) {
            break
        }

        for (i in dx.indices) {
            val nx = dx[i] + top.first
            val ny = dy[i] + top.second
            if (nx < 0 || ny < 0 || nx >= l || ny >= l) {
                continue
            }
            if (maps[nx][ny] == 0) {
                maps[nx][ny] = maps[top.first][top.second] + 1
                q.offer(Pair(nx, ny))
            }
        }
    }

    return maps[targetX][targetY] - 1
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    for (tc in 0 until t) {
        val l = br.readLine().toInt()
        val (currX, currY) = br.readLine().split(" ").map { it.toInt() }
        val (targetX, targetY) = br.readLine().split(" ").map { it.toInt() }

        println(sol7562(l, currX, currY, targetX, targetY))
    }
}