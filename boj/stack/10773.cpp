#include <bits/stdc++.h>
using namespace std;

void solve(){
  int K;
  cin >> K;
  int s[100001];
  int pos = -1;

  for(int i=0; i<K; i++){
    int input;
    cin >> input;

    if(input == 0) pos--;
    else s[++pos] = input;
  }

  int sum = 0;
  for(int i=0; i<=pos; i++){
    sum += s[i];
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