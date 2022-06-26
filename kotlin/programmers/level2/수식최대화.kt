class 수식최대화 {
    fun solution(expression: String): Long {
        var answer: Long = 0

        val combinations = arrayOf(
            charArrayOf('+', '-', '*'),
            charArrayOf('+', '*', '-'),
            charArrayOf('-', '+', '*'),
            charArrayOf('-', '*', '+'),
            charArrayOf('*', '-', '+'),
            charArrayOf('*', '+', '-')
        )

        for (i in combinations.indices) {
            val operand = expression.split("+", "-", "*").map { it.toLong() }.toMutableList()
            val operator = mutableListOf<Char>()
            expression.forEach {
                if (it !in '0'..'9') operator.add(it)
            }
            for (j in combinations[i].indices) {
                var cnt = operator.count { it == combinations[i][j] }
                while (true) {
                    if (cnt == 0) break
                    val idx = operator.indexOf(combinations[i][j])
                    operand[idx] = cal(operand[idx], operand[idx + 1], combinations[i][j])
                    operand.removeAt(idx + 1)
                    operator.removeAt(idx)
                    --cnt
                }
            }
            val res = if(operand[0] > 0) operand[0] else operand[0]*-1
            if(answer < res) answer = res
        }

        return answer
    }

    fun cal(a: Long, b: Long, operator: Char): Long {
        return when (operator) {
            '-' -> a - b
            '+' -> a + b
            else -> a * b
        }
    }
}

fun main(args: Array<String>) {
    val input = "100-200*300-500+20"
    val c = 수식최대화()
    println(c.solution(input))
}