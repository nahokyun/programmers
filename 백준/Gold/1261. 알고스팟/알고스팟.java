
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	private static int[] dx={0,0,1,-1};
	private static int[] dy={1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st=new StringTokenizer(br.readLine());

		int m=Integer.parseInt(st.nextToken());
		int n=Integer.parseInt(st.nextToken());

		int[][] map=new int[n][m];
		int[][] needBreak=new int[n][m];
		Deque<Point> deque=new ArrayDeque<>();


		for(int i=0;i<n;i++){
			String s=br.readLine();
			for(int j=0;j<m;j++){
				map[i][j]=s.charAt(j)-'0';
				needBreak[i][j]=10000;
			}
		}//입력종료
		needBreak[0][0]=0;

		deque.addFirst(new Point(0,0));

		while(!deque.isEmpty()){
			Point cur=deque.poll();

			for(int i=0;i<4;i++){
				int cmpX=cur.x+dx[i];
				int cmpY=cur.y+dy[i];

				if(cmpX>=0&&cmpX<m&&cmpY>=0&&cmpY<n){
					if(map[cmpY][cmpX]==1){
						if(needBreak[cmpY][cmpX]>needBreak[cur.y][cur.x]+1) {
							deque.addLast(new Point(cmpX,cmpY));
							needBreak[cmpY][cmpX] = needBreak[cur.y][cur.x] + 1;
						}
					}else{
						if(needBreak[cmpY][cmpX]>needBreak[cur.y][cur.x]) {
							deque.addFirst(new Point(cmpX, cmpY));
							needBreak[cmpY][cmpX] = needBreak[cur.y][cur.x];
						}
					}

				}
			}//4방향 탐색끝
		}

		System.out.println(needBreak[n-1][m-1]);





	}
}
