import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] dp=new int[n+2];
        int max=0;
        for(int i=1;i<=n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int t=Integer.parseInt(st.nextToken());
            int p=Integer.parseInt(st.nextToken());
            max=Math.max(max,dp[i]);
            if(i+t>n+1)
                continue;
            dp[i+t]=Math.max(dp[i+t],max+p);
        }
        

        System.out.println(Math.max(dp[n+1],max));
    }
}