/*
 * 프로그래머스 숫자문자열과영단어 level1
 */

class 숫자문자열과영단어 {
    fun solution(s: String): Int {
        var answer: String = ""

        val m : Map<String, Int> = mapOf(
            "zero" to 0,
            "one" to 1,
            "two" to 2,
            "three" to 3,
            "four" to 4,
            "five" to 5,
            "six" to 6,
            "seven" to 7,
            "eight" to 8,
            "nine" to 9
        )

        val sb = StringBuilder()
        for(i in s.indices){
            if(s[i] in 'a'..'z') {
                sb.append(s[i])
                if(m.containsKey(sb.toString())){
                    answer += m[sb.toString()]
                    sb.clear()
                }
            }
            else answer += s[i]
        }

        return answer.toInt()
    }
}

fun main(args: Array<String>){
    val c = 숫자문자열과영단어()
    println(c.solution("one4seveneight"))
}