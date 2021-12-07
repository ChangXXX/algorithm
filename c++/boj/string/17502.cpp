#include <bits/stdc++.h>
using namespace std;

void solve(){
  int len;
  string input;
  cin >> len >> input;
  
  for(int i=0; i<len; i++){
    if(input[i] == '?'){
      input[i] = input[len-i-1];
    } else if(input[len-i -1]  == '?'){
      input[len-i-1] = input[i];
    }
    if(input[i] == '?' && input[len-i -1] == '?'){
      input[i] = 'a';
      input[len-i-1] = 'a';
    }
  }
  cout << input << endl;
}

int main(int argc, char** argv)
{
  cin.tie(nullptr);
  cout.tie(nullptr);
  ios_base::sync_with_stdio(false);

  solve();
    
	return 0;
}