#include <bits/stdc++.h>
using namespace std;

void solve(){
  string input, bomb;
  cin >> input >> bomb;
  string res = "";

  for(int i=0; i<input.length(); i++){
    res += input[i];

    if(input[i] == bomb.back()){
      bool check = true;
      int idx = res.length() - bomb.length();
      if(idx < 0) continue;

      for(int j=0; j<bomb.length(); j++){
        if(res[idx++] != bomb[j]){
          check = false;
          break;
        }
      }
      if(check) for(int k=0; k<bomb.length(); k++) res.pop_back();
    }
  }
  
  if(res.length() == 0) cout << "FRULA" << endl;
  else cout << res << endl;
}

int main(int argc, char** argv)
{
  cin.tie(nullptr);
  cout.tie(nullptr);
  ios_base::sync_with_stdio(false);

  solve();

	return 0;
}