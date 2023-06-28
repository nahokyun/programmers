#include <string>
#include <vector>
#include<iostream>

using namespace std;

int s[1000001];

int solution(vector<int> elements) {
    int answer = 0;
    int sz=elements.size();
    for(int i=0;i<sz;i++){
        if(s[elements[i]]==0){
            s[elements[i]]++;
        }
    }
    
    for(int i=1;i<=sz;i++){
        int begin=0;
        int end=i;
        
        while(begin!=sz){
            int sum=0;
            for(int j=begin;j<end;j++){
                sum+=elements[j%sz];
            }
            begin++;
            end++;
            if(s[sum]==0){
                s[sum]++;
            }
        }
    }
    
    for(int i=0;i<1000001;i++){
        if(s[i]!=0){
            answer++;
        }
    }
    
    return answer;
}