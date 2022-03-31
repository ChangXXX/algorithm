import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Math.sqrt

class 소수찾기 {
    lateinit var set: MutableSet<Int>
    fun solution(numbers: String): Int {
        set = mutableSetOf()
        val visited = BooleanArray(numbers.length) { false }

        for (i in 0 until numbers.length) {
            visited[i] = true
            combination(numbers[i].toString().toInt(), numbers, visited)
            visited[i] = false
        }

        return set.size
    }

    fun combination(num: Int, numbers: String, visited: BooleanArray) {
        if (isPrime(num)) {
            set += num
        }

        for (i in 0 until numbers.length) {
            if (!visited[i]) {
                visited[i] = true
                combination((num.toString() + numbers[i].toString()).toInt(), numbers, visited)
                visited[i] = false
            }
        }
    }

    fun isPrime(number: Int): Boolean {
        if (number <= 1) {
            return false
        }
        for (i in (2..(sqrt(number.toDouble()).toInt()))) {
            if (number % i == 0) {
                return false
            }
        }
        return true
    }
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val input = br.readLine().toString()
    val c = 소수찾기()

    bw.write(c.solution(input).toString())
    bw.flush()
    bw.close()
    br.close()
}