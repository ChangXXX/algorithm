class 삼각달팽이 {
    fun solution(n: Int): IntArray {
        val answer = mutableListOf<IntArray>()
        for (i in 1..n) {
            answer.add(IntArray(i) { 0 })
        }

        var cnt = 1
        var row = -1
        var col = 0
        var i = n
        while (true) {
            if (i <= 0) break
            for (j in 0 until i) {
                answer[++row][col] = cnt++
            }
            for (j in 0 until i - 1) {
                answer[row][++col] = cnt++
            }
            for (j in 0 until i - 2) {
                answer[--row][--col] = cnt++
            }
            i -= 3
        }
        val res = IntArray(cnt-1) { 0 }
        cnt = 0
        for (i in answer.indices) {
            for (j in answer[i].indices) {
                res[cnt++] = answer[i][j]
            }
        }

        return res
    }
}

fun main(args: Array<String>) {
    val c = 삼각달팽이()
    println(c.solution(4))
}