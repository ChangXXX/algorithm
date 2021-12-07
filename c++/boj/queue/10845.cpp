#include <bits/stdc++.h>
using namespace std;

void solve(){
  int n;
  cin >> n;
  int q[10001];
  int f = 0, b = 0;

  for(int i=0; i<n; i++){
    string cmd;
    cin >> cmd;
    if(cmd == "push"){
      int input;
      cin >> input;
      q[b++] = input;
    } else if(cmd == "pop") {
      if(f==b){
        cout << -1 << endl;
      } else{
        cout << q[f++] << endl;
      }
    } else if(cmd == "size") {
      cout << b-f << endl;
    } else if(cmd == "empty") {
      int empty = (f == b) ? 1 : 0;
      cout << empty << endl;
    } else if(cmd == "front"){
      if(f==b) cout << -1 << endl;
      else cout << q[f] << endl;
    } else if(cmd == "back"){
      if(f==b) cout << -1 << endl;
      else cout << q[b-1] << endl;
    }
  }
}

int main(int argc, char** argv)
{
  cin.tie(nullptr);
  cout.tie(nullptr);
  ios_base::sync_with_stdio(false);

  solve();

	return 0;
}