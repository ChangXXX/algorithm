//import java.lang.Integer.min
//
//fun solution(name: String): Int {
//    var answer = 0
//    val minList =  MutableList<Int>(name.length){0}
//    var minMove = name.length - 1
//
//    name.toCharArray().forEachIndexed { index, c ->
//        minList[index] = Math.min('Z' - c + 1, c - 'A') // 상하 이동횟수
//    }
//
//    for(i in name.indices){ // 좌우 이동
//        if(name[i] != 'A'){
//            var aPos = i + 1;
//            while(aPos < name.length && name[aPos] == 'A'){
//                aPos += 1
//            }
//            val move = 2 * i + name.length - aPos
//            minMove = min(move, minMove)
//        }
//    }
//    answer = minList.sum() + minMove
//
//    return answer
//}
//
//fun main(args:Array<String>){
//    print(solution("BBBAAB"))
//}
