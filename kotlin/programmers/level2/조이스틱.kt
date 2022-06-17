import kotlin.math.min

/*
 *  programmers 조이스틱 https://programmers.co.kr/learn/courses/30/lessons/42860
*/

class 조이스틱 {
    var moveCount = 99999

    fun solution(name: String): Int {
        var answer = 0
        val moves = IntArray(name.length) { 0 }
        val check = BooleanArray(name.length) { false }

        for (i in name.indices) {
            moves[i] = min(name[i] - 'A', 'Z' - name[i] + 1)
            if(name[i] == 'A') check[i] = true
        }

        if (name.all { it == 'A' }) return answer

        check[0] = true
        dfs(check, 0, 0, name)

        answer = moves.sum() + moveCount

        return answer
    }

    fun dfs(check: BooleanArray, cnt: Int, idx: Int, name: String) {
        if (check.all { it == true }) {
            if (moveCount > cnt) moveCount = cnt
            return
        }

        if (cnt >= moveCount) return

        var right = idx
        var rightCount = 0
        while(true){
            if(right == name.length - 1) right = 0
            else right += 1
            rightCount += 1

            if(!check[right] && name[right] != 'A') break
        }

        var left = idx
        var leftCount = 0
        while(true){
            if(left == 0) left = name.length - 1
            else left -= 1
            leftCount += 1

            if(!check[left] && name[left] != 'A') break
        }

        check[right]= true
        dfs(check, cnt + rightCount, right, name)
        check[right] = false

        check[left] = true
        dfs(check, cnt + leftCount, left, name)
        check[left] = false
    }
}

fun main(args: Array<String>) {
    val c = 조이스틱()

    print(c.solution("BBABAAAABBBAAAABABB"))
}
