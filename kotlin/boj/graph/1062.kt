package boj

// boj 1062 가르침

import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var isVisited: BooleanArray
private var ans: Int = 0

fun sol1062(arr: Array<String>, n: Int, k: Int) {
    isVisited = BooleanArray(26) { false }
    isVisited['a' - 'a'] = true
    isVisited['n' - 'a'] = true
    isVisited['t' - 'a'] = true
    isVisited['i' - 'a'] = true
    isVisited['c' - 'a'] = true

    dfs1062(0, 0, arr, k)
    println(ans)
}

fun dfs1062(idx: Int, cnt: Int, origin: Array<String>, k: Int) {
    if (cnt == k - 5) {
        var count = 0
        for (i in origin.indices) {
            var flag = true
            for (j in origin[i].indices) {
                if (!isVisited[origin[i][j] - 'a']) {
                    flag = false
                    break
                }
            }
            if (flag) count++
        }

        if (ans < count) ans = count

        return
    }

    for (i in idx until 26) {
        if (!isVisited[i]) {
            isVisited[i] = true
            dfs1062(i + 1, cnt + 1, origin, k)
            isVisited[i] = false
        }
    }
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array<String>(n) { br.readLine().toString() }

    // anta, tica 에서 배울 수 있는 글자 5개
    if (k < 5) {
        println(0)
        return
    } else if (k == 26) {
        // 알파벳 다 배울 수 있으면 단어 다 배울 수 있음
        println(n)
        return
    }

    sol1062(arr, n, k)
}