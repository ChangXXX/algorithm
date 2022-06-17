class 모음사전 {
    fun solution(word: String): Int {
        val list = mutableListOf<String>()

        combi(list, "")

        list.sort()

        return list.indexOf(word) + 1
    }

    fun combi(list: MutableList<String>, before: String){
        if(before.length == 5) return

        for(i in 0 until 5){
            if(i == 0){
                val new = before + "A"
                list.add(new)
                combi(list, new)
            } else if(i == 1){
                val new = before + "E"
                list.add(new)
                combi(list, new)
            } else if(i == 2){
                val new = before + "I"
                list.add(new)
                combi(list, new)
            } else if(i == 3){
                val new = before + "O"
                list.add(new)
                combi(list, new)
            } else if(i == 4){
                val new = before + "U"
                list.add(new)
                combi(list, new)
            }
        }
    }
}

fun main(args: Array<String>){
    val word = "I"
    val c = 모음사전()
    println(c.solution(word))
}