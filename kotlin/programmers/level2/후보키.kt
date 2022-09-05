/**
 * 프로그래머스, 2019 카카오 블라인드, 후보키, level2
 */

class 후보키 {

    fun solution(relation: Array<Array<String>>): Int {
        var answer = 0
        val possibles = mutableListOf<Int>()

        for (i in 1 until (1 shl relation[0].size)) {
            if (!minimality(possibles, i)) continue
            if (!uniqueness(i, relation)) continue
            possibles.add(i)
            answer++
        }

        println(answer)

        return answer
    }

    fun uniqueness(bits: Int, relation: Array<Array<String>>): Boolean {
        val list = ArrayList<Int>()
        for (i in 0 until relation[0].size) {
            val curr = 1 shl i
            if (curr and bits != 0) {
                list.add(i)
            }
        }

        val set = mutableSetOf<String>()
        for (i in 0 until relation.size) {
            val sb = StringBuilder()
            list.forEach { col ->
                sb.append(relation[i][col])
            }
            sb.toString()
            set.add(sb.toString())
        }

        return set.size == relation.size
    }

    fun minimality(possibles: MutableList<Int>, bits: Int): Boolean {
        possibles.forEach { key ->
            if (key and bits == key) return false
        }

        return true
    }
}

fun main() {
    val relation: Array<Array<String>> = arrayOf(
        arrayOf("100", "ryan", "music", "2"),
        arrayOf("200", "apeach", "math", "2"),
        arrayOf("300", "tube", "computer", "3"),
        arrayOf("400", "con", "computer", "4"),
        arrayOf("500", "muzi", "music", "3"),
        arrayOf("600", "apeach", "music", "2")
    )
    후보키().solution(relation)
}