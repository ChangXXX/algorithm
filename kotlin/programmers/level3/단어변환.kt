class 단어변환 {
    var answer = 0
    lateinit var isVisited: BooleanArray

    fun solution(begin: String, target: String, words: Array<String>): Int {
        isVisited = BooleanArray(words.size) { false }

        dfs(begin, target, words, 0)

        return answer
    }

    fun dfs(begin: String, target: String, words: Array<String>, depth: Int) {
        if (begin == target) {
            answer = depth
            return
        }

        for (i in words.indices) {
            if (isVisited[i]) continue

            var cnt = 0

            for (j in begin.indices) {
                if (begin[j] != words[i][j]) cnt++
            }
            if (cnt == 1) {
                isVisited[i] = true
                dfs(words[i], target, words, depth + 1)
                isVisited[i] = false
            }
        }
    }
}