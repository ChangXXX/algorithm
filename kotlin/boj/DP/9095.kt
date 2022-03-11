package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


// 백준 1,2,3 더하기

var dp = intArrayOf()

fun dp(){
    for(i in 4 until 11){
        dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
    }
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    dp = IntArray(11)

    val t = br.readLine().toInt()
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4
    dp()

    for (i in 0 until t) {
        val n = br.readLine().toInt()

        bw.write(dp[n].toString()+"\n")
    }
    bw.flush()
    br.close()
    bw.close()
}