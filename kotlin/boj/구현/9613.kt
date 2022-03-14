package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 백준 GCD 합

fun sol9613(a: Long, b: Long): Int {

    return if (b == 0L) return a.toInt() else sol9613(b, a % b)
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val t = br.readLine().toInt()
    for (i in 0 until t) {
        var ans: Long = 0
        val n = br.readLine().split(" ").map { it.toLong() }.toLongArray()

        for (j in 1 until n.size-1) {
            for (k in j + 1 until n.size) {
                ans += sol9613(n[j], n[k])
            }
        }
        bw.write(ans.toString()+"\n")
    }
    bw.flush()
    bw.close()
    br.close()
}