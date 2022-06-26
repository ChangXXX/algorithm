class 튜플 {
    fun solution(s: String): IntArray {
        val arr = mutableListOf<MutableList<Int>>()
        val ans = mutableListOf<Int>()

        var idx = 1
        while (true) {
            if (idx == s.length - 1) break
            if (s[idx] !in '0'..'9') {
                idx++
                continue
            }

            val sb = StringBuilder()
            val tmp = mutableListOf<Int>()
            while (true) {
                if (s[idx] == '}') {
                    tmp.add(sb.toString().toInt())
                    sb.clear()
                    arr.add(tmp)
                    idx++
                    break
                }
                if (s[idx] == ',') {
                    tmp.add(sb.toString().toInt())
                    sb.clear()
                    idx++
                    continue
                }
                sb.append(s[idx++])
            }
        }
        arr.sortWith { mutableList, mutableList2 ->
            mutableList.size - mutableList2.size
        }

        for(i in arr.indices){
            for(j in arr[i].indices){
                if(!ans.contains(arr[i][j])) ans.add(arr[i][j])
            }
        }

        return ans.toIntArray()
    }
}

fun main(args: Array<String>) {
    val input = "{{2},{2,1},{2,1,3},{2,1,3,4}}"
    val c = 튜플()
    println(c.solution(input))
}