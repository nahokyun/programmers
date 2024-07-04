
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static int[] dx={0,0,1,-1};
	static int[] dy={1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		int n=Integer.parseInt(br.readLine());

		int[][] blindness=new int[n][n];
		int[][] normal=new int[n][n];

		for(int i=0;i<n;i++){
			String s=br.readLine();
			for(int j=0;j<n;j++){
				char cur=s.charAt(j);
				if(cur=='R'){
					blindness[i][j]=2;
					normal[i][j]=2;
				}else if(cur=='G'){
					blindness[i][j]=2;
					normal[i][j]=3;
				}else{
					blindness[i][j]=1;
					normal[i][j]=1;
				}
			}
		}
		//입력 종료

		System.out.println(GroupCount(normal,n)+" "+GroupCount(blindness,n));

	}//end of main

	private static int GroupCount(int[][] normal,int n) {
		int groupCount=0;

		boolean[][] visited=new boolean[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(!visited[i][j]){
					bfs(normal,i,j,n,visited);
					groupCount++;
				}
			}
		}
		return groupCount;
	}

	private static void bfs(int[][] normal, int sti, int stj, int n, boolean[][] visited) {
		Queue<Point> q=new ArrayDeque<>();
		q.add(new Point(stj,sti));
		visited[sti][stj]=true;

		while(!q.isEmpty()){
			Point cur=q.poll();
			int curColor=normal[cur.y][cur.x];
			for(int i=0;i<4;i++){
				int cmpX=cur.x+dx[i];
				int cmpY=cur.y+dy[i];

				if(cmpX>=0&&cmpX<n&&cmpY>=0&&cmpY<n&&normal[cmpY][cmpX]==curColor&&!visited[cmpY][cmpX]){
					q.add(new Point(cmpX,cmpY));
					visited[cmpY][cmpX]=true;
				}
			}
		}
	}
}
