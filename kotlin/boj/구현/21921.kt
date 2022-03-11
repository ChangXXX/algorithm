package boj

import java.io.BufferedReader
import java.io.InputStreamReader

// 백준 블로그

fun sol21921(n: Int, x: Int, visitor: IntArray) {
    var sum: Int = 0
    var max: Int = 0
    var days: Int = 0

    if (visitor.count { it == 0 } == n) {
        println("SAD")
        return Unit
    }

    var cnt: Int = -1

    visitor.forEachIndexed { idx, it ->
        sum += it
        cnt++
        if (cnt == x-1) {
            if (max < sum) {
                max = sum
                days = 1
            } else if(max == sum){
                days++
            }
            sum -= visitor[idx - cnt--]
        }
    }

    println(max)
    println(days)
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, x) = br.readLine().split(" ").map { it.toInt() }
    val visitor = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    sol21921(n, x, visitor)

    br.close()
}