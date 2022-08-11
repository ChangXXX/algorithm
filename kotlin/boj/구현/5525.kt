package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

/**
 * boj 5525, IOIOI ,string
 * firstSolution 100점
 * secondSolution 50점
 */

class P5525 {
    fun firstSolution(n: Int, m: Int, s: String) {
        var ans = 0

        var currIdx = 0
        var cnt = 0
        while (true) {
            if (currIdx + 2 >= m) break

            if (s[currIdx] == 'I' && s[currIdx + 1] == 'O' && s[currIdx + 2] == 'I') {
                cnt += 1

                if (cnt == n) {
                    cnt -= 1
                    ans += 1
                }
                currIdx += 1
            } else cnt = 0

            currIdx += 1
        }
        println(ans)
    }

    fun secondSolution(n: Int, m: Int, s: String) {
        var ans = 0
        val sb = StringBuilder("IOI")
        for (i in 1 until n) {
            sb.append("OI")
        }
        val rgx = sb.toString()

        for (i in 0 until m - rgx.length + 1) {
            if (s.substring(i, rgx.length + i) == rgx) ans++
        }
        println(ans)
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val s = br.readLine().toString()
    P5525().firstSolution(n, m, s)
}