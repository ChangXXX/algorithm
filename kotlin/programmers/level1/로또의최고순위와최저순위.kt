import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class 로또의최고순위와최저순위 {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var cnt: Int = 0
        var zero: Int = 0
        var answer = IntArray(2)

        lottos.sortDescending()
        win_nums.sortDescending()

        for (i in lottos.indices) {
            if (lottos[i] == 0) {
                zero = lottos.size - i
                break
            }

            for (j in win_nums.indices) {
                if (lottos[i] == win_nums[j]) {
                    ++cnt
                }
            }
        }

        if (zero == 0) {
            answer[0] = rank(cnt)
            answer[1] = rank(cnt)
        } else {
            answer[0] = rank(cnt + zero)
            answer[1] = rank(cnt)
        }

        return answer
    }

    private fun rank(cnt: Int): Int {
        return when (cnt) {
            6 -> 1
            5 -> 2
            4 -> 3
            3 -> 4
            2 -> 5
            else -> 6
        }
    }
}