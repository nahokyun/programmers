#include <string>
#include <vector>
#include <cstring>
#include <iostream>
#include<algorithm>

using namespace std;
bool flag[101];
bool main_flag[101];
int choice(int i,vector<int> cards){
    int idx=i;
    vector<int> v;
    while(flag[cards[idx]]==false){
        flag[cards[idx]]=true;
        v.push_back(cards[idx]);
        idx=cards[idx]-1;
        // cout<<cards[idx]<<" ";
    }
    //cout<<endl;
    
    return v.size();
}

int solution(vector<int> cards) {
    int answer = 0;
    vector<int> szv;
    szv.push_back(0);
    for(int i=0;i<cards.size();i++){
        
        //memset(flag,false,sizeof(flag));
        int sz=0;
        if(!flag[cards[i]])
            sz=choice(i,cards);
        if(sz!=0)
            szv.push_back(sz);
        
        
    }
    sort(szv.begin(),szv.end());
    
    // for(int i=0;i<szv.size();i++){
    //     cout<<szv[i]<<" ";
    // }
    
    answer=szv[szv.size()-1]*szv[szv.size()-2];
    
    return answer;
}