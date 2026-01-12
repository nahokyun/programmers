import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int[] dx={0, 0, 1, -1};
    static int[] dy={1, -1, 0, 0};
    static int n;
    static int m;
    static int maxDist=0;
    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        char[][] map=new char[n][m];
        
        
        
        for(int i=0;i<n;i++){
            String input=br.readLine();
            for(int j=0;j<m;j++){
                map[i][j]=input.charAt(j);
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]=='L'){
                    boolean[][] visited=new boolean[n][m];
                    maxDist=Math.max(maxDist,findPoint(map,new Point(j,i),visited));   
                }
            }
        }//find
        
        System.out.println(maxDist-1);
    }//end of main
    
    static public int findPoint(char[][] map, Point st, boolean[][] visited){
        Queue<Point> q=new ArrayDeque<>();
        q.add(st);
        visited[st.y][st.x]=true;
        int count=0;
        
        while(!q.isEmpty()){
            count++;
            Queue<Point> tmp=new ArrayDeque<>();
            while(!q.isEmpty()){
                Point cur=q.poll();
                for(int i=0;i<4;i++){
                    int cmpX=cur.x+dx[i];
                    int cmpY=cur.y+dy[i];
                
                    if(cmpX>=0&&cmpX<m&&cmpY>=0&&cmpY<n
                       &&!visited[cmpY][cmpX]&&map[cmpY][cmpX]=='L'){
                        visited[cmpY][cmpX]=true;
                        tmp.add(new Point(cmpX,cmpY));
                    }
                }
            }
            q=tmp;
        }
        return count;
    }//end of func
}