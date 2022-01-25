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
