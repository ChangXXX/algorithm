#include <bits/stdc++.h>
using namespace std;

void solution(string numbers) {
    int sum1 = 0;
    int sum2 = 0;

    for(int i=0; i<numbers.length()/2; i++)
        sum1 += numbers[i];

    for(int i=numbers.length()/2; i<numbers.length(); i++)
        sum2 += numbers[i];

    if(sum1 == sum2) cout << "LUCKY" << endl;
    else cout << "READY" << endl;
}

int main(int argc, char** argv){
    cin.tie(nullptr);
    cout.tie(nullptr);
    ios_base::sync_with_stdio(false);

    string input;
    cin >> input;

    solution(input);

	return 0;
}