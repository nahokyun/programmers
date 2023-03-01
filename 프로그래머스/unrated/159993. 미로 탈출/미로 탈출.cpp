#include <string>
#include <vector>
#include<iostream>
#include<queue>
using namespace std;

int movecountL=1000000;
int movecountE=1000000;
int dx[4]={0,0,-1,1};
int dy[4]={1,-1,0,0};
bool checkL[101][101];
bool checkE[101][101];

void findL_bfs(vector<string> maps,int startx,int starty){
    queue<pair<int,pair<int,int>>> q;
    
    q.push({0,{startx,starty}});
    int size=maps.size();
    int size2=maps[0].size();
    while(!q.empty()){
        int cur_distance=q.front().first;
        int cur_x=q.front().second.first;
        int cur_y=q.front().second.second;

        
        q.pop();
        for(int i=0;i<4;i++){
            int cmp_x=cur_x+dx[i];
            int cmp_y=cur_y+dy[i];
        
            if(checkL[cmp_y][cmp_x]!=true&&cmp_x>=0&&cmp_y>=0&&cmp_x<size2&&cmp_y<size){
                if(maps[cmp_y][cmp_x]=='X'){//벽일경우 큐에서 다음 좌표 확인
                    checkL[cmp_y][cmp_x]=true;
                    continue;
                }
                if(maps[cmp_y][cmp_x]=='L'){//레버 발견시 
                    movecountL=cur_distance+1;
                    return;

                }
                checkL[cmp_y][cmp_x]=true;
                q.push({cur_distance+1,{cmp_x,cmp_y}});
            }
        }
    }
}

void findE_bfs(vector<string> maps,int startx,int starty){
    queue<pair<int,pair<int,int>>> q;
    
    q.push({0,{startx,starty}});
    int size=maps.size();
    int size2=maps[0].size();
    
    while(!q.empty()){
        int cur_distance=q.front().first;
        int cur_x=q.front().second.first;
        int cur_y=q.front().second.second;
        
        
        q.pop();
        for(int i=0;i<4;i++){
            int cmp_x=cur_x+dx[i];
            int cmp_y=cur_y+dy[i];
        
            if(checkE[cmp_y][cmp_x]!=true&&cmp_x>=0&&cmp_y>=0&&cmp_x<size2&&cmp_y<size){
                if(maps[cmp_y][cmp_x]=='X'){ 
                    checkE[cmp_y][cmp_x]=true;
                    continue;
                }
                
                if(maps[cmp_y][cmp_x]=='E'){
                    movecountE=cur_distance+1;
                    return;
                }

                checkE[cmp_y][cmp_x]=true;
                q.push({cur_distance+1,{cmp_x,cmp_y}});
            }
        }
    }
}


int solution(vector<string> maps) {
    int answer = 0;
    int s_x=0;
    int s_y=0;
    int l_x=0;
    int l_y=0;
    int size=maps.size();
    int size2=maps[0].size();
    
    for(int i=0;i<size;i++){
        for(int j=0;j<size2;j++){
            if(maps[i][j]=='S'){//시작좌표
                s_x=j;
                s_y=i;
            }
            if(maps[i][j]=='L'){//레버좌표
                l_x=j;
                l_y=i;
            }
        }
    }
    findL_bfs(maps,s_x,s_y);
    findE_bfs(maps,l_x,l_y);

    if(movecountL!=1000000&&movecountE!=1000000)
        return movecountL+movecountE;
    else
        return -1;
}