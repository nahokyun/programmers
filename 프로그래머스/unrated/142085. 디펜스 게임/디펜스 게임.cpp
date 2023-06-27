#include <string>
#include <vector>
#include<iostream>
#include<queue>

using namespace std;

int solution(int n, int k, vector<int> enemy) {
    int answer = 0;
    priority_queue<int,vector<int>,greater<int>> pq;
    
    if(k<=enemy.size()){
        for(int i=0;i<k;i++){
            pq.push(enemy[i]);
        }
    }else{
        answer=enemy.size();
        return answer;
    }
    int endpoint=k;
    int i=k;
    while(n>=0){
        endpoint=i;
        if(i>=enemy.size()){
            break;
        }
        if(pq.top()<enemy[i]){
            n-=pq.top();
            pq.pop();
            pq.push(enemy[i]);
        }else{
            n-=enemy[i];
        }
        i++;
    }
    
    answer=endpoint;
    
    return answer;
}