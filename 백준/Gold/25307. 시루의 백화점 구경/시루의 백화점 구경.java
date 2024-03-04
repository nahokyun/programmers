import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.awt.Point;

public class Main {
	static Point siru;
	static Queue<Point> mannequins=new ArrayDeque<>();
	static Point mannequin;
	static Point chair;
	static boolean mannequinExist;
	static int[][] manRange;

	static int N;
	static int M;
	static int K;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx={1,-1,0,0};
	static int[] dy={0,0,1,-1};

	static int minHealth=-1;

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());


		map = new int[N][M];
		manRange=new int[N][M];

		visited = new boolean[N][M];
		for(int i=0;i<N;i++){
			st=new StringTokenizer(br.readLine());
			Arrays.fill(manRange[i],1000000);
			for(int j=0;j<M;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
				if (map[i][j]==2){
					chair=new Point(j,i);
				}else if(map[i][j]==3){
					mannequin=new Point(j,i);
					mannequins.add(mannequin);
					manRange[i][j]=0;
					map[i][j]=5;
					mannequinExist=true;
				}else if(map[i][j]==4){
					siru=new Point(j,i);
				}
			}
		}//입력종료

		marking(mannequins);

		bfs();

		System.out.println(minHealth);

	}

	private static void marking(Queue<Point> mannequins) {
		Queue<Point> q=mannequins;
		int curDistance=0;

		while(!q.isEmpty()){
			Queue<Point> tmp=new ArrayDeque<>();
			curDistance++;
			if(curDistance>K){
				return;
			}
			while(!q.isEmpty()){
				Point cur= q.poll();
				for(int i=0;i<4;i++){
					int cmpX=cur.x+dx[i];
					int cmpY=cur.y+dy[i];

					if(cmpX>=0&&cmpX<M&&cmpY>=0&&cmpY<N){
						if(map[cmpY][cmpX]!=4)
							map[cmpY][cmpX]=5;
						if(manRange[cmpY][cmpX]>manRange[cur.y][cur.x]+1) {
							manRange[cmpY][cmpX] = manRange[cur.y][cur.x] + 1;
							tmp.add(new Point(cmpX, cmpY));
						}
					}
				}
			}
			q=tmp;
		}

	}

	private static void bfs() {
		Queue<Point> q=new ArrayDeque<>();
		q.add(siru);
		visited[siru.y][siru.x]=true;

		int health=0;
		while(!q.isEmpty()){
			Queue<Point> tmp=new ArrayDeque<>();
			while(!q.isEmpty()){
				Point cur=q.poll();

				if(map[cur.y][cur.x]==2){
					minHealth=health;
					return;
				}
				for(int i=0;i<4;i++){
					int cmpX=cur.x+dx[i];
					int cmpY=cur.y+dy[i];

					if(cmpX>=0&&cmpX<M&&cmpY<N&&cmpY>=0&&manRange[cmpY][cmpX]==1000000&&map[cmpY][cmpX]!=1&&!visited[cmpY][cmpX]){
						tmp.add(new Point(cmpX,cmpY));
						visited[cmpY][cmpX]=true;
					}
				}
			}
			health++;
			q=tmp;
		}
	}


}
