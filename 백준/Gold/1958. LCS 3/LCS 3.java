
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		String s3 = br.readLine();

		int[][][] dp = new int[s3.length() + 1][s1.length() + 1][s2.length() + 1];
		int max = 0;
		for (int k = 1; k <= s3.length(); k++) {
			for (int i = 1; i <= s1.length(); i++) {
				for (int j = 1; j <= s2.length(); j++) {
					if (s1.charAt(i - 1) == s2.charAt(j - 1) && s3.charAt(k - 1) == s1.charAt(i - 1)) {
						dp[k][i][j] = dp[k-1][i - 1][j - 1] + 1;
					} else {
						dp[k][i][j] = Math.max(dp[k][i - 1][j], Math.max(dp[k-1][i][j],dp[k][i][j - 1]));
					}
					max = Math.max(max, dp[k][i][j]);
				}
			}
		}

		System.out.println(max);

	}
}
