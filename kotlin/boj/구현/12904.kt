package boj

// boj 12904 A와 B, 문자열, 그리디

import java.io.BufferedReader
import java.io.InputStreamReader

fun sol12904(s: String, t: String) {
    val sb = StringBuilder()
    sb.append(t)

    while (true) {
        var check = false
        if (sb.length == s.length) {
            break
        }

        if (sb.last() == 'B') check = true
        sb.setLength(sb.length - 1)
        if (check) sb.reverse()
    }

    var ans = false
    if (sb.toString() == s) ans = true
    println(if (ans) 1 else 0)
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine().toString()
    val t = br.readLine().toString()

    sol12904(s, t)
}
