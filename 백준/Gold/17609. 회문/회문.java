import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            String cur=br.readLine();
            sb.append(find(0,cur.length()-1,cur,0)).append('\n');
        }//end of input
        
        System.out.println(sb);
    }//end of main
    
    public static int find(int st, int ed, String cur, int result){
        if(result>=2){
            return result;
        }
        while(st<ed){
            if(cur.charAt(st)==cur.charAt(ed)){
                st++;
                ed--;
            }else{
                return Math.min(find(st+1,ed,cur,result+1),find(st,ed-1,cur,result+1));
            }
        }
        return result;
    }
}