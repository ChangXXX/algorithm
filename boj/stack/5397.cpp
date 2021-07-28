#include <bits/stdc++.h>
using namespace std;

void solve(){
  int T;
  cin >> T;
  stack<char> s1, s2;
  for(int i=0; i<T; i++){
    string input;
    cin >> input;
    string res = "";
    for(int j=0; j<input.length(); j++){
      if(input[j] == '<'){
        if(!s1.empty()) {
          s2.push(s1.top()); 
          s1.pop();
        }
      } else if(input[j] == '>'){
        if(!s2.empty()){
          s1.push(s2.top());
          s2.pop();
        }
      } else if(input[j] == '-'){
        if(!s1.empty()) s1.pop();
      } else{
        s1.push(input[j]);
      }
    }
    while(!s1.empty()){
      s2.push(s1.top());
      s1.pop();
    }
    while(!s2.empty()){
      cout << s2.top();
      s2.pop();
    }
    cout << endl;
  }
}

int main(int argc, char** argv)
{
  cin.tie(nullptr);
  cout.tie(nullptr);
  ios_base::sync_with_stdio(false);

  solve();

	return 0;
}