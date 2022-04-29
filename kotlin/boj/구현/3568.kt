package boj

// boj 3568 iSharp

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val inputs = br.readLine().toString().split(" ").map { it.toString() }.toTypedArray()
    val res = Array<String>(inputs.size - 1) { "" }

    for (i in 1 until inputs.size) {
        val org = inputs[i].toCharArray()
        val sb = StringBuilder()
        sb.append(inputs[0])
        val alpha = StringBuilder()

        for (j in org.size - 2 downTo 0) { // org 끝에는 ,이나 ; 이 있기 때문에 -2 부터
            if (org[j] == ']') continue
            else if (org[j] == '[') {
                sb.append("[]")
                continue
            }
            if (org[j] in ('a'..'z') || (org[j] in 'A'..'Z')) {
                alpha.append(org[j])
            } else sb.append(org[j])
        }
        sb.append(" ")
        alpha.reverse()
        alpha.append(";")
        res[i-1] = sb.toString() + alpha.toString()
    }

    res.forEach { it ->
        println(it)
    }
}