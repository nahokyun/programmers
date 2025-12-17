import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        
        int[] dp=new int[n+1];
        Arrays.fill(dp,1000001);
        dp[1]=0;
        
        
        for(int i=2;i<=n;i++){
            if(i%2!=0&&i%3==0){
                dp[i]=Math.min(dp[i-1],dp[i/3])+1;
            }else if(i%2==0&&i%3!=0){
                dp[i]=Math.min(dp[i-1],dp[i/2])+1;
            }else if(i%2==0&&i%3==0){
                dp[i]=Math.min(dp[i/2],Math.min(dp[i-1],dp[i/3]))+1;
            }else{
                dp[i]=dp[i-1]+1;
            }
        }
        int cur=dp[n];
        StringBuilder sb=new StringBuilder();
        sb.append(dp[n]).append('\n');
        
        int idx=n;
        while(idx!=1){
            if(idx%3==0&&dp[idx/3]==cur-1){
                sb.append(idx).append(' ');
                idx/=3;
            }else if(idx%2==0&&dp[idx/2]==cur-1){
                sb.append(idx).append(' ');
                idx/=2;
            }else{
                sb.append(idx).append(' ');
                idx-=1;
            }
            cur--;
        }
        sb.append(1);
        
        
        System.out.println(sb);
        
    }
} 