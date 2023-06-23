#include <string>
#include <vector>
#include<iostream>
#include<queue>

using namespace std;

bool flag[101][101];
char map[101][101];
int dp[101][101];
int dx[4]={-1,0,1,0};
int dy[4]={0,1,0,-1};

void bfs(int x,int y,int l,int l2){
    queue<pair<int,int>> q;
    q.push({x,y});
    
    while(!q.empty()){
        int curx=q.front().first;
        int cury=q.front().second;
        flag[cury][curx]=true;
        q.pop();
        
        for(int i=0;i<4;i++){
            int cmpx = curx;
            int cmpy = cury;

            while (1) {
                cmpx = cmpx + dx[i];
                cmpy = cmpy + dy[i];
                if (cmpx >= 0 && cmpx < l && cmpy >= 0 && cmpy < l2 && map[cmpy][cmpx] != 'D') {
                    continue;
                }
                cmpx -= dx[i];
                cmpy -= dy[i];
                break;
            }
            if(cmpx>=0&&cmpx<l&&cmpy>=0&&cmpy<l2&&map[cmpy][cmpx]!='D'){
                if(!flag[cmpy][cmpx]||dp[cmpy][cmpx]>dp[cury][curx]+1){
                    dp[cmpy][cmpx]=dp[cury][curx]+1;
                    q.push({cmpx,cmpy});
                    flag[cmpy][cmpx]=true;
                }
            }
        }
        
        
    }
    
}

int solution(vector<string> board) {
    int answer = 0;
    int goalx=0;
    int goaly=0;
    int stx=0;
    int sty=0;
    for(int i=0;i<board.size();i++){
        for(int j=0;j<board[0].size();j++){
            if(board[i][j]=='R'){
                stx=j;
                sty=i;
            }else if(board[i][j]=='G'){
                goalx=j;
                goaly=i;
            }
            map[i][j]=board[i][j];
        }
    }
    
    for (int i = 0; i < 101; i++) {
        for (int j = 0; j < 101; j++) {
            dp[i][j] = 1000000;
        }
    }
    dp[sty][stx] = 0;
    
    bfs(stx,sty,board[0].size(),board.size());

    if(dp[goaly][goalx]==1000000){
        answer=-1;
    }else{
        answer=dp[goaly][goalx];
    }
    return answer;
}