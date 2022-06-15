package boj

import java.io.BufferedReader
import java.io.InputStreamReader

fun isPalindrome(input: CharArray): Boolean {
    for (i in 0 until input.size / 2) {
        if (input[i] != input[input.size - i - 1]) return false
    }

    return true
}

fun sol1254(input: CharArray) {
    var ans = input.size

    for(i in 0 until input.size){
        if(isPalindrome(input.sliceArray(i until input.size))){
            ans += i
            break
        }
    }

    println(ans)
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().toString().toCharArray()

    sol1254(input)
}