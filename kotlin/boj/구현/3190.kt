package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * boj 3190 뱀 골드4 구현, 자료구조
 */

data class Dir(
    val x: Int,
    val y: Int,
    val dir: Int
)

fun sol3190(n: Int, apples: Array<IntArray>, rotates: Array<Pair<Int, String>>) {
    var ans = 0
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    val dp = Array<IntArray>(n) { IntArray(n) { 0 } }

    for (i in apples.indices) {
        val (x, y) = apples[i]
        dp[x][y] = -1
    }
    dp[0][0] = 1

    val q: Deque<Dir> = LinkedList<Dir>()
    q.offer(Dir(0, 0, 1))

    while (q.isNotEmpty()) {
        ans++
        val top = q.first()
        val nx = top.x + dx[top.dir]
        val ny = top.y + dy[top.dir]
        var nDir = top.dir
        if (nx >= n || nx < 0 || ny >= n || ny < 0 || dp[nx][ny] == 1) break

        for (i in rotates.indices) {
            if (rotates[i].first == ans) {
                nDir += if (rotates[i].second == "L") 3 else 1
                nDir %= 4
                break
            }
        }

        if (dp[nx][ny] == 0) {
            val pop = q.pollLast()
            dp[pop.x][pop.y] = 0
        }
        dp[nx][ny] = 1

        q.offerFirst(Dir(nx, ny, nDir))
    }
    println(ans)
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val k = br.readLine().toInt()
    val apples = Array<IntArray>(k) { intArrayOf(2) }
    for (i in 0 until k) {
        val apple = br.readLine().split(" ").map { it.toInt() - 1 }.toIntArray()
        apples[i] = apple
    }

    val l = br.readLine().toInt()
    val rotates = Array<Pair<Int, String>>(l) { Pair(0, "0") }
    for (i in 0 until l) {
        val (time, dir) = br.readLine().split(" ").map { it.toString() }
        rotates[i] = Pair(time.toInt(), dir)
    }

    sol3190(n, apples, rotates)
}