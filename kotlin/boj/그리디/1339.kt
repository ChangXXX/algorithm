package boj

// boj 1339 단어수학

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun sol1339(map: MutableMap<Char, Int>): String {
    val list = map.toList().sortedByDescending { it.second }

    var cnt = 9
    var ans = 0

    for(i in list.indices){
        ans += list[i].second * cnt--
    }

    return ans.toString()
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val map = mutableMapOf<Char, Int>()

    for (i in 0 until n) {
        val input = br.readLine().toString()

        var pos = 1
        for (j in input.length - 1 downTo 0) {
            val cnt = map.get(input[j]) ?: 0
            if (cnt == 0) map.set(input[j], pos)
            else map[input[j]] = cnt + pos
            pos *= 10
        }
    }

    bw.write(sol1339(map))
    bw.flush()
    bw.close()
    br.close()
}
