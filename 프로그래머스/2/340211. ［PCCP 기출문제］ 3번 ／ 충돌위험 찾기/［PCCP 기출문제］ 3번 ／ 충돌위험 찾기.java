import java.awt.Point;
import java.util.*;

class Solution {
    static int answer;
    static int x;
    public int solution(int[][] points, int[][] routes) {
        answer = 0;
        
        Set<Integer>[][] map=new Set[101][101];
        for(int i=1;i<101;i++){
            for(int j=1;j<101;j++){
                map[i][j]=new HashSet<Integer>();
            }
        }
        boolean[][][] flag=new boolean[101][101][20001];
        for(int i=0;i<routes.length;i++){
            x=1;
            //System.out.println(i+"번째 들어감");
            for(int j=1;j<routes[i].length;j++){
                Point start=new Point(points[routes[i][j-1]-1][1],points[routes[i][j-1]-1][0]);
                Point end=new Point(points[routes[i][j]-1][1],points[routes[i][j]-1][0]);
                if(j==1){
                    if(map[start.y][start.x].contains(0)&&!flag[start.y][start.x][0]){
                        //System.out.println("start.x : "+start.x+" start.y : "+start.y);
                        answer++;
                        flag[start.y][start.x][0]=true;
                    }else{
                        map[start.y][start.x].add(0);
                    }
                    
                }
                
                cal(start,end,map,flag);
                //System.out.println("다음 x 시작 : "+x);
                
            }
            
        }
        
        return answer;
    }
    
    private static void cal(Point start, Point end, Set<Integer>[][] map, boolean[][][] flag){
        
        //System.out.println("시작점:"+start.y+", "+start.x+" 끝점:"+end.y+", "+end.x);
        //가로길이 계산
        int garo=0;
        boolean garoPos=false;
        if(start.x<=end.x){//왼쪽에서 오른쪽으로 갈때
            garo=end.x-start.x;
            garoPos=true;
        }else{
            garo=start.x-end.x;
        }
        //세로길이 계산
        int sero=0;
        boolean seroPos=false;
        if(start.y<=end.y){//왼쪽에서 오른쪽으로 갈때
            sero=end.y-start.y;
            seroPos=true;
        }else{
            sero=start.y-end.y;
        }
        
        
        
        
        
        
        if(garoPos){
            if(seroPos){//가로증가 세로증가
                //System.out.println("가로+ 세로+");
                if(start.y!=end.y){
                    for(int j=start.y+1;j<=end.y;j++){
                        if(map[j][start.x].contains(x)&&!flag[j][start.x][x]){
                            //System.out.println("중복감지");
                            flag[j][start.x][x]=true;
                            answer++;
                        }else{
                            //System.out.println(j+", "+start.x+" 추가"+" x: "+x);
                            map[j][start.x].add(x);
                        }
                        x++;
                    }
                }
                
                if(start.x==end.x){
                    return;
                }
                
                for(int i=start.x+1;i<=end.x;i++){
                    if(map[end.y][i].contains(x)&&!flag[end.y][i][x]){
                        //System.out.println("중복감지");
                        flag[end.y][i][x]=true;
                        answer++;
                    }else{
                        //System.out.println(end.y+", "+i+" 추가"+" x: "+x);
                        map[end.y][i].add(x);
                    }
                    x++;
                }
            }
            else{//가로증가 세로감소
                if(start.y!=end.y){
                    //System.out.println("가로+ 세로-");
                    for(int j=start.y-1;j>=end.y;j--){
                        if(map[j][start.x].contains(x)&&!flag[j][start.x][x]){
                            //System.out.println("중복감지");
                            flag[j][start.x][x]=true;
                            answer++;
                        }else{
                            //System.out.println(j+", "+start.x+" 추가"+" x: "+x);
                            map[j][start.x].add(x);
                        }
                        x++;
                    }
                }
                
                if(start.x==end.x){
                    return;
                }
                
                for(int i=start.x+1;i<=end.x;i++){
                    if(map[end.y][i].contains(x)&&!flag[end.y][i][x]){
                        //System.out.println("중복감지");
                        flag[end.y][i][x]=true;
                        answer++;
                    }else{
                        //System.out.println(end.y+", "+i+" 추가"+" x: "+x);
                        map[end.y][i].add(x);
                    }
                    x++;
                } 
            }
        }else{
            if(seroPos){//가로감소 세로증가
                //System.out.println("가로- 세로+");
                if(start.y!=end.y){
                    for(int j=start.y+1;j<=end.y;j++){
                        if(map[j][start.x].contains(x)&&!flag[j][start.x][x]){
                            //System.out.println("중복감지");
                            flag[j][start.x][x]=true;
                            answer++;
                        }else{
                            //System.out.println(j+", "+start.x+" 추가"+" x: "+x);
                            map[j][start.x].add(x);
                        }
                        x++;
                    }
                }
                
                if(start.x==end.x){
                    return;
                }
                
                for(int i=start.x-1;i>=end.x;i--){
                    if(map[end.y][i].contains(x)&&!flag[end.y][i][x]){
                        //System.out.println("중복감지");
                        flag[end.y][i][x]=true;
                        answer++;
                    }else{
                        //System.out.println(end.y+", "+i+" 추가"+" x: "+x);
                        map[end.y][i].add(x);
                    }
                    x++;
                }
            }else{//가로감소 세로감소
                //System.out.println("가로- 세로-");
                if(start.y!=end.y){
                    for(int j=start.y-1;j>=end.y;j--){
                        if(map[j][start.x].contains(x)&&!flag[j][start.x][x]){
                            //System.out.println("중복감지");
                            flag[j][start.x][x]=true;
                            answer++;
                        }else{
                            //System.out.println(j+", "+start.x+" 추가"+" x: "+x);
                            map[j][start.x].add(x);
                        }
                        x++;
                    }
                }
                
                if(start.x==end.x){
                    return;
                }
                
                for(int i=start.x-1;i>=end.x;i--){
                    if(map[end.y][i].contains(x)&&!flag[end.y][i][x]){
                        //System.out.println("중복감지");
                        flag[end.y][i][x]=true;
                        answer++;
                    }else{
                        //System.out.println(end.y+", "+i+" 추가"+" x: "+x);
                        map[end.y][i].add(x);
                    }
                    x++;
                }
            }
        }
        
    }
}