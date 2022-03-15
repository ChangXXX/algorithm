package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// boj 1068 트리

var answer: Int = 0

fun sol1068(node: Int, target: Int, isVisited: BooleanArray, trees: Array<MutableList<Int>>) {
    isVisited[node] = true
    var childNode: Int = 0
    for (i in 0 until trees[node].size) {
        var adj = trees[node][i]
        if (!isVisited[adj] && adj != target) {
            childNode++
            sol1068(adj, target, isVisited, trees)
        }
    }

    if (childNode == 0) {
        answer++
    }
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val nodes = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val target = br.readLine().toInt()
    val isVisited = BooleanArray(n) { false }
    var root: Int = 0

    val trees = Array(n) { mutableListOf<Int>() }

    for (i in 0 until n) {
        if (nodes[i] != -1) {
            trees[i].add(nodes[i])
            trees[nodes[i]].add(i)
        } else root = i
    }

    if (root == target) bw.write("0\n")
    else {
        sol1068(root, target, isVisited, trees)
        bw.write("$answer\n")
    }
    bw.flush()
    bw.close()
    br.close()
}
