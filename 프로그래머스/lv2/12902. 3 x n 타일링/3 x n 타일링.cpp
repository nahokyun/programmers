#include <string>
#include <vector>

using namespace std;

unsigned long long dp[5001];

int solution(int n) {
    
    int answer = 0;
    dp[2]=3;
    
    for(int i=4;i<=n;i++){
        if(i%2==1)
            dp[i]=0;
        else{
            for(int j=2;j<i;j=j+2){
                if(j==2)
                    dp[i]=(dp[i]+dp[i-j]*3)%1000000007;
                else
                    dp[i]=(dp[i]+dp[i-j]*2)%1000000007;
            }
            dp[i]=(dp[i]+2)%1000000007;
            
        }
    }
    answer=dp[n];
    return answer;
}