#include <string>
#include <vector>
#include<algorithm>
#include<iostream>

using namespace std;
int t[10000001];//sort후 t[i]는 같은 개수인 원소 내림차순
int ct[10000001];//ct[i]는 i개 있는 원소의 개수


int solution(int k, vector<int> tangerine) {
    int answer = 0;
    for(int i=0;i<tangerine.size();i++){
        t[tangerine[i]]++;
    }
    sort(t,t+10000001,greater<int>());
    
    for(int i=0;t[i]!=0;i++){
        ct[t[i]]++;
    }
    int sum=0;
    for(int i=0;i<=k;i++){
        sum+=t[i];
        answer++;
        if(sum>=k)
            break;
    }
    
    
    // for(int i=0;i<5;i++){
    //     cout<<t[i]<<" ";
    // }
    // cout<<endl;
    // for(int i=0;i<5;i++){
    //     cout<<ct[i]<<" ";
    // }
    return answer;
}