package boj

// boj 1141 접두사

import java.io.BufferedReader
import java.io.InputStreamReader

fun sol1141(n: Int, words: ArrayList<String>) {
    var ans = 0

    for (i in 0 until n) {
        var check = false
        for (j in i + 1 until n) {
            if (words[j].startsWith(words[i])) {
                check = true
                break
            }
        }
        if(!check) ans++
    }

    println(ans)
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val words = ArrayList<String>()
    for (i in 0 until n) {
        words.add(br.readLine().toString())
    }

    words.sortWith(kotlin.Comparator { o1, o2 -> o1.length - o2.length })
    sol1141(n, words)
}