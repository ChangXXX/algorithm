class 모의고사 {
    val first = intArrayOf(1, 2, 3, 4, 5)
    val second = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
    val third = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

    fun solution(answers: IntArray): IntArray {
        var scores = IntArray(3) { 0 }
        val answer = arrayListOf<Int>()

        answers.forEachIndexed { index, i ->
            if (i == first[index % 5]) scores[0]++
            if (i == second[index % 8]) scores[1]++
            if (i == third[index % 10]) scores[2]++
        }
        val max = scores.maxOf { it }

        for (i in scores.indices) {
            if (max == scores[i]) answer.add(i + 1)
        }

        return answer.toIntArray()
    }
}
