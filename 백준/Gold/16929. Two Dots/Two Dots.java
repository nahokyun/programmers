
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[] dx= {0,0,1,-1};
	static int[] dy= {1,-1,0,0};
	static boolean[][] visited;
	private static char[][] map;
	static int startX;
	static int startY;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		for(int i=0;i<n;i++){
			String cur=br.readLine();
			for(int j=0;j<m;j++){
				map[i][j]=cur.charAt(j);
			}
		}//입력 종료

		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				visited=new boolean[n][m];
				startX=j;
				startY=i;
				if(findCycle(j,i,1)){
					System.out.println("Yes");
					return;
				}
			}
		}
		System.out.println("No");




	}

	private static boolean findCycle(int leftX, int leftY,int count) {
		visited[leftY][leftX]=true;
		for(int i=0;i<4;i++) {
			int cmpX=leftX+dx[i];
			int cmpY=leftY+dy[i];
			
			if(cmpX>=0&&cmpX<m&&cmpY>=0&&cmpY<n&&map[cmpY][cmpX]==map[startY][startX]) {
				if(!visited[cmpY][cmpX]) {
					visited[cmpY][cmpX]=true;
					if(findCycle(cmpX,cmpY,count+1)) {
						return true;
					}
				}else {
					if(count>=4&&startX==cmpX&&startY==cmpY)
						return true;
				}
			}
		}


		return false;
	}
}
