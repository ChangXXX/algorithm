#include <bits/stdc++.h>
using namespace std;

void solve(){
  string input;
  cin >> input;
  int cnt=0;
  int res=0;
  for(int i=0; i<input.size(); i++){
    if(input[i] == 'X') {
      cnt = 0;
    } else{
      cnt++;
    }
    res += cnt;
  }
  cout << res << endl;
}

int main(int argc, char** argv)
{
    cin.tie(nullptr);
    cout.tie(nullptr);
    ios_base::sync_with_stdio(false);
    
    int test_case;
    cin >> test_case;
    
    for(int i=0; i<test_case; i++){
      solve();
    }
	return 0;
}