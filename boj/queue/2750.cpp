#include <bits/stdc++.h>
using namespace std;

void solve(){
  int n;
  cin >> n;
  vector<int> v;
  for(int i=0; i<n; i++){
    int input;
    cin >> input;
    v.push_back(input);
  }
  sort(v.begin(), v.end());

  for(auto it : v) cout << it << "\n";
  
}

int main(int argc, char** argv)
{
  cin.tie(nullptr);
  cout.tie(nullptr);
  ios_base::sync_with_stdio(false);

  solve();

	return 0;
}