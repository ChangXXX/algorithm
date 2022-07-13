package boj

/*
 * boj 11000 강의실 배정 그리디
 */

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun sol11000(times: Array<Pair<Int, Int>>) {
    val pq = PriorityQueue<Int>(kotlin.Comparator { o1, o2 -> o1 - o2 })
    pq.offer(times[0].second)

    for (i in 1 until times.size) {
        if (pq.peek() <= times[i].first) pq.poll()
        pq.offer(times[i].second)
    }

    println(pq.size)
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val times = Array<Pair<Int, Int>>(n) { Pair(0, 0) }
    for (i in 0 until n) {
        val (start, close) = br.readLine().split(" ").map { it.toInt() }
        times[i] = Pair(start, close)
    }
    times.sortBy { it.first }

    sol11000(times)
}
