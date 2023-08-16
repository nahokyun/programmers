
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		long[] dp=new long[101];
		
		dp[1]=1;
		dp[2]=2;
		dp[3]=3;
		dp[4]=4;
		dp[5]=5;
		dp[6]=6;
		
		for(int i=7;i<=n;i++) {
			for(int j=1;j<=3;j++) {
				dp[i]=Math.max(dp[i],dp[i-3-j]*(j+2));
			}
		}
		System.out.println(dp[n]);
	}
}
