class 순위검색 {
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        var answer = IntArray(query.size) { 0 }
        val applier = HashMap<String, MutableList<Int>>()
        for (i in info.indices) {
            val information = info[i].split(" ").map { it.toString() }.toTypedArray()
            combi(0, "", information, applier)
        }
        applier.values.forEach { it.sort() }

        for (i in query.indices) {
            val q = query[i].split(" and ").map { it.toString() }.toTypedArray()
            val (foods, limitScore) = q[3].split(" ").map { it.toString() }
            val query = q[0]+q[1]+q[2]+foods

            answer[i] = if(applier.containsKey(query)) find(applier[query]!!, limitScore.toInt()) else 0
        }

        return answer
    }

    fun combi(depth: Int, key: String, info: Array<String>, map: HashMap<String, MutableList<Int>>) {
        if (depth == 4) {
            if (map.containsKey(key)) map[key]!!.add(info[4].toInt())
            else map[key] = mutableListOf(info[4].toInt())

            return
        }

        combi(depth + 1, key + info[depth], info, map)
        combi(depth + 1, "$key-", info, map)
    }

    fun find(list: MutableList<Int>, target: Int): Int{
        var left = 0
        var right = list.size - 1

        while(left <= right){
            var mid = (left+right)/2
            if(list[mid] < target) left = mid + 1
            else right = mid - 1
        }
        return list.size - left
    }
}

fun main(args: Array<String>) {
    val info = arrayOf(
        "java backend junior pizza 150",
        "python frontend senior chicken 210",
        "python frontend senior chicken 150",
        "cpp backend senior pizza 260",
        "java backend junior chicken 80",
        "python backend senior chicken 50"
    )

    val query = arrayOf(
        "java and backend and junior and pizza 100",
        "python and frontend and senior and chicken 200",
        "cpp and - and senior and pizza 250",
        "- and backend and senior and - 150",
        "- and - and - and chicken 100",
        "- and - and - and - 150"
    )
    val c = 순위검색()
    c.solution(info, query).forEach {
        println(it)
    }
}