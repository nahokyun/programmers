import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s1=br.readLine();
        String s2=br.readLine();
        StringBuilder sb=new StringBuilder();//최종 정답용
        StringBuilder sb2=new StringBuilder();//문자열 저장용
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        int x=s2.length();
        int y=s1.length();
        int max=0;
        for(int i=0;i<s1.length();i++){
            for(int j=0;j<s2.length();j++){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i+1][j+1]=dp[i][j]+1;
                }else{
                    dp[i+1][j+1]=Math.max(dp[i][j+1],dp[i+1][j]);
                }
                max=Math.max(max,dp[i+1][j+1]);
            }
        }//end of dp
        
        sb.append(max).append('\n');
        
        while(max!=0){
            if(dp[y][x]==dp[y-1][x]){
                y--;
                continue;
            }
            if(dp[y][x]==dp[y][x-1]){
                x--;
                continue;
            }
            sb2.append(s1.charAt(y-1));
            max--;
            x--;
            y--;
        }
        sb.append(sb2.reverse());

        System.out.println(sb);
    }
}