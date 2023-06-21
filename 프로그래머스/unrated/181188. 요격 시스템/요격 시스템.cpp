#include <string>
#include <vector>
#include<iostream>
#include<algorithm>

using namespace std;



int solution(vector<vector<int>> targets) {
    int answer = 1;
    sort(targets.begin(),targets.end());
    int ed=targets[0][1];
    
    for(int i=1;i<targets.size();i++){
        if(ed>targets[i][0]&&ed<=targets[i][1]){
            continue;
        }else if(ed>targets[i][0]&&ed>targets[i][1]){
            ed=targets[i][1];
            continue;
        }
        else if(ed<=targets[i][0]){
            ed=targets[i][1];
        }
        answer++;
    }
    
    
    
    return answer;
}