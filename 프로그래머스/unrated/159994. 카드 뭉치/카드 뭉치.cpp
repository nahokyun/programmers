#include <string>
#include <vector>
#include<iostream>

using namespace std;

string solution(vector<string> cards1, vector<string> cards2, vector<string> goal) {
    string answer = "Yes";
    int cards1_idx=0;
    int cards2_idx=0;
    
    int size=goal.size();
    
    for(int i=0;i<size;i++){
        string cur=goal[i];
        if(cards1[cards1_idx]==goal[i]){
            cards1_idx++;
            continue;
        }
        if(cards2[cards2_idx]==goal[i]){
            cards2_idx++;
            continue;
        }
        answer="No";
    }
    
    return answer;
}