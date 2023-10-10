
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.awt.Point;

public class Main {

	private static int[][] map;
	private static int R;
	private static int C;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	private static Point end;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		end = null;

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) {
					end=new Point(j,i);
				}
			}
		}
		// 입력 종료

		while (T-- > 0) {
			expansion();
			
			operation();
		}
		
		int count=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]!=-1) {
					count+=map[i][j];
				}
			}
		}
		System.out.println(count);

	}

	private static void operation() {
		int[][] tmp=new int[R][C];
		for(int i=0;i<R;i++) {
			tmp[i]=map[i].clone();
		}
		
		Point start=new Point(end.x,end.y-1);
		
		for(int i=1;i<C;i++) {//아래 시계방향회전
			if(end.x==i) {
				continue;
			}
			if(end.x+1==i) {
				tmp[end.y][i]=0;
				continue;
			}
			tmp[end.y][i]=map[end.y][i-1];
		}
		for(int i=end.y+1;i<R;i++) {
			if(end.y==i+1&&end.x==C-1) {
				tmp[i+1][end.x]=0;
				continue;
			}

			tmp[i][C-1]=map[i-1][C-1];
		}
		
		for(int i=C-2;i>=0;i--) {
			tmp[R-1][i]=map[R-1][i+1];
		}
		for(int i=R-2;i>=end.y;i--) {
			if(end.x==0&&end.y==i) {
				tmp[end.y][0]=-1;
				continue;
			}
			tmp[i][0]=map[i+1][0];
		}
		//아래 회전 완료
		for(int i=1;i<C;i++) {//아랫변
			if(start.x==i) {
				continue;
			}
			if(start.x+1==i) {
				tmp[start.y][i]=0;
				continue;
			}
			tmp[start.y][i]=map[start.y][i-1];
		}
		for(int i=start.y-1;i>=0;i--) {//오른쪽 변
			if(start.y+1==i&&start.x==C-1) {
				tmp[i][start.x]=0;
				continue;
			}
			tmp[i][C-1]=map[i+1][C-1];
		}
		
		for(int i=0;i<C-1;i++) {
			tmp[0][i]=map[0][i+1];
		}
		for(int i=1;i<=start.y;i++) {
			if(start.x==0&&start.y==i) {
				continue;
			}
			tmp[i][0]=map[i-1][0];
		}
		
		map=tmp;
		
//		for(int i=0;i<R;i++) {
//			for(int j=0;j<C;j++) {
//				System.out.print(tmp[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
	}

	private static void expansion() {
		int[][] tmp=new int[R][C];
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int cur=map[i][j];
				if(cur!=0) {
					tmp[i][j]+=map[i][j];
					for(int k=0;k<4;k++) {
						int cmpX=j+dx[k];
						int cmpY=i+dy[k];
						
						if(cmpX>=0&&cmpX<C&&cmpY>=0&&cmpY<R&&map[cmpY][cmpX]!=-1) {
							tmp[cmpY][cmpX]+=cur/5;
							tmp[i][j]-=cur/5;
						}
					}
				}
			}
		}
		map=tmp;
//		for(int i=0;i<R;i++) {
//			for(int j=0;j<C;j++) {
//				System.out.print(tmp[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();

	}

}
