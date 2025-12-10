import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for(int x=0;x<T;x++){
            int n=Integer.parseInt(br.readLine());
            StringTokenizer st;
            int[][] arr=new int[4][n+1];
            int[][] dp=new int[4][n+1];
            for(int j=1;j<=2;j++){
                st=new StringTokenizer(br.readLine());
                for(int i=1;i<=n;i++){
                    arr[j][i]=Integer.parseInt(st.nextToken());
                }
            }//입력종료
            
            dp[1][1]=arr[1][1];
            dp[2][1]=arr[2][1];
            for(int j=2;j<=n;j++){
                for(int i=1;i<=2;i++){
                    dp[i][j]=Math.max(Math.max(dp[i-1][j-1],dp[i-1][j-2]),Math.max(dp[i+1][j-1],dp[i+1][j-2]))+arr[i][j];
                }
            }
            //탐색 종료
            sb.append(Math.max(dp[1][n],dp[2][n])).append('\n');
        }
        
        
        System.out.println(sb);
    }
}