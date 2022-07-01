class 최소직사각형 {
    fun solution(sizes: Array<IntArray>): Int {
        val bigList = IntArray(sizes.size){0}
        val smallList = IntArray(sizes.size){0}
        for(i in sizes.indices){
            if(sizes[i][0] > sizes[i][1]){
                bigList[i] = sizes[i][0]
                smallList[i] = sizes[i][1]
            } else{
                bigList[i] = sizes[i][1]
                smallList[i] = sizes[i][0]
            }
        }

        var max = 0
        var min = 0

        for(i in bigList.indices){
            if(bigList[i] > max) max = bigList[i]
            if(smallList[i] > min) min = smallList[i]
        }

        return max * min
    }
}