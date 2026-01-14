import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static List<Point> li;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static class Point{
        int x;
        int y;
        public Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int[][] map=new int[n][m];
        boolean isExist=false;
        int count=0;
        int before1Hour=0;
        int tmp=0;//이전 사라질 치즈개수
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]==1){
                    isExist=true;
                    before1Hour++;
                }
            }
        }//end of input
        
        while(isExist){
            li=new ArrayList<>();
            isExist=false;
            boolean[][] isVisited=new boolean[n][m];
            Queue<Point> q=new ArrayDeque<>();
            q.add(new Point(0,0));
            isVisited[0][0]=true;
            before1Hour-=tmp;
            
            while(!q.isEmpty()){
                Point cur=q.poll();
                for(int i=0;i<4;i++){
                    int cmpX=cur.x+dx[i];
                    int cmpY=cur.y+dy[i];
                    
                    if(cmpX>=0&&cmpY>=0&&cmpX<m&&cmpY<n
                       &&!isVisited[cmpY][cmpX]){
                        if(map[cmpY][cmpX]==1){
                            li.add(new Point(cmpX,cmpY));
                            isExist=true;
                        }else{
                            q.add(new Point(cmpX,cmpY));
                        }
                        isVisited[cmpY][cmpX]=true;
                    }
                }
            }//find disappear

            if(isExist){
                for(Point cur:li){
                    map[cur.y][cur.x]=0;
                }
                tmp=li.size();
                count++;
            }
        }//end of func
        System.out.println(count);
        System.out.print(tmp);
    }
}