
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		int t=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for(int test=0;test<t;test++){
			int n=Integer.parseInt(br.readLine());
			StringTokenizer st=new StringTokenizer(br.readLine());
			int[] coins=new int[n];
			for(int i=0;i<n;i++){
				coins[i]=Integer.parseInt(st.nextToken());
			}

			Arrays.sort(coins);

			int goal=Integer.parseInt(br.readLine());
			int[][] dp=new int[n+1][goal+1];

			for(int i=0;i<=n;i++){
				dp[i][0]=1;
			}

			for(int i=1;i<=n;i++){
				for(int j=0;j<=goal;j++){
					if(j<coins[i-1]) {
						dp[i][j] = dp[i - 1][j];
					}else{
						dp[i][j]=dp[i][j-coins[i-1]]+dp[i-1][j];
					}
				}
			}
			sb.append(dp[n][goal]).append('\n');

		}

		System.out.println(sb);

	}
}
