#include <string>
#include <vector>
#include <algorithm>
#include <unordered_map>
using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    string answer = "";
    unordered_map<string, int> m;
    
    for(string part : participant){
        m[part]++;
    }
    for(string comp : completion){
        m[comp]--;
    }
    for(auto& tmp : m){
        if(tmp.second > 0){
            answer = tmp.first;
            break;
        }
    }
    
    return answer;
}