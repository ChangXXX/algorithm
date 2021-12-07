#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    vector<int> tmp;
    for(vector<int> command : commands){
        for(int i = command[0] - 1; i < command[1]; i++){
            tmp.push_back(array[i]);
        }
        sort(tmp.begin(), tmp.end());
        answer.push_back(tmp[command[2]-1]);
        tmp.clear();
    }
    
    return answer;
}