package boj

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * boj 2230 수 고르기, 투포인터
 * 1 ≤ N ≤ 100,000
 * 0 ≤ M ≤ 2,000,000,000
 * 0 ≤ |A[i]| ≤ 1,000,000,000
 * 첫째 줄에 두 정수 N, M
 * N개의 줄에는 차례로 A[1], A[2], …, A[N]이 주어진다.
 */

fun sol2230(n: Int, m: Int, arr: IntArray) {
    var ans = 2000000001

    var right = 0

    for(left in 0 until n){
        while (right < n && arr[right] - arr[left] < m)
            right++

        if(right == n) break
        ans = ans.coerceAtMost(arr[right] - arr[left])
    }

    println(ans)
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val arr = IntArray(n) { 0 }
    for (i in 0 until n) {
        arr[i] = br.readLine().toInt()
    }
    arr.sort()

    sol2230(n, m, arr)
}