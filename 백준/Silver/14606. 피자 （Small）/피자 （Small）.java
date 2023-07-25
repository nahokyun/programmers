import java.util.Scanner;

import static java.lang.Math.max;

public class Main {
    public static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp=new int[11];
        dp[1]=0;
        dp[2]=1;
        for(int i=3;i<=n;i++){
            for(int j=1;j<i;j++){
                dp[i]=max(dp[i],dp[j]+dp[i-j]+j*(i-j));
            }
        }
        System.out.println(dp[n]);
    }
}
