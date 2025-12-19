import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    
    static int[][][] dp=new int[21][21][21];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        dp[0][0][0]=1;
        int a,b,c;
        while(true){
            st=new StringTokenizer(br.readLine());
            a=Integer.parseInt(st.nextToken());
            b=Integer.parseInt(st.nextToken());
            c=Integer.parseInt(st.nextToken());
            
            if(a==-1&&b==-1&&c==-1)
                break;
            
            sb.append("w(")
                .append(a).append(", ")
                .append(b).append(", ")
                .append(c).append(") = ")
                .append(find(a,b,c))
                .append('\n');

        }//종료
        
        System.out.println(sb); 
    }
    static public int find(int a, int b, int c){
        if(a<=0||b<=0||c<=0){
            return 1;
        }
        if(a>20||b>20||c>20){
            return find(20,20,20);
        }
        if(dp[a][b][c]!=0){
            return dp[a][b][c];
        }
        
        if(a<b&&b<c){
            return dp[a][b][c]=find(a,b,c-1)+find(a,b-1,c-1)-find(a,b-1,c);
        }else{
            return dp[a][b][c]=find(a-1,b,c)+find(a-1,b-1,c)+find(a-1,b,c-1)-find(a-1,b-1,c-1);
        }
        
    }
    
}