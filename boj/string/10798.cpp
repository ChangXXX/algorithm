#include <bits/stdc++.h>
using namespace std;

void solve(){
  char input[5][15];
  memset(input, NULL, sizeof(input));

  for(int i=0; i<5; i++){
    cin >> input[i];
  } 

  string res = "";
  for(int i=0; i<15; i++){
    for(int j=0; j<5; j++){
      if(input[j][i] == NULL) continue;
      res += input[j][i];
    }
  }
  cout << res << endl;
}

int main(int argc, char** argv)
{
  cin.tie(nullptr);
  cout.tie(nullptr);
  ios_base::sync_with_stdio(false);

  solve();
    
	return 0;
}