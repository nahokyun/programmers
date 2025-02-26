
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		String input=br.readLine();
		String output=br.readLine();

		int[][] dp=new int[input.length()+1][output.length()+1];

		for(int i=0;i<dp.length;i++){
			dp[i][0]=i;
		}
		for(int i=0;i<dp[0].length;i++){
			dp[0][i]=i;
		}

		for(int i=1;i<dp.length;i++){
			for(int j=1;j<dp[0].length;j++){
				if(input.charAt(i-1)==output.charAt(j-1)){
					dp[i][j]=dp[i-1][j-1];
				}else{
					dp[i][j]=Math.min(dp[i-1][j]+1,Math.min(dp[i-1][j-1]+1,dp[i][j-1]+1));
				}
			}
		}
		System.out.println(dp[input.length()][output.length()]);
	}
}
