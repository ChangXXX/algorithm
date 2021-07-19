#include <bits/stdc++.h>
using namespace std;

void solve(){
    string input;
    int left = 0, right = 0;
    char punch = '@';

    cin >> input;

    int pos = input.find("(^0^)");

    for(int i=0; i<pos; i++) if(input[i] == punch) left++;
    for(int i=pos+4; i<input.length(); i++) if(input[i] == punch) right++;

    cout << left << " " << right << endl;
}

int main(int argc, char** argv)
{
    cin.tie(nullptr);
    cout.tie(nullptr);
    ios_base::sync_with_stdio(false);
    
	solve();

	return 0;//Your program should return 0 on normal termination.
}