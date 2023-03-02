#include <string>
#include <vector>
#include<iostream>
using namespace std;

int check(vector<int> lottos, vector<int> win_nums){
    int lsize=lottos.size();
    int wsize=win_nums.size();
    int count=0;
    for(int i=0;i<lsize;i++){
        for(int j=0;j<wsize;j++){
            if(lottos[i]==win_nums[j])
                count++;
        }
    }
    return count;
}
int check_0(vector<int> lottos){
    int count=0;
    for(int i=0;i<lottos.size();i++){
        if(lottos[i]==0)
            count++;
    }
    return count;
}
int result(int correct){
    switch(correct){
        case 2:
            return 5;
        case 3:
            return 4;
        case 4:
            return 3;
        case 5:
            return 2;
        case 6:
            return 1;
        default:
            return 6;
    }
}

vector<int> solution(vector<int> lottos, vector<int> win_nums) {
    vector<int> answer;
    //일치하는 숫자의 개수를 체크하는 함수
    int count=check(lottos,win_nums);
    //0의 개수를 체크하는 함수
    int count0=check_0(lottos);
    
    //0을 맞았다고 가정했을때 등수
    int correct=count+count0;
    //0이 틀렸다고 가정했을때 등수
    int incorrect=count;
    
    answer.push_back(result(correct));
    answer.push_back(result(incorrect));
    
    
    return answer;
}