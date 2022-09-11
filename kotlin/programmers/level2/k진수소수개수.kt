import java.lang.StringBuilder
import kotlin.math.sqrt

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92335
 *
 * 프로그래머스, k진수에서 소수 개수 구하기, level2
 */

class k진수소수개수 {
    fun solution(n: Int, k: Int): Int {
        var answer = 0

        val digits = converter(k, n).split("0")
        for (i in 0 until digits.size) {
            if (digits[i].equals("1") || digits[i].isNullOrEmpty()) continue
            if (isPrime(digits[i].toLong())) answer++
        }

        return answer
    }

    fun converter(digit: Int, n: Int): String {
        var num = n
        val sb = StringBuilder()
        if (num == 0) return "0"
        if (digit == 10) return n.toString()

        while (num > 0) {
            sb.insert(0, num % digit)
            num /= digit
        }

        return sb.toString()
    }

    fun isPrime(num: Long): Boolean {
        var i = 2
        while (i <= sqrt(num.toDouble())) {
            if ((num % i++).toInt() == 0) return false
        }
        return true
    }
}

fun main() {
    val n = 110011
    val k = 10

    println(k진수소수개수().solution(n, k))
}