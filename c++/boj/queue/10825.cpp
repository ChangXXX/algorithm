#include <bits/stdc++.h>
using namespace std;

bool cmp(pair<string, tuple<int, int, int>> a, pair<string, tuple<int, int, int>> b){
  int a_korean = get<0>(a.second);
  int a_english = get<1>(a.second);
  int a_math = get<2>(a.second);
  string a_name = a.first;

  int b_korean = get<0>(b.second);
  int b_english = get<1>(b.second);
  int b_math = get<2>(b.second);
  string b_name = b.first;

  if(a_korean == b_korean && a_english == b_english && a_math == b_math) return a_name < b_name;
  if(a_korean == b_korean && a_english == b_english) return a_math > b_math;
  if(a_korean == b_korean) return a_english < b_english;

  return a_korean > b_korean;
}

void solve(){
  int n;
  cin >> n;
  vector<pair<string, tuple<int, int, int>>> v;
  
  string name;
  int k, e, m;
  for(int i=0; i<n; i++){
    cin >> name >> k >> e >> m;
    pair p = make_pair(name, make_tuple(k, e, m));
    v.push_back(p);
  }

  sort(v.begin(), v.end(), cmp);
  for(auto it: v) cout << it.first << "\n";
}

int main(int argc, char** argv)
{
  cin.tie(nullptr);
  cout.tie(nullptr);
  ios_base::sync_with_stdio(false);

  solve();

	return 0;
}