#include <bits/stdc++.h>
using namespace std;
int dp[1000001];

void solve(int x){
    for(int i=2; i<=x; i++){
        dp[i] = dp[i - 1] + 1;
        if(i % 2 == 0){
            dp[i] = min(dp[i], dp[i/2] + 1);
        }
        if(i % 3 == 0){
            dp[i] = min(dp[i], dp[i/3] + 1);
        }
    }
    cout << dp[x] << endl;
}

int main(){
    cin.tie(nullptr);
    cout.tie(nullptr);
    ios_base::sync_with_stdio(false);
    
    int x;
    cin >> x;
    
    memset(dp, 0, sizeof(dp));
    solve(x);
    return 0;
}