import java.util.*

/*
 * 프로그래머스 크레인인형뽑기게임
 */

class 크레인인형뽑기게임 {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        val st = Stack<Int>()

        for(i in moves.indices){
            val move = moves[i]

            for(j in board.indices){
                if(board[j][move-1] == 0) continue

                if(st.isNotEmpty() && st.peek() == board[j][move-1]) {
                    answer += 2
                    st.pop()
                } else st.push(board[j][move-1])

                board[j][move-1] = 0
                break
            }
        }

        return answer
    }
}

fun main(args: Array<String>) {
    val c = 크레인인형뽑기게임()
    val board = arrayOf(
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 0, 1, 0, 3),
        intArrayOf(0, 2, 5, 0, 1),
        intArrayOf(4, 2, 4, 4, 2),
        intArrayOf(3, 5, 1, 3, 1)
    )
    val moves = intArrayOf(1, 5, 3, 5, 1, 2, 1, 4)

    println(c.solution(board, moves))
}