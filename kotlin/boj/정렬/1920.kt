package boj

// boj 1920 수 찾기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun sol1920(arr: IntArray, cmpArray: IntArray, target: Int): Boolean {
    var left = 0
    var right = arr.size-1
    var mid: Int = 0

    while (left <= right) {
        mid = (left + right) / 2

        if (arr[mid] == target) return true
        else if (arr[mid] < target) {
            left = mid + 1
        } else if (arr[mid] > target) {
            right = mid - 1
        }
    }
    return false
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    arr.sort()

    val m = br.readLine().toInt()
    val cmpArr = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    for (i in cmpArr.indices) {
        if (sol1920(arr, cmpArr, cmpArr[i])) bw.write("1\n")
        else bw.write("0\n")
    }
    bw.flush()
    bw.close()
    br.close()
}