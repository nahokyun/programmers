
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.List;

public class Main {

	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int[][] map;
	static boolean[][] visited;
	static int n;
	static Queue<Node> lands;

	static class Node {
		Point position;
		int num;

		public Node(Point position, int num) {
			this.position = position;
			this.num = num;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//입력 종료

		visited = new boolean[n][n];

		lands = new ArrayDeque<>();
		int land = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && map[i][j] != 0) {

					parsing(i, j, land++, lands);

				}
			}
		}//대륙 분리 완료

		//근접 좌표들 자기 섬번호로 변경
		//시간단위로 넓혀짐
		//2칸차이일때 다음 타임에 이미 다른숫자인 좌표 만났을때,
		// 이번타임에 넓힌 영역이다? (현재시간-1)*2+1
		//이번타임에 넓힌 영역이 아니다? 현재시간*2

		int time = 1;
		int min=Integer.MAX_VALUE;
		while (!lands.isEmpty()) {
			Queue<Node> tmp = new ArrayDeque<>();
			boolean[][] curTime = new boolean[n][n];
			while (!lands.isEmpty()) {
				Node cur = lands.poll();

				for (int i = 0; i < 4; i++) {
					int cmpX = cur.position.x + dx[i];
					int cmpY = cur.position.y + dy[i];

					if (cmpX >= 0 && cmpX < n && cmpY >= 0 && cmpY < n) {
						if (map[cmpY][cmpX] == 0) {//넓히려는 지역이 아직 안넓혀진 지역일 경우
							if (!curTime[cmpY][cmpX]) {
								curTime[cmpY][cmpX] = true;
								map[cmpY][cmpX] = cur.num;
								tmp.add(new Node(new Point(cmpX, cmpY), cur.num));
							}
						} else if (map[cmpY][cmpX] != cur.num) {//넓히려는 지역이 이미 넓혀진 지역일 경우
							if (!curTime[cmpY][cmpX]) {
								min=Math.min((time-1)*2,min);
							} else {
								min=Math.min((time-1)*2+1,min);
							}
						}
					}//범위조건 종료
				}//상하좌우 종료
			}//현재 시간대 확장 종료
			if(min!=Integer.MAX_VALUE){
				System.out.println(min);
				return;
			}
			time++;
			lands = tmp;
		}

		System.out.println(1);
	}

	private static void parsing(int y, int x, int idx, Queue<Node> curLand) {
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(x, y));
		map[y][x] = idx;
		visited[y][x] = true;
		curLand.add(new Node(new Point(x, y), idx));
		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int cmpX = cur.x + dx[i];
				int cmpY = cur.y + dy[i];

				if (cmpX >= 0 && cmpX < n && cmpY >= 0 && cmpY < n && map[cmpY][cmpX] == 1 && !visited[cmpY][cmpX]) {
					map[cmpY][cmpX] = idx;
					visited[cmpY][cmpX] = true;
					curLand.add(new Node(new Point(cmpX, cmpY), idx));
					q.add(new Point(cmpX, cmpY));
				}
			}
		}

	}
}
