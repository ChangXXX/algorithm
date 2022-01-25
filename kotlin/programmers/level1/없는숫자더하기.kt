class 없는숫자더하기 {
    fun solution(numbers: IntArray): Int {
        var answer: Int = 0
        for(i in 0..9){
            answer += i
        }
        numbers.forEach { it ->
            answer -= it
        }

        return answer
    }
}

fun main(args: Array<String>){
    val numbers = intArrayOf(5,8,4,0,6,7,9)
    val c = 없는숫자더하기()

    println(c.solution(numbers))
}