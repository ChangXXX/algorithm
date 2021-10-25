#include <string>
#include <vector>
#include <queue>
using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 1;
    
    queue<pair<int,int>> q;
    priority_queue<int> pq;
    
    for(int i=0; i<priorities.size(); i++) {
        q.push(make_pair(i, priorities[i])); // pos, priority
        pq.push(priorities[i]);
    }
    
    while(!q.empty()){
        bool flag = false;
        pair<int, int> f = q.front();
        q.pop();
        
        if(pq.top() == f.second){
            answer++;
            pq.pop();
            
            if(location == f.first){
                answer -= 1;
                break;
            }
        } else
            q.push(f);
    }
    
    return answer;
}