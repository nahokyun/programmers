
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		int n=Integer.parseInt(br.readLine());

		String input= br.readLine();
		int[][] dp=new int[n+1][2];
		//[][0]==A로 유지할경우
		//[][1]==B로 유지할경우
		if(input.charAt(0)=='A'){
			dp[0][0]=0;
			dp[0][1]=1;
		}else{
			dp[0][0]=1;
			dp[0][1]=0;
		}

		for(int i=1;i<n;i++){
			if(input.charAt(i)=='A'){
				dp[i][0]=Math.min(dp[i-1][0],dp[i-1][1]+1);
				dp[i][1]=Math.min(dp[i-1][0],dp[i-1][1])+1;
			}else{
				dp[i][0]=Math.min(dp[i-1][0],dp[i-1][1])+1;
				dp[i][1]=Math.min(dp[i-1][0]+1,dp[i-1][1]);
			}
		}
		System.out.println(Math.min(dp[n-1][0],dp[n-1][1]+1));

	}
}
