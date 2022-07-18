/*
 * 프로그래머스 level1 2021 카카오blind 신규아이디추천
 */

class 신규아이디추천 {
    fun solution(new_id: String): String {
        var sb = StringBuilder()
        val lower = new_id.lowercase()

        for (i in lower.indices) {
            if (lower[i] in 'a'..'z' || lower[i] in '0'..'9' || lower[i] == '-' || lower[i] == '_' || lower[i] == '.') {
                if (i != 0 && sb.isNotEmpty() && sb.last() == '.' && lower[i] == '.') continue
                sb.append(lower[i])
            }
        }

        if (sb.isNotEmpty() && sb.first() == '.') {
            sb = sb.deleteCharAt(0)
        }

        if (sb.isNotEmpty() && sb.last() == '.') {
            sb.setLength(sb.length - 1)
        }

        if(sb.isEmpty()) sb.append("a")

        if (sb.length >= 16) {
            sb.setLength(15)

            while (true) {
                if (sb.last() != '.') break
                sb.setLength(sb.length-1)
            }
        }

        if (sb.length <= 2) {
            while (true) {
                if (sb.length == 3) break

                sb.append(sb.last())
            }
        }

        return sb.toString()
    }
}

fun main(args: Array<String>) {
    val new_id = "=.="
    val c = 신규아이디추천()
    println(c.solution(new_id))
}