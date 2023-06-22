#include <string>
#include <vector>
#include <iostream>

using namespace std;
vector<int> result[3];

int solution(vector<int> picks, vector<string> minerals) {
    int answer = 0;
    for(int i=0;i<minerals.size();i=i+5){
        int s_score=0;
        int i_score=0;
        int d_score=0;
        for(int j=0;j<5&&i+j<minerals.size();j++){
            if(minerals[i+j]=="diamond"){
                s_score+=25;
                i_score+=5;
                d_score+=1;
            }
            if(minerals[i+j]=="iron"){
                s_score+=5;
                i_score+=1;
                d_score+=1;
            }
            if(minerals[i+j]=="stone"){
                s_score+=1;
                i_score+=1;
                d_score+=1;
            }
        }
        result[0].push_back(d_score);
        result[1].push_back(i_score);
        result[2].push_back(s_score);
    }
    bool flag=true;
    int counttool=0;
    for(int i=0;i<3;i++){
        counttool+=picks[i];
    }
    if(counttool<result[0].size()){   
        result[0].erase(result[0].begin()+counttool,result[0].end());
        result[1].erase(result[1].begin()+counttool,result[1].end());
        result[2].erase(result[2].begin()+counttool,result[2].end());
        
    }
    
    while(flag){
        int maxx=0;
        int maxidx=0;
        
        for(int i=0;i<result[2].size();i++){
            if(result[2][i]>maxx){
                maxx=result[2][i];
                maxidx=i;
            }
        }//점수 최댓값 탐색완료
        

        for(int i=0;i<3;i++){
            if(picks[i]!=0){
                answer+=result[i][maxidx];
                picks[i]--;
                break;
            }
        }//가지고 있는 가장 좋은 곡괭이로 캤을때로 점수 증가
        
        for(int i=0;i<3;i++){
            result[i].erase(result[i].begin()+maxidx);
        }//다 캐진 광물들 제거
        

        if((!picks[0]&&!picks[1]&&!picks[2])||result[0].size()==0)//곡괭이를 모두 사용했거나 광물이 모두 캐졌으면 탈출조건 만족
            flag=false;
    }
    
    
    
    return answer;
}