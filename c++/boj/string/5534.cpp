#include <bits/stdc++.h>
using namespace std;

string findString;
int res;
void solve(){
  string input;
  cin >> input;

  for(int i=0; i<input.length(); i++){
    if(input[i] != findString[0]) continue;
    else{
      if(findString.length() == 1){
        res++;
        break;
      } else{
        string tmp;
        for(int gap = 1; gap<input.length(); gap++){
          tmp = input[i];
          for(int j=i+gap; j<input.length(); j += gap){
            tmp += input[j];
            if(tmp.length() == findString.length()){
              if(findString == tmp){ // 맞는경우 함수 종료
                res++;
                return;
              } // 틀린 경우 간격 증가
              break;
            }
          }
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

  
  int T;
  cin >> T >> findString;

  res = 0;
  for(int i=0; i<T; i++) {
    solve();
  }
  cout << res << endl;

	return 0;
}