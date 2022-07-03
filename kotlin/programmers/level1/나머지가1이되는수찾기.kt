class 나머지가1이되는수찾기 {
    fun solution(n: Int): Int {
        var answer: Int = 0

        for(i in 2 until n){
            if(n%i == 1){
                answer = i
                break
            }
        }

        return answer
    }
}