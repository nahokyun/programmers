#include <string>
#include <vector>
#include<algorithm>
#include<iostream>
#include<queue>


using namespace std;
int dx[4]={0,0,-1,1};
int dy[4]={-1,1,0,0};
int check[101][101];
int sum=0;

void bfs(int y,int x,vector<string> maps){
    queue<pair<int,int>> q;
    q.push({y,x});
    int maxx=maps[0].size();
    int maxy=maps.size();
    sum=0;
    
    while(!q.empty()){
        int cur_x=q.front().second;
        int cur_y=q.front().first;

        sum+=maps[cur_y][cur_x]-'0';

        q.pop();
        
        for(int i=0;i<4;i++){
            int cmp_x=cur_x+dx[i];
            int cmp_y=cur_y+dy[i];
            
            if(cmp_x>=0&&cmp_x<maxx&&cmp_y>=0&&cmp_y<maxy
               &&check[cmp_y][cmp_x]!=-1&&maps[cmp_y][cmp_x]!='X'){
                q.push({cmp_y,cmp_x});
                check[cmp_y][cmp_x]=-1;
            }
        }
    }

}

vector<int> solution(vector<string> maps) {
    vector<int> answer;
    int maxx=maps[0].size();
    int maxy=maps.size();
    
    for(int i=0;i<maxy;i++){
        for(int j=0;j<maxx;j++){
            if(maps[i][j]=='X'){
                check[i][j]=-1;
                continue;
            }
            if(check[i][j]==0){
                check[i][j]=-1;
                bfs(i,j,maps);
            }
            if(sum!=0)
                answer.push_back(sum);
            sum=0;
        }  
    }
    if(answer.size()!=0)
        sort(answer.begin(),answer.end());
    else
        answer.push_back(-1);
    
    return answer;
}