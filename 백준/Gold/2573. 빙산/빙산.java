
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int[] dx={0,0,1,-1};
	private static int[] dy={1,-1,0,0};
	private static int n;
	private static int m;
	private static boolean noSep;

	private static class Melt{
		Point position;
		int beMinus;

		public Melt(Point position, int beMinus) {
			this.position = position;
			this.beMinus = beMinus;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());

		int[][] map=new int[n][m];
		List<Point> q=new ArrayList<>();

		for(int i=0;i<n;i++){
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]!=0){
					q.add(new Point(j,i));
				}
			}
		}//입력 종료


		int year=0;
		while(checkOne(map,q)){
			Queue<Melt> melting=checkMelt(map,q);

			melt(melting,map,q);

			year++;
		}

		System.out.println(noSep?0:year);
	}

	private static void melt(Queue<Melt> melting, int[][] map, List<Point> q) {
		int idx=0;
		List<Integer> del=new ArrayList<>();
		while(!melting.isEmpty()){
			Melt cur=melting.poll();
			if(map[cur.position.y][cur.position.x]- cur.beMinus<=0){
				del.add(idx);
				map[cur.position.y][cur.position.x]=0;
			}else{
				map[cur.position.y][cur.position.x]-= cur.beMinus;
			}
			idx++;
		}

		Collections.reverse(del);
		for(int cur:del)
			q.remove(cur);
	}

	private static Queue<Melt> checkMelt(int[][] map, List<Point> q) {
		Queue<Melt> result=new ArrayDeque<>();

		for(Point cur:q){
			int minus=0;
			for(int i=0;i<4;i++){
				int cmpX=cur.x+dx[i];
				int cmpY=cur.y+dy[i];
				if(cmpX>=0&&cmpX<m&&cmpY>=0&&cmpY<n&&map[cmpY][cmpX]==0){
					minus++;
				}
			}//4방향 탐색완료

			result.add(new Melt(cur,minus));
		}

		return result;
	}

	private static boolean checkOne(int[][] map, List<Point> q) {
		boolean[][] visited=new boolean[n][m];
		if(q.isEmpty()) {
			noSep=true;
			return false;
		}

		Point start=q.get(0);
		Queue<Point> qq=new ArrayDeque<>();
		qq.add(start);
		visited[start.y][start.x]=true;

		while(!qq.isEmpty()){
			Point cur=qq.poll();

			for(int i=0;i<4;i++){
				int cmpX=cur.x+dx[i];
				int cmpY=cur.y+dy[i];
				if(cmpX>=0&&cmpX<m&&cmpY>=0&&cmpY<n&&!visited[cmpY][cmpX]&&map[cmpY][cmpX]!=0){
					visited[cmpY][cmpX]=true;
					qq.add(new Point(cmpX,cmpY));
				}
			}
		}

		for(Point cur:q){
			if(!visited[cur.y][cur.x])
				return false;
		}
		return true;
	}
}
