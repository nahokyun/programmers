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
            int[][] arr=new int[2][n+1];
            int[][] dp=new int[2][n+1];
            for(int j=0;j<2;j++){
                st=new StringTokenizer(br.readLine());
                for(int i=1;i<=n;i++){
                    arr[j][i]=Integer.parseInt(st.nextToken());
                }
            }//입력종료
            
            dp[0][1]=arr[0][1];
            dp[1][1]=arr[1][1];
            for(int j=2;j<=n;j++){
                for(int i=0;i<2;i++){
                    if(i==0){
                        dp[i][j]=Math.max(dp[1][j-1],dp[1][j-2])+arr[i][j];
                    }else{
                        dp[i][j]=Math.max(dp[0][j-1],dp[0][j-2])+arr[i][j];
                    }
                }
            }
            //탐색 종료
            sb.append(Math.max(dp[0][n],dp[1][n])).append('\n');
        }
        
        
        System.out.println(sb);
    }
}