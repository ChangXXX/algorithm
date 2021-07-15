#include <bits/stdc++.h>
using namespace std;

void solve(int r, string s) {
    string res = "";
    for(int i=0; i<s.size(); i++){
        for(int j=0; j<r; j++){
            res += s[i];
        }
    }
    cout << res << endl;
}

int main(int argc, char** argv)
{
    cin.tie(nullptr);
    cout.tie(nullptr);
    ios_base::sync_with_stdio(false);
    int T;
    cin >> T;
    for(int i=0; i<T; i++){
        int r;
        string s;
        cin >> r >> s;
        solve(r, s);
    }
    return 0;
}