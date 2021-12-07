#include <bits/stdc++.h>
using namespace std;

int ans(string input){
  stack<char> s;
  
  for(int i=0; i<input.length(); i++){
    if(s.empty()){
      s.push(input[i]);
      continue;
    }
    if(s.top() == '{'){
      if(input[i] == '}') {
        s.pop();
      }
      else {
        s.push(input[i]);
      }
    } else if(s.top() == '}') {
      s.push(input[i]);
    }
    
  }

  char tmp;
  int cnt = 0;
  while(!s.empty()){
    tmp = s.top();
    s.pop();

    if(tmp == '{'){
      if(s.top() == '{'){
        cnt += 1;
      } else if(s.top() == '}'){
        cnt += 2;
      }
    } else if(tmp == '}') {
      cnt += 1;
    }

    s.pop();
  }

  return cnt;
}

void solve(){
  vector<string> v;
  string input;

  while(true){
    cin >> input;
    if(input.find('-') != string::npos) break;

    v.push_back(input);
  }

  for(int i=0; i<v.size(); i++){
    cout << i +1 << ". " << ans(v[i]) << endl;
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