import static java.util.Arrays.*;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int H;
	static int W;
	static Point start;
	static Point end;
	static int[] dx={1,-1,0,0};
	static int[] dy={0,0,1,-1};
	private static char[][] map;
	private static char[][] map2;
	private static int[][] times;

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		H=Integer.parseInt(st.nextToken());
		W=Integer.parseInt(st.nextToken());

		map = new char[H][W];
		// map2 = new char[H][W];
		times=new int[H][W];

		for(int i=0;i<H;i++){
			fill(times[i],1000000);
			String input=br.readLine();
			for(int j=0;j<W;j++){
				map[i][j]=input.charAt(j);
				if(map[i][j]=='S'){
					start=new Point(j,i);
				}else if(map[i][j]=='E'){
					end=new Point(j,i);
				}
			}
		}
		//입력 종료

		for(int i=0;i<H;i++){
			for(int j=0;j<W;j++){
				if(map[i][j]=='#'){
					for(int k=0;k<4;k++){
						int cmpX=j+dx[k];
						int cmpY=i+dy[k];
						if(cmpX>=0&&cmpX<W&&cmpY>=0&&cmpY<H&&map[cmpY][cmpX]!='#'){
							map[cmpY][cmpX]='I';
						}
					}
				}
			}
		}
		//벽에 인접한 칸 찾기
		moveToEnd();

		System.out.println(times[end.y][end.x]);
		
	}//end of main

	private static void moveToEnd() {
		PriorityQueue<TimeAndPosition> q=new PriorityQueue<>();
		q.add(new TimeAndPosition(start.x,start.y,0));
		boolean[][] visited=new boolean[H][W];

		visited[start.y][start.x]=true;
		times[start.y][start.x]=0;

		while(!q.isEmpty()){
			TimeAndPosition cur=q.poll();

			// map2[cur.position.y][cur.position.x]='V';
			// times[cur.position.y][cur.position.x]=cur.time;

			for(int i=0;i<4;i++){
				int cmpX=cur.position.x+dx[i];
				int cmpY=cur.position.y+dy[i];
				int cmpT;

				if(cmpX>=0&&cmpX<W&&cmpY>=0&&cmpY<H&&map[cmpY][cmpX]!='#'){
					if(map[cmpY][cmpX]=='I'){//벽에 인접한곳으로 갈 경우
						if(map[cur.position.y][cur.position.x]!='I'){
							cmpT=cur.time+1;
						}else{
							cmpT=cur.time;
						}
					}else{//아무것도 없는 칸으로 갈 경우
						cmpT=cur.time+1;
					}

					if(times[cmpY][cmpX]>cmpT||!visited[cmpY][cmpX]){
						times[cmpY][cmpX]=cmpT;
						q.add(new TimeAndPosition(cmpX,cmpY,cmpT));
						visited[cmpY][cmpX]=true;
					}

				}
			}
		}
	}

	static class TimeAndPosition implements Comparable<TimeAndPosition>{
		Point position;
		int time;

		public TimeAndPosition(int x,int y, int time) {
			this.position = new Point(x,y);
			this.time = time;
		}

		@Override
		public int compareTo(TimeAndPosition o) {
			return this.time-o.time;
		}
	}
}
