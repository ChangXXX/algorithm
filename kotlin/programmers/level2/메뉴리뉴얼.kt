import kotlin.math.sign

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/72411
 *
 * 프로그래머스, 메뉴 리뉴얼, level2
 */

class 메뉴리뉴얼 {
    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        var answer: ArrayList<String> = arrayListOf()

        for (i in 0 until course.size) {
            val map: MutableMap<String, Int> = mutableMapOf()
            for (j in 0 until orders.size) {
                val org = orders[j].toCharArray().sorted().joinToString("")
                combi(org, "", 0, course[i], map)
            }

            var max = 0
            map.forEach { (_, value) ->
                if (max < value) max = value
            }

            map.forEach { (key, value) ->
                if (max == value && max != 1) answer.add(key)
            }
            map.clear()
        }

        return answer.sorted().toTypedArray()
    }

    fun combi(org: String, now: String, cnt: Int, len: Int, map: MutableMap<String, Int>) {
        if (now.length == len) {
            map[now] = map[now]?.let { it + 1 } ?: 1
            return
        }

        if (cnt == org.length) return

        combi(org, now + org[cnt], cnt + 1, len, map)
        combi(org, now, cnt + 1, len, map)
    }
}

fun main() {
    val orders = arrayOf("XYZ", "XWY", "WXA")
    val course = intArrayOf(2, 3, 4)
    val ans = 메뉴리뉴얼().solution(orders, course)
    ans.forEach {
        println(it)
    }
}