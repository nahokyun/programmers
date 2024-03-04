import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visited;
	static int[][] map;
	static int[] dx={1,-1,0,0};
	static int[] dy={0,0,1,-1};
	static int N;
	static int M;
	static int K;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());


		N = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(st.nextToken());

		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		visited = new boolean[N][N];

		for(int i=0;i<N;i++){
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		//입력 종료

		List<Integer> arr=new ArrayList<>();

		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(!visited[i][j]&&map[i][j]==0){
					arr.add(bfs(j,i));
				}
			}
		}

		int result=0;
		for(int cur:arr){
			if(cur%K==0)
				result+=cur/K;
			else
				result+=cur/K+1;
		}

		if(result>M||result==0){
			System.out.println("IMPOSSIBLE");
		}else{
			System.out.println("POSSIBLE");
			System.out.println(M-result);
		}

		
		
	}//end of main

	private static int bfs(int x, int y) {
		Queue<Point> q=new ArrayDeque<>();
		q.add(new Point(x,y));
		int count=1;
		visited[y][x]=true;
		while(!q.isEmpty()){
			Point cur=q.poll();
			for(int i=0;i<4;i++){
				int cmpX=cur.x+dx[i];
				int cmpY=cur.y+dy[i];

				if(cmpX>=0&&cmpX<N&&cmpY>=0&&cmpY<N&&!visited[cmpY][cmpX]&&map[cmpY][cmpX]==0){
					q.add(new Point(cmpX,cmpY));
					visited[cmpY][cmpX]=true;
					count++;
				}
			}
		}
		return count;
	}
}
