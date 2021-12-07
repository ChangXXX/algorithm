#include <string>

using namespace std;

int solution(string s) {
    int answer = s.size();
    
    for(int i=1; i<=s.size()/2; i++){ // 반복 글자 길이
        string check = "";
        string res = "";
        int cnt = 1;
        check = s.substr(0, i);
        
        for(int j=i; j<s.size(); j += i){ // 간격만큼 넘어가면서 체크
            if(check == s.substr(j,i)){ // 반복 문자열과 그 다음 같은 간격의 문자열이 같으면
                cnt++;
            } else{
                if(cnt > 1) res += to_string(cnt);
                res += check;
                check = s.substr(j, i); // 새로운 체크할 문자열
                cnt = 1;
            }
        } // check for 끝
        
        if(cnt > 1) res += to_string(cnt);
        res += check;
        if(answer > res.size()) answer = res.size();
    }
    
    return answer;
}