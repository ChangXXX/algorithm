#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

vector<string> solution(vector<vector<string>> tickets) {
    vector<string> answer;
    unordered_map<string, vector<string>> routes;
    sort(tickets.begin(), tickets.end(), greater<vector<string>>());
    for(int i = 0; i < tickets.size(); i++) 
        routes[tickets[i][0]].push_back(tickets[i][1]);
    
    vector<string> st = vector<string> {"ICN"};
    
    while(!st.empty()){
        string airport = st.back();
        if(routes.find(airport) == routes.end() || routes[airport].size() ==0){
            answer.push_back(airport);
            st.pop_back();
        } else{
            st.push_back(routes[airport].back());
            routes[airport].pop_back();
        }
    }
    reverse(answer.begin(), answer.end());
    
    return answer;
}