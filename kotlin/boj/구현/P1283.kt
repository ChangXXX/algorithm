package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

/**
 * 1283 단축키 지정, 구현, 문자열
 * 규칙
 * 1. 먼저 하나의 옵션에 대해 왼쪽에서부터 오른쪽 순서로 단어의 첫 글자가 이미 단축키로 지정되었는지 살펴본다. 만약 단축키로 아직 지정이 안 되어있다면 그 알파벳을 단축키로 지정한다.
 * 2. 만약 모든 단어의 첫 글자가 이미 지정이 되어있다면 왼쪽에서부터 차례대로 알파벳을 보면서 단축키로 지정 안 된 것이 있다면 단축키로 지정한다.
 * 3. 어떠한 것도 단축키로 지정할 수 없다면 그냥 놔두며 대소문자를 구분치 않는다.
 * 4. 위의 규칙을 첫 번째 옵션부터 N번째 옵션까지 차례대로 적용한다.
 */

class P1283 {

    fun solution(n: Int, options: Array<String>) {
        val sets = mutableSetOf<Char>()

        for (i in 0 until n) {
            val option = options[i]
            val words = option.split(" ")
            var flag = -1

            // first rules
            for (j in 0 until words.size) {
                if(words[j].isEmpty()) continue
                if (sets.contains(words[j][0])) continue
                else {
                    sets.add(words[j][0].uppercaseChar())
                    sets.add(words[j][0].lowercaseChar())
                    flag = j
                    break
                }
            }
            if (flag != -1) {
                for (j in 0 until words.size) {
                    if (flag == j) {
                        print("[${words[j][0]}]${words[j].substring(1)} ")
                    } else print(words[j] + " ")
                }
                println()
                continue
            }

            // second rules
            for (j in 0 until option.length) {
                if (sets.contains(option[j])) continue
                else {
                    if (option[j] in 'a'..'z' || option[j] in 'A'..'Z'){
                        sets.add(option[j].uppercaseChar())
                        sets.add(option[j].lowercaseChar())
                        flag = j
                        break
                    }
                }
            }
            if (flag != -1) {
                val sb = StringBuilder()
                for (j in 0 until flag) sb.append(option[j])
                sb.append("[${option[flag]}]")
                for (j in flag + 1 until option.length) sb.append(option[j])
                println(sb.toString())
                continue
            }

            // third rules
            println(option)
        }
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val options = Array<String>(n) { "" }
    for (i in 0 until n) options[i] = br.readLine().toString()

    P1283().solution(n, options)
}