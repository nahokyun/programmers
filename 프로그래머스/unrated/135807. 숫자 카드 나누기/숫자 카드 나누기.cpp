#include <string>
#include <vector>
#include<algorithm>

using namespace std;

int solution(vector<int> arrayA, vector<int> arrayB) {
    int answer = 0;
    sort(arrayA.begin(),arrayA.end());
    sort(arrayB.begin(),arrayB.end());
    vector<int> va;
    for(int i=arrayA[0];i>=2;i--){
        bool flag=false;
        
        for(int j=0;j<arrayA.size();j++){
            if(arrayA[j]%i!=0){
                break;
            }
            if(j==arrayA.size()-1&&arrayA[j]%i==0){
                flag=true;
            }
        }
        if(flag){//현재 i가 arrayA를 다 나눌수 있을때
            va.push_back(i);
            break;
        }
    }
    int maxa=0;
    for(int i=0;i<va.size();i++){
        bool flag=false;
        for(int j=0;j<arrayB.size();j++){
            if(arrayB[j]%va[i]==0){
                flag=true;
                break;
            }
        }
        if(flag)//va[i]중에 arrayB의 원소가 나누어 떨어지는 경우 다음걸로 스킵
            continue;
        else{//어차피 큰 원소가 앞에있으므로 다 나누어떨어지지않았을 때 바로 break
            maxa=va[i];
            break;
        }
    }
    
    
    
    
    
    
    
    vector<int> vb;
    for(int i=arrayB[0];i>=2;i--){
        bool flag=false;
        
        for(int j=0;j<arrayB.size();j++){
            if(arrayB[j]%i!=0){
                break;
            }
            if(j==arrayB.size()-1&&arrayB[j]%i==0){
                flag=true;
            }
        }
        if(flag){//현재 i가 arrayA를 다 나눌수 있을때
            vb.push_back(i);
            break;
        }
    }
    int maxb=0;
    for(int i=0;i<vb.size();i++){
        bool flag=false;
        for(int j=0;j<arrayA.size();j++){
            if(arrayA[j]%vb[i]==0){
                flag=true;
                break;
            }
        }
        if(flag)//vb[i]중에 arrayB의 원소가 나누어 떨어지는 경우 다음걸로 스킵
            continue;
        else{//어차피 큰 원소가 앞에있으므로 다 나누어떨어지지않았을 때 바로 break
            maxb=vb[i];
            break;
        }
    }    
    if(maxa>maxb)
        answer=maxa;
    else
        answer=maxb;
    
    return answer;
}