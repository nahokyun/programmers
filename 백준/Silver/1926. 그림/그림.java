import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        int[][] map=new int[n][m];
        boolean[][] visited=new boolean[n][m];
        int max=0;
        int count=0;
        
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }//end of input

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]&&map[i][j]==1){
                    max=Math.max(max,bfs(i,j,map,visited));
                    count++;
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        sb.append(count).append('\n').append(max);
        
        System.out.println(sb);
        
    }//end of main
    
    public static int bfs(int y,int x,int[][] map, boolean[][] visited){
        Queue<int[]> q=new ArrayDeque<>();
        q.add(new int[]{y,x});
        visited[y][x]=true;
        int count=0;
        
        while(!q.isEmpty()){
            int[] cur=q.poll();
            count++;
            
            for(int i=0;i<4;i++){
                int cmpX=cur[1]+dx[i];
                int cmpY=cur[0]+dy[i];
                if(cmpX>=0&&cmpX<m&&cmpY>=0&&cmpY<n
                      &&map[cmpY][cmpX]==1&&!visited[cmpY][cmpX]){
                    q.add(new int[]{cmpY,cmpX});
                    visited[cmpY][cmpX]=true;
                }
            }
        }
        
        return count;
    }
}
