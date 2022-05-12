package boj

// boj 15903 카드 합체 놀이 greedy

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun sol15903(n: Int, m: Int, cards: LongArray) {
    val q = PriorityQueue<Long>()
    var cnt = 0

    for (i in cards.indices) {
        q.offer(cards[i])
    }

    while (q.isNotEmpty()) {
        if (cnt == m) {
            println(q.sum())
            break
        }
        cnt++
        val first = q.poll()
        val second = q.poll()
        val sum = first + second
        q.offer(sum)
        q.offer(sum)
    }
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val cards = br.readLine().split(" ").map { it.toLong() }.toLongArray()

    sol15903(n, m, cards)
}