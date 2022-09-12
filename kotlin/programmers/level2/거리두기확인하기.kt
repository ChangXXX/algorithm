/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/81302
 *
 * 프로그래머스, 거리두기 확인하기, level2
 */

class 거리두기확인하기 {
    fun solution(places: Array<Array<String>>): IntArray {
        val answer = mutableListOf<Int>()

        for (i in 0 until places.size) {
            answer.add(check(places[i]))
        }

        return answer.toIntArray()
    }

    fun check(place: Array<String>): Int {
        val dx = intArrayOf(0, 1, 0, -1)
        val dy = intArrayOf(-1, 0, 1, 0)
        val ddx = intArrayOf(1, 1, -1, -1)
        val ddy = intArrayOf(-1, 1, 1, -1)

        for (i in 0 until 5) {
            for (j in 0 until 5) {
                if (place[i][j] == 'P') {
                    for (k in 0 until 4) {
                        var nx = j + dx[k]
                        var ny = i + dy[k]
                        if (checkRange(nx, ny)) {
                            if (place[ny][nx] == 'P') return 0
                            val nnx = nx + dx[k]
                            val nny = ny + dy[k]
                            if (checkRange(nnx, nny) && place[ny][nx] == 'O' && place[nny][nnx] == 'P') return 0
                        }

                        nx = j + ddx[k]
                        ny = i + ddy[k]
                        if (checkRange(nx, ny) && place[ny][nx] == 'P' && (place[ny][j] == '0' || place[i][nx] == 'O'))
                            return 0
                    }
                }
            }
        }

        return 1
    }

    fun checkRange(x: Int, y: Int): Boolean {
        if (x >= 0 && x < 5 && y >= 0 && y < 5) return true

        return false
    }
}

fun main(args: Array<String>) {
    val places = arrayOf(
        arrayOf("POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"),
        arrayOf("POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"),
        arrayOf("PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"),
        arrayOf("OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"),
        arrayOf("PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP")
    )
    val c = 거리두기확인하기()

    println(c.solution(places))
}