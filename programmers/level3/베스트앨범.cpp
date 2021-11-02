#include <string>
#include <vector>
#include <unordered_map>
#include <utility>
#include <algorithm>

using namespace std;

bool compare(pair<string, int>& a, pair<string, int>& b){
    return a.second > b.second;
}

bool cmp(pair<int, int>& a, pair<int, int>& b){
    if(a.second == b.second)
        return a.first < b.first;
    
    return a.second > b.second;
}

vector<int> solution(vector<string> genres, vector<int> plays) {
    vector<int> answer;
    unordered_map<string, int> m;
    
    for(int i=0; i<genres.size(); i++)
        m[genres[i]] += plays[i];
    
    vector<pair<string, int>> prior(m.begin(), m.end());
    sort(prior.begin(), prior.end(), compare);
    
    for(auto& genre : prior){
        vector<pair<int, int>> v; // index, play
        for(int i = 0; i < plays.size(); i++){
            if(genres[i] == genre.first){
                v.push_back(make_pair(i, plays[i])); 
            }
        }
        
        sort(v.begin(), v.end(), cmp);
        
        for(int i = 0; i < 2; i++){
            answer.push_back(v[i].first);
            if(v.size() == 1) break;
        }
    }
    
    return answer;
}