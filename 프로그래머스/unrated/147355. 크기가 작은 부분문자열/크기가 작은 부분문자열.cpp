#include <string>
#include <vector>
#include<iostream>

using namespace std;

int solution(string t, string p) {
    int answer = 0;
    //int pvalue=stoi(p);
    int psz=p.size();
    int tsz=t.size();
    vector<string> v;
    for(int i=0;i<tsz-psz+1;i++){
        string tmp=t.substr(i,psz);
        v.push_back(tmp);
    }
    
    for(int i=0;i<v.size();i++){
        if(v[i]<=p)
            answer++;
    }
    
    
    return answer;
}