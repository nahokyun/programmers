
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
import java.util.Queue;

public class Main {
	static int[] dx={0,0,1,-1};
	static int[] dy={1,-1,0,0};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());

		boolean[][] isOutside=new boolean[n][m];
		int[][] map=new int[n][m];

		Queue<Point> q=new ArrayDeque<>();

		for(int i=0;i<n;i++){
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1){
					q.add(new Point(j,i));
				}
			}
		}//입력종료
		int count=0;

		while(!q.isEmpty()){
			isOutside=checkOutside(n, m, map);

			Queue<Point> next=new ArrayDeque<>();
			
			while(!q.isEmpty()){
				Point cur=q.poll();
				int airCount=0;
				for(int i=0;i<4;i++){
					int cmpX=cur.x+dx[i];
					int cmpY=cur.y+dy[i];

					if(cmpX>=0&&cmpX< m &&cmpY>=0&&cmpY< n && map[cmpY][cmpX]==0&&isOutside[cmpY][cmpX]){
						airCount++;
					}
				}
				if(airCount>=2){
					map[cur.y][cur.x]=0;
				}else{
					next.add(new Point(cur.x,cur.y));
				}
				
			}
			count++;
			q=next;
		}

		System.out.println(count);

	}

	private static boolean[][] checkOutside(int n, int m, int[][] map) {
		boolean[][] isOutside=new boolean[n][m];
		boolean[][] isVisited=new boolean[n][m];
		Queue<Point> check=new ArrayDeque<>();
		check.add(new Point(0,0));
		isOutside[0][0]=true;
		isVisited[0][0]=true;

		while(!check.isEmpty()){
			Point cur=check.poll();
			
			for(int i=0;i<4;i++){
				int cmpX=cur.x+dx[i];
				int cmpY=cur.y+dy[i];
				
				if(cmpX>=0&&cmpX< m &&cmpY>=0&&cmpY< n && map[cmpY][cmpX]==0&&!isVisited[cmpY][cmpX]){
					check.add(new Point(cmpX,cmpY));
					isOutside[cmpY][cmpX]=true;
					isVisited[cmpY][cmpX]=true;
				}
			}
		}//실내외 구분 완료
		return isOutside;
	}
}
