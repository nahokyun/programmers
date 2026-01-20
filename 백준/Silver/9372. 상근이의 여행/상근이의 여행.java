import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int t=Integer.parseInt(st.nextToken());
        StringBuilder sb=new StringBuilder();
        
        for(int test=0;test<t;test++){
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            boolean[] visited=new boolean[n+1];
            List<List<Integer>> li=new ArrayList<>();
            count=0;
            for(int i=0;i<=n;i++){
                li.add(new ArrayList<>());
            }
            
            for(int i=0;i<m;i++){
                st=new StringTokenizer(br.readLine());
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                li.get(a).add(b);
                li.get(b).add(a);
            }//end of input
            visited[1]=true;
            dfs(visited,1,li);
            sb.append(count).append('\n');
        }//end of test
        
        System.out.println(sb);
    }//enf of main
    
    static public void dfs(boolean[] visited, int cur, List<List<Integer>> li){
        for(int n:li.get(cur)){
            if(!visited[n]){
                visited[n]=true;
                dfs(visited,n,li);
                count++;
            }
        }
    }
}