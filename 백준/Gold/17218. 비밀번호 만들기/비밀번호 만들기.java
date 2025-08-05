import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static StringBuilder sb=new StringBuilder();
    static int[][] dp;
    static String s1;
    static String s2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s1 = br.readLine();
		s2 = br.readLine();

		dp = new int[s1.length() + 1][s2.length() + 1];
		
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
        int curX=s2.length();
        int curY=s1.length();
        makeStr(curX,curY);

		System.out.println(sb.reverse().toString());

	}
    private static void makeStr(int curX,int curY){
        int cur=dp[curY][curX];
        if(curY==0||curX==0){
            return;
        }
        if(dp[curY-1][curX]!=cur&&dp[curY][curX-1]!=cur){
            sb.append(s1.charAt(curY-1));
            makeStr(curX-1,curY-1);
        }else if(dp[curY-1][curX]==cur){
            makeStr(curX,curY-1);
        }else{
            makeStr(curX-1,curY);
        }
    }
}
