package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

var n: Int = 0
var m: Int = 0
val dx: Array<Int> = arrayOf(-1, 1, 0, 0)
val dy: Array<Int> = arrayOf(0, 0, -1, 1)
var arr: Array<IntArray> = arrayOf()

data class Pos(var x: Int, var y: Int)

fun sol7576(): String {
    var answer: Int = 0

    val q: Queue<Pos> = LinkedList<Pos>()
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (arr[i][j] == 1) {
                q.offer(Pos(i, j))
            }
        }
    }

    while (q.isNotEmpty()) {
        val dq = q.poll()
        for (i in 0 until 4) {
            val nx = dq.x + dx[i]
            val ny = dq.y + dy[i]

            if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                continue
            if (arr[nx][ny] != 0)
                continue

            q.offer(Pos(nx, ny))
            arr[nx][ny] = arr[dq.x][dq.y] + 1
        }
    }

    for(i in 0 until n){
        for(j in 0 until m){
            if(arr[i][j] == 0) return "-1"
            answer = answer.coerceAtLeast(arr[i][j])
        }
    }

    return (answer-1).toString()
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val nm = br.readLine().split(" ").map { it.toInt() }
    n = nm[1]
    m = nm[0]
    arr = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        arr[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    bw.write(sol7576())
    bw.flush()
    br.close()
    bw.close()
}