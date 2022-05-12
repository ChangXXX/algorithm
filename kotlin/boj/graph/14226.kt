package boj


// boj 14226 이모티콘 bfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun sol14226(s: Int) {
    val q: Queue<Triple<Int, Int, Int>> = LinkedList() // 이모티콘 개수, 클립
    val visited = Array(2001) { BooleanArray(2001) { false } }
    q.offer(Triple(1, 0, 0))
    var ans = 1001

    while (q.isNotEmpty()) {
        val dq = q.poll()
        val emoji = dq.first
        val clip = dq.second
        val time = dq.third

        if (emoji == s) {
            if (ans > time) ans = time
            break
        }
        if (emoji in 0..2000 && clip in 0..2000 && !visited[emoji][clip]) {
            visited[emoji][clip] = true
            if (clip > 0) q.offer(Triple(emoji + clip, clip, time + 1))
            q.offer(Triple(emoji - 1, clip, time + 1))
            q.offer(Triple(emoji, emoji, time + 1))
        }
    }

    println(ans)
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine().toInt()

    sol14226(s)
}