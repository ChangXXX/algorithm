import java.util.*

class 괄호회전하기 {
    fun solution(s: String): Int {
        var answer: Int = 0

        var input = s.toCharArray().toList()
        var cnt = 0
        while(cnt<s.length){
            if(check(input.joinToString(""))) answer++
            Collections.rotate(input, -1)
            cnt++
        }

        return answer
    }

    fun check(s: String): Boolean{
        var res = true

        val st = Stack<Char>()

        for(i in s.indices){
            if(s[i] == ')' || s[i] == ']' || s[i] == '}'){
                if(st.isNotEmpty()){
                    when(s[i]){
                        ')' -> if(st.peek() == '(') st.pop() else st.push(s[i])
                        ']' -> if(st.peek() == '[') st.pop() else st.push(s[i])
                        '}' -> if(st.peek() == '{') st.pop() else st.push(s[i])
                    }
                } else{
                    res = false
                    break
                }
            }
            else st.push(s[i])
        }
        if(st.isNotEmpty()) res = false

        return res
    }
}