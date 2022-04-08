package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// boj 1946 신입사원

fun sol1946(ranks: MutableList<IntArray>): String {
    var answer: Int = 1

    ranks.sortBy { it ->
        it[0]
    }

    var standard = ranks[0][1]
    for(i in 1 until ranks.size){
        if(standard > ranks[i][1]){
            standard = ranks[i][1]
            ++answer
        }
    }

    return answer.toString()
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = br.readLine().toInt()

    for (i in 0 until t) {
        val n = br.readLine().toInt()
        val ranks: MutableList<IntArray> = mutableListOf()

        for (j in 0 until n) {
            ranks.add(br.readLine().split(" ").map { it.toInt() }.toIntArray())
        }
        bw.write(sol1946(ranks) + "\n")
    }

    bw.flush()
    bw.close()
    br.close()
}
