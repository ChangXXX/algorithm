class 위장 {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1

        val m: MutableMap<String, Int> = mutableMapOf()

        clothes.forEachIndexed { index, strings ->
            if (m.containsKey(strings[1])) m[strings[1]] = m[strings[1]]!!.plus(1)
            else m[strings[1]] = 1
        }

        for (i in m.entries) {
            if (i.value != 0) answer *= i.value + 1
        }

        return answer - 1
    }
}