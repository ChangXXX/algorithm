#include <bits/stdc++.h>
using namespace std;

void solution(string numbers) {
    string answer = "";
    int sum = 0;

    sort(numbers.begin(), numbers.end());

    for(int i=0; i<numbers.length(); i++){
        if(numbers[i] > 47 && numbers[i] < 58) sum += numbers[i] - '0';
        else answer += numbers[i];
    }
    answer += to_string(sum);

    cout << answer << endl;
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