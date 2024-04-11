import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		int mapSize = (int)Math.pow(2, n);

		map = new int[mapSize][mapSize];

		for (int i = 0; i < mapSize; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < mapSize; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] levels = new int[q];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < q; i++) {
			levels[i] = Integer.parseInt(st.nextToken());
		}
		//입력 종료

		int idx = 0;
		while (q-- > 0) {
			int curLevel = levels[idx];
			int curSize = (int)Math.pow(2, curLevel);//작은 네모 길이
			int[][] tmp = new int[mapSize][mapSize];

			//회전
			for (int i = 0; i < mapSize; i += curSize) {
				for (int j = 0; j < mapSize; j += curSize) {
					rotate(j, i, (int)Math.pow(2, curLevel), tmp,mapSize);
				}
			}
			map = tmp;
			//
			// System.out.println("회전결과");
			// for (int i = 0; i < mapSize; i++) {
			// 	System.out.println(Arrays.toString(tmp[i]));
			// }
			// System.out.println();

			//녹일 얼음 탐색
			ArrayList<Point> meltingIce = new ArrayList<>();
			for (int i = 0; i < mapSize; i++) {
				for (int j = 0; j < mapSize; j++) {
					if (map[i][j] == 0)
						continue;
					if (isMelting(j, i, map, mapSize)) {
						meltingIce.add(new Point(j, i));
					}
				}
			}

			//녹이기
			for (Point cur : meltingIce) {
				// System.out.println("map["+cur.y+"]["+cur.x+"] 값이 깎여야함 ");
				if (map[cur.y][cur.x] > 0)
					map[cur.y][cur.x]--;
			}

			// System.out.println("녹인 결과");
			// for (int i = 0; i < mapSize; i++) {
			// 	System.out.println(Arrays.toString(tmp[i]));
			// }
			// System.out.println();

			idx++;

			// int sum = 0;
			// for (int i = 0; i < mapSize; i++) {
			// 	for (int j = 0; j < mapSize; j++) {
			// 		sum += map[i][j];
			// 	}
			// }
			// System.out.println("합 = "+sum);



		}//while 종료


		boolean[][] visited=new boolean[mapSize][mapSize];
		//덩어리 세기
		int maxIce=0;
		for(int i=0;i<mapSize;i++){
			for(int j=0;j<mapSize;j++){
				if(map[i][j]==0||visited[i][j])
					continue;
				maxIce=Math.max(maxIce,bfs(visited,i,j,map));

			}
		}





		int sum = 0;
		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {
				sum += map[i][j];
			}
		}
		System.out.println(sum);
		System.out.println(maxIce);

	}

	private static int bfs(boolean[][] visited, int startY, int startX,int[][] map) {
		ArrayDeque<Point> q=new ArrayDeque<>();
		q.add(new Point(startX,startY));
		visited[startY][startX]=true;
		int count=1;

		while(!q.isEmpty()){
			Point cur=q.poll();

			for(int i=0;i<4;i++){
				int cmpX=cur.x+dx[i];
				int cmpY=cur.y+dy[i];

				if(cmpX>=0&&cmpX<map[0].length&&cmpY<map[0].length&&cmpY>=0&&!visited[cmpY][cmpX]&&map[cmpY][cmpX]!=0){
					q.add(new Point(cmpX,cmpY));
					visited[cmpY][cmpX]=true;
					count++;
				}
			}
		}
		return count;
	}

	private static boolean isMelting(int curX, int curY, int[][] map, int mapSize) {
		int noIceCount = 0;
		for (int i = 0; i < 4; i++) {
			int cmpX = curX + dx[i];
			int cmpY = curY + dy[i];
			if (cmpX < 0 || cmpX >= mapSize || cmpY < 0 || cmpY >= mapSize) {
				noIceCount++;
				continue;
			}

			if (map[cmpY][cmpX] == 0) {
				noIceCount++;
			}
		}

		return noIceCount >= 2;
	}

	static private int[][] rotate(int startX, int startY, int a, int[][] tmp, int mapSize) {//a는 현재 돌리려는 블록의 가로 길이
		for (int i = 0; i <a; i++) {
			int count=0;
			for (int j = 0; j <a; j++) {
				tmp[i+startY][j+startX] = map[a-1-j+startY][startX+i];
				count++;
			}
		}


		return tmp;
	}
}
