package boj

import java.io.BufferedReader
import java.io.InputStreamReader

fun sol1251(input: CharArray) {
    val ans = mutableListOf<String>()

    for (i in 0 until input.size - 2) {
        val first = input.sliceArray(0..i).reversedArray()
        for (j in i + 1 until input.size - 1) {
            val second = input.sliceArray(i + 1..j).reversedArray()
            for (k in j + 1 until input.size) {
                val third = input.sliceArray(j + 1..input.size - 1).reversedArray()

                ans.add(String(first) + String(second) + String(third))
            }
        }
    }
    ans.sort()

    println(ans[0])
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val input = br.readLine().toString().toCharArray()
    sol1251(input)
}