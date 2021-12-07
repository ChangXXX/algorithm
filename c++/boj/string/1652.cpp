#include <bits/stdc++.h>
using namespace std;

void solve(){
  int N;
  cin >> N;
  char input[101][101];
  
  for(int i=0; i<N; i++) cin >> input[i];

    
  int r=0, c=0, cnt;
  for(int i=0; i<N; i++){ // row check
    cnt = 0;
    for(int j=0; j<N; j++){ 
      if(input[i][j] == '.') cnt++;
      else{
        if(cnt>=2){
          r++;
        }
        cnt = 0;
      }
    }
    if(cnt>=2){ 
      cnt = 0;
      r++;
    }
  }

  for(int i=0; i<N; i++){ // column check
    cnt = 0;
    for(int j=0; j<N; j++){ 
      if(input[j][i] == '.') cnt++;
      else{
        if(cnt>=2){
          c++;
        }
        cnt = 0;
      }
    }
    if(cnt>=2){ 
      cnt = 0;
      c++;
    }
  }

  cout << r << " " << c << endl;
}

int main(int argc, char** argv)
{
  cin.tie(nullptr);
  cout.tie(nullptr);
  ios_base::sync_with_stdio(false);

  solve();
    
	return 0;
}