
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.awt.Point;

public class Main {

	private static int mapSize;
	private static char[][] map;
	static int count = 0;
	static List<Point> cow = new ArrayList<>();
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		mapSize = 2 * n;
		map = new char[mapSize][mapSize];

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());

			map[(y1 + y2-1)][(x1 + x2-1)] = '*';

		} // 길 입력 종료

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			map[2 * y - 1][2 * x - 1] = 'C';
			cow.add(new Point(2*x-1, 2*y-1));
		}
		// 소 입력 종료

		int result = 0;
		for (int i = 0; i < cow.size()-1; i++) {
			count = 0;
			Point cur=cow.get(i);
			bfs(cur);
			map[cur.y][cur.x]=' ';
			result += cow.size()-i - count - 1;
			
		}

		System.out.println(result);

	}

	private static void bfs(Point start) {
		boolean[][] visited = new boolean[mapSize][mapSize];
		Queue<Point> q = new ArrayDeque<>();
		q.add(start);
		visited[start.y][start.x]=true;
		while (!q.isEmpty()) {
			Point cur=q.poll();
			
			for(int i=0;i<4;i++) {
				int cmpX=cur.x+dx[i]*2;
				int cmpY=cur.y+dy[i]*2;
				
				if(isRange(cmpX)&&isRange(cmpY)
						&&!visited[cmpY][cmpX]&&map[cmpY-dy[i]][cmpX-dx[i]]!='*') {
					if(map[cmpY][cmpX]=='C') {
						count++;
					}
					visited[cmpY][cmpX]=true;
					q.add(new Point(cmpX,cmpY));
				}
			}
			
		}

	}

	private static boolean isRange(int value) {
		return (value>0&&value<mapSize);
	}

}
