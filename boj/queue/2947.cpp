#include <bits/stdc++.h>
using namespace std;

void solve(){
  int arr[5];
  for(int i=0; i<5; i++) cin >> arr[i];

  for(int i=0; i<4; i++){
    if(arr[i]>arr[i+1]){
      swap(arr[i], arr[i+1]);
      for(int j=0; j<5; j++){
        cout << arr[j] << " ";
      }
      cout << endl;
    }
    if(i == 3){
      for(int j=0; j<5; j++){
        if(arr[j] == j+1) continue;
        else{
          i = -1;
          break;
        }
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