package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun solution(N: Int, K: Int, sensors: IntArray): String{
    var answer = 0
    val sortedSensor = sensors.sorted()

    var idx = 0
    val gappers:MutableList<Int> = mutableListOf()
    while(idx < N - 1)
        gappers.add(sortedSensor[idx + 1] - sortedSensor[idx++])

    val sorted = gappers.sortedDescending()
    for(i in K-1..sorted.size-1)
        answer += sorted[i]

    return answer.toString()
}

fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val N = br.readLine().toInt()
    val K = br.readLine().toInt()
    val sensors = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    bw.write(solution(N, K, sensors))
    bw.flush()
    br.close()
    bw.close()
}