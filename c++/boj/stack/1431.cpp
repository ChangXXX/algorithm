#include <bits/stdc++.h>
using namespace std;

bool cmp(const string &a, const string &b){
  if(a.length() != b.length()) return a.length()<b.length();
  else{
    int sumA = 0, sumB = 0;
    for(int i=0; i<a.length(); i++){
      if(a[i]-'0' >=1 && a[i]-'0' <= 9) sumA += a[i] -'0';
    }
    for(int i=0; i<b.length(); i++){
      if(b[i]-'0' >=1 && b[i]-'0' <= 9) sumB += b[i] -'0';
    }
    if(sumA!=sumB){
      return sumA < sumB;
    } else return a<b;
  }
}

void solve(){
  int n; cin >> n;

  vector<string> input(n);
  for(int i=0; i<n; i++) cin >> input[i];
  sort(input.begin(), input.end(), cmp);

  for(int i=0; i<n; i++) cout << input[i] << "\n";
}

int main(int argc, char** argv)
{
  cin.tie(nullptr);
  cout.tie(nullptr);
  ios_base::sync_with_stdio(false);

  solve();
  
	return 0;
}