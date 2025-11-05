import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());//전체 칸수
        int[] arr=new int[n+1];
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        
        int k=Integer.parseInt(br.readLine());//소형차가 끌수있는 칸수
        int[] sum=new int[n+1];
        
        for(int i=1;i<=n;i++){
            sum[i]=sum[i-1]+arr[i];
        }
        
        int[][] dp=new int[4][n+1];
        for(int i=1;i<4;i++){
            for(int j=i*k;j<=n;j++){
                dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j-k]+sum[j]-sum[j-k]);
            }
        }
        
        System.out.println(dp[3][n]);   
    }
}
