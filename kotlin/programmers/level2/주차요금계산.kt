import kotlin.math.ceil

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92341
 *
 * 프로그래머스, 주차 요금 계산, level2
 */

class 주차요금계산 {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        var answer = mutableListOf<Int>()

        val map: MutableMap<String, ArrayList<String>> = mutableMapOf()
        for (i in 0 until records.size) {
            val (time, number) = records[i].split(" ")
            if (map.containsKey(number)) map[number]!!.add(time)
            else map.put(number, arrayListOf(time))
        }
        val sorted = map.toSortedMap()

        for (element in sorted) {
            var time = 0
            var cnt = 0
            for (i in 0 until element.value.size) {
                cnt += 1
                if (cnt % 2 == 0)
                    time += getTimeDiff(element.value[cnt - 2], element.value[cnt - 1])
            }
            if (cnt % 2 == 1)
                time += getTimeDiff(element.value[cnt - 1], "23:59")

            answer.add(getPay(time, fees))
        }

        return answer.toIntArray()
    }

    fun getTimeDiff(inTime: String, outTime: String): Int {
        var time = 0
        val (inHour, inMin) = inTime.split(":").map { it.toInt() }
        val (outHour, outMin) = outTime.split(":").map { it.toInt() }
        time = (outHour * 60 + outMin) - (inHour * 60 + inMin)

        return time
    }

    fun getPay(time: Int, fees: IntArray): Int {
        var money = fees[1]
        money += if (time > fees[0]) ceil((time - fees[0]).toFloat() / fees[2]).toInt() * fees[3] else 0

        return money
    }
}

fun main() {
    val fees = intArrayOf(180, 5000, 10, 600)
    val records = arrayOf<String>(
        "05:34 5961 IN",
        "06:00 0000 IN",
        "06:34 0000 OUT",
        "07:59 5961 OUT",
        "07:59 0148 IN",
        "18:59 0000 IN",
        "19:09 0148 OUT",
        "22:59 5961 IN",
        "23:00 5961 OUT"
    )
    주차요금계산().solution(fees, records).forEach {
        println(it)
    }
}