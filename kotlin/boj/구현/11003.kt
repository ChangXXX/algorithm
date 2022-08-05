package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * boj 11003 최솟값 찾기 슬라이딩 윈도우
 * D(i) = A(i-L+1) ~ A(i) 중 최솟값 D의 저장된 수를 출력, i<=0 무시
 * 문제 풀면서 알게 된 점 br.readLine().split(" ") 에서 걸리는 시간이 인풋이 많은 경우 오래 걸림 ( 시간초과 )
 * val tokens = StringTokenizer(br.readline())
 * tokens.nextToken() 으로 해야 시간초과가 안 걸리는 줄 알았으나 걸려버림
 * Pair로 값과 idx를 나눠 사용해도 시간초과가 걸려버림..
 * 93 % 포기..
 */

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val nl = StringTokenizer(br.readLine())
    val n = Integer.parseInt(nl.nextToken())
    val l = Integer.parseInt(nl.nextToken())

    val nums = StringTokenizer(br.readLine())
    val dq: Deque<Int> = LinkedList<Int>()

    val arr = IntArray(n) { 0 }

    for (i in 0 until n) {
        arr[i] = Integer.parseInt(nums.nextToken())

        if (dq.isNotEmpty() && dq.first <= i - l) dq.pollFirst()
        while (dq.isNotEmpty() && arr[dq.last] > arr[i]) dq.pollLast()

        dq.addLast(i)
        bw.write("${arr[dq.first]} ")
    }
    bw.flush()
    bw.close()
}