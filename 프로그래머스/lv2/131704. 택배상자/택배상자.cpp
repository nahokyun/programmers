#include <string>
#include <vector>
#include<stack>
#include<iostream>

using namespace std;

int solution(vector<int> order) {
    int answer = 0;
    stack<int> temp;
    int idx=0;
    
    for(int i=1;i<=order.size();i++){
        
        if(order[idx]==i){
            answer++;
            idx++;
            continue;
        }
        if(!temp.empty()){
            if(temp.top()==order[idx]){
                answer++;
                idx++;
                temp.pop();
                i--;
                continue;
            }
        }
        temp.push(i);
    }
    
    if(!temp.empty()){
        while(!temp.empty()){
            if(temp.top()==order[idx]){
                idx++;
                temp.pop();
                answer++;
            }else
                break;
        }
    }
    
    
    
    return answer;
}