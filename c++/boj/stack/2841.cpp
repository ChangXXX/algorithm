#include <bits/stdc++.h>
using namespace std;

void solve(){
  int N, P;
  cin >> N >> P;

  stack<int> s[8];
  int res = 0;

  for(int i=0; i<N; i++){
    int line, flat;
    cin >> line >> flat;

    if(s[line-1].empty()){
      s[line-1].push(flat);
      res++;
    } else{
      if(flat > s[line-1].top()){
        s[line-1].push(flat);
        res++;
      } else if(flat == s[line-1].top()){
        continue;
      } else if(flat < s[line-1].top()){
        while(flat < s[line-1].top()){
          s[line-1].pop();
          res++;
          if(s[line-1].empty()) break;
        }
        if(!s[line-1].empty() && flat == s[line-1].top()) continue;
        s[line-1].push(flat);
        res++;
      }
    }
  }

  cout << res << endl;
}

int main(int argc, char** argv)
{
  cin.tie(nullptr);
  cout.tie(nullptr);
  ios_base::sync_with_stdio(false);

  solve();

	return 0;
}