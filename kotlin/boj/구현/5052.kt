package boj

// boj 5052 전화번호 목록

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun sol5042(nums: MutableList<String>): String {
    var ans = "YES"
    var flag = false

    nums.sort()
    for (i in 0 until nums.size - 1) {
        if (nums[i + 1].startsWith(nums[i])) {
            ans = "NO"
            flag = true
            break
        }
    }

    return ans + "\n"
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val t = br.readLine().toInt()

    for (i in 0 until t) {
        val n = br.readLine().toInt()
        val nums = mutableListOf<String>()

        for (j in 0 until n) {
            nums.add(br.readLine().toString())
        }

        bw.write(sol5042(nums))
    }

    bw.flush()
    bw.close()
    br.close()
}
