package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// boj 1012 유기농 배추

lateinit var cabbages : Array<IntArray>

fun sol1012(x: Int, y: Int) {
    val dx: Array<Int> = arrayOf(-1, 1, 0, 0)
    val dy: Array<Int> = arrayOf(0, 0, -1, 1)

    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx <= -1 || nx >= cabbages.size || ny <= -1 || ny >= cabbages[nx].size) {
            continue
        }
        if (cabbages[nx][ny] == 1) {
            cabbages[nx][ny] = 0
            sol1012(nx, ny)
        }
    }
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val t = br.readLine().toInt()

    for (c in 0 until t) {
        val (m, n, k) = br.readLine().split(" ").map { it.toInt() }
        cabbages = Array(m) { IntArray(n) { 0 } }
        var ans: Int = 0

        for (i in 0 until k) {
            val (x, y) = br.readLine().split(" ").map { it.toInt() }
            cabbages[x][y] = 1
        }

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (cabbages[i][j] == 1) {
                    ans++
                    sol1012(i, j)
                }
            }
        }
        bw.write(ans.toString()+"\n")
    }
    bw.flush()
    bw.flush()
    bw.close()
    br.close()
}