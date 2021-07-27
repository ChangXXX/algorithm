#include <bits/stdc++.h>
using namespace std;

void solve(){
  int r, c;
  cin >> r >> c;

  char input[21][21];
  vector<string> res;

  for(int i = 0; i<r; i++) cin >> input[i];

  string tmp;
  for(int i=0; i<r; i++){ // 행 check
    tmp = "";
    for(int j=0; j<c; j++){
      if(input[i][j] == '#'){
        if(tmp.length() > 1) res.push_back(tmp);
        
        tmp = "";
        continue;
      }
      tmp += input[i][j];
    }
    if(tmp.length() > 1) res.push_back(tmp);
  }

  for(int i=0; i<c; i++){ // 열 check
    tmp = "";
    for(int j=0; j<r; j++){
      if(input[j][i] == '#'){
        if(tmp.length() > 1) res.push_back(tmp);
        
        tmp = "";
        continue;
      }
      tmp += input[j][i];
    }
    if(tmp.length() > 1) res.push_back(tmp);
  }

  sort(res.begin(), res.end());

  cout << res[0] << endl;
}

int main(int argc, char** argv)
{
  cin.tie(nullptr);
  cout.tie(nullptr);
  ios_base::sync_with_stdio(false);
  
  solve();

	return 0;
}