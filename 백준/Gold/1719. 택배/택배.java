
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n + 1][n + 1];//각 이동 비용

		int[][] road = new int[n + 1][n + 1];//각 경로 저장
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				road[i][j] = j;
				map[i][j] = 100000000;
				if (i == j)
					map[i][j] = 0;
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			map[s][d] = w;
			map[d][s] = w;
		}//입력 종료

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (i == j)
						continue;
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
						road[i][j] = road[i][k];
					}
				}
			}
		}

		StringBuilder sb=new StringBuilder();
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				if(i==j)
					sb.append("-").append(' ');
				else sb.append(road[i][j]).append(' ');
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}
}
