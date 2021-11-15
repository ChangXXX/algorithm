#include <string>
#include <vector>

using namespace std;

void dfs(int i, vector<vector<int>>& computers, vector<bool>& visited){
    visited[i] = true;
    for(int j=0; j<computers.size(); j++){
        if(!visited[j] && computers[i][j] == 1) dfs(j, computers, visited);
    }
}

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    vector<bool> visited(n, false);
    
    for(int i=0; i<computers.size(); i++){
        if(!visited[i]){ // 방문 안한 경우
            dfs(i, computers, visited);
            answer++;
        }
    }
    
    return answer;
}