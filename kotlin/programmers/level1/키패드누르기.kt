import java.lang.Math.abs

class 키패드누르기 {
    data class Pos(
        var x: Int,
        var y: Int
    )

    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""

        val lPos = Pos(0, 0)
        val rPos = Pos(0, 2)

        val maps = arrayOf(
            intArrayOf(-1, 0, -1),
            intArrayOf(7, 8, 9),
            intArrayOf(4, 5, 6),
            intArrayOf(1, 2, 3)
        )

        for (i in numbers.indices) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer += "L"
                if (numbers[i] == 1) lPos.x = 3
                else if (numbers[i] == 4) lPos.x = 2
                else lPos.x = 1
                lPos.y = 0
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer += "R"
                if (numbers[i] == 3) rPos.x = 3
                else if (numbers[i] == 6) rPos.x = 2
                else rPos.x = 1
                rPos.y = 0
            } else {
                for (j in maps.indices) {
                    for (k in maps[j].indices) {
                        if (numbers[i] == maps[j][k]) {
                            val leftDistance = abs(j - lPos.x) + abs(k - lPos.y)
                            val rightDistance = abs(j - rPos.x) + abs(k - rPos.y)
                            if (leftDistance > rightDistance) {
                                answer += "R"
                                rPos.x = j
                                rPos.y = k
                            } else if (leftDistance < rightDistance) {
                                answer += "L"
                                lPos.x = j
                                lPos.y = k
                            } else {
                                if(hand == "right"){
                                    answer += "R"
                                    rPos.x = j
                                    rPos.y = k
                                } else {
                                    answer += "L"
                                    lPos.x = j
                                    lPos.y = k
                                }
                            }
                            break
                        }
                    }
                }
            }
        }
        return answer
    }
}

fun main(args: Array<String>) {
    val numbers = intArrayOf(7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2)
    val hand = "left"
    val c = 키패드누르기()
    println(c.solution(numbers, hand))
}