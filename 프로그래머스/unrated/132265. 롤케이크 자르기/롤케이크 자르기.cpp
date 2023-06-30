#include <string>
#include <vector>
#include<iostream>

using namespace std;

bool flag[1000001];//정방향으로 셀때 플래그
int dp[1000001];
bool i_flag[1000001];//역방향으로 셀때 플래그
int i_dp[1000001];
int solution(vector<int> topping) {
    int answer = 0;
    if(topping.size()==1)
        return answer;
    dp[0]=1;
    flag[topping[0]]=true;
    for(int i=1;i<topping.size();i++){
        if(flag[topping[i]]==false){
            flag[topping[i]]=true;
            dp[i]=dp[i-1]+1;
        }else{
            dp[i]=dp[i-1];
        }
    }
    // for(int i=0;i<topping.size();i++){
    //     cout<<dp[i]<<" ";
    // }
    //cout<<endl;
    i_dp[topping.size()-1]=1;
    i_flag[topping[topping.size()-1]]=true;
    for(int i=topping.size()-2;i>=0;i--){
        if(i_flag[topping[i]]==false){
            i_flag[topping[i]]=true;
            i_dp[i]=i_dp[i+1]+1;
            //cout<<topping[i]<<"는 새로운 원소라 "<<i<<"번 인덱스는 "<<i_dp[i]<<endl; 
        }else{
            i_dp[i]=i_dp[i+1];
        }
    }
    // for(int i=0;i<topping.size();i++){
    //     cout<<i_dp[i]<<" ";
    // }
    
    for(int i=0;i<topping.size()-1;i++){
        if(dp[i]==i_dp[i+1])
            answer++;
    }
    
    
    return answer;
}