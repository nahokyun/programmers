import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int[] dx = {1, 1, 0};
	private static int[] dy = {0, 1, 1};
	private static int[][] dp;
	private static int n;

	private static class Pipe {
		int[] curDir;
		Point position;

		public Pipe(int[] curDir, Point position) {
			this.curDir = curDir;
			this.position = position;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//Arrays.fill(dp[i],1000000);
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//입력종료

		dp[0][1] = 1;
		// find(new Pipe(new int[] {1, 0}, new Point(0, 1)), map);
		if(map[n-1][n-1]!=1) {
			find(0, 1, map);
		}

		System.out.println(dp[n - 1][n - 1]);

	}

	private static void find(int startY, int startX, int[][] map) {

		Queue<Pipe> q=new ArrayDeque<>();
		q.add(new Pipe(new int[] {1, 0},new Point(startX,startY)));

		while(!q.isEmpty()){
			Pipe cur=q.poll();
			int curX=cur.position.x;
			int curY=cur.position.y;
			if(curX==n-1&&curY==n-1){
				dp[n-1][n-1]++;
				continue;
			}

			if(cur.curDir[0]==1&&cur.curDir[1]==0){//가로방향 파이프일때
				if(curX+1<n&&map[curY][curX+1]==0){
					q.add(new Pipe(cur.curDir, new Point(curX+1,curY)));
					if(curY+1<n&&map[curY+1][curX+1]==0&&map[curY+1][curX]==0){//대각 변경
						q.add(new Pipe(new int[]{1,1}, new Point(curX+1,curY+1)));
					}
					continue;
				}
			}
			if(cur.curDir[0]==1&&cur.curDir[1]==1){//대각방향 파이프일때
				boolean flagGaro=false;
				boolean flagSero=false;
				if(curX+1<n&&map[curY][curX+1]==0){//가로 변경
					q.add(new Pipe(new int[]{1,0}, new Point(curX+1,curY)));
					flagGaro=true;
				}
				if(curY+1<n&&map[curY+1][curX]==0){//세로 변경
					q.add(new Pipe(new int[]{0,1}, new Point(curX,curY+1)));
					flagSero=true;
				}
				if(flagGaro&&flagSero&&map[curY+1][curX+1]==0){
					q.add(new Pipe(cur.curDir, new Point(curX+1,curY+1)));
				}
				continue;
			}
			if(cur.curDir[0]==0&&cur.curDir[1]==1){//아래방향 파이프일때
				if(curY+1<n&&map[curY+1][curX]==0){//그대로
					q.add(new Pipe(cur.curDir, new Point(curX,curY+1)));
					if(curX+1<n&&map[curY+1][curX+1]==0&&map[curY][curX+1]==0){//대각 변경
						q.add(new Pipe(new int[]{1,1}, new Point(curX+1,curY+1)));
					}
				}
				continue;
			}
		}
	}//find함수 종료


}
