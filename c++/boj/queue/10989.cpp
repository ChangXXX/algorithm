#include <bits/stdc++.h>
using namespace std;

void solve(){
  int n, input;
  cin >> n;
  unordered_map<int, int> m;
  for(int i=0; i<n; i++){
    cin >> input;
    m[input]++;
  }
  vector<pair<int,int>> v(m.begin(), m.end());
  m.clear();
  sort(v.begin(), v.end());

  for(auto it : v){
    for(int i=0; i<it.second; i++)
      cout << it.first << "\n";
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