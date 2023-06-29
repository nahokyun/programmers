#include <string>
#include <iostream>
#include <vector>

using namespace std;

vector<double> solution(int k, vector<vector<int>> ranges) {
    vector<double> answer;
    vector<double> v;
    vector<double> b;//넓이 저장 백터
    double e=k;
    while(k!=1){
        v.push_back(k);
        if(k%2==0){
            k=k/2;
        }else{
            k=k*3+1;
        }
    }
    v.push_back(k);
    //cout<<v.size()<<endl;
    // for(int i=0;i<v.size();i++){
    //     cout<<v[i]<<" ";
    // }
    
    for(int i=0;i<v.size()-1;i++){
        b.push_back((v[i]+v[i+1])/2);
    }//좌표별 넓이를 백터에 저장
    for(int i=0;i<b.size();i++){
        cout<<"b["<<i<<"]="<<b[i]<<" ";
    }
    cout<<endl;
    
     // vector<int> c;
     // c.push_back(3);
     // c.push_back(-1);
     // ranges.push_back(c);

    for(int i=0;i<ranges.size();i++){
        int begin=ranges[i][0];
        int end=v.size()+ranges[i][1]-1;
        cout<<"i="<<i<<" begin="<<begin<<", end="<<end<<endl;
        
        if(begin==end){
            answer.push_back(0.0);
            continue;
        }else if(end<begin){
            answer.push_back(-1.0);
            continue;
        }
        
        double sum=0;
        for(int j=begin;j<end;j++){
            sum+=b[j];
        }
        answer.push_back(1.0*sum);
    }
    return answer;
}