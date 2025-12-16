import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int rootN=(int)Math.sqrt(n);
        int[] dp=new int[n+1];
        Arrays.fill(dp,100001);
        
        for(int i=1;i<=rootN;i++){
            int cur=i*i;
            dp[cur]=1;
            
            for(int j=i;j<=n;j++){
                if(j>cur){
                    dp[j]=Math.min(dp[j],dp[j-cur]+1);
                }
            }
        }
        
        
        System.out.println(dp[n]);
        
    }
}