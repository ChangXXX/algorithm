import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

class 타겟넘버 { // BFS
    var answer: Int = 0
    var size: Int = 0

    fun solution(numbers: IntArray, target: Int): Int {
        size = numbers.size

        dfs(0, numbers[0], target, numbers)
        dfs(0, numbers[0] * -1, target, numbers)

        return answer
    }

    fun dfs(level: Int, sum: Int, target: Int, numbers: IntArray) {
        if (level == size - 1) {
            if (sum == target) answer++
        } else {
            dfs(level + 1, sum + numbers[level + 1], target, numbers)
            dfs(level + 1, sum - numbers[level + 1], target, numbers)
        }
    }
}
