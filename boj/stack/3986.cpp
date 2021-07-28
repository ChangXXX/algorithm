#include <bits/stdc++.h>
using namespace std;

void solve(){
  int N;
  cin >> N;
  char s[100001];
  int pos = 0;

  int sum = 0;
  for(int i=0; i<N; i++){
    string input;
    cin >> input;

    for(int j=0; j<input.length(); j++){
      if(pos == 0) s[pos++] = input[j];
      else{
        if(s[pos-1] == input[j]) pos -= 1;
        else s[pos++] = input[j];
      }
    }
    
    if(pos == 0) sum++;
    pos = 0;
  }
  cout << sum << endl;
}

int main(int argc, char** argv)
{
  cin.tie(nullptr);
  cout.tie(nullptr);
  ios_base::sync_with_stdio(false);

  solve();

	return 0;
}