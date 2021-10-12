#include <string>
#include <vector>
#include <queue>

using namespace std;

int divide(int i, int k){
    int ans = 0;
    if((100-i)%k != 0){
        ans++;
    }
    return ans+(100-i)/k;
}

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    queue<int> q;
    
    for(int i=0; i<progresses.size(); i++){
        q.push(divide(progresses[i], speeds[i]));
    }

    while(!q.empty()){
        int cnt=1;
        int curr = q.front();
        q.pop();
        while(!q.empty()){
            if(curr >= q.front()){
                cnt++;
                q.pop();
            }     
            else break;
        }
        answer.push_back(cnt);
    }
    
    return answer;
}