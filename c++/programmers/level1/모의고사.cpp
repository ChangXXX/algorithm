#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    int one[] = {1, 2, 3, 4, 5};
    int two[] = {2, 1, 2, 3, 2, 4, 2, 5};
    int three[] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    int scores[3] = {0, };
    
    for(int i=0; i<answers.size(); i++){
        if(answers[i] == one[i%5]){
            scores[0]++;
        }
        if(answers[i] == two[i%8]){
            scores[1]++;
        }
        if(answers[i] == three[i%10]){
            scores[2]++;
        }
    }
    int maxScores = max(max(scores[0], scores[1]), scores[2]);
    for(int i=0; i<3; i++){
        if(scores[i] == maxScores){
            answer.push_back(i+1);
        }
    }
    
    
    return answer;
}