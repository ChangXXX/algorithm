#include <bits/stdc++.h>
using namespace std;

void solve(){
  vector<string> input;
  vector<string> soundArray;
  string sound;

  getline(cin, sound);
  istringstream org(sound);
  string tmp;
  
  while(getline(org, tmp, ' ')){
    soundArray.push_back(tmp);
  }

  while(true){ // 동물 소리 입력받기
    getline(cin, tmp);
    if(tmp == "what does the fox say?") break;

    if(tmp.find("goes") != string::npos){
      input.push_back(tmp.substr(tmp.find("goes")+5));
    }
  }

  for(int i=0; i<input.size(); i++){
    soundArray.erase(remove(soundArray.begin(), soundArray.end(), input[i]), soundArray.end());
  }
  for(int i=0; i<soundArray.size(); i++){
    cout << soundArray[i] << " ";
  }
  cout << endl;
}

int main(int argc, char** argv)
{
  cin.tie(nullptr);
  cout.tie(nullptr);
  ios_base::sync_with_stdio(false);
  
  int T;
  cin >> T;
  cin.ignore();
  for(int i=0; i<T; i++) solve();

	return 0;
}