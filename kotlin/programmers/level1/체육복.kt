class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = 0
        
        var arr = IntArray(n+2, {i -> 1})
        
        for(l in lost)
            arr[l] -= 1
        
        for(r in reserve)
            arr[r] += 1
        
        for(i in 1..n){
            if(arr[i] == 0 && arr[i-1] == 2){
                arr[i] += 1
                arr[i-1] -= 1
            } else if(arr[i]==0 && arr[i+1] == 2){
                arr[i] +=1
                arr[i+1] -= 1
            }
        }
        
        for(i in 1..n){
            if(arr[i] >= 1) answer += 1
        }
        
        return answer
    }
}