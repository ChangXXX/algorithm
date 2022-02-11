package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun sol1715(nums: List<Int>): Int {
    var ans = 0
    val q = PriorityQueue<Int>()

    nums.forEach { it ->
        q.offer(it)
    }

    if (q.size != 1) {
        while (true) {
            val top = q.poll()
            val nextTop = q.poll()
            val sum = top + nextTop
            ans += sum
            if (q.isEmpty()) break
            q.offer(sum)
        }
    }

    return ans
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val nums = mutableListOf<Int>()

    for (i in 0 until n) {
        nums.add(br.readLine().toInt())
    }

    bw.write(sol1715(nums).toString())
    bw.flush()
    br.close()
    bw.close()
}