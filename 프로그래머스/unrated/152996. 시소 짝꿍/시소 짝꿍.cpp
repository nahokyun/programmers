#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

long long dp[1001];


long long solution(vector<int> weights) {
    long long answer = 0;
    for(int i=0;i<weights.size();i++){
        dp[weights[i]]++;
    }
    for(int i=0;i<weights.size();i++){
        long long tmp=(1LL)*weights[i];
        
        if(tmp%3==0&&dp[tmp/3*2]!=0){
            answer+=dp[tmp/3*2];
        }
        if(tmp%2==0&&dp[tmp/2]!=0){
            answer+=dp[tmp/2];
        }
        if(tmp%4==0&&dp[tmp/4*3]!=0){
            answer+=dp[tmp/4*3];
        }
    }
    for(int i=100;i<1001;i++){
        if(dp[i]>1){
            long long n=dp[i];
            answer+=(long long)(n*(n-1))/2;
        }
    }
    
    
    
    return answer;
}