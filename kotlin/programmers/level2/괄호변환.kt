import java.lang.StringBuilder

class 괄호변환 {
    fun solution(p: String): String {
        if (p.isNullOrEmpty() || p == "") return "" // 1 check

        var balance = 0

        for (i in p.indices) {
            if (p[i] == '(') balance++
            else balance--

            if (balance == 0) {
                balance = i
                break
            }
        }
        var u = p.substring(0, balance + 1)
        var v = p.substring(balance + 1)

        val sb = StringBuilder()

        // 옳바른 문자열
        if (u[0] == '(') {
            sb.append(u)
            sb.append(solution(v))
        } else { // 올바른 괄호 문자열이 아닌 경우
            sb.append("(")
            sb.append(solution(v))
            sb.append(")")
            u.substring(1, u.length-1).forEach { it ->
                if(it == '(') sb.append(')')
                else if(it == ')') sb.append('(')
            }
        }

        return sb.toString()
    }
}

fun main(args: Array<String>) {
    val c = 괄호변환()

    println(c.solution(""))
}