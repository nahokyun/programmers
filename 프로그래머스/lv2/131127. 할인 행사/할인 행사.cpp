#include <string>
#include <vector>
#include<iostream>
#include <map>

using namespace std;

int solution(vector<string> want, vector<int> number, vector<string> discount) {
    int answer = 0;
    
    int allcount=10;
    
    

    for(int i=0;i<discount.size()-allcount+1;i++){
        vector<int> tmpnumber;
        map<string,int> tmp;
        for(int j=0;j<number.size();j++){
            tmp[want[j]]=number[j];
        }
        
        for(int j=0;j<10;j++){
            if(tmp.count(discount[i+j])){//해당 키가 있으면
                tmp[discount[i+j]]--;
            }else break;
        }
        
        bool flag=false;
        for(int j=0;j<want.size();j++){//tmp의 키값에 대한 value가 모두 0이 아닌경우를 탐색
            if(tmp[want[j]]!=0)
                flag=true;
        }
        
        if(flag)
            continue;
        else{
            answer++;
            //cout<<i<<" ";
        }
    }
    
    
    return answer;
}