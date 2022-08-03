import java.util.*

/**
 * 프로그래머스 예상 대진표
 */

class 예상대진표 {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0

        var aTemp = a
        var bTemp = b
        while(true){
            if(aTemp == bTemp) break
            aTemp = aTemp/2 + aTemp%2
            bTemp = bTemp/2 + bTemp%2
            answer++
        }

        return answer
    }
}