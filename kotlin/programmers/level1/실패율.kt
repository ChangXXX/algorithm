class 실패율 {
    data class Failure(
        var fail: Double,
        var idx: Int
    )

    fun solution(N: Int, stages: IntArray): IntArray {
        val answer = IntArray(N) { 0 }
        val maps = IntArray(502) { 0 }

        for (i in stages.indices) {
            maps[stages[i]]++
        }
        var sum = 0
        val fail = Array<Failure>(N+1) { Failure(0.0, 0) }
        for (i in 1..N) {
            if(stages.size > sum){
                fail[i-1].fail = maps[i].toDouble() / (stages.size-sum).toDouble()
                sum += maps[i]
            } else{
                fail[i-1].fail = 0.0
            }
            fail[i-1].idx = i
        }
        fail.sortWith(
            compareByDescending(Failure::fail)
                .thenBy(Failure::idx)
        )
        for(i in 0 until N){
            answer[i] = fail[i].idx
        }

        return answer
    }
}

fun main(args: Array<String>) {
    val N = 5
    val stages = intArrayOf(2, 1, 2, 6, 2, 4, 3, 3)
    val c = 실패율()
    println(c.solution(N, stages))
}