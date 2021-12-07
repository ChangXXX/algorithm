import java.lang.StringBuilder

class Solution {
    fun solution(number: String, k: Int): String {
        var answer = ""
        val builder = StringBuilder()
        var kk = k
        
         for(i in number.indices){
             while(builder.isNotEmpty() && kk>0 && builder[builder.lastIndex] < number[i]){
                 builder.setLength(builder.length-1)
                 kk -= 1
             }
             if(kk == 0){
                 builder.append(number.substring(i))
                 break
             }

             builder.append(number[i])
         }
        answer = builder.toString().substring(0, builder.length - kk)

        return answer
    }
}