import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }//end of input
        
        int[] dp=new int[n];
        Arrays.fill(dp, 100_000_000);
        dp[0]=0;
        for(int i=0;i<n;i++){
            int cur=arr[i];
            for(int j=1;j<=cur;j++){
                if(i+j<n){
                    dp[i+j]=Math.min(dp[i+j],dp[i]+1);
                }
            }
        }
        //System.out.println(Arrays.toString(dp));
        System.out.println(dp[n-1]==100_000_000?-1:dp[n-1]);
        
    }//end of main
}