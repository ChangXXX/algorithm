package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

var levelChecker: Boolean = false

fun dfs(nodes: ArrayList<ArrayList<Int>>,level: Int, pos: Int, visited: BooleanArray){
    if(level == 5){
        levelChecker = true
        return
    }

    visited[pos] = true
    for(j in nodes[pos]){
        if(!visited[j]) {
            dfs(nodes, level + 1, j, visited)
        }
    }
    visited[pos] = false
}

fun solution(n: Int, m: Int, nodes: ArrayList<ArrayList<Int>>){
    for(i in 0..n-1){
        val visited: BooleanArray = BooleanArray(n, {it -> false})
        dfs(nodes, 1, i, visited)
        if(levelChecker) break
    }

    var answer = if(levelChecker) "1" else "0"
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    bw.write(answer)
    bw.flush()
    bw.close()
}

fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val nodes: ArrayList<ArrayList<Int>> = arrayListOf()
    for(i in 0..n-1) nodes.add(arrayListOf())

    for(i in 1..m){
        val (p1, p2) = br.readLine().split(" ").map { it.toInt() }
        nodes[p1].add(p2)
        nodes[p2].add(p1)
    }

    solution(n, m, nodes)
    br.close()
}