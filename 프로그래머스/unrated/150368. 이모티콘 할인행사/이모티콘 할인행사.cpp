#include <string>
#include <vector>
#include<iostream>
using namespace std;

int dc[4]={10,20,30,40};
int maxservice=0;
int maxbenefit=0;

void dfs(vector<int> dis,vector<int> emoticons,vector<vector<int>> users){
    if(dis.size()==emoticons.size()){
        vector<int> tmp;
        for(int i=0;i<dis.size();i++){
            tmp.push_back(emoticons[i]*(100-dis[i])/100);
        }
        int service=0;
        int benefit=0;
        for(int i=0;i<users.size();i++){
            int sum=0;
            for(int j=0;j<dis.size();j++){
                if(users[i][0]<=dis[j]){
                    sum+=tmp[j];
                }
            }//i 고객이 기준에 따라 구매했을때 지불해야하는값 : sum
            if(sum>=users[i][1]){
                service++; 
            }else{//일일이 사야할때 가격이 곧 매출
                benefit+=sum;
            }
        }//모든 고객에 대하여 다 탐색 마친 상태 
        if(maxservice<service){
            maxbenefit=benefit;
            maxservice=service;
            
        }else if(maxservice==service){
            if(maxbenefit<benefit)
                maxbenefit=benefit;
        }
        
    }else{
        for(int i=0;i<4;i++){
            dis.push_back(dc[i]);
            dfs(dis,emoticons,users);
            dis.pop_back();
        }
    }
}


vector<int> solution(vector<vector<int>> users, vector<int> emoticons) {
    vector<int> answer;
    vector<int> dis;
    dfs(dis,emoticons,users);
    
    answer.push_back(maxservice);
    answer.push_back(maxbenefit);
    return answer;
}