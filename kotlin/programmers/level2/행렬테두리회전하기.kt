class 행렬테두리회전하기 {
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        var answer = IntArray(queries.size)
        val arr = Array(rows) { IntArray(columns) }
        for (i in arr.indices) {
            for (j in arr[i].indices) {
                arr[i][j] = i * arr.size + j + 1
            }
        }

        for (i in queries.indices) {
            val src = Pair<Int, Int>(queries[i][0] - 1, queries[i][1] - 1)
            val dst = Pair<Int, Int>(queries[i][2] - 1, queries[i][3] - 1)
            var min: Int = arr[src.first][src.second]
            var temp: Int = arr[src.first][src.second]

            // 왼쪽 위로 이동
            for (j in src.first until dst.first) {
                arr[j][src.second] = arr[j + 1][src.second]
                min = min.coerceAtMost(arr[j][src.second])
            }

            // 아래 왼쪽 이동
            for (j in src.second until dst.second) {
                arr[dst.first][j] = arr[dst.first][j + 1]
                min = min.coerceAtMost(arr[dst.first][j])
            }

            // 오른쪽 아래 이동
            for (j in dst.first downTo src.first + 1) {
                arr[j][dst.second] = arr[j - 1][dst.second]
                min = min.coerceAtMost(arr[j][dst.second])
            }

            // 위쪽 오른쪽 이동
            for (j in dst.second downTo src.second + 1) {
                arr[src.first][j] = arr[src.first][j - 1]
                min = min.coerceAtMost(arr[src.first][j])
            }

            arr[src.first][src.second + 1] = temp
            answer[i] = min
        }

        return answer
    }
}