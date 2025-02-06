import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.awt.Point;

public class Main {
	static int[] dx={1,2,2,1,-1,-2,-2,-1};
	static int[] dy={-2,-1,1,2,2,1,-1,-2};
	static int[] dx2={1,0,-1,0};
	static int[] dy2={0,1,0,-1};

	static class Monkey{
		int left;
		Point pos;

		public Monkey(int left, Point pos) {
			this.left = left;
			this.pos = pos;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		int k=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int w=Integer.parseInt(st.nextToken());
		int h=Integer.parseInt(st.nextToken());

		int[][] map=new int[h][w];
		int[][][] dist=new int[k+1][h][w];
		for(int i=0;i<h;i++){
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<w;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
				for(int z=0;z<=k;z++) {
					dist[z][i][j] = 10000000;
				}
			}
		}

		Queue<Monkey> q=new ArrayDeque<>();
		q.add(new Monkey(k,new Point(0,0)));
		dist[k][0][0]=0;

		while(!q.isEmpty()){
			Monkey cur=q.poll();

			for(int i=0;i<4;i++){
				int cmpX=cur.pos.x+dx2[i];
				int cmpY=cur.pos.y+dy2[i];

				if(cmpX>=0&&cmpX<w&&cmpY>=0&&cmpY<h&&map[cmpY][cmpX]!=1){
					if(dist[cur.left][cmpY][cmpX]>dist[cur.left][cur.pos.y][cur.pos.x]+1){
						dist[cur.left][cmpY][cmpX]=dist[cur.left][cur.pos.y][cur.pos.x]+1;
						q.add(new Monkey(cur.left,new Point(cmpX,cmpY)));
					}
				}

			}

			for(int i=0;i<8;i++){
				int cmpX=cur.pos.x+dx[i];
				int cmpY=cur.pos.y+dy[i];

				if(cmpX>=0&&cmpX<w&&cmpY>=0&&cmpY<h&&map[cmpY][cmpX]!=1&&cur.left>=1){
					if(dist[cur.left-1][cmpY][cmpX]>dist[cur.left][cur.pos.y][cur.pos.x]+1){
						dist[cur.left-1][cmpY][cmpX]=dist[cur.left][cur.pos.y][cur.pos.x]+1;

						q.add(new Monkey(cur.left-1, new Point(cmpX,cmpY)));
					}
				}
			}

		}

		int min=10000000;
		for(int i=0;i<=k;i++){
			min=Math.min(min,dist[i][h-1][w-1]);
		}
		System.out.println(min!=10000000?min:-1);





	}
}
