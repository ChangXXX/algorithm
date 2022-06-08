package boj

import java.io.BufferedReader
import java.io.InputStreamReader

fun sol1213(alphas: IntArray, length: Int) {
    var odd = 0
    var center = -1
    var ans = "I'm Sorry Hansoo"

    for(i in 0 until 26){
        if(alphas[i] % 2 == 1){
            odd++
            center = i
        }
    }

    if((length % 2 == 0 && odd == 0) || (length % 2 == 1 && odd == 1)){
        ans = ""
        for(i in 0 until 26){
            for(j in 0 until alphas[i]/2){
                ans += (i+65).toChar()
            }
        }

        if(center != -1){
            ans += (center+65).toChar()
        }

        for(i in 25 downTo 0){
            for(j in 0 until alphas[i]/2){
                ans += (i+65).toChar()
            }
        }
    }

    println(ans)
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().toCharArray()
    val alphas = IntArray(26)
    br.close()

    for (i in input.indices) {
        alphas[input[i] - 'A']++
    }

    sol1213(alphas, input.size)
}