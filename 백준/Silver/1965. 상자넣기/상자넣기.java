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
        }
        
        int[] dp=new int[n];
        dp[0]=1;
        int max=1;
        for(int i=1;i<n;i++){
            int cmp=10000;
            for(int j=i-1;j>=0;j--){
                if(arr[j]<arr[i]){
                    if(cmp==10000)
                        cmp=dp[j];
                    cmp=Math.max(cmp,dp[j]);
                }
            }
            if(cmp==10000)
                dp[i]=1;
            else
                dp[i]=cmp+1;
            max=Math.max(dp[i],max);
        }
        System.out.println(max);
        
    
    }
}