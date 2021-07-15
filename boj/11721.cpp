#include <bits/stdc++.h>
using namespace std;

void solve(string input){
    for(int i=0; i < input.size(); i++){
        if(i%10 == 0 && i != 0) cout << endl;
        cout << input.at(i);
    }
}

int main(){
    cin.tie(nullptr);
    cout.tie(nullptr);
    ios_base::sync_with_stdio(false);
    
    string input;
    cin >> input;
    
    solve(input);
    
    return 0;
}