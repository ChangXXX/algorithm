package boj

import java.io.BufferedReader
import java.io.InputStreamReader

/*
 * boj 15886 내 선물을 받아줘2 구현문제
 */
fun sol15886(n: Int, input: String): Int {
    var ans = 0

    for(i in 0 until input.length-1){
        if(input[i] == 'E' && input[i+1] == 'W'){
            ans++
        }
    }

    return ans
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val input = br.readLine().toString()
    println(sol15886(n, input))
}