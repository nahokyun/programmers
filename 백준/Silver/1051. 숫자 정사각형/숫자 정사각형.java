
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());

		char[][] map=new char[n][m];
		int cur=Math.min(n,m);
		for(int i=0;i<n;i++){
			String input=br.readLine();
			for(int j=0;j<m;j++){
				map[i][j]=input.charAt(j);
			}
		}//input 종료


		while(cur>0) {
			for (int i = 0; i <= n - cur; i++) {
				for (int j = 0; j <= m - cur; j++) {
					if (map[i][j] == map[i + cur - 1][j] && map[i][j] == map[i + cur - 1][j + cur - 1]
						&& map[i][j] == map[i][j + cur - 1]) {
						System.out.println(cur*cur);
						return;
					}
				}
			}
			cur--;
		}


	}
}
