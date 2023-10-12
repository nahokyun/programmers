
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.awt.Point;

public class Main {

	private static int[][] map;
	private static int n;
	private static int m;
	private static int[] blockCount;
	private static boolean[][] visited;
	static int[] dx= {0,0,1,-1};
	static int[] dy= {1,-1,0,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력 종료
		int score=0;
		while (true) {

			visited = new boolean[n][n];
			blockCount = new int[m + 1];
			ArrayList<Point> curBlock = new ArrayList<>();// m이하의 자연수별로 최대로 존재하는 블록그룹 정보
			ArrayList<Point> tmp = new ArrayList<>();// 현재 탐색한 블록 그룹의 위치정보가 있는 덱
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j] && map[i][j] != -1 && map[i][j] != 0&&map[i][j]!=-2) {
						int cur = map[i][j];
						tmp = bfs(i, j);
						
						if (tmp.size() >= blockCount[cur]) {
							blockCount[cur] = tmp.size();
							if (isChange(curBlock,tmp)) {
								curBlock = tmp;
							}
						}
					}
				}
			}

			// 블록 탐색 종료
			if(curBlock.size()<2) {
				break;
			}
			
			score+=curBlock.size()*curBlock.size();
			
			delete(curBlock);
//			for(int i=0;i<n;i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println();
			gravity();
//			for(int i=0;i<n;i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println();
			//삭제 후 중력 작용
			
			
			map=rotate();
			gravity();
			
//			for(int i=0;i<n;i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			//회전

			
//			System.out.println(score);
		}
		System.out.println(score);
	}

	private static int[][] rotate() {
		int[][] tmp=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				tmp[n-j-1][i]=map[i][j];
			}
		}
		return tmp;
	}

	private static void delete(ArrayList<Point> curBlock) {
		for(Point cur:curBlock) {
			map[cur.y][cur.x]=-2;
		}
		//삭제 종료
	}
	private static void gravity() {
		for(int i=n-1;i>0;i--) {
			for(int j=0;j<n;j++) {
				if(map[i][j]==-2) {
					pull(i,j);
				}
			}
		}
		//내리기 종료

	}

	private static void pull(int y,int x) {
		int h=y-1;
		while(h>=0) {
			if(map[h][x]==-1) {
				return;
			}
			if(map[h][x]!=-2) {
				map[y][x]=map[h][x];
				map[h][x]=-2;
				return;
			}else {
				h--;
			}
		}
		
	}

	private static boolean isChange(ArrayList<Point> curBlock, ArrayList<Point> tmp) {
		if(curBlock.size()<tmp.size()) {
			return true;
		}else if(curBlock.size()==tmp.size()){
			int cb_rainbow=countRainbow(curBlock);
			int tmp_rainbow=countRainbow(tmp);
			
			if(cb_rainbow<tmp_rainbow) {
				return true;
			}else if(cb_rainbow==tmp_rainbow) {
				if(curBlock.get(0).y<tmp.get(0).y) {
					return true;
				}else if(curBlock.get(0).y==tmp.get(0).y) {
					return curBlock.get(0).x<tmp.get(0).x;
				}
			}
			
		}
		
		return false;
	}

	private static int countRainbow(ArrayList<Point> curBlock) {
		int count=0;
		for(Point cur:curBlock) {
			if(map[cur.y][cur.x]==0) {
				count++;
			}
		}
		return count;
	}

	private static ArrayList<Point> bfs(int y, int x) {
		ArrayDeque<Point> q=new ArrayDeque<>();
		ArrayList<Point> group=new ArrayList<>();
		q.add(new Point(x,y));
		group.add(new Point(x,y));
		visited[y][x]=true;
		int val=map[y][x];
		
		while(!q.isEmpty()) {
			Point cur=q.poll();
			int curX=cur.x;
			int curY=cur.y;
			for(int i=0;i<4;i++) {
				int cmpX=curX+dx[i];
				int cmpY=curY+dy[i];
				
				if(cmpX>=0&&cmpX<n&&cmpY>=0&&cmpY<n&&!visited[cmpY][cmpX]
						&&(map[cmpY][cmpX]==val||map[cmpY][cmpX]==0)) {
					group.add(new Point(cmpX,cmpY));
					q.add(new Point(cmpX,cmpY));
					visited[cmpY][cmpX]=true;
				}
			}
		}
		for(Point cur:group) {
			if(map[cur.y][cur.x]==0) {
				visited[cur.y][cur.x]=false;
			}
		}
		
		return group;
	}

}
