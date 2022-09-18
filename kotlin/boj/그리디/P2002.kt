package boj

/**
 * https://www.acmicpc.net/problem/2002
 *
 * boj, 2002, 추월, 구현, 자료 구조, 문자열, 해시
 */

import java.io.BufferedReader
import java.io.InputStreamReader

class P2002 {
    fun solution(n: Int, inputs: Map<String, Int>, outs: Array<Int>) {
        var ans = 0

        for (i in 0 until n-1) {
            for(j in i+1 until n){
                if(outs[i] > outs[j]){
                    ans++
                    break
                }
            }
        }
        println(ans)
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val outputs = Array<Int>(n) { 0 }
    val inputs = mutableMapOf<String, Int>()
    for (i in 0 until n) {
        inputs.put(br.readLine(), i)
    }
    for(i in 0 until n){
        outputs[i] = inputs[br.readLine()]!!
    }


    P2002().solution(n, inputs.toMap(), outputs)
}