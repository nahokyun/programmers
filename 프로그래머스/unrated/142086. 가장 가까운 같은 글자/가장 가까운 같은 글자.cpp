#include <string>
#include <vector>
#include<iostream>

using namespace std;
vector<int> alpha(26,-1);

vector<int> solution(string s) {
    vector<int> answer;
    for(int i=0;i<s.size();i++){
        if(alpha[s[i]-'a']!=-1){//이미 나온적이 있는 문자
            answer.push_back(i-alpha[s[i]-'a']);
            alpha[s[i]-'a']=i;
        }
        else{
            alpha[s[i]-'a']=i;
            answer.push_back(-1);
        }
    }
    
    
    return answer;
}