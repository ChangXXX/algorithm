#include <bits/stdc++.h>
using namespace std;

void solve(){
  string input;
  cin >> input;
  int sum = 0;
  int cnt = 1;
  stack<char> s;

  for(int i=0; i<input.length(); i++){
    if(input[i] == '('){
      s.push(input[i]);
      cnt *= 2;
    } else if(input[i] == '['){
      s.push(input[i]);
      cnt *= 3;
    }
    if(input[i] == ')' && (s.empty() || s.top() != '(')){
      cout << 0 << endl;
      return;
    }
    if(input[i] == ']' && (s.empty() || s.top() != '[')){
      cout << 0 << endl;
      return;
    }
    if(input[i] == ')'){
      if(input[i-1] == '(') sum += cnt;
      cnt /= 2;
      s.pop();
    } else if(input[i] == ']'){
      if(input[i-1] == '[') sum += cnt;
      cnt /= 3;
      s.pop();
    }
  }
  if(s.size() == 0) cout << sum << endl;
  else cout << 0 << endl;
}

int main(int argc, char** argv)
{
  cin.tie(nullptr);
  cout.tie(nullptr);
  ios_base::sync_with_stdio(false);

  solve();

	return 0;
}