package boj

// boj 1697 숨바꼭질

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


fun sol12851(n: Int, k: Int) {
    var ans = -1
    val visited = BooleanArray(100001) { false }
    val q: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
    q.offer(Pair(n, 0))

    while (q.isNotEmpty()) {
        val now = q.poll()
        visited[now.first] = true
        if (now.first == k) {
            ans = now.second
            break
        }

        if (now.first + 1 in 0..100000 && !visited[now.first + 1]) {
            q.offer(Pair(now.first + 1, now.second + 1))
        }
        if (now.first - 1 in 0..100000 && !visited[now.first - 1]) {
            q.offer(Pair(now.first - 1, now.second + 1))
        }
        if (now.first * 2 in 0..100000 && !visited[now.first * 2]) {
            q.offer(Pair(now.first * 2, now.second + 1))
        }

    }
    println(ans)
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    sol12851(n, k)
}