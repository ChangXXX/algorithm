#include <bits/stdc++.h>
using namespace std;

string input;

enum {
  palindrome = 0, // 회문
  pseudo, // 유사
  none // 그외
};

int solve(int l, int r, bool check){
  for(int i=l, j = r; i<j; i++, j--){
    if(input[i] == input[j]) continue;
    else{
      if(check){ // check는 한번 틀렸는지 안틀렸는지 확인
        if(solve(i, j-1, false) == 0 || solve(i+1, j, false) == 0) return pseudo;
      }
      return none;
    }
  }
  return palindrome;
}

int main(int argc, char** argv)
{
  cin.tie(nullptr);
  cout.tie(nullptr);
  ios_base::sync_with_stdio(false);

  int T;
  cin >> T;
  for(int i=0; i<T; i++) {
    cin >> input;
    cout << solve(0, input.length()-1, true) << endl;
  }

	return 0;
}