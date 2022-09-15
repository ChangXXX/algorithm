package boj

/**
 * https://www.acmicpc.net/problem/11724
 *
 * boj, 11724 연결 요소의 개수, graph, dfs
 */

import java.io.BufferedReader
import java.io.InputStreamReader

class P11724 {

    fun solution(arr: Array<ArrayList<Int>>, n: Int, m: Int) {
        val visited = BooleanArray(n + 1) { false }
        var answer = 0

        for (i in 1 until n + 1) {
            if (!visited[i]) {
                dfs(arr, visited, i)
                answer++
            }
        }
        println(answer)
    }

    fun dfs(arr: Array<ArrayList<Int>>, visited: BooleanArray, pos: Int) {
        visited[pos] = true
        for (node in arr[pos]) {
            if (!visited[node]) {
                dfs(arr, visited, node)
            }
        }
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array<ArrayList<Int>>(n + 1) { arrayListOf() }
    for (i in 0 until m) {
        val (start, end) = br.readLine().split(" ").map { it.toInt() }
        arr[start].add(end)
        arr[end].add(start)
    }
    P11724().solution(arr, n, m)
}