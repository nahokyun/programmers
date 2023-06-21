#include <string>
#include <vector>
#include<cmath>
#include<algorithm>
#include<iostream>

using namespace std;

long long circle(long long r,long long x){
    long long l=1LL*r*r;
    long long t=floor(sqrt(l-x*x));
    
    return t;
}

unsigned long long solution(int r1, int r2) {
    long long count=0;
    long long little=0;
    long long big=0;
    long long answer = 0;

    for(long long i=1;i<1LL*r1;i++){
        long long maxx=circle(1LL*r1,i);
        long long ii=i*i;
        long long rr=1LL*r1*r1;
        if(maxx*maxx+ii==rr){
            count++;
        }
        little+=maxx;
        //cout<<"현재 x1 : "<<i<<"현재 센 점 개수"<<maxx<<endl;
    }
    //cout<<little<<endl;
    
    for(long long i=1;i<1LL*r2;i++){
        long long maxx=circle(1LL*r2,i);
        big+=maxx;
        //cout<<"현재 x : "<<i<<"현재 센 점 개수"<<maxx<<endl;
    }
    //cout<<big<<endl;
    //cout<<"count : "<<count;
    answer=big-little+count+1LL*r2-1LL*r1+1LL;
    return answer*4;
}