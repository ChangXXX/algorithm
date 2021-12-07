#include <bits/stdc++.h>
using namespace std;

void solve(){
  int N;
  cin >> N;
  string input;
  
  int arr[10001];
  memset(arr, -1, sizeof(arr));
  int pos = -1;

  for(int i=0; i<N; i++){
    cin >> input;
    if(input == "push"){
      int p;
      cin >> p;
      arr[++pos] = p;
    } else if(input == "pop"){
      if(pos < 0){
        cout << -1 << endl;
      } else{
        cout << arr[pos--] << endl;
      }
    } else if(input == "size"){
      cout << pos + 1 << endl;
    } else if(input == "empty"){
      if(pos >= 0){
        cout << 0 << endl;
      } else{
        cout << 1 << endl;
      }
    } else if(input == "top"){
      if(pos < 0){
        cout << -1 << endl;
      } else{
        cout << arr[pos] << endl;
      }
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