import java.util.Stack

class 숫자문자열과영단어 {
    fun solution(s: String): Int {
        var answer: Int = 0

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

        val st = Stack<Char>()
        for(i in s.indices){
            st.push(s[i])
        }

        var stream = ""
        var pos = 1
        while(st.isNotEmpty()){
            var top = st.peek()
            st.pop()
            if(top in 'a'..'z'){
                stream = top + stream
            }
            if(top in '0'..'9' || m.containsKey(stream)){
                if(top in '0'..'9'){
                    answer += pos * (top - '0')
                } else if(m.containsKey(stream)){
                    answer += pos * m[stream]!!
                    stream = ""
                }
                pos *= 10
            }
        }

        return answer
    }
}

fun main(args: Array<String>){
    val c = 숫자문자열과영단어()
    println(c.solution("23four5six7"))
}
