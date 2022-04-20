package boj

//boj 2504 괄호의 값

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

fun sol2504(inputs: CharArray) {
    var ans = 0
    var cnt = 1
    val s = Stack<Char>()

    for (i in inputs.indices) {
        when (inputs[i]) {
            '(' -> {
                cnt *= 2
                s.push(inputs[i])
            }
            '[' -> {
                cnt *= 3
                s.push(inputs[i])
            }
            ')' -> {
                if (s.empty() || s.peek() != '(') {
                    println(0)
                    return
                }
                if (inputs[i - 1] == '(') ans += cnt
                cnt /= 2
                s.pop()
            }
            ']' -> {
                if (s.empty() || s.peek() != '[') {
                    println(0)
                    return
                }
                if (inputs[i - 1] == '[') ans += cnt
                cnt /= 3
                s.pop()
            }
        }
    }

    if (s.size == 0) println(ans)
    else println(0)
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val inputs = br.readLine().toString().toCharArray()

    sol2504(inputs)
}