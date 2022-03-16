package boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// boj 1197 최소 스패닝 트리

data class Node (
    val to: Int,
    val weight: Int
)

fun sol1197(isVisited: BooleanArray, nodes: Array<MutableList<Node>>): Int {
    val q = PriorityQueue<Node>(kotlin.Comparator { o1, o2 ->  o1.weight - o2.weight})
    var depth = 1
    var ans: Int = 0

    q.offer(Node(1, 0))

    while (q.isNotEmpty()) {
        val node = q.poll()
        val to = node.to
        val weight = node.weight

        if(!isVisited[to]){
            isVisited[to] = true
            ans += weight

            if(++depth == nodes.size) return ans

            for(i in nodes[to].indices){
                val next = nodes[to][i]
                if(!isVisited[next.to]){
                    q.offer(next)
                }
            }
        }
    }

    return ans
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (v, e) = br.readLine().split(" ").map { it.toInt() }
    val nodes = Array(v + 1) { mutableListOf<Node>() }
    val isVisited = BooleanArray(v + 1) { false }

    for (i in 0 until e) {
        val (from, to, weight) = br.readLine().split(" ").map { it.toInt() }
        nodes[from].add(Node(to, weight))
        nodes[to].add(Node(from, weight))
    }

    bw.write(sol1197(isVisited, nodes).toString())
    bw.flush()
    br.close()
    bw.close()
}