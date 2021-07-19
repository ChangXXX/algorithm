#include <bits/stdc++.h>
using namespace std;

void solve(){
  string input;
  cin >> input;
  bool check = true;
  
  for(int i=0; i<input.size()/2; i++){
      if(input[i] != input[input.size()-i -1]) check = false;
  }
  if(check) cout << 1 << endl;
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