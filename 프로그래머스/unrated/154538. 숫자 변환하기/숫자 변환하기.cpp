#include <string>
#include <vector>
#include<iostream>
#include<queue>

using namespace std;


int dp[1000001];
int dx[2]={2,3};

int solution(int x, int y, int n) {
    int answer = 0;
    
    for(int i=0;i<1000001;i++){
        dp[i]=1000001;
    }
    dp[x]=0;
    queue<pair<int,int>> q;
    q.push({x,0});
    while(!q.empty()){
        int cur=q.front().first;
        int op=q.front().second;
        q.pop();
        for(int i=0;i<3;i++){
            int cmp=cur;
            if(i==2){
                cmp+=n;
            }else{
                cmp*=dx[i];
            }
            if(cmp>y)
                break;
            
            if(cmp==y){
                if(dp[y]>op+1)
                    dp[y]=op+1;
            }else{
                if(dp[cmp]>op+1){
                    dp[cmp]=op+1;
                    q.push({cmp,op+1});
                }
            }
            
        }
        
    }
    if(dp[y]==1000001)
        answer=-1;
    else
        answer=dp[y];
    
    return answer;
}