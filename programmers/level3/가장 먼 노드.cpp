#include <string>
#include <vector>
#include <unordered_map>
#include <queue>
#include <algorithm>

using namespace std;

int solution(int n, vector<vector<int>> edge) {
    int answer = 0;
    unordered_map<int, vector<int>> routes;
    vector<bool> visited(n + 1, false);
    vector<int> cnt(n + 1, 0);
    
    for(int i=0; i<edge.size(); i++){
        routes[edge[i][0]].push_back(edge[i][1]);
        routes[edge[i][1]].push_back(edge[i][0]);
    }
    
    queue<int> q;
    q.push(1);
    visited[1] = true;
    
    while(!q.empty()){ // BFS
        int f = q.front();
        q.pop();
        
        for(int i=0; i<routes[f].size(); i++){
            if(!visited[routes[f][i]]){
                q.push(routes[f][i]);
                cnt[routes[f][i]] = cnt[f]+1;
                visited[routes[f][i]] = true;
            }
        }
    }
    
    // *max_element 최대 값 구하기, max_element 사용시 최대 값 idx
    answer = count(cnt.begin(), cnt.end(), *max_element(cnt.begin(), cnt.end())); 
    
    return answer;
}