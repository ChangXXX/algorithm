#include <bits/stdc++.h>
using namespace std;

bool cmp(const string &a, const string &b){
  if(a.length() != b.length()) return a.length()<b.length();
  else{
    return a<b;
  }
}

void solve(){
  int n; cin >> n;

  vector<string> input;
  for(int i=0; i<n; i++) {
    string tmp;
    cin >> tmp;
    if(find(input.begin(), input.end(), tmp) == input.end()){
      input.push_back(tmp);
    }
  }
  sort(input.begin(), input.end(), cmp);

  for(int i=0; i<input.size(); i++)  cout << input[i] << '\n';
}

int main(int argc, char** argv)
{
  cin.tie(nullptr);
  cout.tie(nullptr);
  ios_base::sync_with_stdio(false);

  solve();
  
	return 0;
}