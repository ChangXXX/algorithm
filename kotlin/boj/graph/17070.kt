package boj

// boj 17070 파이프 dfs

import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var map: Array<IntArray>
private var ans = 0

fun sol17070(x: Int, y: Int, direction: Int, n: Int) { // direction 0 가로, 1세로, 2 대각선
    val dx: IntArray = intArrayOf(0, 1, 1) // 가로 세로 대각선
    val dy: IntArray = intArrayOf(1, 0, 1)

    if (x == n && y == n) {
        ans++
        return
    }

    for (i in 0 until 3) {
        // 가로 -> 세로 x, 세로 -> 가로 x
        if ((direction == 0 && i == 1) || (direction == 1 && i == 0)) continue // if (direction xor i == 1) continue

        val nx = x + dx[i]
        val ny = y + dy[i]
        // map 밖으로 나가거나 벽 만나는 경우
        if (nx <= 0 || ny <= 0 || nx > n || ny > n || map[nx][ny] == 1) continue

        // 대각선인 경우 대각선이 차지하는 3가지 방향이 벽인지 확인
        if (i == 2 && (map[x + 1][y] == 1 || map[x][y + 1] == 1)) continue

        sol17070(nx, ny, i, n)
    }
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    map = Array<IntArray>(n + 1) { intArrayOf(n + 1) }

    for (i in 1 until n + 1) {
        val input = br.readLine().split(" ").map { it.toInt() }.toMutableList()
        input.add(0, 0)
        map[i] = input.toIntArray()
    }

    sol17070(1, 2, 0, n)
    println(ans)
}