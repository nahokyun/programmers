import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
import java.awt.Point;

public class Main {
	static int n;
	static int[][] map;
	static int[] dx={0,0,-1,1};
	static int[] dy={1,-1,0,0};
	static int[][] curDistances;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		curDistances = new int[n][n];
		Shark baby = null;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					baby = new Shark(2, 1, new Point(j, i), 0);
				}
			}
		}//입력 종료

		while(true){
			Point target=fishTarget(baby);
			if(target==null){
				break;
			}
			//target 확인



			baby=move(target,baby);
			//이동후 업데이트


		}
		System.out.println(baby.time);
	}

	private static Shark move(Point target, Shark baby) {
		int newSize=baby.size;
		int newExp=baby.exp;
		if(baby.exp==baby.size){
			newExp=1;
			newSize=baby.size+1;
		}else{
			newExp++;
		}
		map[target.y][target.x]=0;
		map[baby.position.y][baby.position.x]=0;

		return new Shark(newSize,newExp,target,baby.time+curDistances[target.y][target.x]);//거리 더 해줘야함
	}

	private static Point fishTarget(Shark baby) {
		int minDist=100000;
		Point target=null;

		findDistances(baby);
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(minDist>curDistances[i][j]&&map[i][j]!=0&&map[i][j]!=9&&map[i][j]<baby.size&&curDistances[i][j]!=100000){
					target=new Point(j,i);
					minDist=curDistances[i][j];
				}
			}
		}

		return target;
	}

	private static void findDistances(Shark baby) {
		Queue<Point> q=new ArrayDeque<>();
		boolean[][] visited=new boolean[n][n];
		for(int i=0;i<n;i++){
			Arrays.fill(curDistances[i],100000);
		}
		curDistances[baby.position.y][baby.position.x]=0;
		q.add(baby.position);

		int time=0;
		while(!q.isEmpty()) {
			time++;
			Queue<Point> tmp=new ArrayDeque<>();
			while (!q.isEmpty()) {
				Point cur=q.poll();
				visited[cur.y][cur.x]=true;
				for(int i=0;i<4;i++){
					int cmpX=cur.x+dx[i];
					int cmpY=cur.y+dy[i];
					if(cmpX>=0&&cmpX<n&&cmpY<n&&cmpY>=0&&map[cmpY][cmpX]<=baby.size&&!visited[cmpY][cmpX]){
						visited[cmpY][cmpX]=true;
						curDistances[cmpY][cmpX]=time;
						tmp.add(new Point(cmpX,cmpY));
					}
				}
			}
			q=tmp;
		}
	}

	static class Shark{
		int size;
		int exp;
		Point position;
		int time;

		public Shark(int size, int exp, Point position, int time) {
			this.size = size;
			this.exp = exp;
			this.position = position;
			this.time = time;
		}
	}
}
