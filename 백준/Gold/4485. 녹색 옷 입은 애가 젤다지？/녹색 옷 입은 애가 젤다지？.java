import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static class Point{
        int x;
        int y;
        Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n;
        StringBuilder sb=new StringBuilder();
        int idx=1;
        while((n=Integer.parseInt(br.readLine()))!=0){
            int[][] cave=new int[n][n];
            int[][] cost=new int[n][n];
            for(int i=0;i<n;i++){
                StringTokenizer st=new StringTokenizer(br.readLine());
                Arrays.fill(cost[i],10000000);
                for(int j=0;j<n;j++){
                    cave[i][j]=Integer.parseInt(st.nextToken());
                }
            }//end of input
            
            int[] dx={0,0,1,-1};
            int[] dy={1,-1,0,0};
            cost[0][0]=cave[0][0];
            Queue<Point> q=new ArrayDeque<>();
            q.add(new Point(0,0));
            while(!q.isEmpty()){
                Point cur=q.poll();
                
                for(int i=0;i<4;i++){
                    int cmpX=cur.x+dx[i];
                    int cmpY=cur.y+dy[i];
                    if(cmpX>=0&&cmpX<n&&cmpY>=0&&cmpY<n
                          &&cost[cmpY][cmpX]>cost[cur.y][cur.x]+cave[cmpY][cmpX]){
                        cost[cmpY][cmpX]=cost[cur.y][cur.x]+cave[cmpY][cmpX];
                        q.add(new Point(cmpX,cmpY));
                    }
                }
            }
            sb.append("Problem ").append(idx).append(": ").append(cost[n-1][n-1]).append('\n');
            idx++;
        }//end of testcase
        System.out.println(sb);
    }
}