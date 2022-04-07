package boj

// boj 1541 잃어버린 괄호

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun sol1541(input: String): String {
    var answer: Int = 0
    val minus = input.split("\\-".toRegex()).toTypedArray()

    for (i in minus.indices) {
        val plus = minus[i].split("\\+".toRegex()).toTypedArray().sumOf { it.toInt() }
        if (i == 0) answer += plus
        else answer -= plus
    }

    return answer.toString()
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().toString()
    br.close()

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    bw.write(sol1541(input).toString())
    bw.flush()
    bw.close()
}
