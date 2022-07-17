// programmers level1 신고 결과 받기

class 신고결과받기 {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        var answer = IntArray(id_list.size) { 0 }
        val setReport = report.distinct()

        val users = Array<String>(setReport.size) { "" }
        val reportedUsers = Array<String>(setReport.size) { "" }
        val cntArray = IntArray(id_list.size) { 0 }

        for (i in setReport.indices) {
            val (user, reportedUser) = setReport[i].split(" ").map { it.toString() }
            users[i] = user
            reportedUsers[i] = reportedUser
            cntArray[id_list.indexOf(reportedUser)]++
        }

        for(i in reportedUsers.indices){
            if(cntArray[id_list.indexOf(reportedUsers[i])] >= k){
                answer[id_list.indexOf(users[i])]++
            }
        }

        return answer
    }
}
