#include <bits/stdc++.h>
using namespace std;

void solve(){
  string input;
  cin >> input;
  char s[51];
  int pos = -1;

  if(input.length() % 2 != 0){
    cout << "NO" << endl;
    return;
  }

  for(int i=0; i<input.length(); i++){
    if(pos == -1) s[++pos] = input[i];
    else{
      if(s[pos] == '('){
        if(input[i] == ')') pos--;
        else s[++pos] = input[i];
      } else{
        s[++pos] = input[i];
      }
    }
  }

  if(pos == -1) cout << "YES" << endl;
  else if(pos > -1) cout << "NO" << endl;
}

int main(int argc, char** argv)
{
  cin.tie(nullptr);
  cout.tie(nullptr);
  ios_base::sync_with_stdio(false);
  
  int T;
  cin >> T;
  for(int i=0; i<T; i++) solve();

	return 0;
}