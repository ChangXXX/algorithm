import java.util.*

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/118667
 *
 * 프로그래머스, 두큐 합 같게 만들기, level2
 */

class 두큐합같게만들기 {

    fun solution(queue1: IntArray, queue2: IntArray): Int {
        var answer = 0
        var sum1 = queue1.sum().toLong()
        var sum2 = queue2.sum().toLong()
        val q1: Queue<Int> = LinkedList<Int>(queue1.toList())
        val q2: Queue<Int> = LinkedList<Int>(queue2.toList())
        var idx1 = 0
        var idx2 = 0

        while (idx1 < queue1.size + queue2.size && idx2 < queue1.size + queue2.size) {
            if (sum1 == sum2) {
                return answer
            }
            if (sum1 > sum2) {
                val front = q1.poll()
                q2.offer(front)
                sum1 -= front
                sum2 += front
                ++idx1
            } else if (sum1 < sum2) {
                val front = q2.poll()
                q1.offer(front)
                sum1 += front
                sum2 -= front
                ++idx2
            }
            ++answer
        }

        return -1
    }
}

fun main() {
    val queue1 = intArrayOf(3, 2, 7, 2)
    val queue2 = intArrayOf(4, 6, 5, 1)
    println(두큐합같게만들기().solution(queue1, queue2))
}