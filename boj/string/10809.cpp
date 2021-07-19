#include <bits/stdc++.h>
using namespace std;

void solve(){
  string input;
  cin >> input;
  
  int cnt[26];

  memset(cnt, -1, sizeof(cnt));

  for(int i=0; i<input.size(); i++){
    if(cnt[input[i] - 97] == -1) cnt[input[i] - 97] = i;
  }
  for(int i=0; i< 26; i++) cout << cnt[i] << " ";
}

int main(int argc, char** argv)
{
  solve();
    
	return 0;
}