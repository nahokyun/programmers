import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());

		for(int test=1;test<=t;test++){
			int n=Integer.parseInt(br.readLine());

			int[][]dp=new int[n+1][7];
			dp[0][1]=1;

			for(int i=1;i<=n;i++){
				String cur=br.readLine();
				char op1=cur.charAt(0);
				int num1=cur.charAt(2)-'0';
				char op2=cur.charAt(4);
				int num2=cur.charAt(6)-'0';

				for(int j=0;j<7;j++){
					if(dp[i-1][j]==1){
						if(op1=='+'){
							dp[i][(j+num1)%7]=1;
						}else{
							dp[i][(j*num1)%7]=1;
						}
						if(op2=='+'){
							dp[i][(j+num2)%7]=1;
						}else{
							dp[i][(j*num2)%7]=1;
						}
					}
				}
			}
			//입력 종료



			if(dp[n][0]==1){
				System.out.println("LUCKY");
			}else{
				System.out.println("UNLUCKY");
			}
		}//end of testcase

	}//end of main
}

