#include <string>
#include <vector>
#include<iostream>

using namespace std;

vector<int> solution(vector<int> sequence, int k) {
    vector<int> answer;
    
    for(int i=0;i<sequence.size();i++){
        if(sequence[i]>k){
            sequence.resize(i);
        }
    }
    int sum=sequence[0];
    int st=0;
    int ed=0;
    int min=100000000;
    int mined=0;
    int minst=0;
    while(st<=ed&&ed<sequence.size()){
        if(sum<k){
            ed++;
            sum+=sequence[ed];
            continue;
        }else if(sum>k){
            sum-=sequence[st];
            st++;
        }else {
            int len=ed-st;
            if(min>len){
                mined=ed;
                minst=st;
                min=len;
            }else if(min==len){
                if(minst>st){
                    minst=st;
                    mined=ed;
                }
            }
            sum-=sequence[st];
            st++;
        }
    }
    answer.push_back(minst);
    answer.push_back(mined);

    
    // bool flag=true;
    // int length=1;
    // while(flag){
    //     for(int i=0;i<sequence.size()-length+1;i++){
    //         int sum=0;
    //         for(int j=0;j<length;j++){//length만큼 길이의 수열 합
    //             sum+=sequence[i+j];
    //         }
    //         if(sum==k){
    //             answer.push_back(i);
    //             answer.push_back(i+length-1);
    //             flag=false;
    //             break;
    //         }
    //     }
    //     length++;
    // }
    
    
    
    
    return answer;
}