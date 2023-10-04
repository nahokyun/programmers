
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
import java.awt.Point;

public class Main {
	static ArrayDeque<Point> water = new ArrayDeque<>();
	
	private static char[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[][] waterTime;
	static int[][] escapeTime;
	private static int r;
	private static int c;

	private static Point end;

	private static Point start;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		String s;

		map = new char[r][c];
		waterTime = new int[r][c];
		escapeTime = new int[r][c];

		start = null;
		end = null;

		for (int i = 0; i < r; i++) {
			s = br.readLine();
			for (int j = 0; j < c; j++) {
				waterTime[i][j]=1000000;
				map[i][j] = s.charAt(j);
				if (map[i][j] == '*') {
					water.add(new Point(j, i));
				}
				if (map[i][j] == 'S') {
					start = new Point(j, i);
				}
				if(map[i][j]=='D') {
					end=new Point(j,i);
				}
			}
		}
		waterBfs();
		// 입력 종료
		
		int result=hogerBfs(start);
		System.out.println(result==-1?"KAKTUS":result);
	}

	private static int hogerBfs(Point start) {
		boolean[][] flag=new boolean[r][c];
		ArrayDeque<Point> q = new ArrayDeque<>();
		q.add(start);
		flag[start.y][start.x]=true;
		
		int curTime=1;
		while(!q.isEmpty()) {
			ArrayDeque<Point> tmp=new ArrayDeque<>();
			while(!q.isEmpty()) {
				Point cur = q.poll();
				int curX = cur.x;
				int curY = cur.y;
				if(curX==end.x&&curY==end.y)
					return curTime;
				escapeTime[curY][curX] = curTime;
				
				for (int i = 0; i < 4; i++) {
					int cmpX = curX + dx[i];
					int cmpY = curY + dy[i];
					if(cmpX==end.x&&cmpY==end.y) {
						return curTime;
					}

					if (cmpX >= 0 && cmpX < c && cmpY >= 0 && cmpY < r 
							&& map[cmpY][cmpX] != 'X'&&!flag[cmpY][cmpX]
									&&curTime<waterTime[cmpY][cmpX]) {
						flag[cmpY][cmpX]=true;
						tmp.add(new Point(cmpX,cmpY));
					}
				}
			}
			curTime++;
			q=tmp;
		}
		return -1;
	}

	private static void waterBfs() {
		boolean[][] flag=new boolean[r][c];
		int curTime=0;
		while (!water.isEmpty()) {
			ArrayDeque<Point> tmp = new ArrayDeque<>();
			while (!water.isEmpty()) {
				Point cur = water.poll();
				int curX = cur.x;
				int curY = cur.y;
				waterTime[curY][curX] = curTime;
				flag[curY][curX]=true;

				for (int i = 0; i < 4; i++) {
					int cmpX = curX + dx[i];
					int cmpY = curY + dy[i];

					if (cmpX >= 0 && cmpX < c && cmpY >= 0 && cmpY < r 
							&& map[cmpY][cmpX] != 'X'&&!flag[cmpY][cmpX]&&map[cmpY][cmpX]!='D') {
						flag[cmpY][cmpX]=true;
						tmp.add(new Point(cmpX,cmpY));
					}
				}
			}
			curTime++;
			water=tmp;
		}

	}
}

