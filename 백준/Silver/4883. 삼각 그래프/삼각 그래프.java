import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();

		int test=Integer.parseInt(br.readLine());
		int testNum=1;
		while(test!=0){

			int[][] map=new int[test+1][3];
			int[][] dp=new int[test+1][3];

			for(int i=1;i<=test;i++){
				StringTokenizer st=new StringTokenizer(br.readLine());
				for(int j=0;j<3;j++){
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			//입력 종료

			dp[1][0]=2000000;
			dp[1][1]=map[1][1];
			dp[1][2]=dp[1][1]+map[1][2];

			for(int i=2;i<=test;i++){
				for(int j=0;j<3;j++){
					if(j==0){//왼쪽을 구할때
						dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j+1])+map[i][j];
					}else if(j==1){//가운데를 구할때
						dp[i][j]=Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),Math.min(dp[i-1][j+1],dp[i][j-1]))+map[i][j];
					}else{//오른쪽을 구할때
						dp[i][j]=Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+map[i][j];
					}
				}
			}



			sb.append(testNum++).append(". ").append(dp[test][1]).append('\n');
			test=Integer.parseInt(br.readLine());
		}//end of testcase

		System.out.println(sb);
	}
}
