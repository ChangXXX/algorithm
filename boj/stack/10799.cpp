#include <bits/stdc++.h>
using namespace std;

void solve(){
  string input;
  cin >> input;

  char s[100001];
  int pos = -1;
  int sum = 0;
  int line = 0;

  for(int i=0; i<input.length(); i++){
    if(input[i] == '('){
        line++;
        s[++pos] = input[i];
    }
    else if(input[i] == ')'){
      line--;
      if(s[pos] == '('){
        pos--;
        sum += line;
      } else if(s[pos] == ')'){
        pos--;
        sum += 1;
      }
      s[++pos] = input[i];
    }
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