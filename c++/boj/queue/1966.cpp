#include <bits/stdc++.h>
using namespace std;

void solve(){
  int n, m;
  cin >> n >> m; // n 문서 개수, m 찾고자하는 문서 첫 idx
  vector<pair<int, int>> q; // 첫 idx, priority

  for(int i = 1; i<=n; i++){
    int input;
    cin >> input; // 중요도
    q.push_back(make_pair(i, input));
  }

  int cnt = 1;
  while(!q.empty()){
    auto cur = q.front();
    int priority = cur.second;

    for(auto it : q){ // 정렬
      if(priority < it.second){
        q.push_back(cur);
        q.erase(q.begin());
        priority = 0;
        break;
      }
    }

    if(priority != 0){ // 정렬 후 위치 탐색
      if(cur.first == m+1){
        cout << cnt << endl;
        break;
      }
      q.erase(q.begin());
      cnt++;
    }
  }
}

int main(int argc, char** argv)
{
  cin.tie(nullptr);
  cout.tie(nullptr);
  ios_base::sync_with_stdio(false);

  int t;
  cin >> t;

  for(int i=0; i<t; i++) solve();

	return 0;
}