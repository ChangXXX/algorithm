#include <bits/stdc++.h>
using namespace std;

void solve(){
  string input;
  cin >> input;
  char res;
  int cnt[26];
  memset(cnt, 0, sizeof(cnt));

  for(int i=0; i<input.size(); i++){
    if(input[i] >= 'a' && input[i] <= 'z') cnt[input[i] - 'a']++;
    else cnt[input[i] - 'A']++;
  }
  
  int midx = 0;
  res = char(midx + 'A');
  for(int i=0; i<26; i++) if(cnt[midx] < cnt[i]) {
    midx = i;
    res = char(midx + 'A');
  }

  for(int i=0; i<26; i++) if(cnt[midx] == cnt[i] && midx != i) res = '?';
  
  cout << res << endl;
}

int main(int argc, char** argv)
{
  solve();
    
	return 0;
}