#include <bits/stdc++.h>
using namespace std;

void solve(string input) {
    string res = "";
    char reg[9] = {'C', 'A', 'M', 'B', 'R', 'I', 'D', 'G', 'E'};
    for(int i=0; i<input.size(); i++){
        auto it = find(begin(reg), end(reg), input[i]);
        if(it != end(reg)) continue;
        else res += input[i];
  }
    cout << res << endl;
}

int main(int argc, char** argv)
{
    cin.tie(nullptr);
    cout.tie(nullptr);
    ios_base::sync_with_stdio(false);
    
    string input;
    cin >> input;
    solve(input);
    
    return 0;
}