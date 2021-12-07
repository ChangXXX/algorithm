#include <bits/stdc++.h>
using namespace std;

string findString;
int res;
void solve(){
  string input;
  cin >> input;
  string tmp = "";
  tmp += input.substr(input.length() - findString.length(), findString.length());
  tmp += input;

  if(tmp.find(findString) != string::npos){
    res++;
  }
}

int main(int argc, char** argv)
{
  cin.tie(nullptr);
  cout.tie(nullptr);
  ios_base::sync_with_stdio(false);

  cin >> findString;
  int T;
  cin >> T;

  res = 0;
  for(int i=0; i<T; i++) {
    solve();
  }
  cout << res << endl;

	return 0;
}