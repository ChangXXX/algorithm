package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// boj 2667 단지번호 붙이기

private lateinit var maps: Array<IntArray>
private lateinit var isVisited: Array<BooleanArray>

fun sol2667(x: Int, y: Int, danji: Int) {
    val dx: Array<Int> = arrayOf(-1, 1, 0, 0)
    val dy: Array<Int> = arrayOf(0, 0, -1, 1)

    maps[x][y] = danji
    isVisited[x][y] = true

    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx < 0 || nx >= maps.size || ny < 0 || ny >= maps.size) continue
        if (maps[nx][ny] == 0) continue
        if (maps[nx][ny] == 1 && !isVisited[nx][ny]) {
            maps[nx][ny] = danji
            isVisited[nx][ny] = true
            sol2667(nx, ny, danji)
        }
    }

}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    maps = Array(n) { IntArray(n) }
    isVisited = Array(n) { BooleanArray(n) { false } }

    for (i in 0 until n) {
        val inputs = br.readLine().toString()

        for (j in inputs.indices) {
            maps[i][j] = inputs[j] - '0'
        }
    }

    var ans: Int = 0

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (maps[i][j] == 1 && !isVisited[i][j]) {
                sol2667(i, j, ++ans)
            }
        }
    }

    bw.write(ans.toString() + "\n")

    val arr = IntArray(ans) { 0 }


    for (i in 0 until n) {
        for (j in 0 until n) {
            if (maps[i][j] != 0) arr[maps[i][j]-1]++
        }
    }
    arr.sort()
    for (i in 0 until ans) {
        bw.write(arr[i].toString() + "\n")
    }

    bw.flush()
    bw.close()
    br.close()
}