class 오픈채팅방 {
    fun solution(record: Array<String>): Array<String> {
        var answer = ArrayList<String>()
        val enterCommand = "님이 들어왔습니다."
        val leaveCommand = "님이 나갔습니다."
        val mutableRecord = mutableListOf<String>()
        val m = mutableMapOf<String, String>()

        record.forEach { it ->
            val tmp = it.split(" ").toList()
            when(tmp[0]){
                "Enter" -> {
                    mutableRecord.add(tmp[1] + " Enter")
                    m[tmp[1]] = tmp[2]
                }
                "Leave" -> mutableRecord.add(tmp[1] + " Leave")
                "Change" -> m[tmp[1]] = tmp[2]
            }
        }

        mutableRecord.forEach{ it ->
            val tmp = it.split(" ").toList().toMutableList()
            tmp[0] = m[tmp[0]].toString()
            when(tmp[1]){
                "Enter" -> tmp[1] = enterCommand
                "Leave" -> tmp[1] = leaveCommand
            }
            answer.add(tmp.joinToString(""))
        }

        return answer.toTypedArray()
    }
}
