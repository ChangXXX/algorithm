package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * boj 13335 트럭, 구현, 자료구조, 큐
 */

class P13335 {

    fun solution(n: Int, w: Int, l: Int, trucks: IntArray) {
        var ans = 0

        val truckQueue: Queue<Int> = LinkedList<Int>()
        for (i in 0 until n) {
            truckQueue.offer(trucks[i])
        }
        val bridgeQueue: Queue<Int> = LinkedList<Int>()
        for (i in 0 until w) {
            bridgeQueue.offer(0)
        }

        while (bridgeQueue.isNotEmpty()) {
            ans++
            bridgeQueue.poll()

            if (truckQueue.isNotEmpty()) {
                if (bridgeQueue.sum() + truckQueue.peek() > l) {
                    bridgeQueue.offer(0)
                } else {
                    bridgeQueue.offer(truckQueue.poll())
                }
            }
        }

        println(ans)
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, w, l) = br.readLine().split(" ").map { it.toInt() }
    val trucks = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    P13335().solution(n, w, l, trucks)
}